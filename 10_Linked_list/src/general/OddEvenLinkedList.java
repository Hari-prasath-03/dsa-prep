package general;

import leetcode_node_impl.ListNode;

public class OddEvenLinkedList {
    // time: O(n) space: not exactly a O(n) but we can do it more optimally!
    public static ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(), evenList = new ListNode();
        ListNode oddTemp = oddList, evenTemp = evenList;

        int cnt = 1;
        while (head != null) {
            if (cnt % 2 != 0) {
                oddTemp.next = head;
                oddTemp = oddTemp.next;
            } else {
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            }
            cnt++;
            head = head.next;
        }
        evenTemp.next = null;
        oddTemp.next = evenList.next;
        return oddList.next;
    }

    public static ListNode oddEvenListUsingPointer(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    static void main() {
        System.out.println(oddEvenListUsingPointer(ListNode.of(1,2,3,4,5)));
        System.out.println(oddEvenListUsingPointer(ListNode.of(2,1,3,5,6,4,7)));
    }
}
