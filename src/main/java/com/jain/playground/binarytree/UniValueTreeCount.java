package com.jain.playground.binarytree;

//Given a binary tree,count the number of uni-value subtrees.
//A Uni-value subtree means all nodes of the subtree have the same value.

class UniValueTreeCount {

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count); // check left is uni
        boolean right = helper(node.right, count); // check right is uni
        if (left && right) {
            // check left == right == left
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}