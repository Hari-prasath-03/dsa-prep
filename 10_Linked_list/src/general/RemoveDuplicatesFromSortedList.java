package general;

import leetcode_node_impl.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val)  temp.next = temp.next.next;
            else temp = temp.next;
        }

        return head;
    }

    static void main() {
        System.out.println(deleteDuplicates(ListNode.of(1,1,2)));
        System.out.println(deleteDuplicates(ListNode.of(1,1,2,3,3)));
    }
}
