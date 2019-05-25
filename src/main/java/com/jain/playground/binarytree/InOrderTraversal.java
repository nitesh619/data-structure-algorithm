package com.jain.playground.binarytree;

import java.util.ArrayList;
import java.util.List;

class InOrderTraversal {

    //recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        // left - root- right
        List<Integer> ino = new ArrayList<>();
        inorderTraversal(root, ino);
        return ino;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ino) {
        if (root != null) {
            inorderTraversal(root.left, ino);
            ino.add(root.val);
            inorderTraversal(root.right, ino);
        }
    }

    //via looping
    public List<Integer> inorderTraversalLoop(TreeNode root) {
        TreeNode currNode = root;
        List<Integer> inorder = new ArrayList<Integer>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        stack.add(root);
        int top = 0;

        while (currNode != null && !stack.isEmpty()) {
            if (currNode.left != null) {
                top++;
                stack.add(top, currNode.left);
                currNode = currNode.left;
            } else {
                TreeNode node = stack.remove(top);
                top--;
                inorder.add(node.val);
                if (node.right != null) {
                    currNode = node.right;
                    top++;
                    stack.add(top, node.right);
                }
            }
        }
        return inorder;
    }
}