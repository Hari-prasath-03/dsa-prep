package general;

import leetcode_treenode_impl.TreeNode;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    static void main() {
        System.out.println(invertTree(TreeNode.of(4,2,7,1,3,6,9))); // [4,7,2,9,6,3,1]
        System.out.println(invertTree(TreeNode.of(2,1,3))); // [2,3,1]
        System.out.println(invertTree(TreeNode.of())); // []
    }
}
