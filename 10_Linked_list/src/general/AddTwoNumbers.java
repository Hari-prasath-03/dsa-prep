package general;

import leetcode_node_impl.ListNode;

public class AddTwoNumbers {
    private static int number(ListNode node) {
        if (node == null) return 0;
        return node.val + number(node.next) * 10;
    }
    private static ListNode buildList(int num) {
        if (num == 0) return null;
        return new ListNode(num % 10, buildList(num / 10));
    }
    // fail due to integer overflow error in leetcode
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = number(l1) + number(l2);
        if (num == 0) return new ListNode(0);
        return buildList(num);
    }

    // works for submittion
    public static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
        return addWithCarry(l1, l2, 0);
    }

    private static ListNode addWithCarry(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        return new ListNode(sum % 10, addWithCarry(l1, l2, sum / 10));
    }

    static void main() {
        {
            ListNode list1 = ListNode.of(2,4,3);
            ListNode list2 = ListNode.of(5,6,4);
            System.out.println(addTwoNumbersOptimized(list1, list2));
        }
        {
            ListNode list1 = ListNode.of(0);
            ListNode list2 = ListNode.of(0);
            System.out.println(addTwoNumbersOptimized(list1, list2));
        }
        {
            ListNode list1 = ListNode.of(9,9,9,9,9,9,9);
            ListNode list2 = ListNode.of(9,9,9,9);
            System.out.println(addTwoNumbersOptimized(list1, list2));
        }
    }
}
