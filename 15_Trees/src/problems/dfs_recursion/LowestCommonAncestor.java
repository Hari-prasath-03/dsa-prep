package problems.dfs_recursion;

import leetcode_treenode_impl.TreeNode;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    static void main() {
        {
            TreeNode root = TreeNode.of(3,5,1,6,2,0,8,null,null,7,4);
            TreeNode p = root.find(5), q = root.find(1);
            System.out.println(lowestCommonAncestor(root, p, q).val); // 3
        }
        {
            TreeNode root = TreeNode.of(3,5,1,6,2,0,8,null,null,7,4);
            TreeNode p = root.find(5), q = root.find(4);
            System.out.println(lowestCommonAncestor(root, p, q).val); // 5
        }
        {
            TreeNode root = TreeNode.of(1,2);
            TreeNode p = root.find(1), q = root.find(2);
            System.out.println(lowestCommonAncestor(root, p, q).val); // 1
        }
    }
}
