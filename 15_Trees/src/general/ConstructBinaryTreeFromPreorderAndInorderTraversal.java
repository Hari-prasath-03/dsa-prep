package general;

import leetcode_treenode_impl.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIdx = inMap.get(root.val);
        int leftLen = inIdx - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inIdx - 1, inMap);
        root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, inIdx + 1, inEnd, inMap);
        return root;
    }

    static void main() {
        System.out.println(
                buildTree(
                        new int[] {3,9,20,15,7},
                        new int[] {9,3,15,20,7}
                )); // [3,9,20,null,null,15,7]
        System.out.println(
                buildTree(
                        new int[] {25,20,10,5,0,6,12,22,36,30,28,40,38,48},
                        new int[] {0,5,6,10,12,20,22,25,28,30,36,38,40,48}
                )); // [25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6]
        System.out.println(buildTree(new int[] {-1}, new int[] {-1}));
    }
}
