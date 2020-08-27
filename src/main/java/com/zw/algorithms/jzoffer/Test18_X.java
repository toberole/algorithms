package com.zw.algorithms.jzoffer;

import com.zw.algorithms.bean.BTree;

import java.util.Stack;

/**
 * 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * 镜像输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class Test18_X {

    public static void main(String[] args) {

    }

    /**
     * 递归 根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
     * <p>
     * 终止条件： 当节点 rootroot 为空时（即越过叶节点），则返回 nullnull ；
     * 递推工作：
     * 初始化节点 tmptmp ，用于暂存 rootroot 的左子节点；
     * 开启递归 右子节点 mirrorTree(root.right)mirrorTree(root.right) ，并将返回值作为 rootroot 的 左子节点 。
     * 开启递归 左子节点 mirrorTree(tmp)mirrorTree(tmp) ，并将返回值作为 rootroot 的 右子节点 。
     * 返回值： 返回当前节点 rootroot ；
     * 时间复杂度 O(N)O(N) ： 其中 NN 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)O(N) 时间。
     * 空间复杂度 O(N)O(N) ： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N)O(N) 大小的栈空间。
     */
    public BTree.TreeNode mirrorTree(BTree.TreeNode root) {
        if (root == null) return null;
        BTree.TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    /**
     * 方法二：辅助栈（或队列）
     * 利用栈（或队列）遍历树的所有节点 nodenode ，并交换每个 nodenode 的左 / 右子节点。
     * 算法流程：
     * 特例处理： 当 rootroot 为空时，直接返回 nullnull ；
     * 初始化： 栈（或队列），本文用栈，并加入根节点 rootroot 。
     * 循环交换： 当栈 stackstack 为空时跳出；
     * 出栈： 记为 nodenode ；
     * 添加子节点： 将 nodenode 左和右子节点入栈；
     * 交换： 交换 nodenode 的左 / 右子节点。
     * 返回值： 返回根节点 rootroot 。
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： 其中 NN 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)O(N) 时间。
     * 空间复杂度 O(N)O(N) ： 最差情况下（当为满二叉树时），栈 stackstack 最多同时存储 N/2N/2 个节点，占用 O(N)O(N) 额外空间。
     */
    public static BTree.TreeNode mirrorTree1(BTree.TreeNode root) {
        if (root == null) return null;
        Stack<BTree.TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            BTree.TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);

            BTree.TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
