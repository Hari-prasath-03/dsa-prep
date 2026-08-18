package basic_tree_traversal;

import leetcode_treenode_impl.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private static void levelOrderTraversal(TreeNode head) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(head);

        while (!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (curr != null) {
                System.out.print(curr.val + " ");
                que.offer(curr.left);
                que.offer(curr.right);
            }
        }
    }

    // LC's - 102
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (curr == null) continue; // This line is exist just to satisfies my compiler! It don't do anything
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
                inner.add(curr.val);
            }
            list.add(inner);
        }
        return list;
    }

    static List<Integer> leftView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (curr == null) continue; // This line is exist just to satisfies my compiler! It don't do anything
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
                if (i == 0) list.add(curr.val);
            }
        }
        return list;
    }

    static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (curr == null) continue; // This line is exist just to satisfies my compiler! It don't do anything
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
                if (i == size - 1) list.add(curr.val);
            }
        }
        return list;
    }

    static void main() {
        System.out.println(levelOrder(TreeNode.of(3,9,20,null,null,15,7))); //[[3],[9,20],[15,7]]
        System.out.println(levelOrder(TreeNode.of(1))); // [[1]]
        /*
                              25
                       20           36
                   10     22      30      40
                 5     12       28      38    48
              0    6
        */
        TreeNode root = TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6);
        System.out.println(leftView(root)); // [25, 20, 10, 5, 0]
        System.out.println(rightView(root)); // [25, 36, 40, 48, 6]
    }
}
