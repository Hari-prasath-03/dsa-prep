package problems.basic_traversal;

import leetcode_treenode_impl.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        return list;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    static void main() {
        System.out.println(inorderTraversal(TreeNode.of(1,null,2,3))); // [1,3,2]
        System.out.println(inorderTraversal(TreeNode.of(1,2,3,4,5,null,8,null,null,6,7,9))); // [4,2,6,5,7,1,3,9,8]
        System.out.println(inorderTraversal(TreeNode.of()));
        System.out.println(inorderTraversal(TreeNode.of(1)));
    }
}
