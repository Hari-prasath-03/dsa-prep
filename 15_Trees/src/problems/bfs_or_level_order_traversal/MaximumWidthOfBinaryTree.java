package problems.bfs_or_level_order_traversal;

import leetcode_treenode_impl.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Deque<Pair<TreeNode, Integer>> dq = new LinkedList<>();
        dq.offer(new Pair<>(root, 0));

        while (!dq.isEmpty()) {
            int size = dq.size();
            int stIdx = dq.peekFirst().getValue();
            int endIdx = dq.peekLast().getValue();
            maxWidth = Math.max(maxWidth, endIdx - stIdx + 1);

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curr = dq.poll();
                if (curr == null) continue;
                TreeNode node = curr.getKey();
                int idx = curr.getValue();

                if (node.left != null) dq.offer(new Pair<>(node.left, idx * 2));
                if (node.right != null) dq.offer(new Pair<>(node.right, idx * 2 + 1));
            }
        }
        return maxWidth;
    }

    static void main() {
        System.out.println(widthOfBinaryTree(TreeNode.of(1,3,2,5,3,null,9))); // 4
        System.out.println(widthOfBinaryTree(TreeNode.of(1,3,2,5,null,null,9,6,null,7))); // 7
        System.out.println(widthOfBinaryTree(TreeNode.of(1,3,2,5))); // 2
    }
}
