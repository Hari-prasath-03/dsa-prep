package problems.design;

import leetcode_treenode_impl.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (curr != null) {
                sb.append(curr.val).append(",");
                que.offer(curr.left);
                que.offer(curr.right);
            } else sb.append("#,");
        }

        int end = sb.length() - 1;
        while (!sb.isEmpty() && end >= 0) {
            char curr = sb.charAt(end);
            if (curr == '#' || curr == ',') end--;
            else break;
        }
        return sb.substring(0, end + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] nums = data.split(",");
        int n = nums.length;

        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int i = 1;
        while (!que.isEmpty() && i < n) {
            TreeNode curr = que.poll();

            if (!"#".equals(nums[i])) {
                curr.left = new TreeNode(Integer.parseInt(nums[i]));
                que.offer(curr.left);
            }
            i++;

            if (i < n) {
                if (!"#".equals(nums[i])) {
                    curr.right = new TreeNode(Integer.parseInt(nums[i]));
                    que.offer(curr.right);
                }
                i++;
            }
        }

        return root;
    }

    static void main() {
        var obj = new SerializeAndDeserializeBinaryTree();
        {
            String serialized = obj.serialize(TreeNode.of(1, 2, 3, null, null, 4, 5));
            System.out.println("serialized: " + serialized);
            TreeNode deserialized = obj.deserialize(serialized);
            System.out.println("deserialized: " + deserialized);
        }
        {
            String serialized = obj.serialize(TreeNode.of());
            System.out.println("serialized: " + serialized);
            TreeNode deserialized = obj.deserialize(serialized);
            System.out.println("deserialized: " + deserialized);
        }
        {
            String serialized = obj.serialize(TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6));
            System.out.println("serialized: " + serialized);
            TreeNode deserialized = obj.deserialize(serialized);
            System.out.println("deserialized: " + deserialized);
        }
    }
}
