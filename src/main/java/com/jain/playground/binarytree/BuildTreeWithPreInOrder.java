package com.jain.playground.binarytree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class BuildTreeWithPreInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int preStart = 0;
        int preEnd = preorder.length - 1;

        return buildTree(inorder, inStart, inEnd, preorder, preStart, preEnd);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart,
            int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (node.val == inorder[i]) {
                k = i;
            }
        }

        node.left = buildTree(inorder, inStart, k - 1, preorder, preStart + 1,
                preStart + 1 + k - inStart);
        node.right = buildTree(inorder, k + 1, inEnd, preorder, preStart + 1 + k - inStart, preEnd);

        return node;
    }
}