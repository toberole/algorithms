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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode ret = root;
        while (true) {
            if (p.val < ret.val && q.val < ret.val) {
                ret = ret.left;
            } else if (p.val > ret.val && q.val > ret.val) {
                ret = ret.right;
            } else {
                break;
            }
        }

        return ret;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
