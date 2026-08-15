package traversal;

import leetcode_treenode_impl.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    static void createHorizontalDistanceMap(TreeNode root, int key, Map<Integer, List<Integer>> map) {
        if (root == null) return;
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(root.val);
        createHorizontalDistanceMap(root.left, key - 1, map);
        createHorizontalDistanceMap(root.right, key + 1, map);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        createHorizontalDistanceMap(root, 0, map);
        return new ArrayList<>(map.values());
    }

    static List<Integer> topView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        for (List<Integer> col: verticalTraversal(root)) {
            list.add(col.getFirst());
        }
        return list;
    }

    static List<Integer> bottomView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        for (List<Integer> col: verticalTraversal(root)) {
            list.add(col.getLast());
        }
        return list;
    }

    static void main() {
        System.out.println(verticalTraversal(TreeNode.of(3,9,20,null,null,15,7))); // [[9], [3, 15], [20], [7]]
        System.out.println(verticalTraversal(TreeNode.of(1,2,3,4,5,6,7))); // [[4], [2], [1, 5, 6], [3], [7]]
        System.out.println(verticalTraversal(TreeNode.of(1,2,3,4,6,5,7))); // [[4], [2], [1, 6, 5], [3], [7]]

        /*
                              25
                       20           36
                   10     22      30      40
                 5     12       28      38    48
              0    6
        */
        TreeNode root = TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6);
        System.out.println(topView(root)); // [0, 5, 10, 20, 25, 36, 40, 48]
        System.out.println(bottomView(root)); // [0, 5, 6, 28, 30, 38, 40, 48]
    }
}
