package com.zw.algorithms.test3;

import com.zw.algorithms.bean.TreeNode;

public class Tree1 {
    private int k;
    private int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        get_k(root);

        return res;
    }

    private void get_k(TreeNode root) {
        if (root == null || k == 0) return;
        get_k(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        get_k(root.left);
    }
}
