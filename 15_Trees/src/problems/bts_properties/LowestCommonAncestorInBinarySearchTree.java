package problems.bts_properties;

import leetcode_treenode_impl.TreeNode;

public class LowestCommonAncestorInBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static TreeNode lowestCommonAncestorSpaceOptimised(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
        return null;
    }

    static void main() {
        {
            TreeNode root = TreeNode.of(6,2,8,0,4,7,9,null,null,3,5);
            TreeNode p = root.find(2), q = root.find(8);
            System.out.println(lowestCommonAncestorSpaceOptimised(root, p, q).val); // 6
        }
        {
            TreeNode root = TreeNode.of(6,2,8,0,4,7,9,null,null,3,5);
            TreeNode p = root.find(2), q = root.find(4);
            System.out.println(lowestCommonAncestorSpaceOptimised(root, p, q).val); // 2
        }
        {
            TreeNode root = TreeNode.of(2,1);
            TreeNode p = root.find(2), q = root.find(1);
            System.out.println(lowestCommonAncestorSpaceOptimised(root, p, q).val); // 2
        }
    }
}
