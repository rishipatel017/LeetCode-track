# DSA Placement Practice — Most Commonly Asked Coding Questions
### Pure Python (no imports / no built-in libraries) — for Tier-3 college placement rounds

Practice tip: Read the question, try coding it yourself for 10-15 min BEFORE looking at the answer.
Do this daily — 5 questions/day — and you will start clearing rounds easily.

---

## SECTION 1: ARRAYS

### 1. Find the largest element in an array
```python
def find_max(arr):
    max_val = arr[0]
    for i in range(1, len(arr)):
        if arr[i] > max_val:
            max_val = arr[i]
    return max_val

print(find_max([3, 7, 2, 9, 4]))  # 9
```

### 2. Find the second largest element
```python
def second_largest(arr):
    largest = second = float('-inf')
    for num in arr:
        if num > largest:
            second = largest
            largest = num
        elif num > second and num != largest:
            second = num
    return second

print(second_largest([3, 7, 2, 9, 4]))  # 7
```

### 3. Reverse an array (in-place, two pointer)
```python
def reverse_array(arr):
    left, right = 0, len(arr) - 1
    while left < right:
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1
    return arr

print(reverse_array([1, 2, 3, 4, 5]))  # [5,4,3,2,1]
```

### 4. Check if array is sorted
```python
def is_sorted(arr):
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True

print(is_sorted([1, 2, 3, 4]))  # True
```

### 5. Move all zeros to the end (keep order of non-zeros)
```python
def move_zeros(arr):
    pos = 0
    for i in range(len(arr)):
        if arr[i] != 0:
            arr[pos], arr[i] = arr[i], arr[pos]
            pos += 1
    return arr

print(move_zeros([0, 1, 0, 3, 12]))  # [1,3,12,0,0]
```

### 6. Find missing number in 1..n
```python
def missing_number(arr, n):
    expected_sum = n * (n + 1) // 2
    actual_sum = 0
    for num in arr:
        actual_sum += num
    return expected_sum - actual_sum

print(missing_number([1, 2, 4, 5], 5))  # 3
```

### 7. Find duplicate element in array
```python
def find_duplicate(arr):
    seen = []
    for num in arr:
        found = False
        for s in seen:
            if s == num:
                found = True
                break
        if found:
            return num
        seen.append(num)
    return -1

print(find_duplicate([1, 3, 4, 2, 2]))  # 2
```

### 8. Maximum subarray sum (Kadane's Algorithm) — VERY FREQUENTLY ASKED
```python
def max_subarray_sum(arr):
    max_so_far = arr[0]
    current_max = arr[0]
    for i in range(1, len(arr)):
        current_max = max(current_max + arr[i], arr[i])
        max_so_far = max(max_so_far, current_max)
    return max_so_far

print(max_subarray_sum([-2, 1, -3, 4, -1, 2, 1, -5, 4]))  # 6
```

### 9. Two Sum problem (without hashmap, brute force + optimized versions)
```python
# Brute Force O(n^2)
def two_sum_brute(arr, target):
    n = len(arr)
    for i in range(n):
        for j in range(i + 1, n):
            if arr[i] + arr[j] == target:
                return [i, j]
    return []

# Optimized using own dictionary logic (manual hashmap using dict is allowed,
# dict is a core language type not an external library)
def two_sum_optimized(arr, target):
    seen = {}
    for i in range(len(arr)):
        complement = target - arr[i]
        if complement in seen:
            return [seen[complement], i]
        seen[arr[i]] = i
    return []

print(two_sum_brute([2, 7, 11, 15], 9))  # [0,1]
```

### 10. Rotate array by k positions
```python
def rotate_array(arr, k):
    n = len(arr)
    k = k % n
    return arr[n - k:] + arr[:n - k]

print(rotate_array([1, 2, 3, 4, 5], 2))  # [4,5,1,2,3]
```

### 11. Find intersection of two arrays
```python
def intersection(arr1, arr2):
    result = []
    for a in arr1:
        for b in arr2:
            if a == b and a not in result:
                result.append(a)
    return result

print(intersection([1, 2, 2, 3], [2, 3, 4]))  # [2,3]
```

