package com.zw.algorithms.test3;

import com.zw.algorithms.bean.TreeNode;

public class Solution7 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return (l > r ? l : r) + 1;
    }
}
