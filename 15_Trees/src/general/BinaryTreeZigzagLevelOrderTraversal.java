package general;

import leetcode_treenode_impl.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        boolean isBack = false;
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> inner = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (curr == null) continue;
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
                // both are insertions takes O(1) due to LinkedList
                if (isBack) inner.addFirst(curr.val);
                else inner.add(curr.val);
            }
            isBack = !isBack;
            list.add(inner);
        }
        return list;
    }

    static void main() {
        System.out.println(zigzagLevelOrder(TreeNode.of(3,9,20,null,null,15,7))); // [[3],[20,9],[15,7]]
        System.out.println(zigzagLevelOrder(TreeNode.of(1))); // [[1]]
        System.out.println(zigzagLevelOrder(TreeNode.of())); // []
        System.out.println(zigzagLevelOrder(TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6))); // [[25], [36,20], [10,22,30,40], [48,38,28,12,5], [0,6]]
    }
}
