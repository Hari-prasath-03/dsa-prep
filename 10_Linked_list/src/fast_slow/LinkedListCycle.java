package fast_slow;

import leetcode_node_impl.ListNode;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    static void main() {
        {
            ListNode linkedNode = new ListNode(2);
            ListNode list = new ListNode(3, linkedNode.next = new ListNode(0, new ListNode(-4, linkedNode)));
            System.out.println(hasCycle(list)); // true
            /*
            3 -> 2 -> 0 -> -4
                 ^          |
                 |__________|
            * */
        }
        {
            ListNode list = new ListNode(1);
            list.next = new ListNode(2, list);
            System.out.println(hasCycle(list)); // true
            /*
            1 -> 2
            ^    |
            |____|
            * */
        }
        {
            ListNode list = new ListNode(1);
            list.next = new ListNode(2, new ListNode(3, new ListNode(4, list)));
            System.out.println(hasCycle(list)); // true
            /*
            1 -> 2 -> 3 -> 4
            ^              |
            |______________|
            * */
        }
        {
            ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            System.out.println(hasCycle(list)); // false
        }
        {
            ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
            System.out.println(hasCycle(list)); // false
        }
    }
}
