package com.zw.algorithms.test1;

import java.util.ArrayList;
import java.util.List;

public class Test24 {
    public static void main(String[] args) {

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = null;
        if (rowIndex == 0) {
            res = new ArrayList<>();
            res.add(1);
            return res;
        }

        if (rowIndex == 1) {
            res = new ArrayList<>();
            res.add(1);
            res.add(1);
            return res;
        }


        List<Integer> pre_line = res;
        List<Integer> cur_line = null;

        return null;
    }
}
