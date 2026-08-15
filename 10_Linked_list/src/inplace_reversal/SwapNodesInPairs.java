package inplace_reversal;

import leetcode_node_impl.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1, head);
        ListNode prev = temp;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            // swap the nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;
            // move to next pair
            prev = first;
            head = first.next;
        }
        return temp.next;
    }

    static void main() {
        System.out.println(swapPairs(ListNode.of(1, 2, 3, 4))); // 2, 1, 4, 3
        System.out.println(swapPairs(null)); // null
        System.out.println(swapPairs(ListNode.of(1))); // 1
        System.out.println(swapPairs(ListNode.of(1, 2, 3))); // 2, 1, 3
    }
}
