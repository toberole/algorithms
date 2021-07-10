package com.zw.algorithms.test3;

import com.zw.algorithms.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    /**
     * 前序遍历
     */
    public void preorderTraversal(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * 非递归前序遍历
     */
    public void preorderTraversal1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();

            System.out.println(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 递归中序遍历
     */
    public void midorderTraversal(TreeNode root) {
        if (root == null) return;
        midorderTraversal(root.left);
        System.out.println(root);
        midorderTraversal(root.right);
    }

    /**
     * 非递归中序遍历
     */
    public void midorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void postorderTraversal(TreeNode root) {
        if (root == null) return;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }


    public void postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                //访问左子树
                stack.push(node);
                node = node.left;
            }
            //判断栈顶元素(根)
            node = stack.peek();
            //1.如果此时的根的右子树为空node.right == null
            //2.如果此时的根的右子树已经访问过了node.right == prev(prev记录的是上次访问打印的节点)
            if (node.right == null || node.right == prev) {
                //打印根节点，并出栈，将打印过的节点从栈中删除
                stack.pop();
                System.out.println(node.val);
                //记录prev，表示以当前prev为根的子树已经访问过了
                prev = node;
                //node置null就不会再次访问以node为根节点的左右子树，这里的node既然已经打印，说明它的左右子树早已访问完毕
                node = null;
            } else {
                //访问右子树
                node = node.right;
            }
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();//
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public void levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {//如果根节点不为空,将第一层根节点入队列
            queue.offer(root);
        }

        while (!queue.isEmpty()) {//只要队列不为空，执行循环
            int num = queue.size();//记录此时队列的长度，此时的num代表了某一层一共有多少个节点，防止被后边入队的节点个数影响输出这一层的节点
            for (int i = 0; i < num; i++) {//对某一层的所有节点进行操作(从左到右)
                TreeNode topNode = queue.poll();//取出这一层第一个节点
                System.out.println(topNode.val);//打印节点
                if (topNode.left != null) {//将此节点的左子树根节点入队列
                    queue.offer(topNode.left);
                }
                if (topNode.right != null) {//将此节点的右子树根节点入队列
                    queue.offer(topNode.right);
                }
            }
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, left.left);
    }

    public int kthLargest(TreeNode root, int k) {
        if (k == 0) return root.val;

        kthLargest(root.left, k--);
        kthLargest(root.right, k--);

    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println();
    }

}