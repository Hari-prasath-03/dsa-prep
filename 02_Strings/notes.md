# Strings

## Overview
A sequence of characters, usually stored as an array of chars under the hood. In Java, `String` is immutable, every modification creates a new object, so repeated concatenation in a loop is costly. Use `StringBuilder` for mutable, efficient building.

## Common Terminologies
- **Substring**: contiguous sequence of characters within a string.
- **Subsequence**: characters in order but not necessarily contiguous.
- **Palindrome**: reads the same forwards and backwards.
- **Anagram**: same characters, different arrangement.
- **Immutable**: cannot be changed after creation (Java, Python strings).

## Key Operations & Complexity
| Operation | Complexity |
|---|---|
| Access by index | O(1) |
| Concatenation (`+`) | O(n) per operation, O(n^2) in a loop |
| Concatenation (`StringBuilder`) | O(1) amortized per append |
| Comparison (`equals`) | O(n) |
| Substring | O(n) (creates new string) |
| Search (`indexOf`) | O(n * m) naive |

## Advantages
- Easy to read, compare, and manipulate with built in methods.
- Immutability in Java makes strings safe to share and use as hash keys.

## Disadvantages
- Immutability means naive concatenation is expensive.
- Extra memory overhead compared to raw char arrays.

## Common String Operations
- Concatenation, counting character frequency, removing characters, reversing, case conversion, splitting/joining, checking palindrome or anagram.

---

## Problems by Pattern

### String Manipulation
- [Capitalize the Title][1]: split on spaces, capitalize first letter of each word, rebuild.

### Two Pointers
- [Valid Palindrome][2]: pointers from both ends, skip non-alphanumeric, compare case insensitively.
- [Reverse Words in a String][3]: trim extra spaces, reverse word order, reverse whole string then reverse each word.
- [String Compression][4]: in place, one pointer to read, one to write, count consecutive repeats.
- [Reverse Only Letters][5]: two pointers from both ends, skip non-letters, swap letters only.

### Hashing
- [Longest Palindrome][6]: count character frequency, pair up even counts, add one odd count in the middle if any.

### String Parsing / Simulation
- [String to Integer][7]: handle leading whitespace, optional sign, digit parsing, and overflow clamping to int range.

### Prefix Matching
- [Longest Common Prefix][8]: vertical scanning character by character across all strings, or horizontal scanning by shrinking the prefix.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/capitalize-the-title/description/
[2]: https://leetcode.com/problems/valid-palindrome/description/
[3]: https://leetcode.com/problems/reverse-words-in-a-string/description/
[4]: https://leetcode.com/problems/string-compression/description/
[5]: https://leetcode.com/problems/reverse-only-letters/description/
[6]: https://leetcode.com/problems/longest-palindrome/description/
[7]: https://leetcode.com/problems/string-to-integer-atoi/description/
[8]: https://leetcode.com/problems/longest-common-prefix/description/
