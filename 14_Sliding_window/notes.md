# Sliding Window

## Overview
Maintains a window (a contiguous subarray/substring) over the data, expanding and shrinking its boundaries instead of recomputing from scratch for every subarray. Turns many O(n^2) or O(n^3) brute force subarray/substring problems into O(n).

## Types of Sliding Window
- **Fixed size window**: window size is given upfront, slide it one step at a time, add the new element and remove the oldest.
- **Variable size window**: window grows by moving the right pointer, shrinks by moving the left pointer when a constraint is violated, size adapts based on the condition being tracked.

## Key Operations & Complexity
| Approach | Time | Space |
|---|---|---|
| Fixed window | O(n) | O(1) to O(k) depending on tracked state |
| Variable window | O(n) (each pointer moves forward at most n times) | O(1) to O(k) |

---

## Problems by Pattern

### Variable Size Window
- [Longest Substring Without Repeating Characters][1]: expand right, shrink left whenever a repeated character is found, track max window length.
- [Longest Repeating Character Replacement][2]: expand right, track max character frequency in window, shrink left when `window size - max freq > k`.
- [Minimum Window Substring][3]: expand right until all required characters are covered, shrink left while still valid, track the smallest valid window.

### Fixed Size Window
- [Find All Anagrams in a String][4]: window size equals pattern length, slide one step at a time, compare character frequency counts.

### Kadane's Algorithm
- [Maximum Subarray][5]: track running sum, reset to current element whenever running sum goes negative, keep max sum seen.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
[2]: https://leetcode.com/problems/longest-repeating-character-replacement/description/
[3]: https://leetcode.com/problems/minimum-window-substring/description/
[4]: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
[5]: https://leetcode.com/problems/maximum-subarray/description/