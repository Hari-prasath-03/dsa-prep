# Queue

## Overview
FIFO (first in, first out) structure, elements are added at the rear and removed from the front. Backed by a linked list, circular array, or two stacks. Enqueue/dequeue are O(1) with a proper implementation (avoid using a plain array with shifting, which is O(n)).

## Key Operations & Complexity
| Operation | Complexity |
|---|---|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek front | O(1) |
| Search | O(n) |

## Circular Queue
- Fixed size array where front and rear wrap around using modulo, avoids wasting space that a naive array based queue loses after repeated dequeues.

## Monotonic Deque
- A double ended queue kept in increasing or decreasing order, elements violating the order are popped from the back before inserting. Front of the deque always holds the current max/min for a sliding window, each element pushed and popped at most once, giving O(n) overall.

---

## Problems by Pattern

### Monotonic Deque
- [Sliding Window Maximum][1]: decreasing deque of indices, pop smaller elements from the back before pushing, pop expired indices from the front, front is always the window max.

### Design
- [Design Circular Queue][2]: fixed size array, track front and rear indices with modulo wraparound, track count or use one empty slot to distinguish full from empty.
- [Implement Stack using Queues][3]: implement stack push/pop using two queues, either make push costly (rotate the queue after adding) or make pop costly (rotate elements to the second queue to expose the last one).

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/sliding-window-maximum/description/
[2]: https://leetcode.com/problems/design-circular-queue/description/
[3]: https://leetcode.com/problems/implement-stack-using-queues/description/