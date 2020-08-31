package com.zw.base.test;

/**
 * 锁升级 锁的4中状态：
 * 无锁状态、偏向锁状态、轻量级锁状态、重量级锁状态（级别从低到高）
 * 锁的状态变迁 是由JVM操作对象头部 Mark Word完成的
 * <p>
 * 所谓锁的升级、降级，就是 JVM 优化 synchronized 运行的机制，当 JVM 检测到不同的竞争状况时，
 * 会自动切换到适合的锁实现，这种切换就是锁的升级、降级：
 * <p>
 * 当没有竞争出现时，默认会使用偏向锁。JVM 会利用 CAS 操作（compare and swap），
 * 在对象头上的 Mark Word 部分设置线程 ID，以表示这个对象偏向于当前线程，
 * 所以并不涉及真正的互斥锁。这样做的假设是基于在很多应用场景中，
 * 大部分对象生命周期中最多会被一个线程锁定，使用偏向锁可以降低无竞争开销。
 * <p>
 * 如果有另外的线程试图锁定某个已经被偏向过的对象，JVM 就需要撤销（revoke）偏向锁，
 * 并切换到轻量级锁实现。轻量级锁依赖 CAS 操作 Mark Word 来试图获取锁，
 * 如果重试成功，就使用轻量级锁；否则，进一步升级为重量级锁
 * <p>
 * 膨胀过程的实现比较复杂，大概实现过程如下：
 * 1、整个膨胀过程在自旋下完成；
 * <p>
 * 2、mark->has_monitor()方法判断当前是否为重量级锁，即Mark Word的锁标识位为 10，如果当前状态为重量级锁，执行步骤（3），否则执行步骤（4）；
 * <p>
 * 3、mark->monitor()方法获取指向ObjectMonitor的指针，并返回，说明膨胀过程已经完成；
 * <p>
 * 4、如果当前锁处于膨胀中，说明该锁正在被其它线程执行膨胀操作，则当前线程就进行自旋等待锁膨胀完成，这里需要注意一点，虽然是自旋操作，但不会一直占用cpu资源，每隔一段时间会通过os::NakedYield方法放弃cpu资源，或通过park方法挂起；如果其他线程完成锁的膨胀操作，则退出自旋并返回；
 * <p>
 * 5、如果当前是轻量级锁状态，即锁标识位为 00，膨胀过程如下：
 * <p>
 * 通过omAlloc方法，获取一个可用的ObjectMonitor monitor，并重置monitor数据；
 * 通过CAS尝试将Mark Word设置为markOopDesc:INFLATING，标识当前锁正在膨胀中，如果CAS失败，说明同一时刻其它线程已经将Mark Word设置为markOopDesc:INFLATING，当前线程进行自旋等待膨胀完成；
 * 如果CAS成功，设置monitor的各个字段：_header、_owner和_object等，并返回；
 * 6、如果是无锁，重置监视器值；
 * <p>
 * 偏向锁会偏向于第一个获得它的线程，如果在接下来的执行过程中，该锁没有被其他的线程获取，则持有偏向锁的线程将永远不需要同步。大多数情况下，锁不仅不存在多线程竞争，而且总是由同一线程多次获得，为了让线程获得锁的代价更低而引入了偏向锁。
 * <p>
 * 当锁对象第一次被线程获取的时候，线程使用CAS操作把这个锁的线程ID记录再对象Mark Word之中，同时置偏向标志位1。以后该线程在进入和退出同步块时不需要进行CAS操作来加锁和解锁，只需要简单地测试一下对象头的Mark Word里是否存储着指向当前线程的偏向锁。如果测试成功，表示线程已经获得了锁。
 * <p>
 * 如果线程使用CAS操作时失败则表示该锁对象上存在竞争并且这个时候另外一个线程获得偏向锁的所有权。当到达全局安全点（safepoint，这个时间点上没有正在执行的字节码）时获得偏向锁的线程被挂起，膨胀为轻量级锁（涉及Monitor Record，Lock Record相关操作，这里不展开），同时被撤销偏向锁的线程继续往下执行同步代码。
 * <p>
 * 当有另外一个线程去尝试获取这个锁时，偏向模式就宣告结束。
 * <p>
 * 线程在执行同步块之前，JVM会先在当前线程的栈帧中创建用于存储锁记录(Lock Record)的空间，并将对象头中的Mard Word复制到锁记录中，官方称为Displaced Mark Word。然后线程尝试使用CAS将对象头中的Mark Word替换为指向锁记录的指针。如果成功，当前线程获得锁，如果失败，表示其他线程竞争锁，当前线程便尝试使用自旋来获取锁。如果自旋失败则锁会膨胀成重量级锁。如果自旋成功则依然处于轻量级锁的状态。
 * <p>
 * 轻量级锁的解锁过程也是通过CAS操作来进行的，如果对象的Mark Word仍然指向线程的锁记录，那就用CAS操作把对象当前的Mark Word和线程中赋值的Displaced Mark Word替换回来，如果替换成功，整个同步过程就完成了，如果替换失败，就说明有其他线程尝试过获取该锁，那就要在释放锁的同时，唤醒被挂起的线程。
 * <p>
 * 轻量级锁提升程序同步性能的依据是：对于绝大部分的锁，在整个同步周期内都是不存在竞争的（区别于偏向锁）。这是一个经验数据。如果没有竞争，轻量级锁使用CAS操作避免了使用互斥量的开销，但如果存在锁竞争，除了互斥量的开销外，还额外发生了CAS操作，因此在有竞争的情况下，轻量级锁比传统的重量级锁更慢。
 * <p>
 * 整个synchronized锁流程如下：
 * 检测Mark Word里面是不是当前线程的ID，如果是，表示当前线程处于偏向锁
 * 如果不是，则使用CAS将当前线程的ID替换Mard Word，如果成功则表示当前线程获得偏向锁，置偏向标志位1
 * 如果失败，则说明发生竞争，撤销偏向锁，进而升级为轻量级锁。
 * 当前线程使用CAS将对象头的Mark Word替换为锁记录指针，如果成功，当前线程获得锁
 * 如果失败，表示其他线程竞争锁，当前线程便尝试使用自旋来获取锁。
 * 如果自旋成功则依然处于轻量级状态。
 * 如果自旋失败，则升级为重量级锁。
 */
public class Test_Lock {
    private final static Object lock = new Object();
    private static int i = 0;

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        synchronized (lock) {
            synchronized (lock) {
                System.out.println(i++);
            }
        }
    }
}
