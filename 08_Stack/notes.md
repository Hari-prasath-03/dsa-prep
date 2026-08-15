# Stack

## Overview
LIFO (last in, first out) structure, elements are added and removed from the same end (the top). Backed by an array or linked list, push/pop/peek are all O(1).

## Key Operations & Complexity
| Operation | Complexity |
|---|---|
| Push | O(1) |
| Pop | O(1) |
| Peek | O(1) |
| Search | O(n) |

## When Stacks Show Up
- Matching/validating nested structures (brackets, tags).
- Undo operations, backtracking through choices.
- Evaluating expressions (infix, postfix), where operators need to wait for operands.
- Tracking "next greater/smaller" relationships efficiently using a monotonic stack.

## Monotonic Stack
- A stack kept in increasing or decreasing order by popping elements that violate the order before pushing a new one. Used to find the next/previous greater or smaller element in O(n) instead of O(n^2) brute force.

---

## Problems by Pattern

### Monotonic Stack
- [Daily Temperatures][1]: decreasing stack of indices, pop and compute distance when a warmer day is found.
- [Next Greater Element I][2]: decreasing stack, pop elements smaller than the current one and record the current as their next greater.
- [Largest Rectangle in Histogram][3]: increasing stack of indices, when a shorter bar appears, pop and calculate area using the popped bar's height.

### Design
- [Min Stack][4]: maintain a second stack (or store pairs) tracking the running minimum alongside each push, so getMin stays O(1).

### Expression Evaluation
- [Evaluate Reverse Polish Notation][5]: push operands, on an operator pop two, apply it, push the result back.
- [Basic Calculator][6]: stack holds pending signs/results across parentheses, evaluate left to right handling `+`, `-`, and nested groups.

### General
- [Valid Parentheses][7]: push opening brackets, pop and match on closing brackets, valid only if the stack empties at the end.
- [Decode String][8]: stack holds counts and partial strings, pop and repeat/build when a closing bracket is hit.
- [Longest Valid Parentheses][9]: stack of indices, pop on match and measure the valid span using the new top as a boundary.
- [Asteroid Collision][10]: stack simulates surviving asteroids, pop while a right-moving one collides with an incoming left-moving one.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/daily-temperatures/description/
[2]: https://leetcode.com/problems/next-greater-element-i/description/
[3]: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
[4]: https://leetcode.com/problems/min-stack/description/
[5]: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
[6]: https://leetcode.com/problems/basic-calculator/description/
[7]: https://leetcode.com/problems/valid-parentheses/description/
[8]: https://leetcode.com/problems/decode-string/description/
[9]: https://leetcode.com/problems/longest-valid-parentheses/description/
[10]: https://leetcode.com/problems/asteroid-collision/description/