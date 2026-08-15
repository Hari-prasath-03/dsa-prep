# Heap

## Overview
A complete binary tree stored as an array, satisfying the heap property, every parent is smaller than its children (min heap) or larger than its children (max heap). Gives O(log n) insert and extract of the min/max, and O(1) peek.

## Types of Heap
- **Min Heap**: parent is always smaller than its children, root holds the minimum.
- **Max Heap**: parent is always larger than its children, root holds the maximum.

## Heap Representation
- Stored as an array, no explicit pointers needed.
- For a node at index `i`: parent is at `(i - 1) / 2`, left child at `2i + 1`, right child at `2i + 2`.

## Operations on Heap
| Operation | Complexity |
|---|---|
| Peek min/max | O(1) |
| Insert | O(log n) |
| Extract min/max | O(log n) |
| Build heap from array | O(n) |
| Heapify (sift up/down) | O(log n) |

## Heaps and Priority Queue
- A priority queue is the abstract concept (retrieve highest priority element first), a heap is the concrete data structure typically used to implement it efficiently. Java's `PriorityQueue` is a min heap by default, pass a custom comparator for max heap or custom ordering.

## Application of Heap
- Scheduling by priority, finding top K elements, merging K sorted lists, median maintenance (two heaps), Dijkstra's and Prim's algorithms.

---

## Problems by Pattern

### Top K Elements
- [K Closest Points to Origin][1]: max heap of size k by distance, pop the farthest whenever the heap exceeds k.
- [Kth Largest Element in an Array][2]: min heap of size k, root ends up being the kth largest.
- [Top K Frequent Words][3]: count frequencies with a hashmap, min heap of size k with a comparator on frequency (and lexical order for ties).
- [Find K Closest Elements][4]: max heap of size k by distance to target, or binary search for the window start.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/k-closest-points-to-origin/description/
[2]: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
[3]: https://leetcode.com/problems/top-k-frequent-words/description/
[4]: https://leetcode.com/problems/find-k-closest-elements/description/