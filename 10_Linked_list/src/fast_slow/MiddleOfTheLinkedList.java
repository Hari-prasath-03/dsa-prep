package fast_slow;

import leetcode_node_impl.ListNode;

public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void main() {
        System.out.println(middleNode(ListNode.of(1, 2, 3, 4, 5)));
        System.out.println(middleNode(ListNode.of(1, 2, 3, 4, 5, 6)));
    }
}
