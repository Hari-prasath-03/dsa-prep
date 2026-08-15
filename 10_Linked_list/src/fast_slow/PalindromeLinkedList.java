package fast_slow;

import leetcode_node_impl.ListNode;

public class PalindromeLinkedList {
    public static ListNode middleNode(ListNode fast) {
        ListNode slow = fast;
        while (fast != null && fast.next != null) {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(middleNode(head));
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    static void main() {
        System.out.println(isPalindrome(ListNode.of(1, 2, 2, 1))); // true
        System.out.println(isPalindrome(ListNode.of(1, 2))); // false
    }
}
