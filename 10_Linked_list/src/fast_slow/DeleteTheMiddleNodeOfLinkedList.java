package fast_slow;

import leetcode_node_impl.ListNode;

public class DeleteTheMiddleNodeOfLinkedList {
    static ListNode middleNode(ListNode slow) {
        ListNode fast = slow.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode middle = middleNode(head);
        middle.next = middle.next.next;
        return head;
    }

    static void main() {
        System.out.println(deleteMiddle(ListNode.of(1,3,4,7,1,2,6)));
        System.out.println(deleteMiddle(ListNode.of(1,2,3,4)));
        System.out.println(deleteMiddle(ListNode.of(2,1)));
    }
}
