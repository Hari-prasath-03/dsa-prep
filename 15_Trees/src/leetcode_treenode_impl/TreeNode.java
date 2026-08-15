package leetcode_treenode_impl;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer... nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) return null;
        int n = nums.length;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int i = 1;
        while (!que.isEmpty() && i < n) {
            TreeNode curr = que.poll();

            if (nums[i] != null) {
                curr.left = new TreeNode(nums[i]);
                que.add(curr.left);
            }
            i++;

            if (i < n) {
                if (nums[i] != null) {
                    curr.right = new TreeNode(nums[i]);
                    que.add(curr.right);
                }
                i++;
            }
        }

        return root;
    }

    public TreeNode find(int val) {
        if (this.val == val) return this;

        if (this.left != null) {
            TreeNode left = this.left.find(val);
            if (left != null) return left;
        }
        if (this.right != null) {
            TreeNode right = this.right.find(val);
            if (right != null) return right;
        }
        return null;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(this);

        while (!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (curr != null) {
                list.add(curr.val);
                que.add(curr.left);
                que.add(curr.right);
            } else list.add(null);
        }

        while (!list.isEmpty() && list.getLast() == null) {
            list.removeLast();
        }

        return list.toString();
    }
}
