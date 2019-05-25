package com.jain.playground.binarytree;

import java.util.ArrayList;
import java.util.List;

// TwoPointer
public class BinarySearchTreeTwoSum {

    public boolean findTarget(TreeNode root, int target) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}