package com.zw.base.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CAS
 * 全称（Compare And Swap）,比较交换,Unsafe类是CAS的核心类,提供硬件级别的原子操作。
 * 缺点：
 * 开销大：在并发量比较高的情况下，如果反复尝试更新某个变量，却又一直更新不成功，会给CPU带来较大的压力
 * ABA问题：当变量从A修改为B在修改回A时，变量值等于期望值A，但是无法判断是否修改，CAS操作在ABA修改后依然成功。
 * 如何避免：Java提供了AtomicStampedReference和AtomicMarkableReference来解决。AtomicStampedReference通过包装[E,Integer]的元组来对对象标记版本戳stamp，对于ABA问题其解决方案是加上版本号，即在每个变量都加上一个版本号，每次改变时加1，即A —> B —> A，变成1A —> 2B —> 3A。
 * 不能保证代码块的原子性：CAS机制所保证的只是一个变量的原子性操作，而不能保证整个代码块的原子性。
 * <p>
 * AQS（AbstractQueuedSynchronizer）
 * 维护一个volatile int state（代表共享资源状态）和一个FIFO线程等待队列。
 * <p>
 * 模板方法基本分为三类：
 * 独占锁
 * 共享锁
 * 释放锁
 * 资源共享的方式
 * Exclusive（独占，只有一个线程能执行，如ReentrantLock）
 * Share（共享，多个线程可以同时执行，如Semaphore/CountDownLatch）
 * 同步队列
 * AQS依靠同步队列（一个FIFO的双向队列）来完成同步状态的管理。当当前线程获取状态失败后，
 * 同步器会将当前线程以及等待信息构造成一个节点（Node），并尝试将他加入到同步队列。
 * Head节点不保存等待的线程信息，仅通过next指向队列中第一个保存等待线程信息的Node。
 * <p>
 * 队列同步器 AbstractQueuedSynchronizer（以下简称 AQS），是用来构建锁或者其他同步组件的基础框架。
 * 它使用一个 int 成员变量来表示同步状态，通过 CAS 操作对同步状态进行修改，确保状态的改变是安全的。
 * 通过内置的 FIFO （First In First Out）队列来完成资源获取线程的排队工作。
 * <p>
 * AQS 和 synchronized
 * 在介绍 AQS 的使用之前，需要首先说明一点，AQS 同步和 synchronized 关键字同步（以下简称 synchronized 同步）是采用的两种不同的机制。
 * 首先看下 synchronized 同步，synchronized 关键字经过编译之后，会在同步块的前后分别形成 monitorenter 和 monitorexit 这两个字节码指令，这两个字节码需要关联到一个监视对象，当线程执行 monitorenter 指令时，需要首先获得获得监视对象的锁，
 * 这里监视对象锁就是进入同步块的凭证，只有获得了凭证才可以进入同步块，当线程离开同步块时，会执行 monitorexit 指令，释放对象锁。
 * 在 AQS 同步中，使用一个 int 类型的变量 state 来表示当前同步块的状态。以独占式同步（一次只能有一个线程进入同步块）为例，state 的有效值有两个 0 和 1，其中 0 表示当前同步块中没有线程，1 表示同步块中已经有线程在执行。
 * 当线程要进入同步块时，需要首先判断 state 的值是否为 0，假设为 0，会尝试将 state 修改为 1，只有修改成功了之后，线程才可以进入同步块。注意上面提到的两个条件：
 * <p>
 * state 为 0，证明当前同步块中没有线程在执行，所以当前线程可以尝试获得进入同步块的凭证，而这里的凭证就是是否成功将 state 修改为 1（在 synchronized 同步中，我们说的凭证是对象锁，但是对象锁的最终实现是否和这种方式类似，没有找到相关的资料）
 * 成功将 state 修改为 1，通过使用 CAS 操作，我们可以确保即便有多个线程同时修改 state，也只有一个线程会修改成功。关于 CAS 的具体解释会在后面提到。
 * 当线程离开同步块时，会修改 state 的值，将其设为 0，并唤醒等待的线程。所以在 AQS 同步中，我们说线程获得了锁，实际上是指线程成功修改了状态变量 state，而线程释放了锁，是指线程将状态变量置为了可修改的状态（在独占式同步中就是置为了 0），让其他线程可以再次尝试修改状态变量。
 * <p>
 * CAS 操作
 * CAS（Compare and Swap），比较并交换，通过利用底层硬件平台的特性，实现原子性操作。
 * CAS 操作涉及到3个操作数，内存值 V，旧的期望值 A，需要修改的新值 B。
 * 当且仅当预期值 A 和 内存值 V 相同时，才将内存值 V 修改为 B，否则什么都不做。
 * CAS 操作类似于执行了下面流程:
 * if(oldValue == memory[valueAddress]) {
 * memory[valueAddress] = newValue;
 * }
 * <p>
 * AQS 依赖内部的同步队列（一个 FIFO的双向队列）来完成同步状态的管理，当前线程获取同步状态失败时，
 * 同步器会将当前线程以及等待状态等信息构造成一个节点（Node）并将其加入同步队列，同时会阻塞当前线程，
 * 当同步状态释放时，会把队列中第一个等待节点线程唤醒（下图中的 Node1），使其再次尝试获取同步状态。
 * <p>
 * 在 Node 类中定义了四种等待状态：
 * CANCELED： 1，因为等待超时 （timeout）或者中断（interrupt），节点会被置为取消状态。处于取消状态的节点不会再去竞争锁，也就是说不会再被阻塞。节点会一直保持取消状态，而不会转换为其他状态。处于 CANCELED 的节点会被移出队列，被 GC 回收。
 * SIGNAL： -1，表明当前的后继结点正在或者将要被阻塞（通过使用 LockSupport.pack 方法），因此当前的节点被释放（release）或者被取消时（cancel）时，要唤醒它的后继结点（通过 LockSupport.unpark 方法）。
 * CONDITION： -2，表明当前节点在条件队列中，因为等待某个条件而被阻塞。
 * PROPAGATE： -3，在共享模式下，可以认为资源有多个，因此当前线程被唤醒之后，可能还有剩余的资源可以唤醒其他线程。该状态用来表明后续节点会传播唤醒的操作。需要注意的是只有头节点才可以设置为该状态（This is set (for head node only) in doReleaseShared to ensure propagation continues, even if other operations have since intervened.）。
 * 0：新创建的节点会处于这种状态
 */

