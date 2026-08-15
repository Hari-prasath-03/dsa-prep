package general;

import leetcode_node_impl.ListNode;

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = middleNode(head);
        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode second = reverse(secondHalf);
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode curr) {
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
        ListNode list1 = ListNode.of(1,2,3,4);
        reorderList(list1); // 1,4,2,3
        System.out.println(list1);

        ListNode list2 = ListNode.of(1,2,3,4,5);
        reorderList(list2); // 1,5,2,4,3
        System.out.println(list2);
    }
}
