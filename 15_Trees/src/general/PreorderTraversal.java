package general;

import leetcode_treenode_impl.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    private static void preOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    static void main() {
        System.out.println(preorderTraversal(TreeNode.of(1,null,2,3))); // [1,2,3]
        System.out.println(preorderTraversal(TreeNode.of(1,2,3,4,5,null,8,null,null,6,7,9))); // [1,2,4,5,6,7,3,8,9]
        System.out.println(preorderTraversal(TreeNode.of()));
        System.out.println(preorderTraversal(TreeNode.of(1)));
    }
}
