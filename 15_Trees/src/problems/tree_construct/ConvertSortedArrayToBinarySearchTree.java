package problems.tree_construct;

import leetcode_treenode_impl.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    static void main() {
        System.out.println(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
        System.out.println(sortedArrayToBST(new int[] {1,3}));
    }
}
