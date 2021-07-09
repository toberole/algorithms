package com.zw.algorithms.test3;

import com.zw.util.Util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], 0);
            res = Math.max(nums[i], res);
        }

        return res;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;

    }

    public int majorityElement1(int[] nums) {
        int ret = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ret = nums[i];
            }

            if (nums[i] == ret) {
                count++;
            } else {
                count--;
            }
        }

        return ret;
    }

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        if (s.length() == 1) return s.charAt(0);

        char res = s.charAt(0);
        int len = s.length();
        char[] chs = s.toCharArray();

        boolean b = true;
        for (int i = 0; i < len - 1; i++) {
            if (chs[i] != chs[i + 1]) {
                b = false;
                break;
            }
        }

        if (b) return ' ';

        for (int i = 0; i < len - 1; i++) {
            char c = chs[i];
            for (int j = i + 1; j < len; j++) {
                if (c == chs[j]) {
                    break;
                }

                if (j == len - 1) {
                    return c;
                }
            }
        }
        return res;
    }

    public static char firstUniqChar1(String s) {
        if (s == null || s.length() == 0) return ' ';
        if (s.length() == 1) return s.charAt(0);

        int len = s.length();
        char chs[] = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer n = map.get(chs[i] + "");
            if (n == null) {
                map.put(chs[i] + "", 1);
            } else {
                map.put(chs[i] + "", n + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            int n = map.get(chs[i] + "");
            System.out.println(n);
            if (n == 1) return chs[i];
        }

        return ' ';
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        int res[] = new int[2];
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < len; i++) {
            int n = nums[i];
            if (set.contains(target - n)) {
                res[0] = n;
                res[1] = target - n;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(firstUniqChar1("loveleetcode"));

        int arr[] = {2, 7, 11, 15};
        Util.printArray(twoSum(arr, 9));
    }

}
