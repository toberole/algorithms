package com.zw.algorithms.jzoffer.q1;

import com.zw.algorithms.bean.BTree;

/**
 * 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 *
 * 输出: 4
 */
public class Test24 {
    public static void main(String[] args) {

    }

    public static int kthLargest(BTree.TreeNode root, int k) {
        if (k==1)return root.val;

        kthLargest(root.left,k--);
        if (k==0)return root.val;
        kthLargest(root.right,k--);

        return -1;
    }
}
