package com.zw.algorithms.test1;

import com.zw.algorithms.bean.BTree;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Test22 {
    public static void main(String[] args) {
        // test1();

        test2();
    }

    private static void test2() {
        int[] nums = {0, 2, 0, 1, 0, 3, 0};
        BTree bTree = new BTree(nums);
        bTree.midOrderCreate();
        bTree.print();
    }

    public static void test1() {
        int[] nums = {1, 2, 0, 0, 3, 0, 0};
        BTree bTree = new BTree(nums);
        bTree.preOrderCreate();
        bTree.print();
    }

    public static boolean isSameTree(BTree p, BTree q) {
        return false;
    }
}
