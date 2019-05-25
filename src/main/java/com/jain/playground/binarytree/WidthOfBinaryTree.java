package com.jain.playground.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class WidthOfBinaryTree {

    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }

    // do pre-order traversal
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        //record leftmost node at depth and later subtract its post from righmost at same level
        left.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - left.get(depth) + 1); // at each level check width
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}