package problems.bfs_or_level_order_traversal;

import leetcode_treenode_impl.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideView(root, 0, list);
        return list;
    }

    private static void rightSideView(TreeNode root, int level, List<Integer> list) {
        if (root == null) return;
        if (list.size() == level) list.add(root.val);
        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }

    static void main() {
        System.out.println(rightSideView(TreeNode.of(1,2,3,null,5,null,4))); // [1,3,4]
        System.out.println(rightSideView(TreeNode.of(1,2,3,4,null,null,null,5))); // [1,3,4,5]
        System.out.println(rightSideView(TreeNode.of(1,null,3))); // [1,3]
        System.out.println(rightSideView(TreeNode.of())); // []
    }
}
