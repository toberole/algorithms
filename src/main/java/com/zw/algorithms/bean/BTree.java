package com.zw.algorithms.bean;

public class BTree {
    private TreeValue treeValue;
    private TreeNode root;

    public BTree(int[] nums) {
        treeValue = new TreeValue(nums);
        root = new TreeNode();
    }

    /**
     * 先序递归创建二叉树
     */
    public void preOrderCreate() {
        preOrderCreateTree(root);
    }

    /**
     * 中序递归创建二叉树
     */
    public void midOrderCreate() {
        midOrderCreateTree(root);
    }

    private TreeNode midOrderCreateTree(TreeNode treeNode) {
        if (treeValue.data[treeValue.index++] == 0) return null;

        treeNode.val = treeValue.data[treeValue.index++];

        TreeNode left = new TreeNode();
        treeNode.left = midOrderCreateTree(left);

        TreeNode right = new TreeNode();
        treeNode.right = midOrderCreateTree(right);

        return treeNode;
    }

    /**
     * 后续递归创建二叉树
     */
    public void postOrderCreate() {
        postOrderCreateTree(root);
    }

    private void postOrderCreateTree(TreeNode root) {

    }

    public void print() {
        printTree(root);
    }

    /**
     * 前递序 归创建二叉树
     */
    private TreeNode preOrderCreateTree(TreeNode node) {
        if (0 == treeValue.data[treeValue.index]) return null;

        node.val = treeValue.data[treeValue.index];

        TreeNode left = new TreeNode();
        treeValue.index++;
        node.left = preOrderCreateTree(left);

        TreeNode right = new TreeNode();
        treeValue.index++;
        node.right = preOrderCreateTree(right);

        return node;
    }

    /**
     * 前序打印
     */
    private void printTree(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println(treeNode.val);

        printTree(treeNode.left);
        printTree(treeNode.right);
    }

    public static class TreeValue {
        public int[] data;
        public int index;

        public TreeValue(int[] values) {
            this.index = 0;
            this.data = values;
        }
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
    }
}



