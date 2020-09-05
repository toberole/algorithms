package com.zw.algorithms.jzoffer.q2;

import com.zw.algorithms.bean.BTree;

/**
 * 二叉搜索树的最近公共祖先
 */
public class Test10 {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树
     */
    public static BTree.TreeNode lowestCommonAncestor1(BTree.TreeNode root,
                                                       BTree.TreeNode p,
                                                       BTree.TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            //说明p，q都在左子树
            return lowestCommonAncestor1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            //说明p，q都在右子树
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            //p，q各在一边，说明当前的根就是最近共同祖先
            return root;
        }
    }

    /**
     * 普通二叉树
     */
    public static BTree.TreeNode lowestCommonAncestor2(BTree.TreeNode root,
                                                       BTree.TreeNode p,
                                                       BTree.TreeNode q) {
        if (root == null) return null;

        //如果根节点就是p或者q，返回根节点
        if (root == p || root == q) return root;

        //分别去左右子树里面找
        BTree.TreeNode left = lowestCommonAncestor2(root.left, p, q);
        BTree.TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            //p，q各在一边，说明当前的根就是最近共同祖先
            return root;
        } else if (left != null) {
            //说明p，q都在左子树
            return left;
        } else if (right != null) {
            //说明p，q都在右子树
            return right;
        } else {
            return null;
        }
    }
}
