# Permutation Using Queue (Java)

A console-based Java program that stores elements in a **Queue** and generates all permutations of a chosen size using **recursion** and **backtracking**.

## Features

- Add elements to a queue (input is converted to uppercase)
- Display the current queue
- Generate permutations of `r` elements out of `n` elements in the queue
- Show the total number of permutations generated
- Menu-driven interface

## Concepts Used

| Concept | Where it is used |
|---|---|
| `Queue` / `LinkedList` | Stores the elements (`add`, `poll`, `peek`, `isEmpty`, `size`) |
| Recursion | `arrangeElement()` builds each permutation |
| Backtracking | `isUsed[]` marks and unmarks elements while arranging |
| Arrays | `copyQueue()` copies the queue into a `String[]` |
| Static methods and variables | Shared `Scanner`, `queue`, and `total` counter |

## Project Structure

```
pagalan/
└── juvinne_Exam.java
```

## How to Run

**Requirements:** JDK 8 or higher.

From the folder that contains the `pagalan` directory:

```bash
javac pagalan/juvinne_Exam.java
java pagalan.juvinne_Exam
```

Or run it directly from your IDE (Eclipse, IntelliJ, NetBeans, VS Code).

## Menu

```
==========PERMUTATION==========
1. Add Element
2. Display Elements
3. Generate Permutation
4. Exit
```

| Option | Description |
|---|---|
| 1 | Asks how many elements to add, then enqueues each one |
| 2 | Prints the current queue, or "Queue is Empty." |
| 3 | Asks how many elements to arrange, then prints all permutations and the total |
| 4 | Exits the program |

> **Note:** When exactly 5 elements are added in one go, the program dequeues the first 2 elements (front of the queue) and displays the updated queue.

## How It Works

1. **Add Element** – each input is converted to uppercase and added to the end of the queue.
2. **Copy Queue** – `copyQueue()` polls every element and adds it back, so the queue order stays the same while the values are copied to an array.
3. **Generate Permutation** – `arrangeElement()` is called recursively:
   - If `position == numSelect`, a full arrangement is printed and `total` is incremented.
   - Otherwise, it loops through the elements, picks one that is not yet used, marks it, recurses, then unmarks it (backtracking).

The number of permutations follows the formula:

```
P(n, r) = n! / (n - r)!
```

## Sample Run

```
Enter your choice: 1
Enter number of elements to add: 3
Enter element 1: a
Enter element 2: b
Enter element 3: c

Queue: [A, B, C]

Enter your choice: 3

Queue: [A, B, C]

Enter number of elements to arrange: 2

AB
AC
BA
BC
CA
CB

Total Permutation: 6
```

*(For `n = 3`, `r = 2`: P(3, 2) = 3! / 1! = 6)*

## Input Validation

- Choosing option 3 with an empty queue shows a message asking you to add elements first.
- The number of elements to arrange must be from `1` to the queue size.

## Author

Juvinne
