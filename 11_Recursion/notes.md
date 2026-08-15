# Recursion

## Overview
A function that calls itself to solve smaller instances of the same problem, relying on the call stack to hold state for each call. Every recursive solution needs a base case (stops the recursion) and a recursive case (breaks the problem down and moves toward the base case).

## General Approach
1. Identify the base case, the smallest input where the answer is known directly.
2. Identify the recursive case, how to reduce the problem toward the base case.
3. Trust the recursion, assume the recursive call correctly solves the smaller subproblem, then figure out how to combine it into the current call's answer.

## Key Aspects
- **Call stack**: each call adds a stack frame, deep recursion risks stack overflow.
- **Time complexity**: often expressed via a recurrence relation (e.g. T(n) = T(n-1) + O(1)), depends on branching factor and depth.
- **Space complexity**: O(depth) for the call stack, plus any extra structures built along the way.
- **Recursion tree**: visualizing calls as a tree helps spot repeated subproblems (candidates for memoization) and count total calls.

---

## Problems by Pattern

### Backtracking / Combinatorial Generation
- [Generate Parentheses][1]: recursively add `(` or `)` while tracking open/close counts, backtrack when counts go invalid.
- [Letter Combinations of a Phone Number][2]: recursively pick one letter per digit, build the combination, backtrack to try the next letter.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/generate-parentheses/description/
[2]: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/