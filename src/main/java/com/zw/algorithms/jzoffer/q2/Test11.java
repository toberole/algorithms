package com.zw.algorithms.jzoffer.q2;

import com.zw.algorithms.bean.BTree;

import java.util.Arrays;

/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Test11 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 1, 3)));
    }

    /**
     * 使用两种遍历树的结果 推导出树，其中必须有一种中序
     * 前序 + 中序
     * 后续 + 中序
     */

    /**
     * 前序遍历列表：第一个元素永远是 【根节点 (root)】
     * 中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
     * <p>
     * 算法思路：
     * 通过【前序遍历列表】确定【根节点 (root)】
     * 将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
     * 递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】
     */
    public static BTree.TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int rootVal = preorder[0];

        int rootIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        BTree.TreeNode root = new BTree.TreeNode(rootVal);

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
                Arrays.copyOfRange(inorder, 0, rootIndex)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length),
                Arrays.copyOfRange(inorder, rootIndex + 1, preorder.length)
        );

        return root;
    }
}
