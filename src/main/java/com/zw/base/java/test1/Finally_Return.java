package com.zw.base.java.test1;

/**
 * 两种情况下 finally 不会执行
 * <p>
 * try 模块没有运行。
 * 使用System.exit(0)终止JVM。
 * <p>
 * 结论
 * 在进入 finally 语句块之前，catch 已经计算好了最终要 return 的数据，并缓存了该数据的地址
 * 对于可变对象，finally 修改可变对象内部的值，能够影响到 return 的结果
 * 对于不可变对象，finally 中修改不能影响到 return 的结果
 * finally 中的 return 语句可以修改最终要 return 的数据的地址。
 * <p>
 * 结论
 * 在进入 finally 语句块之前，catch 已经计算好了最终要 return 的数据，并缓存了该数据的地址
 * 对于可变对象，finally 修改可变对象内部的值，能够影响到 return 的结果
 * 对于不可变对象，finally 中修改不能影响到 return 的结果
 * finally 中的 return 语句可以修改最终要 return 的数据的地址。
 * <p>
 * 结论
 * 在进入 finally 语句块之前，catch 已经计算好了最终要 return 的数据，并缓存了该数据的地址
 * 对于可变对象，finally 修改可变对象内部的值，能够影响到 return 的结果
 * 对于不可变对象，finally 中修改不能影响到 return 的结果
 * finally 中的 return 语句可以修改最终要 return 的数据的地址。
 */

/**
 * 结论
 * 在进入 finally 语句块之前，catch 已经计算好了最终要 return 的数据，并缓存了该数据的地址
 * 对于可变对象，finally 修改可变对象内部的值，能够影响到 return 的结果
 * 对于不可变对象，finally 中修改不能影响到 return 的结果
 * finally 中的 return 语句可以修改最终要 return 的数据的地址。
 */

/**
 * return语句理解：
 * 1、设置返回值，return 1 设置返回值为 1
 * 2、执行finally语句序列，因为finally是可以嵌套的;
 * 3、清理函数上下文环境；
 * 4、返回主调函数。
 */
public class Finally_Return {
    public static int test() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Finally_Return.test());
    }
}