### 12. Kth largest element in array
```python
def kth_largest(arr, k):
    arr = arr[:]  # copy so original not modified
    n = len(arr)
    # simple selection sort style pick
    for i in range(k):
        max_idx = i
        for j in range(i + 1, n):
            if arr[j] > arr[max_idx]:
                max_idx = j
        arr[i], arr[max_idx] = arr[max_idx], arr[i]
    return arr[k - 1]

print(kth_largest([3, 2, 1, 5, 6, 4], 2))  # 5
```

---

## SECTION 2: STRINGS

### 13. Reverse a string
```python
def reverse_string(s):
    s = list(s)
    left, right = 0, len(s) - 1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1
    return "".join(s)

print(reverse_string("hello"))  # olleh
```

### 14. Check if string is palindrome
```python
def is_palindrome(s):
    left, right = 0, len(s) - 1
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True

print(is_palindrome("madam"))  # True
```

### 15. Check if two strings are anagrams
```python
def is_anagram(s1, s2):
    if len(s1) != len(s2):
        return False
    count = {}
    for ch in s1:
        count[ch] = count.get(ch, 0) + 1
    for ch in s2:
        if ch not in count:
            return False
        count[ch] -= 1
        if count[ch] < 0:
            return False
    for val in count.values():
        if val != 0:
            return False
    return True

print(is_anagram("listen", "silent"))  # True
```

### 16. Count occurrences of each character
```python
def char_count(s):
    count = {}
    for ch in s:
        count[ch] = count.get(ch, 0) + 1
    return count

print(char_count("hello"))  # {'h':1,'e':1,'l':2,'o':1}
```

### 17. Find first non-repeating character
```python
def first_unique_char(s):
    count = {}
    for ch in s:
        count[ch] = count.get(ch, 0) + 1
    for ch in s:
        if count[ch] == 1:
            return ch
    return None

print(first_unique_char("swiss"))  # w
```

### 18. Remove duplicate characters from string
```python
def remove_duplicates(s):
    seen = {}
    result = ""
    for ch in s:
        if ch not in seen:
            seen[ch] = True
            result += ch
    return result

print(remove_duplicates("programming"))  # progamin
```

### 19. Check if string contains only digits
```python
def is_numeric(s):
    for ch in s:
        if ch < '0' or ch > '9':
            return False
    return len(s) > 0

print(is_numeric("12345"))  # True
```

### 20. String to integer conversion (like atoi) — without int()
```python
def string_to_int(s):
    s = s.strip()
    if not s:
        return 0
    sign = 1
    i = 0
    if s[0] == '-':
        sign = -1
        i = 1
    elif s[0] == '+':
        i = 1
    result = 0
    while i < len(s) and '0' <= s[i] <= '9':
        result = result * 10 + (ord(s[i]) - ord('0'))
        i += 1
    return sign * result

print(string_to_int("  -123abc"))  # -123
```

### 21. Count vowels and consonants
```python
def count_vowels_consonants(s):
    vowels = "aeiouAEIOU"
    v_count = c_count = 0
    for ch in s:
        if ch.isalpha():
            if ch in vowels:
                v_count += 1
            else:
                c_count += 1
    return v_count, c_count

print(count_vowels_consonants("Hello World"))  # (3, 7)
```

### 22. Longest word in a sentence
```python
def longest_word(sentence):
    words = sentence.split()
    longest = ""
    for w in words:
        if len(w) > len(longest):
            longest = w
    return longest

print(longest_word("I love competitive programming"))  # competitive
```

### 23. Check for balanced parentheses (using own stack list)
```python
def is_balanced(s):
    stack = []
    pairs = {')': '(', ']': '[', '}': '{'}
    for ch in s:
        if ch in "([{":
            stack.append(ch)
        elif ch in ")]}":
            if not stack or stack[-1] != pairs[ch]:
                return False
            stack.pop()
    return len(stack) == 0

print(is_balanced("{[()]}"))  # True
print(is_balanced("{[(])}"))  # False
```

