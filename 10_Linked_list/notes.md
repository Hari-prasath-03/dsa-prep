# Linked List

## Overview
A sequence of nodes where each node holds data and a pointer to the next node (and previous, for doubly linked lists). No contiguous memory requirement, so insertion/deletion at a known position is O(1), but random access requires O(n) traversal.

## Key Operations & Complexity
| Operation | Complexity |
|---|---|
| Access by index | O(n) |
| Insert/Delete at head | O(1) |
| Insert/Delete at tail (no tail pointer) | O(n) |
| Insert/Delete at tail (with tail pointer) | O(1) |
| Search | O(n) |

## Common Patterns
- **Fast and slow pointers**: one pointer moves one step, the other moves two steps, used for finding the middle, detecting cycles, or finding a value N nodes from the end.
- **In-place reversal**: track `prev`, `curr`, and `next` while walking the list, rewiring pointers as you go, no extra space needed.
- **Dummy node**: create a placeholder node before the head to simplify edge cases (deleting the head, merging lists), avoids special casing the first node.

---

## Problems by Pattern

### Fast and Slow Pointers
- [Middle of the Linked List][1]: slow moves one step, fast moves two, slow lands on the middle when fast reaches the end.
- [Linked List Cycle][2]: if fast and slow ever meet, there's a cycle (Floyd's algorithm).
- [Delete the Middle Node of a Linked List][3]: fast/slow to locate the middle, keep a trailing pointer to unlink it.
- [Palindrome Linked List][4]: fast/slow to find the middle, reverse the second half, compare both halves.
- [Find the Duplicate Number][5]: array values treated as pointers, fast/slow cycle detection finds the entry point of the cycle, which is the duplicate.

### In-place Reversal
- [Reverse Linked List][6]: rewire `next` pointers one node at a time using `prev`, `curr`, `next`.
- [Reverse Linked List II][7]: reverse only the sublist between two positions, reconnect the reversed part back into the list.
- [Swap Nodes in Pairs][8]: reverse two nodes at a time, carefully reconnecting each pair to the next.

### Merge
- [Merge Two Sorted Lists][9]: compare heads of both lists, attach the smaller, advance that list's pointer.
- [Sort List][10]: merge sort, use fast/slow to split the list in half, recursively sort, merge two sorted halves.

### Two Pointers (Gap)
- [Remove Nth Node From End of List][11]: advance one pointer n steps ahead, then move both together until the lead pointer hits the end.

### General
- [Partition List][12]: build two separate chains (less than x, greater or equal), then connect them.
- [Odd Even Linked List][13]: separate nodes into odd-index and even-index chains, then connect odd chain's tail to even chain's head.
- [Remove Duplicates from Sorted List][14]: single pass, skip over nodes with the same value as the current node.
- [Reorder List][15]: find the middle (fast/slow), reverse the second half, merge the two halves alternately.
- [Add Two Numbers][16]: traverse both lists simultaneously, add digits with carry, build the result list as you go.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/middle-of-the-linked-list/description/
[2]: https://leetcode.com/problems/linked-list-cycle/description/
[3]: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
[4]: https://leetcode.com/problems/palindrome-linked-list/description/
[5]: https://leetcode.com/problems/find-the-duplicate-number/description/
[6]: https://leetcode.com/problems/reverse-linked-list/description/
[7]: https://leetcode.com/problems/reverse-linked-list-ii/description/
[8]: https://leetcode.com/problems/swap-nodes-in-pairs/description/
[9]: https://leetcode.com/problems/merge-two-sorted-lists/description/
[10]: https://leetcode.com/problems/sort-list/description/
[11]: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
[12]: https://leetcode.com/problems/partition-list/description/
[13]: https://leetcode.com/problems/odd-even-linked-list/description/
[14]: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
[15]: https://leetcode.com/problems/reorder-list/description/
[16]: https://leetcode.com/problems/add-two-numbers/description/