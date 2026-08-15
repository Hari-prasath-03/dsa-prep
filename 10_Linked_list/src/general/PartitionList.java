package general;

import leetcode_node_impl.ListNode;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode();
        ListNode higher = new ListNode();

        ListNode lesserTemp = lesser, higherTemp = higher;
        while (head != null) {
            if (head.val < x) {
                lesserTemp.next = head;
                lesserTemp = lesserTemp.next;
            } else {
                higherTemp.next = head;
                higherTemp = higherTemp.next;
            }
            head = head.next;
        }
        higherTemp.next = null;
        lesserTemp.next = higher.next;

        return lesser.next;
    }

    static void main() {
        ListNode list1 = ListNode.of(1,4,3,2,5,2);
        System.out.println(partition(list1, 3));

        ListNode list2 = ListNode.of(2,1);
        System.out.println(partition(list2, 2));
    }
}