---

## SECTION 3: SEARCHING & SORTING

### 24. Linear Search
```python
def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

print(linear_search([4, 2, 7, 1], 7))  # 2
```

### 25. Binary Search (iterative) — VERY FREQUENTLY ASKED
```python
def binary_search(arr, target):
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

print(binary_search([1, 3, 5, 7, 9, 11], 7))  # 3
```

### 26. Binary Search (recursive)
```python
def binary_search_recursive(arr, target, low, high):
    if low > high:
        return -1
    mid = (low + high) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search_recursive(arr, target, mid + 1, high)
    else:
        return binary_search_recursive(arr, target, low, mid - 1)

print(binary_search_recursive([1, 3, 5, 7, 9], 9, 0, 4))  # 4
```

### 27. Bubble Sort
```python
def bubble_sort(arr):
    n = len(arr)
    for i in range(n - 1):
        swapped = False
        for j in range(n - 1 - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr

print(bubble_sort([5, 1, 4, 2, 8]))  # [1,2,4,5,8]
```

### 28. Selection Sort
```python
def selection_sort(arr):
    n = len(arr)
    for i in range(n - 1):
        min_idx = i
        for j in range(i + 1, n):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr

print(selection_sort([64, 25, 12, 22, 11]))  # [11,12,22,25,64]
```

### 29. Insertion Sort
```python
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr

print(insertion_sort([12, 11, 13, 5, 6]))  # [5,6,11,12,13]
```

### 30. Merge Sort — VERY FREQUENTLY ASKED
```python
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    while i < len(left):
        result.append(left[i])
        i += 1
    while j < len(right):
        result.append(right[j])
        j += 1
    return result

print(merge_sort([38, 27, 43, 3, 9, 82, 10]))
```

### 31. Quick Sort — VERY FREQUENTLY ASKED
```python
def quick_sort(arr, low=0, high=None):
    if high is None:
        high = len(arr) - 1
    if low < high:
        pi = partition(arr, low, high)
        quick_sort(arr, low, pi - 1)
        quick_sort(arr, pi + 1, high)
    return arr

def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

print(quick_sort([10, 7, 8, 9, 1, 5]))
```

---

## SECTION 4: LINKED LIST

### 32. Linked List basic implementation
```python
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node

    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")

ll = LinkedList()
ll.append(1)
ll.append(2)
ll.append(3)
ll.display()  # 1 -> 2 -> 3 -> None
```

### 33. Reverse a linked list — VERY FREQUENTLY ASKED
```python
def reverse_linked_list(head):
    prev = None
    current = head
    while current:
        next_node = current.next
        current.next = prev
        prev = current
        current = next_node
    return prev  # new head
```

### 34. Detect loop in linked list (Floyd's Cycle Detection)
```python
def has_cycle(head):
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            return True
    return False
```

### 35. Find middle of linked list
```python
def find_middle(head):
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    return slow.data if slow else None
```

### 36. Merge two sorted linked lists
```python
def merge_sorted_lists(l1, l2):
    dummy = Node(0)
    tail = dummy
    while l1 and l2:
        if l1.data <= l2.data:
            tail.next = l1
            l1 = l1.next
        else:
            tail.next = l2
            l2 = l2.next
        tail = tail.next
    tail.next = l1 if l1 else l2
    return dummy.next
```

---

## SECTION 5: STACKS & QUEUES

### 37. Implement stack using list
```python
class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if not self.is_empty():
            return self.items.pop()
        return None

    def peek(self):
        if not self.is_empty():
            return self.items[-1]
        return None

    def is_empty(self):
        return len(self.items) == 0

s = Stack()
s.push(1)
s.push(2)
print(s.pop())  # 2
```

### 38. Implement queue using list
```python
class Queue:
    def __init__(self):
        self.items = []

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if not self.is_empty():
            return self.items.pop(0)
        return None

    def is_empty(self):
        return len(self.items) == 0

q = Queue()
q.enqueue(1)
q.enqueue(2)
print(q.dequeue())  # 1
```

