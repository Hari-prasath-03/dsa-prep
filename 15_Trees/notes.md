# Trees

## Overview
A hierarchical structure of nodes, each node holding data and references to child nodes. A binary tree restricts each node to at most two children (left and right). No cycles, one path exists between the root and any node.

## Binary Tree
- General tree where each node has at most 2 children, no ordering constraint between left and right values.
- Height: length of the longest path from root to a leaf. Balanced trees have height O(log n), skewed trees degrade to O(n).

## Binary Search Tree (BST)
- A binary tree with an ordering property: left subtree values are less than the node, right subtree values are greater.
- Inorder basic_tree_traversal of a BST visits nodes in sorted order, this property drives most BST-specific techniques.

## Balanced BST
- A BST where the height difference between left and right subtrees of every node is bounded (commonly by 1), keeping operations at O(log n) instead of degrading to O(n) on a skewed tree.

## Tree Traversals
| Traversal | Order | Typical Use |
|---|---|---|
| Preorder | root, left, right | copying/serializing a tree, prefix expression |
| Inorder | left, root, right | sorted output from a BST |
| Postorder | left, right, root | deleting a tree, postfix expression |
| BFS (Level order) | level by level, using a queue | shortest path in unweighted tree, level-based problems |
| DFS | preorder/inorder/postorder, using recursion or a stack | most tree problems reduce to some form of DFS |
| Vertical Order | grouped by column offset, top to bottom within each column | column-based views, printing a tree vertically |

## Key Operations & Complexity
| Operation | Balanced BST | Skewed Tree |
|---|---|---|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Traversal (any) | O(n) | O(n) |

---

## Problems by Pattern

### Traversal (Basic)
- [Binary Tree Preorder Traversal][1]: visit root, then recurse left, then right.
- [Binary Tree Inorder Traversal][2]: recurse left, visit root, then recurse right.
- [Binary Tree Postorder Traversal][3]: recurse left, recurse right, then visit root.

### BFS / Level Order Variants
- [Binary Tree Right Side View][4]: BFS level order, keep the last node visited at each level.
- [Binary Tree Zigzag Level Order Traversal][5]: BFS level order, reverse the order of nodes on alternating levels.
- [Maximum Width of Binary Tree][6]: BFS while assigning each node a positional index, width is the index range at each level.

### DFS Recursion (General)
- [Maximum Depth of Binary Tree][7]: recurse into both children, return `1 + max(left, right)`.
- [Invert Binary Tree][8]: recursively swap left and right children at every node.
- [Same Tree][9]: recurse both trees together, compare values and structure at each step.
- [Symmetric Tree][10]: recurse two pointers (mirror of each other) checking left against right.
- [Subtree of Another Tree][11]: DFS through the main tree, at each node check if the subtree rooted there matches (using the same-tree check).
- [Balanced Binary Tree][12]: DFS computing height bottom up, return -1 early if any subtree is already unbalanced.
- [Lowest Common Ancestor of a Binary Tree][13]: DFS both children, if both return non-null the current node is the LCA, otherwise propagate the non-null side up.
- [Binary Tree Maximum Path Sum][14]: post order DFS returning the best downward path from each node, track a global max including paths that go through a node from both sides.

### BST Properties
- [Validate Binary Search Tree][15]: DFS carrying a valid (low, high) range for each node, or inorder basic_tree_traversal checking strictly increasing values.
- [Kth Smallest Element in a BST][16]: inorder basic_tree_traversal (which visits in sorted order), stop at the kth visited node.
- [Lowest Common Ancestor of a Binary Search Tree][17]: compare target values against the current node's value to decide whether to go left, right, or stop.

### Tree Construction
- [Convert Sorted Array to Binary Search Tree][18]: recursively pick the middle element as root, left half builds the left subtree, right half builds the right subtree.
- [Construct Binary Tree from Preorder and Inorder Traversal][19]: preorder gives the root, inorder splits left/right subtrees around that root, recurse on each half.

### Design
- [Serialize and Deserialize Binary Tree][20]: preorder basic_tree_traversal to serialize (including null markers), rebuild recursively from the same sequence to deserialize.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
[2]: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
[3]: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
[4]: https://leetcode.com/problems/binary-tree-right-side-view/description/
[5]: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
[6]: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
[7]: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
[8]: https://leetcode.com/problems/invert-binary-tree/description/
[9]: https://leetcode.com/problems/same-tree/description/
[10]: https://leetcode.com/problems/symmetric-tree/description/
[11]: https://leetcode.com/problems/subtree-of-another-tree/description/
[12]: https://leetcode.com/problems/balanced-binary-tree/description/
[13]: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
[14]: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
[15]: https://leetcode.com/problems/validate-binary-search-tree/description/
[16]: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
[17]: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
[18]: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
[19]: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
[20]: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
