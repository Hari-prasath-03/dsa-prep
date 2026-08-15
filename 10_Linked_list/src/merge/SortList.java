package merge;

import leetcode_node_impl.ListNode;

public class SortList {
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = middleNode(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextToMiddle);
        return merge(left, right);
    }

    public static ListNode middleNode(ListNode fast) {
        ListNode slow = fast;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null) ? l2 : l1;
        return res.next;
    }

    static void main() {
        ListNode list1 = ListNode.of(4, 2, 3, 1);
        System.out.println(sortList(list1));
        ListNode list2 = ListNode.of(-1, 5, 3, 4, 0);
        System.out.println(sortList(list2));
        System.out.println(sortList(null));
    }
}
