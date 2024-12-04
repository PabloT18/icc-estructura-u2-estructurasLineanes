# Implementación de Pilas en Java

Este documento describe la implementación de dos clases de pilas en Java: `Stack` y `StackGeneric<T>`. Ambas clases implementan la estructura de datos **Pila (Stack)** siguiendo el principio **LIFO (Last In, First Out)** utilizando listas enlazadas. A continuación, se detallan sus características, métodos y ejemplos de uso.

## Tabla de Contenidos

1. [Introducción](#introducción)
2. [Clase `Stack`](#clase-stack)
   - [Descripción](#descripción)
   - [Atributos](#atributos)
   - [Métodos](#métodos)
   - [Ejemplo de Uso](#ejemplo-de-uso)
3. [Clase `StackGeneric<T>`](#clase-stackgenerict)
   - [Descripción](#descripción-1)
   - [Atributos](#atributos-1)
   - [Métodos](#métodos-1)
   - [Ejemplo de Uso](#ejemplo-de-uso-1)
4. [Comparación entre `Stack` y `StackGeneric<T>`](#comparación-entre-stack-y-stackgenerict)
5. [Conclusión](#conclusión)

---

## Introducción

Una **Pila (Stack)** es una estructura de datos lineal que sigue el principio **LIFO**: el último elemento en entrar es el primero en salir. Es ideal para situaciones donde se requiere un orden estricto de procesamiento, como la gestión de llamadas (call stack), reversión de datos, o algoritmos de recorrido en profundidad.

Las clases `Stack` y `StackGeneric<T>` implementan esta estructura utilizando listas enlazadas, permitiendo un manejo dinámico de los elementos sin necesidad de una capacidad fija.

---

## Clase `Stack`

### Descripción

La clase `Stack` implementa una pila de enteros utilizando una lista enlazada. Permite añadir elementos a la cima de la pila y retirarlos también desde la cima de manera eficiente con una complejidad de **O(1)** para las operaciones principales.

### Atributos

```java
private Node top; // Nodo en la cima de la pila
private int size; // Número de elementos en la pila
```

- **`top`**: Referencia al nodo que se encuentra en la cima de la pila.
- **`size`**: Contador que mantiene el número de elementos presentes en la pila.

### Métodos

#### Constructor

```java
/**
 * Constructor de la clase Stack.
 * Inicializa una pila vacía con la cima como null y tamaño 0.
 */
public Stack() {
    this.top = null;
    this.size = 0;
}
```

#### `push(int value)`

Añade un nuevo elemento a la cima de la pila.

```java
/**
 * Método push:
 * Añade un nuevo elemento a la cima de la pila.
 *
 * @param value El valor del elemento que se desea añadir.
 *

 */
public void push(int value) {
    Node newNode = new Node(value);
    newNode.next = top;
    top = newNode;
    size++;
}
```

#### `pop()`

Retira y retorna el elemento en la cima de la pila.

```java
/**
 * Método pop:
 * Retira y retorna el elemento en la cima de la pila.
 *
 * @return El valor del elemento retirado.
 * @throws EmptyStackException Si la pila está vacía.
 *

 */
public int pop() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    int value = top.value;
    top = top.next;
    size--;
    return value;
}
```

#### `peek()`

Obtiene el valor del elemento en la cima de la pila sin retirarlo.

```java
/**
 * Método peek:
 * Retorna el valor del elemento en la cima de la pila sin retirarlo.
 *
 * @return El valor del elemento en la cima de la pila.
 * @throws EmptyStackException Si la pila está vacía.
 *

 */
public int peek() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    return top.value;
}
```

#### `isEmpty()`

Verifica si la pila está vacía.

```java
/**
 * Método isEmpty:
 * Verifica si la pila está vacía.
 *
 * @return <code>true</code> si la pila no contiene elementos, de lo contrario <code>false</code>.
 */
public boolean isEmpty() {
    return top == null;
}
```

#### `size()`

Retorna el número de elementos en la pila.

```java

public int size() {
    return size;
}
```

### Ejemplo de Uso

```java
package Materia.App;

import Materia.Staks.Stack;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de Stack
        Stack stack = new Stack();

        // Añadir elementos a la pila
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Obtener el tamaño de la pila
        System.out.println("Tamaño de la pila: " + stack.size()); // Salida: 3

        // Obtener el elemento en la cima sin retirarlo
        System.out.println("Elemento en la cima: " + stack.peek()); // Salida: 30

        // Retirar elementos de la pila
        System.out.println("Elemento retirado: " + stack.pop()); // Salida: 30
        System.out.println("Elemento retirado: " + stack.pop()); // Salida: 20

        // Verificar si la pila está vacía
        System.out.println("¿La pila está vacía? " + stack.isEmpty()); // Salida: false

        // Retirar el último elemento
        System.out.println("Elemento retirado: " + stack.pop()); // Salida: 10

        // Verificar nuevamente si la pila está vacía
        System.out.println("¿La pila está vacía? " + stack.isEmpty()); // Salida: true
    }
}
```

**Salida Esperada:**

```
Tamaño de la pila: 3
Elemento en la cima: 30
Elemento retirado: 30
Elemento retirado: 20
¿La pila está vacía? false
Elemento retirado: 10
¿La pila está vacía? true
```

---

## Clase `StackGeneric<T>`

### Descripción

La clase `StackGeneric<T>` implementa una pila genérica utilizando una lista enlazada genérica. Permite manejar cualquier tipo de dato, proporcionando flexibilidad y reutilización en diferentes contextos. Las operaciones principales (`push`, `pop`, `peek`, `isEmpty`, `size`) tienen una complejidad de **O(1)**.

### Atributos

```java
private NodeGeneric<T> top; // Nodo en la cima de la pila
private int size;           // Número de elementos en la pila
```

- **`top`**: Referencia al nodo que se encuentra en la cima de la pila.
- **`size`**: Contador que mantiene el número de elementos presentes en la pila.

### Métodos

#### Constructor

```java
/**
 * Constructor de la clase StackGeneric.
 * Inicializa una pila vacía con la cima como null y tamaño 0.
 */
public StackGeneric() {
    this.top = null;
    this.size = 0;
}
```

#### `push(T data)`

Añade un nuevo elemento a la cima de la pila.

```java
/**
 * Método push:
 * Añade un nuevo elemento a la cima de la pila.
 *
 * @param data El dato del elemento que se desea añadir.
 *
 */
public void push(T data) {
    NodeGeneric<T> newNode = new NodeGeneric<>(data);
    newNode.setNext(top);
    top = newNode;
    size++;
}
```

#### `pop()`

Retira y retorna el elemento en la cima de la pila.

```java
/**
 * Método pop:
 * Retira y retorna el elemento en la cima de la pila.
 *
 * @return El dato del elemento retirado.
 * @throws EmptyStackException Si la pila está vacía.

 */
public T pop() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    T data = top.getData();
    top = top.getNext();
    size--;
    return data;
}
```

#### `peek()`

Obtiene el valor del elemento en la cima de la pila sin retirarlo.

```java
/**
 * Método peek:
 * Retorna el dato del elemento en la cima de la pila sin retirarlo.
 *
 * @return El dato del elemento en la cima de la pila.
 * @throws EmptyStackException Si la pila está vacía.

 */
public T peek() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    return top.getData();
}
```

#### `isEmpty()`

Verifica si la pila está vacía.

```java
/**
 * Método isEmpty:
 * Verifica si la pila está vacía.
 *
 * @return <code>true</code> si la pila no contiene elementos, de lo contrario <code>false</code>.
 */
public boolean isEmpty() {
    return top == null;
}
```

#### `size()`

Retorna el número de elementos en la pila.

```java
/**
 * Método size:
 * Retorna el número de elementos en la pila.
 *
 * @return El tamaño actual de la pila.

 */
public int size() {
    return size;
}
```

#### `printAllNodes()`

Imprime todos los elementos de la pila en orden desde la cima hasta el final.

```java
/**
 * Método printAllNodes:
 * Imprime todos los elementos de la pila en orden desde la cima hasta el final.
 */
public void printAllNodes() {
    NodeGeneric<T> current = top;
    System.out.print("Cima -> ");
    while (current != null) {
        System.out.print(current.getData() + " -> ");
        current = current.getNext();
    }
    System.out.println("FIN");
}
```

### Ejemplo de Uso

```java
package Materia.App;

import Materia.Staks.StackGeneric;

public class App {
    public static void main(String[] args) {
        // Crear una pila genérica para almacenar Strings
        StackGeneric<String> stack = new StackGeneric<>();

        // Añadir elementos a la pila
        stack.push("Primer");
        stack.push("Segundo");
        stack.push("Tercero");

        // Obtener el tamaño de la pila
        System.out.println("Tamaño de la pila: " + stack.size()); // Salida: 3

        // Obtener el elemento en la cima sin retirarlo
        System.out.println("Elemento en la cima: " + stack.peek()); // Salida: Tercero

        // Retirar elementos de la pila
        System.out.println("Elemento retirado: " + stack.pop()); // Salida: Tercero
        System.out.println("Elemento retirado: " + stack.pop()); // Salida: Segundo

        // Verificar si la pila está vacía
        System.out.println("¿La pila está vacía? " + stack.isEmpty()); // Salida: false

        // Retirar el último elemento
        System.out.println("Elemento retirado: " + stack.pop()); // Salida: Primer

        // Verificar nuevamente si la pila está vacía
        System.out.println("¿La pila está vacía? " + stack.isEmpty()); // Salida: true

        // Imprimir todos los nodos (debería mostrar "FIN")
        stack.printAllNodes(); // Salida: Cima -> FIN
    }
}
```

**Salida Esperada:**

```
Tamaño de la pila: 3
Elemento en la cima: Tercero
Elemento retirado: Tercero
Elemento retirado: Segundo
¿La pila está vacía? false
Elemento retirado: Primer
¿La pila está vacía? true
Cima -> FIN
```

---

## Comparación entre `Stack` y `StackGeneric<T>`

| Característica              | `Stack`                            | `StackGeneric<T>`                       |
|-----------------------------|------------------------------------|-----------------------------------------|
| **Tipo de Datos**           | Enteros (`int`)                    | Genérico (`T`)                           |
| **Flexibilidad**            | Limitado a enteros                 | Puede manejar cualquier tipo de dato    |
| **Reutilización**           | Menor reutilización en diferentes contextos | Mayor reutilización en diferentes contextos |
| **Implementación de Nodos** | Utiliza la clase `Node`             | Utiliza la clase genérica `NodeGeneric<T>` |
| **Uso de Generics**         | No                               | Sí                                       |
| **Ejemplos de Uso**         | Manejo específico de enteros        | Manejo de diferentes tipos de datos como Strings, Objetos, etc. |
| **Complejidad de Métodos**  | O(1) para operaciones principales   | O(1) para operaciones principales       |

**Conclusión:**

- **`Stack`** es adecuada cuando se necesita manejar exclusivamente datos de tipo entero.
- **`StackGeneric<T>`** ofrece mayor flexibilidad al permitir manejar cualquier tipo de dato, facilitando su reutilización en diferentes contextos y aplicaciones.

---

## Conclusión

Las clases `Stack` y `StackGeneric<T>` proporcionan implementaciones eficientes de la estructura de datos **Pila (Stack)** en Java utilizando listas enlazadas. Mientras que `Stack` está especializada en enteros, `StackGeneric<T>` ofrece una solución más flexible y reutilizable para manejar diferentes tipos de datos. Ambas clases garantizan operaciones de inserción y eliminación en tiempo constante **O(1)**, lo que las hace ideales para una amplia gama de aplicaciones en programación y algoritmos.
