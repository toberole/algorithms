package com.zw.algorithms.test1;

public class Util {
    public static void printArray(int[] nums) {
        StringBuffer sb = new StringBuffer();
        for (Number n : nums) {
            sb.append(String.valueOf(n));
        }
        System.out.println(sb.toString());
    }
}