### 39. Implement Queue using two stacks (classic interview question)
```python
class QueueUsingStacks:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def enqueue(self, item):
        self.stack1.append(item)

    def dequeue(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        if not self.stack2:
            return None
        return self.stack2.pop()
```

### 40. Next Greater Element (using stack)
```python
def next_greater_element(arr):
    n = len(arr)
    result = [-1] * n
    stack = []
    for i in range(n - 1, -1, -1):
        while stack and stack[-1] <= arr[i]:
            stack.pop()
        if stack:
            result[i] = stack[-1]
        stack.append(arr[i])
    return result

print(next_greater_element([4, 5, 2, 25]))  # [5,25,25,-1]
```

---

## SECTION 6: RECURSION

### 41. Factorial
```python
def factorial(n):
    if n == 0 or n == 1:
        return 1
    return n * factorial(n - 1)

print(factorial(5))  # 120
```

### 42. Fibonacci (recursive + memoized)
```python
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

def fibonacci_memo(n, memo={}):
    if n in memo:
        return memo[n]
    if n <= 1:
        return n
    memo[n] = fibonacci_memo(n - 1, memo) + fibonacci_memo(n - 2, memo)
    return memo[n]

print(fibonacci_memo(10))  # 55
```

### 43. Sum of digits
```python
def sum_of_digits(n):
    if n == 0:
        return 0
    return n % 10 + sum_of_digits(n // 10)

print(sum_of_digits(12345))  # 15
```

### 44. Power of a number (x^n)
```python
def power(x, n):
    if n == 0:
        return 1
    if n % 2 == 0:
        half = power(x, n // 2)
        return half * half
    return x * power(x, n - 1)

print(power(2, 10))  # 1024
```

### 45. GCD of two numbers (Euclidean algorithm)
```python
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

print(gcd(48, 18))  # 6
```

---

## SECTION 7: TREES (Binary Tree basics)

### 46. Binary Tree implementation + Traversals
```python
class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def inorder(root, result=None):
    if result is None:
        result = []
    if root:
        inorder(root.left, result)
        result.append(root.data)
        inorder(root.right, result)
    return result

def preorder(root, result=None):
    if result is None:
        result = []
    if root:
        result.append(root.data)
        preorder(root.left, result)
        preorder(root.right, result)
    return result

def postorder(root, result=None):
    if result is None:
        result = []
    if root:
        postorder(root.left, result)
        postorder(root.right, result)
        result.append(root.data)
    return result

# Build a sample tree:
#        1
#       / \
#      2   3
#     / \
#    4   5
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print(inorder(root))    # [4,2,5,1,3]
print(preorder(root))   # [1,2,4,5,3]
print(postorder(root))  # [4,5,2,3,1]
```

### 47. Height of binary tree
```python
def tree_height(root):
    if root is None:
        return 0
    return 1 + max(tree_height(root.left), tree_height(root.right))

print(tree_height(root))  # 3
```

### 48. Level order traversal (BFS) using own queue
```python
def level_order(root):
    if root is None:
        return []
    result = []
    queue = [root]
    while queue:
        node = queue.pop(0)
        result.append(node.data)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    return result

print(level_order(root))  # [1,2,3,4,5]
```

### 49. Count total nodes in binary tree
```python
def count_nodes(root):
    if root is None:
        return 0
    return 1 + count_nodes(root.left) + count_nodes(root.right)

print(count_nodes(root))  # 5
```

### 50. Check if binary tree is a mirror / symmetric
```python
def is_mirror(t1, t2):
    if t1 is None and t2 is None:
        return True
    if t1 is None or t2 is None:
        return False
    return (t1.data == t2.data and
            is_mirror(t1.left, t2.right) and
            is_mirror(t1.right, t2.left))
```

---

## SECTION 8: BASIC DYNAMIC PROGRAMMING

### 51. Climbing stairs (1 or 2 steps at a time)
```python
def climb_stairs(n):
    if n <= 2:
        return n
    a, b = 1, 2
    for _ in range(3, n + 1):
        a, b = b, a + b
    return b

print(climb_stairs(5))  # 8
```

