package com.zw.algorithms.test1;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素
 */
public class Test30 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();


    }
}

/**
 * 思路：每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值
 * 如：入栈序列为2-3-1，则入栈后栈中元素序列为：2-2-3-2-1-1,
 * "元素本身" -> "当前最小值" -> "元素本身" -> "当前最小值"
 * 用空间代价来换取时间代价
 * <p>
 * 注意栈的实现
 */
class MinStack {
    // 直接使用java的Stack
    private Stack<Integer> stack;


    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int temp = stack.peek();
            stack.push(x);
            if (temp > x) {
                stack.push(x);
            } else {
                stack.push(temp);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        stack.pop();
        return stack.peek();
    }

    public int getMin() {
        return stack.peek();
    }
}

