package leetcode_node_impl;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... nums) {
        ListNode list = new ListNode();
        ListNode temp = list;
        for (int num: nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return list.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) sb.append(" -> ");
            temp = temp.next;
        }
        return sb.toString();
    }
}
