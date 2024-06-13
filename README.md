
# Linear Data Structures 

## Getting Started

This project is a practical exercise on how to implement basic linear data structures in Java. It includes examples of stacks, queues, and their generic versions, demonstrating how to manage different versions using annotated tags in Git.

This repository refers to the second unit of Data Structures, where the first chapter covers linear data structures: Stacks, Queues, and Linked Lists.


## Requirements
- Java JDK 11 or higher
- Git 2.20 or higher

## Stacks and Queues

### Stacks
A stack is a linear data structure that follows the LIFO (Last In, First Out) principle. It means that the last element added to the stack will be the first one to be removed. The main operations for a stack are:
- **Push:** Add an element to the top of the stack.
- **Pop:** Remove the element from the top of the stack.
- **Peek:** Retrieve the element at the top of the stack without removing it.
- **isEmpty:** Check if the stack is empty.

### Queues
A queue is a linear data structure that follows the FIFO (First In, First Out) principle. It means that the first element added to the queue will be the first one to be removed. The main operations for a queue are:
- **Add:** Add an element to the end of the queue.
- **Remove:** Remove the element from the front of the queue.
- **Peek:** Retrieve the element at the front of the queue without removing it.
- **isEmpty:** Check if the queue is empty.

## Node and NodeGeneric Classes

### Node
The `Node` class is used to represent a single element in a linked list, stack, or queue. It holds an integer value and a reference to the next node in the structure.

### NodeGeneric
The `NodeGeneric` class is a generic version of the `Node` class. It can hold any type of data (specified by the generic type parameter `T`) and a reference to the next node in the structure.

```java
public class Node {
    public int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class NodeGeneric<T> {
    T data;
    NodeGeneric<T> next;

    public NodeGeneric(T data) {
        this.data = data;
    }
}
```



## Versions

### Version 2.0.0

To create this version, use the following Git commands:

```sh
git add .
git commit -m "Initial version of data structures implementation"
git tag -a v2.0.0 -m "Materia de Estructura de Datos Lineales"
git push origin --tags
```

#### Description

This version includes the implementation of basic linear data structures:

- **Pila (Stack):** A stack implementation using the `Node` class.
- **Queue:** A queue implementation using the `Node` class.
- **QueueGeneric:** A generic queue implementation using the `NodeGeneric` class.
- **StackGeneric:** A generic stack implementation using the `NodeGeneric` class.

Additionally, this version includes examples in the `App` class demonstrating how to use these data structures.


### Version 2.0.2

To create this version, use the following Git commands:

```sh
git add .
git commit -m "Estructuras Lineales – Ejercicios"
git tag -a v2.0.2 -m "Estructuras Lineales – Ejercicios"
git push origin --tags
```

#### Description

This version includes the addition of two exercises related to linear data structures:
- **Exercise 01: Parentheses Validation**
  - Implementation of an algorithm to determine if a string containing only the characters '(', ')', '{', '}', '[' and ']' is valid.
  - Example usage:
    ```java
    SignValidator validParenthesis = new SignValidator();
    boolean result = validParenthesis.isValid("([]){}"); // True
    ```

- **Exercise 02: Stack Sorting**
  - Implementation of an algorithm to sort a stack of integers such that the smallest elements are at the top of the stack.
  - Example usage:
    ```java
    StackSorter stackSorter = new StackSorter();
    StackGeneric<Integer> stack = new StackGeneric<>();
    stack.push(7);
    stack.push(2);
    stack.push(5);
    stack.push(1);
    StackGeneric<Integer> stackSorted = stackSorter.sortStack(stack);
    stackSorted.printAllNodes(); // Output: 1 -> 2 -> 5 -> 7 -> END
    ```

This version also includes an update to the `App` class to demonstrate how to use these new exercises.


## Contribute

To contribute to this project, please create a fork and send a pull request, or simply open an issue with your comments and suggestions.

## Authors

- [PABLO TORRES] - Initial development