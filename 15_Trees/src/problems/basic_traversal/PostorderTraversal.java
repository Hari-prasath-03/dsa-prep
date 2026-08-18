package problems.basic_traversal;

import leetcode_treenode_impl.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postOrder(root, list);
        return list;
    }

    private static void postOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    static void main() {
        System.out.println(postorderTraversal(TreeNode.of(1,null,2,3))); // [3,2,1]
        System.out.println(postorderTraversal(TreeNode.of(1,2,3,4,5,null,8,null,null,6,7,9))); // [4,6,7,5,2,9,8,3,1]
        System.out.println(postorderTraversal(TreeNode.of()));
        System.out.println(postorderTraversal(TreeNode.of(1)));
    }
}
