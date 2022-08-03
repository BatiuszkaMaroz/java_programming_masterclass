# (Hash)Map

![hashmap](hashmap.png)

### Hashcode

While generating hash code multiply it by 31 (or any other prime, one less than power of two) for better distribution over buckets. More on that in Effective Java book.

### get() flow:

1. Obtain hash code from key (uses `hashCode()` method).
1. Retreive bucket calculated using hash code.
1. Get value with same key from list/tree\* that is in the bucket (uses `equals()` method).

### put() flow:

1. Obtain hash code from key (uses `hashCode()` method).
1. Retreive bucket calculated using hash code.
1. Add value to the list/tree\*.

### Rules

1. Equal keys **must** have **equal** hashes (if keys are equal its programmer job to make hascodes equal sometimes).
1. Different keys **can** have **equal** or **different** hashes.

### Conflicts

If two different keys have the same hash, the two values belonging to them will be stored in the same bucket. Inside a bucket, values are stored in a list and retrieved by looping over all elements. The cost of this is O(n).

\*As of Java 8 if bucket contains 8 or more elements list is changed to balanced tree, and if 6 or less it returns to list. It improves performance to O(log n).

### Facts

- Keys should be immutable. If key has changed we're no longer able to get the corresponding value because HashMap is searching in the wrong bucket.
- `null` can be a key in a map.

### `equals()`: `instanceof` vs `getClass()`

- [stackoverflow link](https://stackoverflow.com/questions/48490674/class-compare-vs-instanceof-in-equals-method-java)
- use `instanceof` in parent class if instances of subclassess will be compared to parent class / other subclasses,
- if only instances of one particular class will be compared use `getClass()` instead, it prevents from errors and is safer to use.
