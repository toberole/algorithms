package com.zw.algorithms.jzoffer.q2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class Test4 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return new int[0];

        int len = nums.length;

        int[] res = new int[len - k + 1];

        for (int i = 0; i <= len - k; i++) {
            int max = nums[i];

            for (int j = i; j <= i + (k - 1); j++) {
                if (nums[j] > max) max = nums[j];
            }

            res[i] = max;
        }

        return res;
    }

    /**
     * 双端队列
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        //边界条件的判断
        if (nums == null || k <= 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        //双端队列，就是两边都可以插入和删除数据的队列，注意这里存储
        //的是元素在数组中的下标，不是元素的值
        Deque<Integer> qeque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //如果队列中队头元素和当前元素位置相差i-k，相当于队头元素要
            //出窗口了，就把队头元素给移除，注意队列中存储
            //的是元素的下标（函数peekFirst()表示的是获取队头的下标，函数
            //pollFirst()表示的是移除队头元素的下标）
            if (!qeque.isEmpty() && qeque.peekFirst() <= i - k) {
                qeque.pollFirst();
            }
            //在添加一个值之前，前面比他小的都要被移除掉，并且还要保证窗口
            //中队列头部元素永远是队列中最大的
            while (!qeque.isEmpty() && nums[qeque.peekLast()] < nums[i]) {
                qeque.pollLast();
            }
            //当前元素的下标加入到队列的尾部
            qeque.addLast(i);
            //当窗口的长度大于等于k个的时候才开始计算（注意这里的i是从0开始的）
            if (i >= k - 1) {
                //队头元素是队列中最大的，把队列头部的元素加入到数组中
                res[index++] = nums[qeque.peekFirst()];
            }
        }
        return res;
    }

}