/**
 * CountDownLatch原理
 * CountDownLatch是使用一组线程来等待其它线程执行完成，这个场景类似于一群人考试，先做的人先交了，
 * 但是在考试时间没到的前提下，老师必须额等待最后一个学生完成交卷老师才能走，CountDownLatch
 * 使用Sync继承AQS。构造函数很简单地传递计数值给Sync，并且设置了state，这个state的值就是倒计时的数值，
 * 每当一个线程完成了自己的任务（学生完成交卷），那么就使用CountDownLatch.countdown（）方法来
 * 做一次state的减一操作，在内部是通过CAS完成这个更新操作，直到所有的线程执行完毕，也就是说计数值变成0，
 * 那么就然后在闭锁上等待的线程就可以恢复执行任务。
 * <p>
 * CyclicBarrier原理 栅栏
 * CyclicBarrier 的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。线程进入屏障通过CyclicBarrier的await()方法。
 * 实现原理：在CyclicBarrier的内部定义了一个Lock对象，其实就是ReenTrantLock对象，每当一个线程调用CyclicBarrier的await方法时，将剩余拦截的线程数减1，然后判断剩余拦截数是否为0，如果不是，进入Lock对象的条件队列等待。如果是，执行barrierAction对象的Runnable方法，然后将锁的条件队列中的所有线程放入锁等待队列中，这些线程会依次的获取锁、释放锁，接着先从await方法返回，再从CyclicBarrier的await方法中返回。
 * 其中await方法：1.获取lock对象，然后拦截数减一，直到拦截数为0，结束await
 * 2.出现中断，结束栅栏然后退出
 * 3.超时也可以退出栅栏
 */
public class Test_CAS_AQS {
    private final static int count = 10;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
//        test_CountDownLatch();
        test_CyclicBarrier();
    }

    /**
     * CyclicBarrier 多个任务运行到一个节点的时候 才能继续运行 齐头并进
     */
    private static void test_CyclicBarrier() {
        cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("************ CyclicBarrier ************");
            }
        });
        startThread(count, cyclicBarrier);
        System.out.println("test_CyclicBarrier ......");
        startThread(count, cyclicBarrier);
    }

    private static void startThread(int count, CyclicBarrier cyclicBarrier) {
        Thread[] threads = new Test_CyclicBarrier_Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Test_CyclicBarrier_Thread(cyclicBarrier);
        }
        for (int i = 0; i < count; i++) {
            threads[i].start();
        }
    }

    /**
     * CountDownLatch 用于一个任务等其他的N个任务完成的情况
     */
    private static void test_CountDownLatch() {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(count);
            Thread[] threads = new Test_CountDownLatch_Thread[count];
            for (int i = 0; i < count; i++) {
                threads[i] = new Test_CountDownLatch_Thread(countDownLatch);
            }
            long t = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                threads[i].start();
            }

            countDownLatch.await();
            System.out.println("...... end ...... " + (System.currentTimeMillis() - t));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Test_CountDownLatch_Thread extends Thread {
        private CountDownLatch countDownLatch;

        public Test_CountDownLatch_Thread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("run ......");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    private static class Test_CyclicBarrier_Thread extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Test_CyclicBarrier_Thread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                // 等待其他的线程
                cyclicBarrier.await();
                System.out.println("Test_CyclicBarrier_Thread run ...... " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
