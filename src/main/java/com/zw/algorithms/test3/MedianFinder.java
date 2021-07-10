package com.zw.algorithms.test3;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        // 小顶堆，保存较大的一半
        A = new PriorityQueue<>();
        // 大顶堆，保存较小的一半
        B = new PriorityQueue<>((x, y) -> (y - x));
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.size());
    }
}
