# Matrix

## Overview
A 2D array, elements accessed via `[row][col]`. Internally stored as an array of arrays (row major in Java), so `matrix[i]` gives a full row in O(1), and iterating row by row is more cache friendly than column by column.

## Matrix Traversal
- **Row wise / Column wise**: standard nested loops, `for row in rows: for col in cols`.
- **Row/Column specific**: fix one index, iterate the other, useful for extracting a single row or column.
- **Diagonal traversal**: main diagonal where `row == col`, anti diagonal where `row + col == n - 1`. Diagonals going the other direction keep `row - col` constant.

## Key Operations & Complexity
| Operation | Complexity |
|---|---|
| Access element | O(1) |
| Full traversal | O(rows * cols) |
| Row extraction | O(cols) |
| Column extraction | O(rows) |
| Transpose | O(rows * cols) |

## Common Techniques
- **Transpose then reverse**: rotating a matrix 90 degrees, transpose swaps `matrix[i][j]` with `matrix[j][i]`, then reverse each row (clockwise) or reverse each column (counterclockwise).
- **Boundary simulation**: track top, bottom, left, right boundaries and shrink them as you traverse layer by layer, used in spiral order problems.
- **In place marking**: use the first row/column or a sentinel value as markers to avoid extra space, common in "set to zero" style problems.

---

## Problems by Pattern

### Hashing
- [Valid Sudoku][1]: use hash sets (or boolean arrays) for each row, column, and 3x3 box, check for duplicates while scanning once.

### General
- [Rotate Image][2]: transpose the matrix, then reverse each row, all in place with O(1) extra space.
- [Spiral Matrix][3]: maintain top, bottom, left, right boundaries, traverse right, down, left, up, shrinking boundaries after each pass.
- [Set Matrix Zero][4]: first pass marks which rows/cols need zeroing (using first row/column as markers to stay O(1) space), second pass applies the zeroing.
- [Magic Squares In Grid][5]: slide a 3x3 window over the grid, check each window for the magic square property (rows, columns, diagonals all sum to the same value, using digits 1 to 9 exactly once).

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/valid-sudoku/description/
[2]: https://leetcode.com/problems/rotate-image/description/
[3]: https://leetcode.com/problems/spiral-matrix/description/
[4]: https://leetcode.com/problems/set-matrix-zeroes/description/
[5]: https://leetcode.com/problems/magic-squares-in-grid/description/
