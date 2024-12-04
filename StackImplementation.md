# Implementación de Colas en Java

Este documento describe la implementación de dos clases de colas en Java: `Queue` y `QueueGeneric<T>`. Ambas clases implementan la estructura de datos **Cola (Queue)** siguiendo el principio **FIFO (First In, First Out)** utilizando listas enlazadas. A continuación, se detallan sus características, métodos y ejemplos de uso.

## Tabla de Contenidos

1. [Introducción](#introducción)
2. [Clase `Queue`](#clase-queue)
   - [Descripción](#descripción)
   - [Atributos](#atributos)
   - [Métodos](#métodos)
   - [Ejemplo de Uso](#ejemplo-de-uso)
3. [Clase `QueueGeneric<T>`](#clase-queuegenerict)
   - [Descripción](#descripción-1)
   - [Atributos](#atributos-1)
   - [Métodos](#métodos-1)
   - [Ejemplo de Uso](#ejemplo-de-uso-1)
4. [Comparación entre `Queue` y `QueueGeneric<T>`](#comparación-entre-queue-y-queuegenerict)
5. [Conclusión](#conclusión)

---

## Introducción

Una **Cola (Queue)** es una estructura de datos lineal que sigue el principio **FIFO**: el primer elemento en entrar es el primero en salir. Es ideal para situaciones donde se requiere un orden estricto de procesamiento, como la gestión de tareas, sistemas de impresión, o simulaciones de colas en algoritmos.

Las clases `Queue` y `QueueGeneric<T>` implementan esta estructura utilizando listas enlazadas, permitiendo un manejo dinámico de los elementos sin necesidad de una capacidad fija.

---

## Clase `Queue`

### Descripción

La clase `Queue` implementa una cola de enteros utilizando una lista enlazada. Permite añadir elementos al final de la cola y retirarlos del frente de manera eficiente con una complejidad de **O(1)** para las operaciones principales.

### Atributos

```java
private Node front; // Nodo al frente de la cola
private Node rear;  // Nodo al final de la cola
private int size;    // Número de elementos en la cola
```

- **`front`**: Referencia al primer elemento de la cola.
- **`rear`**: Referencia al último elemento de la cola.
- **`size`**: Contador que mantiene el número de elementos presentes en la cola.

### Métodos

#### Constructor

```java
/**
 * Constructor de la clase Queue.
 * Inicializa una cola vacía con referencias front y rear como null y tamaño 0.
 */
public Queue() {
    this.front = null;
    this.rear = null;
    this.size = 0;
}
```

#### `enqueue(int value)`

Añade un nuevo elemento al final de la cola.

```java

public void enqueue(int value) {
    Node newNode = new Node(value);
    if (isEmpty()) {
        front = newNode;
        rear = newNode;
    } else {
        rear.next = newNode;
        rear = newNode;
    }
    size++;
}
```

#### `dequeue()`

Retira y retorna el elemento al frente de la cola.

```java
/**
 * Método dequeue:
 * Retira y retorna el elemento al frente de la cola.
 * 
 * @return El valor del elemento retirado.
 * @throws NoSuchElementException Si la cola está vacía.

 */
public int dequeue() {
    if (isEmpty()) {
        throw new NoSuchElementException("La cola está vacía.");
    }
    int value = front.value;
    front = front.next;
    if (front == null) {
        rear = null;
    }
    size--;
    return value;
}
```

#### `peek()`

Obtiene el valor del elemento al frente de la cola sin retirarlo.

```java
/**
 * Método peek:
 * Retorna el valor del elemento al frente de la cola sin retirarlo.
 * 
 * @return El valor del elemento al frente de la cola.
 * @throws NoSuchElementException Si la cola está vacía.

 */
public int peek() {
    if (isEmpty()) {
        throw new NoSuchElementException("La cola está vacía.");
    }
    return front.value;
}
```

#### `isEmpty()`

Verifica si la cola está vacía.

```java

public boolean isEmpty() {
    return front == null;
}
```

#### `size()`

Retorna el número de elementos en la cola.

```java


public int size() {
    return size;
}
```

### Ejemplo de Uso

```java
package Materia.App;

import Materia.Cola.Queue;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de Queue
        Queue queue = new Queue();

        // Añadir elementos a la cola
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Obtener el tamaño de la cola
        System.out.println("Tamaño de la cola: " + queue.size()); // Salida: 3

        // Obtener el elemento al frente de la cola sin retirarlo
        System.out.println("Elemento al frente: " + queue.peek()); // Salida: 10

        // Retirar elementos de la cola
        System.out.println("Elemento retirado: " + queue.dequeue()); // Salida: 10
        System.out.println("Elemento retirado: " + queue.dequeue()); // Salida: 20

        // Verificar si la cola está vacía
        System.out.println("¿La cola está vacía? " + queue.isEmpty()); // Salida: false

        // Retirar el último elemento
        System.out.println("Elemento retirado: " + queue.dequeue()); // Salida: 30

        // Verificar nuevamente si la cola está vacía
        System.out.println("¿La cola está vacía? " + queue.isEmpty()); // Salida: true
    }
}
```

**Salida Esperada:**

```
Tamaño de la cola: 3
Elemento al frente: 10
Elemento retirado: 10
Elemento retirado: 20
¿La cola está vacía? false
Elemento retirado: 30
¿La cola está vacía? true
```

---

## Clase `QueueGeneric<T>`

### Descripción

La clase `QueueGeneric<T>` implementa una cola genérica utilizando una lista enlazada genérica. Permite manejar cualquier tipo de dato, proporcionando flexibilidad y reutilización en diferentes contextos. Las operaciones principales (`add`, `remove`, `peek`, `isEmpty`, `size`) tienen una complejidad de **O(1)**.

### Atributos

```java
private NodeGeneric<T> first; // Nodo al frente de la cola
private NodeGeneric<T> last;  // Nodo al final de la cola
private int size;              // Número de elementos en la cola
```

- **`first`**: Referencia al primer elemento de la cola.
- **`last`**: Referencia al último elemento de la cola.
- **`size`**: Contador que mantiene el número de elementos presentes en la cola.

### Métodos

#### Constructor

```java
/**
 * Constructor de la clase QueueGeneric.
 * Inicializa una cola vacía con referencias first y last como null y tamaño 0.
 */
public QueueGeneric() {
    this.first = null;
    this.last = null;
    this.size = 0;
}
```

#### `add(T data)`

Añade un nuevo elemento al final de la cola.

```java
/**
 * Método add:
 * Añade un nuevo elemento al final de la cola.
 *
 * @param data El dato del elemento que se desea añadir.
 *

 */
public void add(T data) {
    NodeGeneric<T> newNode = new NodeGeneric<>(data);
    if (isEmpty()) {
        first = newNode;
        last = newNode;
    } else {
        last.setNext(newNode);
        last = newNode;
    }
    size++;
}
```

#### `remove()`

Retira y retorna el elemento al frente de la cola.

```java
/**
 * Método remove:
 * Retira y retorna el elemento al frente de la cola.
 *
 * @return El dato del elemento retirado.
 * @throws NoSuchElementException Si la cola está vacía.
 *

 */
public T remove() {
    if (isEmpty()) {
        throw new NoSuchElementException("La cola está vacía.");
    }
    T data = first.getData();
    first = first.getNext();
    if (first == null) {
        last = null;
    }
    size--;
    return data;
}
```

#### `peek()`

Obtiene el valor del elemento al frente de la cola sin retirarlo.

```java
/**
 * Método peek:
 * Retorna el dato del elemento al frente de la cola sin retirarlo.
 *
 * @return El dato del elemento al frente de la cola.
 * @throws NoSuchElementException Si la cola está vacía.

 */
public T peek() {
    if (isEmpty()) {
        throw new NoSuchElementException("La cola está vacía.");
    }
    return first.getData();
}
```

#### `isEmpty()`

Verifica si la cola está vacía.

```java
/**
 * Método isEmpty:
 * Verifica si la cola está vacía.
 */
public boolean isEmpty() {
    return first == null;
}
```

#### `size()`

Retorna el número de elementos en la cola.

```java

public int size() {
    return size;
}
```



### Ejemplo de Uso

```java
package Materia.App;

import Materia.Cola.QueueGeneric;

public class App {
    public static void main(String[] args) {
        // Crear una cola genérica para almacenar Strings
        QueueGeneric<String> queue = new QueueGeneric<>();

        // Añadir elementos a la cola
        queue.add("Primer");
        queue.add("Segundo");
        queue.add("Tercero");

        // Obtener el tamaño de la cola
        System.out.println("Tamaño de la cola: " + queue.size()); // Salida: 3

        // Obtener el elemento al frente de la cola sin retirarlo
        System.out.println("Elemento al frente: " + queue.peek()); // Salida: Primer

        // Retirar elementos de la cola
        System.out.println("Elemento retirado: " + queue.remove()); // Salida: Primer
        System.out.println("Elemento retirado: " + queue.remove()); // Salida: Segundo

        // Verificar si la cola está vacía
        System.out.println("¿La cola está vacía? " + queue.isEmpty()); // Salida: false

        // Retirar el último elemento
        System.out.println("Elemento retirado: " + queue.remove()); // Salida: Tercero

        // Verificar nuevamente si la cola está vacía
        System.out.println("¿La cola está vacía? " + queue.isEmpty()); // Salida: true
    }
}
```

**Salida Esperada:**

```
Tamaño de la cola: 3
Elemento al frente: Primer
Elemento retirado: Primer
Elemento retirado: Segundo
¿La cola está vacía? false
Elemento retirado: Tercero
¿La cola está vacía? true
```

---

## Comparación entre `Queue` y `QueueGeneric<T>`

| Característica              | `Queue`                            | `QueueGeneric<T>`                       |
|-----------------------------|------------------------------------|-----------------------------------------|
| **Tipo de Datos**           | Enteros (`int`)                    | Genérico (`T`)                           |
| **Flexibilidad**            | Limitado a enteros                 | Puede manejar cualquier tipo de dato    |
| **Reutilización**           | Menor reutilización en diferentes contextos | Mayor reutilización en diferentes contextos |
| **Implementación de Nodos** | Utiliza la clase `Node`             | Utiliza la clase genérica `NodeGeneric<T>` |
| **Uso de Generics**         | No                               | Sí                                       |
| **Ejemplos de Uso**         | Manejo específico de enteros        | Manejo de diferentes tipos de datos como Strings, Objetos, etc. |
| **Complexidad de Métodos**  | O(1) para operaciones principales   | O(1) para operaciones principales       |

**Conclusión:**

- **`Queue`** es adecuada cuando se necesita manejar exclusivamente datos de tipo entero.
- **`QueueGeneric<T>`** ofrece mayor flexibilidad al permitir manejar cualquier tipo de dato, facilitando su reutilización en diferentes contextos y aplicaciones.

---

## Conclusión

Las clases `Queue` y `QueueGeneric<T>` proporcionan implementaciones eficientes de la estructura de datos **Cola (Queue)** en Java utilizando listas enlazadas. Mientras que `Queue` está especializada en enteros, `QueueGeneric<T>` ofrece una solución más flexible y reutilizable para manejar diferentes tipos de datos. Ambas clases garantizan operaciones de inserción y eliminación en tiempo constante **O(1)**, lo que las hace ideales para una amplia gama de aplicaciones en programación y algoritmos.

