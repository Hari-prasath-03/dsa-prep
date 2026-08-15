# Sorting

## Overview
Arranging elements in a defined order (ascending/descending). Choice of algorithm depends on input size, whether stability matters (equal elements keep relative order), and whether extra space is allowed.

## Sorting Algorithms
- **Bubble Sort**: repeatedly swap adjacent out of order elements, largest bubbles to the end each pass. Simple but slow.
- **Selection Sort**: repeatedly find the minimum from the unsorted part and swap it to the front. Minimizes swaps but still O(n²).
- **Insertion Sort**: build the sorted array one element at a time, inserting each into its correct position. Fast on nearly sorted data.
- **Merge Sort**: divide and conquer, split array in half, recursively sort each half, merge two sorted halves. Stable, guaranteed O(n log n).

## Key Operations & Complexity
| Algorithm | Best | Average | Worst | Space | Stable |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Cyclic Sort | O(n) | O(n) | O(n) | O(1) | No |

## Cyclic Sort
- Applies when values are in a known range (like 1 to n), place each number at its correct index by repeatedly swapping until every index holds its expected value. Useful for finding missing, duplicate, or misplaced numbers in O(n) time and O(1) space.

---

## Problems by Pattern

### Cyclic Sort
- [First Missing Positive][1]: apply cyclic sort to place numbers in range, then scan for the first index whose value doesn't match.
- [Missing Number][2]: cyclic sort into range 0 to n, the index left without its value is the missing number.
- [Find All Duplicates in an Array][3]: cyclic sort, any value that lands on an index already holding its correct value is a duplicate.

### Two Pointers
- [Move Zeroes][4]: pointer tracks next non-zero position, swap non-zero elements forward as you scan.
- [Merge Sorted Array][5]: merge from the back using two pointers, avoids overwriting unprocessed elements in the first array.

### Dutch National Flag / Three-way Partitioning
- [Sort Colors][6]: partition array into three sections (0s, 1s, 2s) in one pass using low, mid, high pointers.

### General
- [Minimum Absolute Difference][7]: sort the array, the minimum difference always occurs between adjacent elements.
- [Wiggle Sort][8]: sort the array, then interleave by swapping adjacent pairs to create the zigzag pattern.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/first-missing-positive/description/
[2]: https://leetcode.com/problems/missing-number/description/
[3]: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
[4]: https://leetcode.com/problems/move-zeroes/description/
[5]: https://leetcode.com/problems/merge-sorted-array/description/
[6]: https://leetcode.com/problems/sort-colors/description/
[7]: https://leetcode.com/problems/minimum-absolute-difference/description/
[8]: https://leetcode.com/problems/wiggle-sort-II/description/