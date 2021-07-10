package com.zw.algorithms.test3;

import com.zw.algorithms.bean.TreeNode;

public class Solution6 {
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;

        TreeNode l = mirrorTree(root.left);
        TreeNode r = mirrorTree(root.right);

        root.left = r;
        root.right = l;
        return root;
    }

    public static TreeNode pre_visit(TreeNode root) {
        if (root == null) return root;

        TreeNode l = mirrorTree(root.left);
        TreeNode r = mirrorTree(root.right);

        root.left = r;
        root.right = l;
        return root;
    }
}
