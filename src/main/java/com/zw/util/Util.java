package com.zw.util;

public class Util {
    public static int arr[] = {1,5,2,3,7,4,6};

    public static void printArray(int[] nums) {
        StringBuffer sb = new StringBuffer();
        for (Number n : nums) {
            sb.append(String.valueOf(n) + " ");
            if (sb.length() > 100) {
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }
        System.out.println(sb.toString());
    }

    public static String arr2String(int[] nums) {
        StringBuffer sb = new StringBuffer();
        for (Number n : nums) {
            sb.append(String.valueOf(n));
        }
        return sb.toString();
    }

}
