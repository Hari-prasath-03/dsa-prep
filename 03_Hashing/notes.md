# Hashing

## Overview
A technique that maps data (keys) to a fixed size array (bucket) using a hash function, giving average O(1) time for insert, delete, and lookup. Backing structure is usually an array of buckets, each bucket handling collisions via chaining (linked list) or open addressing (probing).

## Hashing vs Encryption
- **Hashing**: one way, deterministic, used for fast lookup and data integrity. Not meant to be reversed.
- **Encryption**: two way, reversible with a key, used for confidentiality.

## Hash Functions
- Takes a key, returns an integer index within bucket array bounds.
- Good hash function: uniform distribution, deterministic, fast to compute, minimizes collisions.
- Collisions are inevitable (pigeonhole principle), handled by chaining or open addressing.

## Types of Hashing
- **Chaining**: each bucket holds a list of entries that hash to it.
- **Open Addressing**: on collision, probe for the next open slot (linear, quadratic, double hashing).
- **Load Factor**: entries divided by bucket count, triggers resize (rehash) when too high.

## Application of Hashing
- Fast lookup (HashMap, HashSet), caching, duplicate detection, counting frequencies, indexing, checksums.

## Hashing in Data Structures
- Java: `HashMap`, `HashSet`, `HashTable`.
- Average case O(1) for get/put/contains, worst case O(n) if many collisions (bad hash function or adversarial input).

## Key Operations & Complexity
| Operation | Average | Worst Case |
|---|---|---|
| Insert | O(1) | O(n) |
| Delete | O(1) | O(n) |
| Lookup | O(1) | O(n) |

---
## Problems by Pattern

### Hashing / Set
- [Intersection of Two Arrays][1]: put one array in a set, scan the other, collect common elements.
- [Longest Consecutive Sequence][2]: put all numbers in a set, for each number that starts a sequence (no predecessor in set), count consecutive length.

### Hashing / Counting
- [Ransom Note][3]: count character frequency of magazine, check if ransom note's needs are satisfied.
- [Valid Anagram][4]: count character frequency of both strings, compare counts.

### Design
- [Insert Delete GetRandom O(1)][5]: combine a HashMap (value to index) with an ArrayList (for O(1) random access), swap and pop for O(1) delete.

---
<!-- Link Definitions -->

[1]: https://leetcode.com/problems/intersection-of-two-arrays/description/
[2]: https://leetcode.com/problems/longest-consecutive-sequence/description/
[3]: https://leetcode.com/problems/ransom-note/description/
[4]: https://leetcode.com/problems/valid-anagram/description/
[5]: https://leetcode.com/problems/insert-delete-getrandom-o1/description/
