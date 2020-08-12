package com.zw.algorithms.bean;

public class Tree {
    public static class TreeValue {
        public int[] data;
        public int index = 0;

        public TreeValue(int[] values) {
            this.data = values;
        }
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
    }

    /**
     * 前递序 归创建二叉树
     */
    public static TreeNode createTree(TreeNode node, TreeValue treeValue) {
        if (0 == treeValue.data[treeValue.index]) return null;

        node.val = treeValue.data[treeValue.index];

        TreeNode left = new TreeNode();
        treeValue.index++;
        node.left = createTree(left, treeValue);


        TreeNode right = new TreeNode();
        treeValue.index++;
        node.right = createTree(right, treeValue);

        return node;
    }

    /**
     * 前序打印
     *
     * @param root
     */
    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);

        printTree(root.left);
        printTree(root.right);
    }
}



