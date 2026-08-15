package two_pointers;

import leetcode_node_impl.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode res = new ListNode(0, head);
        ListNode temp = res, rm = res;
        while (temp != null) {
            if (cnt++ > n) rm = rm.next;
            temp = temp.next;
        }
        rm.next = rm.next.next;
        return res.next;
    }

    static void main() {
        ListNode list1 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(removeNthFromEnd(list1, 2));
        ListNode list2 = new ListNode(1);
        System.out.println(removeNthFromEnd(list2, 1));
        ListNode list3 = ListNode.of(1, 2);
        System.out.println(removeNthFromEnd(list3, 1));
    }
}