### 52. 0/1 Knapsack
```python
def knapsack(weights, values, capacity):
    n = len(weights)
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for w in range(capacity + 1):
            if weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
            else:
                dp[i][w] = dp[i - 1][w]
    return dp[n][capacity]

print(knapsack([1, 3, 4, 5], [1, 4, 5, 7], 7))  # 9
```

### 53. Longest Common Subsequence (LCS)
```python
def lcs(s1, s2):
    m, n = len(s1), len(s2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i - 1] == s2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[m][n]

print(lcs("abcde", "ace"))  # 3
```

### 54. Coin Change (minimum coins)
```python
def coin_change(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0
    for i in range(1, amount + 1):
        for c in coins:
            if c <= i:
                dp[i] = min(dp[i], dp[i - c] + 1)
    return dp[amount] if dp[amount] != float('inf') else -1

print(coin_change([1, 2, 5], 11))  # 3
```

---

## SECTION 9: MATH & BIT MANIPULATION

### 55. Check if number is prime
```python
def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

print(is_prime(29))  # True
```

### 56. Print all primes up to n (Sieve of Eratosthenes)
```python
def sieve_of_eratosthenes(n):
    is_prime_arr = [True] * (n + 1)
    is_prime_arr[0] = is_prime_arr[1] = False
    for i in range(2, int(n ** 0.5) + 1):
        if is_prime_arr[i]:
            for j in range(i * i, n + 1, i):
                is_prime_arr[j] = False
    return [i for i in range(n + 1) if is_prime_arr[i]]

print(sieve_of_eratosthenes(30))
```

### 57. Check if number is Armstrong number
```python
def is_armstrong(n):
    digits = str(n)
    power = len(digits)
    total = 0
    for d in digits:
        total += int(d) ** power
    return total == n

print(is_armstrong(153))  # True
```

### 58. Check if number is palindrome (without converting to string)
```python
def is_palindrome_number(n):
    original = n
    reversed_num = 0
    while n > 0:
        digit = n % 10
        reversed_num = reversed_num * 10 + digit
        n //= 10
    return original == reversed_num

print(is_palindrome_number(12321))  # True
```

### 59. Swap two numbers without a temp variable
```python
def swap(a, b):
    a = a + b
    b = a - b
    a = a - b
    return a, b

print(swap(5, 10))  # (10, 5)
```

### 60. Count set bits (1s) in binary representation
```python
def count_set_bits(n):
    count = 0
    while n:
        count += n & 1
        n >>= 1
    return count

print(count_set_bits(13))  # 3 (1101)
```

### 61. Check if a number is power of 2
```python
def is_power_of_two(n):
    if n <= 0:
        return False
    return (n & (n - 1)) == 0

print(is_power_of_two(16))  # True
```

### 62. Find single non-repeating element (all others appear twice) — using XOR
```python
def single_number(arr):
    result = 0
    for num in arr:
        result ^= num
    return result

print(single_number([4, 1, 2, 1, 2]))  # 4
```

---

## HOW TO PRACTICE THIS EFFECTIVELY

1. **Don't memorize — understand the pattern.** Two-pointer, sliding window, Kadane's, fast-slow pointers, and DP tabulation cover 80% of "easy/medium" rounds.
2. **Dry-run on paper.** Before typing code in an interview, trace through a small example (3-4 elements) — this is what interviewers actually watch for.
3. **Say your approach out loud first**, then code. Most Tier-3 rejections happen because candidates jump straight to code with no plan.
4. **Repeat weak topics.** If strings/arrays feel fine but recursion/DP don't, spend 2x time there.
5. **Time yourself.** Aim to solve each "easy" question in under 10-15 minutes without hints.

If you want, I can also give you:
- A **sliding window** question set (another very common round topic)
- A **hashmap/frequency-count** heavy set
- **Company-wise** frequently repeated questions (TCS/Infosys/Wipro/Cognizant style)

Just tell me which one to add next.
