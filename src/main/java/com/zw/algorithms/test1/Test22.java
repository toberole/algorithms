package com.zw.algorithms.test1;


import com.zw.algorithms.bean.Tree;


/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Test22 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0, 3, 0, 0};
        Tree.TreeValue treeValue = new Tree.TreeValue(nums);

        Tree.TreeNode root = new Tree.TreeNode();
        Tree.createTree(root, treeValue);

        System.out.println("*********************");
        Tree.printTree(root);
    }

    public static boolean isSameTree(Tree.TreeNode p, Tree.TreeNode q) {
        return false;
    }
}
