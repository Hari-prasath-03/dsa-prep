# Arrays

## Overview
A contiguous block of memory holding elements of the same type, accessed via index in O(1). Fixed size in most languages (Java `int[]`); dynamic arrays (`ArrayList`) resize by allocating a new larger array and copying (amortized O(1) append).

## Types
- **1D Array**: linear sequence, single index.
- **2D / Matrix**: array of arrays, accessed via `[row][col]`.
- **Dynamic Array**: resizable wrapper (`ArrayList`, `Vector`) over a static array.
- **Jagged Array**: 2D array where each row can have a different length.

## Key Operations & Complexity
| Operation | Static Array | Dynamic Array |
|---|---|----------|
| Access by index | O(1) | O(1)     |
| Search (unsorted) | O(n) | O(n)     |
| Search (sorted, binary search) | O(log n) | O(log n)|
| Insert/Delete at end | n/a | O(1) amortized |
| Insert/Delete at start/middle | O(n), shift | O(n), shift |

## Advantages
- O(1) random access.
- Cache friendly (contiguous memory), fast iteration.
- Simple to use with predictable memory layout.

## Disadvantages
- Fixed size (static arrays), resizing is costly.
- Insert/delete at arbitrary position is O(n) due to shifting.
- Wasted space if over allocated (dynamic arrays).

## Common Array Algorithms
- Linear search, sorting, reversing in place, rotation (via reversal or extra array), finding peak/max/min, prefix sums, two-pointer scans.

---

## Problems by Pattern

### Linear Search
- [Find given element in the array][1]: linear scan baseline.

### Two Pointers
- [Rotate Array][2]: rotate in place using the reversal trick or cyclic replacement.

### Boyer-Moore Voting
- [Majority Element][3]: O(n) time, O(1) space, cancel out non-majority votes.

### Dynamic Programming / Greedy
- [Best Time to Buy and Sell Stock][4]: track running min price, max profit so far.

### Prefix Sum
- [Product of Array Except Self][5]: prefix/suffix product arrays, O(n) with no division.
- [Subarray Sum Equals K][6]: prefix sum plus hashmap of running sums.
- [Contiguous Array][7]: prefix sum trick (treat 0 as -1) plus hashmap.

### Greedy / Intervals
- [Non-overlapping Intervals][8]: sort by end time, greedily keep non-overlapping ones.
- [Insert Interval][9]: merge new interval into a sorted, non-overlapping list.

---
<!-- Link Definitions -->

[1]: https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1
[2]: https://leetcode.com/problems/rotate-array/description/
[3]: https://leetcode.com/problems/majority-element/description/
[4]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
[5]: https://leetcode.com/problems/product-of-array-except-self/description/
[6]: https://leetcode.com/problems/subarray-sum-equals-k/description/
[7]: https://leetcode.com/problems/contiguous-array/description/
[8]: https://leetcode.com/problems/non-overlapping-intervals/description/
[9]: https://leetcode.com/problems/insert-interval/description/
