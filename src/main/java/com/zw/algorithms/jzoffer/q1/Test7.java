package com.zw.algorithms.jzoffer.q1;

import java.util.Stack;

/**
 * 两个栈 模拟队列操作
 */
public class Test7 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) return out.pop();

        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        if (out.isEmpty()) return -1;

        return out.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
