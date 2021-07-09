package com.zw.algorithms.test3;

import com.zw.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int n = nums[i] + nums[j];
            if (n > target) {
                j--;
            } else if (n < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[0];

    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int max = (target - 1) / 2;

        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = i; ; j++) {
                sum += j;
                if (sum > target) break;

                if (sum == target) {
                    int[] temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        temp[k - i] = k;
                    }

                    res.add(temp);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        Util.printArray(twoSum(arr, 9));
    }
}
