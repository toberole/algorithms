package com.zw.algorithms.bean;

public class BTree {
    private TreeValue treeValue;
    private TreeNode root;

    public BTree(int[] nums) {
        treeValue = new TreeValue(nums);
        root = new TreeNode();
    }

    public void preOrderCreate() {
        preOrderCreateTree(root);
    }

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

    public void postOrderCreate() {
        postOrderCreateTree(root);
    }

    private void postOrderCreateTree(TreeNode root) {

    }

    public void print() {
        printTree(root);
    }

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


}



