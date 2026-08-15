# Backtracking

## Overview
An extension of recursion, explore a choice, recurse deeper, and undo (backtrack) the choice if it doesn't lead to a valid solution, then try the next choice. Effectively a depth-first search over a tree of decisions, pruning branches early when they can't possibly work.

## General Approach
1. Make a choice (add to current path/state).
2. Recurse into the next decision.
3. Undo the choice (remove from path/state) before trying the next option.
4. Prune early when a partial state already violates constraints, avoids wasting time exploring doomed branches.

## Key Aspects
- **State + choices + constraints**: every backtracking problem needs a way to track current state, the set of choices available at each step, and a check for valid/invalid states.
- **Time complexity**: usually exponential, bounded by branching factor raised to depth, pruning reduces the effective search space.
- **Space complexity**: O(depth) for the recursion stack plus the current path being built.

---

## Problems by Pattern

### Permutations
- [Permutations][1]: at each step, try every unused element next, mark it used, recurse, then unmark.

### Subsets / Combinations
- [Subsets][2]: at each element, branch into two choices, include it or skip it.
- [Combination Sum][3]: at each step, either reuse the current candidate or move to the next, backtrack when the running sum exceeds the target.

### Constraint Satisfaction
- [Sudoku Solver][4]: try digits 1 to 9 in each empty cell, check row/column/box validity, backtrack on dead ends.
- [N-Queens][5]: place one queen per row, check column and diagonal conflicts before placing, backtrack when no valid column remains.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/permutations/description/
[2]: https://leetcode.com/problems/subsets/description/
[3]: https://leetcode.com/problems/combination-sum/description/
[4]: https://leetcode.com/problems/sudoku-solver/description/
[5]: https://leetcode.com/problems/n-queens/description/