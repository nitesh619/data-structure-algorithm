package com.jain.playground.binarytree;

class MaxDepth {

    // bottom - up approach
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // max of left or right branch
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}