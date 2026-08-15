# Binary Search

## Overview
Repeatedly halves a search space by comparing the middle element to a target, eliminating half the remaining candidates each step. Requires the search space to be sorted or monotonic (a condition that flips from false to true, or vice versa, at some point).

## Key Operations & Complexity
| Operation | Time | Space |
|---|---|---|
| Standard binary search | O(log n) | O(1) |
| Binary search on answer space | O(log(range) * check cost) | O(1) |

## Templates
- **Exact match**: `low <= high`, return mid when `arr[mid] == target`.
- **First/Last occurrence**: don't stop at first match, keep narrowing to push the boundary left (first) or right (last).
- **Binary search on answer**: search space is not the array itself but a range of possible answers, use a `check(mid)` function to decide which half to keep.

---

## Problems by Pattern

### Find Occurrence
- [Find First and Last Position of Element in Sorted Array][1]: when `arr[mid] == target`, record it and keep searching right half for a later occurrence.

### Binary Search on Solution
- [Sqrt(x)][2]: search the answer range (0 to x), check if `mid * mid <= x`, narrow toward the largest valid mid.
- [Median of Two Sorted Arrays][3]: binary search on the partition index of the smaller array, check if the partition satisfies the median condition.

### General
- [Find Minimum in Rotated Sorted Array][4]: compare `arr[mid]` with `arr[high]` to decide which half is unsorted and contains the minimum.
- [Find Peak Element][5]: compare `arr[mid]` with `arr[mid + 1]`, move toward the side that's increasing.
- [Search a 2D Matrix][6]: treat the 2D matrix as a flattened sorted array, binary search using row/col conversion from a single index.
- [Search in Rotated Sorted Array][7]: determine which half is sorted, check if target lies within that half's range.
- [Single Element in a Sorted Array][8]: use index parity (even/odd) after the mid to decide which half contains the unpaired element.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
[2]: https://leetcode.com/problems/sqrtx/description/
[3]: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
[4]: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
[5]: https://leetcode.com/problems/find-peak-element/description/
[6]: https://leetcode.com/problems/search-a-2d-matrix/description/
[7]: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
[8]: https://leetcode.com/problems/single-element-in-a-sorted-array/description/