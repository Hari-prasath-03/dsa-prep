package merge;

import leetcode_node_impl.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode temp = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = (list1 == null) ? list2 : list1;
        return res.next;
    }

    public static ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoListsRec(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoListsRec(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) return list2;
        return list1;
    }

    static void main() {
        {
            ListNode list1 = ListNode.of(1, 2, 4);
            ListNode list2 = ListNode.of(1, 3, 4);
            System.out.println(mergeTwoListsRec(list1, list2));
        }
        {
            ListNode list1 = new ListNode();
            ListNode list2 = new ListNode();
            System.out.println(mergeTwoListsRec(list1, list2));
        }
        {
            ListNode list1 = new ListNode();
            ListNode list2 = new ListNode(0);
            System.out.println(mergeTwoListsRec(list1, list2));
        }
        {
            ListNode list1 = ListNode.of(1, 2, 3, 9);
            ListNode list2 = ListNode.of(4, 5, 6, 7, 8);
            System.out.println(mergeTwoListsRec(list1, list2));
        }
    }
}
