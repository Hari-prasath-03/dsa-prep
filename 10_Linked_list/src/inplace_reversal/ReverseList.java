package inplace_reversal;

import leetcode_node_impl.ListNode;

public class ReverseList {
    public static ListNode reverseList(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void main() {
        System.out.println(reverseList(ListNode.of(1, 2, 3, 4, 5)));
        System.out.println(reverseList(ListNode.of(1, 2)));
    }
}
