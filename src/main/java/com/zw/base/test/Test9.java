package com.zw.base.test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;

public class Test9 {
    public static void main(String[] args) {
        try {

            final String s = "hello world";
            int len = s.length();
            int arr[] = new int[10];
            int n = arr.length;
            System.out.println(1);

            Error error = new Error();
            error.setStackTrace(new StackTraceElement[0]);

            ObjectInputStream objectInputStream;
            ObjectOutputStream objectOutputStream;

            return;
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }
    }

    private void test(){
        HttpURLConnection httpURLConnection = null;
        httpURLConnection.getContentLengthLong();
    }
}
