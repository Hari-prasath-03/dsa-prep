# Two Pointer

## Overview
Uses two index pointers to traverse a data structure (usually an array or string) instead of nested loops, cutting many O(n²) brute force solutions down to O(n). Works best on sorted arrays or when scanning from both ends or at different speeds reveals useful structure.

## Types of Two Pointer Approach
- **Opposite direction (converging)**: one pointer starts at the beginning, the other at the end, they move toward each other based on a condition. Common on sorted arrays.
- **Same direction (fast and slow)**: both pointers start together and move forward at different speeds or conditions, one tracks a "write" position while the other scans ahead.
- **Expand around center**: pointers start together at a candidate center and move outward in opposite directions, used for palindrome checks.

## Advantages
- Reduces time complexity from O(n²) to O(n) for many search/comparison problems.
- O(1) extra space, no auxiliary data structures needed.

## Challenges
- Usually requires the array to be sorted first (or sortable), which costs O(n log n) if not already sorted.
- Choosing the wrong movement condition (which pointer to move) can break correctness, needs careful proof of why shrinking from one side is safe.

## Key Operations & Complexity
| Approach | Time | Space |
|---|---|---|
| Two pointer scan | O(n) | O(1) |
| Two pointer with prior sort | O(n log n) | O(1) extra (excluding sort) |

---

## Problems by Pattern

### Converging Pointers
- [Two Sum II][1]: sorted array, move left/right pointers based on sum compared to target.
- [3Sum][2]: fix one element, two pointers converge on the remaining sorted subarray.
- [Container With Most Water][3]: move the pointer at the shorter line inward, since it's always the limiting factor.
- [Squares of Sorted Array][4]: compare absolute values from both ends, fill result array from the back.
- [Reverse String][5]: swap characters from both ends moving inward.

### Expand Around Center
- [Longest Palindromic Substring][6]: for each index (and each gap between indices), expand outward while characters match, track the longest match.

### General
- [Remove Duplicates From Sorted Array][7]: slow pointer marks the write position, fast pointer scans for the next unique value.
- [Trapping Rain Water][8]: track max height seen from left and right, move the pointer with the smaller max inward, add trapped water at each step.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
[2]: https://leetcode.com/problems/3sum/description/
[3]: https://leetcode.com/problems/container-with-most-water/description/
[4]: https://leetcode.com/problems/squares-of-a-sorted-array/description/
[5]: https://leetcode.com/problems/reverse-string/description/
[6]: https://leetcode.com/problems/longest-palindromic-substring/description/
[7]: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
[8]: https://leetcode.com/problems/trapping-rain-water/description/
