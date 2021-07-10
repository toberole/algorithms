package com.zw.algorithms.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution8 {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                sb.append(ch + "");
                if (i == s.length() - 1) {
                    String s1 = sb.toString();
                    if (s1.length() > 0) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            } else {
                String s1 = sb.toString();
                if (s1.length() > 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        sb.setLength(0);
        for (int i = list.size() - 1; i >= 0; i--) {
            s = list.get(i);
            if (i == 0) {
                sb.append(s);
            } else {
                sb.append(s + " ");
            }
        }

        return sb.toString();
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer count = map.get(n);
            if (count == null) {
                map.put(n, 1);
            } else {
                map.put(n, count + 1);
            }
        }

        Integer integer = map.get(target);
        if (integer == null) {
            return 0;
        }
        return integer;
    }

    public int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }

        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }

    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] < target) i++;
            if (nums[j] > target) j--;

            if (nums[i] == target && nums[j] == target) {
                return j - i + 1;
            }
        }

        if (nums[i] == target) return 1;

        return 0;
    }

    public static String reverseLeftWords(String s, int n) {
        if (n == 0 || s == null || s.length() == 0 || n % s.length() == 0) return s;

        int len = s.length();
        char chs[] = s.toCharArray();

        n = n % len;

        for (int i = 0; i < n; i++) {
            char c = chs[0];

            for (int j = 1; j < len; j++) {
                chs[j - 1] = chs[j];
            }
            chs[len - 1] = c;
        }

        return new String(chs);
    }



    public static void main(String[] args) {
//        System.out.println(reverseWords("the sky is blue"));
//
//        int arr[] = {5, 7, 7, 8, 8, 10};
//        System.out.println(search2(arr, 6));
        // vbzkgsaoiu
        //  vbzkgsaoiu
        System.out.println(reverseLeftWords("vbzkgsaoiu", 2));

    }
}
