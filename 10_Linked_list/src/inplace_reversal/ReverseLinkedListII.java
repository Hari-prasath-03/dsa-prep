package inplace_reversal;

import leetcode_node_impl.ListNode;

public class ReverseLinkedListII {
    private static ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right == left) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode headToReverse = dummy.next, prevOfHeadToReverse = dummy;
        for (int i = 1; i < left; i++) {
            prevOfHeadToReverse = headToReverse;
            headToReverse = headToReverse.next;
        }

        ListNode endOfReverse = headToReverse;
        for (int i = left; i < right; i++) {
            endOfReverse = endOfReverse.next;
        }

        ListNode startOfEnd = endOfReverse.next;
        endOfReverse.next = null;

        prevOfHeadToReverse.next = reverse(headToReverse);
        headToReverse.next = startOfEnd;

        return dummy.next;
    }

    static void main() {
        System.out.println(reverseBetween(ListNode.of(1,2,3,4,5), 2, 4)); // [1,4,3,2,5]
        System.out.println(reverseBetween(ListNode.of(5), 1, 1)); // [1,4,3,2,5]
        System.out.println(reverseBetween(ListNode.of(3, 5), 1, 2)); // [5,3]
    }
}
