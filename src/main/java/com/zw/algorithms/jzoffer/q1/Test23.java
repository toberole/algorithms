package com.zw.algorithms.jzoffer.q1;

import com.zw.algorithms.bean.BTree;

/**
 * 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 */
public class Test23 {
    public static void main(String[] args) {

    }

    public static int maxDepth(BTree.TreeNode root) {
        if (root == null) return 0;
        int ld = maxDepth(root.left) + 1;
        int rd = maxDepth(root.right) + 1;

        return ld > rd ? ld : rd;
    }
}
