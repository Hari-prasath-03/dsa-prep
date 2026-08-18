package basic_tree_traversal;

import leetcode_treenode_impl.TreeNode;

public class DSF {
    static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    static void main() {
        TreeNode root = TreeNode.of(25,
                20,36,
                10,22,30,40,
                5,12,null,null,28,null,38,48,
                0,6);
        /*
                              25
                        20           36
                   10     22      30      40
                5     12       28      38    48
              0   6
        */
        System.out.println("\nInOrder");
        inOrder(root);
        System.out.println("\nPreOrder");
        preOrder(root);
        System.out.println("\nPostOrder");
        postOrder(root);
    }
}
