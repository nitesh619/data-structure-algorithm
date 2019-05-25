package com.jain.playground.binarytree;

import java.util.ArrayList;
import java.util.List;

class PreOrderTraversal {

    public List<Integer> preOrderTraversal(TreeNode root) {
        // root - left - right
        List<Integer> pre = new ArrayList<>();
        preOrderTraversal(root, pre);
        return pre;
    }

    public void preOrderTraversal(TreeNode root, List<Integer> pre) {
        if (root != null) {
            pre.add(root.val);
            preOrderTraversal(root.left, pre);
            preOrderTraversal(root.right, pre);
        }
    }
}