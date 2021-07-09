package com.zw.algorithms.test3;

import com.zw.algorithms.bean.TreeNode;

public class Solution5 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;
    }


    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return root;

        TreeNode left = mirrorTree1(root.left);
        TreeNode right = mirrorTree1(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {

    }
}
