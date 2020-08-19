package com.zw.base.test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteOrder;

public class Test4 extends Object {
    private int i = 0;

    public static void main(String[] args) {
        System.out.println(ByteOrder.nativeOrder());
        byteOrder();
    }

    /**
     * 判断大小端
     */
    public static void byteOrder() {
        try {
            int n = 0x12345678;

            String origin = Integer.toHexString(n);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(n);

            byte[] bs = byteArrayOutputStream.toByteArray();
            StringBuffer sb = new StringBuffer();
            for (byte b : bs) {
                sb.append(Integer.toHexString(b));
            }

            boolean b = origin.equalsIgnoreCase(sb.toString());
            if (b) {
                System.out.println("大端存储");
            } else {
                System.out.println("小端存储");
            }

            dataOutputStream.close();
            byteArrayOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class InnerClass {
        public void sys() {
            System.out.println(i);
        }
    }
}
