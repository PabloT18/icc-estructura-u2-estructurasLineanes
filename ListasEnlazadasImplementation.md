# Implementación de Listas Enlazadas en Java

Este documento describe la implementación de dos clases de listas enlazadas en Java: `ListaEnlazada` y `ListaEnlazadaGenerica<T>`. Ambas clases implementan la estructura de datos **Lista Enlazada (Linked List)**, proporcionando funcionalidades para añadir, eliminar, imprimir y obtener el tamaño de la lista. Además, se incluyen explicaciones detalladas sobre el funcionamiento de las listas enlazadas y sus aplicaciones comunes.

## Tabla de Contenidos

1. [Introducción](#introducción)
2. [Clase `ListaEnlazada`](#clase-listaenlazada)
   - [Descripción](#descripción)
   - [Atributos](#atributos)
   - [Métodos](#métodos)
   - [Ejemplo de Uso](#ejemplo-de-uso)
3. [Clase `ListaEnlazadaGenerica<T>`](#clase-listaenlazadagenerict)
   - [Descripción](#descripción-1)
   - [Atributos](#atributos-1)
   - [Métodos](#métodos-1)
   - [Ejemplo de Uso](#ejemplo-de-uso-1)
4. [Funcionamiento de las Listas Enlazadas](#funcionamiento-de-las-listas-enlazadas)
   - [Estructura de una Lista Enlazada](#estructura-de-una-lista-enlazada)
   - [Operaciones Básicas](#operaciones-básicas)
   - [Complejidad de Operaciones](#complejidad-de-operaciones)
5. [Usos Comunes de las Listas Enlazadas](#usos-comunes-de-las-listas-enlazadas)
6. [Comparación entre `ListaEnlazada` y `ListaEnlazadaGenerica<T>`](#comparación-entre-listaenlazada-y-listaenlazadagenerict)
7. [Conclusión](#conclusión)

---

## Introducción

Una **Lista Enlazada (Linked List)** es una estructura de datos lineal donde cada elemento (nodo) contiene un valor y una referencia (enlace) al siguiente nodo en la secuencia. A diferencia de los arrays, las listas enlazadas permiten una inserción y eliminación de elementos más eficiente, ya que no requieren reorganizar todos los elementos existentes.

Las clases `ListaEnlazada` y `ListaEnlazadaGenerica<T>` implementan esta estructura en Java, ofreciendo funcionalidades básicas para manipular la lista. Mientras que `ListaEnlazada` está especializada en almacenar enteros, `ListaEnlazadaGenerica<T>` es una implementación genérica que puede manejar cualquier tipo de dato.

---

## Clase `ListaEnlazada`

### Descripción

La clase `ListaEnlazada` implementa una lista enlazada simple que almacena elementos de tipo entero (`int`). Proporciona métodos para añadir elementos al final de la lista, eliminar nodos específicos, imprimir la lista y obtener el tamaño actual de la lista.

### Atributos

```java
public Node head; // Referencia al primer nodo de la lista
private int size = 0; // Contador del número de nodos en la lista
```

- **`head`**: Referencia al primer nodo de la lista. Si la lista está vacía, `head` es `null`.
- **`size`**: Contador que mantiene el número de nodos presentes en la lista.

### Métodos

#### Constructor

```java
/**
 * Constructor de la clase ListaEnlazada.
 * Inicializa una lista enlazada vacía con la cabeza como null y tamaño 0.
 */
public ListaEnlazada() {
    this.head = null;
    this.size = 0;
}
```

#### `appendToTail(int value)`

Añade un nuevo nodo al final de la lista.

```java
/**
 * Método appendToTail:
 * Añade un nuevo nodo al final de la lista.
 *
 * @param value Valor del nodo que se desea añadir.
 *
 * <p><b>Complejidad:</b> O(n).</p>
 * <ul>
 *     <li>Si la lista está vacía, el nuevo nodo se convierte en la cabeza.</li>
 *     <li>Si no está vacía, recorre la lista hasta el último nodo y enlaza el nuevo nodo.</li>
 * </ul>
 */
public void appendToTail(int value) {
    if (head == null) {
        head = new Node(value);
        size++;
        return;
    }

    Node current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = new Node(value);
    size++;
}
```

#### `deleteNode(int value)`

Elimina el primer nodo que contiene un valor específico.

```java
/**
 * Método deleteNode:
 * Elimina el primer nodo que contiene un valor específico.
 *
 * @param value El valor del nodo que se desea eliminar.
 *
 * <p><b>Complejidad:</b> O(n).</p>
 * <ul>
 *     <li>Si la lista está vacía, no realiza ninguna acción.</li>
 *     <li>Si el nodo a eliminar es la cabeza, actualiza la referencia `head` al siguiente nodo.</li>
 *     <li>Si el nodo a eliminar no es la cabeza, recorre la lista para encontrar el nodo y lo elimina.</li>
 *     <li>Decrementa el contador `size` si se elimina un nodo.</li>
 * </ul>
 */
public void deleteNode(int value) {
    if (head == null)
        return;

    if (head.value == value) {
        head = head.next;
        size--;
        return;
    }

    Node current = head;
    while (current.next != null) {
        if (current.next.value == value) {
            current.next = current.next.next;
            size--;
            return;
        }
        current = current.next;
    }
}
```

#### `print()`

Imprime todos los elementos de la lista en orden desde la cabeza hasta el final.

```java
/**
 * Método print:
 * Imprime todos los elementos de la lista en orden desde la cabeza hasta el final.
 *
 * <p><b>Complejidad:</b> O(n).</p>
 * <ul>
 *     <li>Recorre la lista desde la cabeza hasta el último nodo.</li>
 *     <li>Imprime el valor de cada nodo seguido de una flecha.</li>
 *     <li>Finaliza con "END" para indicar el final de la lista.</li>
 * </ul>
 */
public void print() {
    if (head == null) {
        System.out.println("END");
        return;
    }
    Node current = head;
    while (current.next != null) {
        System.out.print(current.value + " -> ");
        current = current.next;
    }
    System.out.println(current.value + " -> END");
}
```

#### `getSize()`

Retorna el número de elementos en la lista.

```java
/**
 * Método getSize:
 * Retorna el número de elementos en la lista.
 *
 * @return El tamaño actual de la lista.
 *
 * <p><b>Complejidad:</b> O(1).</p>
 * <ul>
 *     <li>Retorna el valor del contador `size`.</li>
 * </ul>
 */
public int getSize() {
    return size;
}
```

### Ejemplo de Uso

```java
package Materia.App;

import Materia.Listas.ListaEnlazada;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de ListaEnlazada
        ListaEnlazada lista = new ListaEnlazada();

        // Añadir elementos a la lista
        lista.appendToTail(10);
        lista.appendToTail(20);
        lista.appendToTail(30);
        lista.appendToTail(40);

        // Imprimir la lista
        lista.print(); // Salida: 10 -> 20 -> 30 -> 40 -> END

        // Obtener el tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.getSize()); // Salida: 4

        // Eliminar un elemento de la lista
        lista.deleteNode(20);
        lista.print(); // Salida: 10 -> 30 -> 40 -> END

        // Obtener el tamaño de la lista después de la eliminación
        System.out.println("Tamaño de la lista después de eliminar 20: " + lista.getSize()); // Salida: 3

        // Eliminar un elemento que no existe (no afecta la lista)
        lista.deleteNode(50);
        lista.print(); // Salida: 10 -> 30 -> 40 -> END
        System.out.println("Tamaño de la lista después de intentar eliminar 50: " + lista.getSize()); // Salida: 3
    }
}
```

**Salida Esperada:**

```
10 -> 20 -> 30 -> 40 -> END
Tamaño de la lista: 4
10 -> 30 -> 40 -> END
Tamaño de la lista después de eliminar 20: 3
10 -> 30 -> 40 -> END
Tamaño de la lista después de intentar eliminar 50: 3
```

---

## Clase `ListaEnlazadaGenerica<T>`

### Descripción

La clase `ListaEnlazadaGenerica<T>` implementa una lista enlazada simple genérica que puede almacenar elementos de cualquier tipo (`T`). Esta implementación proporciona mayor flexibilidad al permitir manejar diferentes tipos de datos sin necesidad de modificar la estructura básica de la lista.

### Atributos

```java
public NodeGeneric<T> head; // Referencia al primer nodo de la lista
private int size = 0; // Contador del número de nodos en la lista
```

- **`head`**: Referencia al primer nodo de la lista. Si la lista está vacía, `head` es `null`.
- **`size`**: Contador que mantiene el número de nodos presentes en la lista.

### Métodos

#### Constructor

```java
/**
 * Constructor de la clase ListaEnlazadaGenerica.
 * Inicializa una lista enlazada vacía con la cabeza como null y tamaño 0.
 */
public ListaEnlazadaGenerica() {
    this.head = null;
    this.size = 0;
}
```

#### `appendToTail(T data)`

Añade un nuevo nodo al final de la lista.

```java
/**
 * Método appendToTail:
 * Añade un nuevo nodo al final de la lista.
 *
 * @param data Dato del nodo que se desea añadir.
 *
 * <p><b>Complejidad:</b> O(n).</p>
 * <ul>
 *     <li>Si la lista está vacía, el nuevo nodo se convierte en la cabeza.</li>
 *     <li>Si no está vacía, recorre la lista hasta el último nodo y enlaza el nuevo nodo.</li>
 * </ul>
 */
public void appendToTail(T data) {
    if (head == null) {
        head = new NodeGeneric<>(data);
        size++;
        return;
    }

    NodeGeneric<T> current = head;
    while (current.getNext() != null) {
        current = current.getNext();
    }
    current.setNext(new NodeGeneric<>(data));
    size++;
}
```

#### `deleteNode(T data)`

Elimina el primer nodo que contiene un dato específico.

```java
/**
 * Método deleteNode:
 * Elimina el primer nodo que contiene un dato específico.
 *
 * @param data El dato del nodo que se desea eliminar.
 *
 * <p><b>Complejidad:</b> O(n).</p>
 * <ul>
 *     <li>Si la lista está vacía, no realiza ninguna acción.</li>
 *     <li>Si el nodo a eliminar es la cabeza, actualiza la referencia `head` al siguiente nodo.</li>
 *     <li>Si el nodo a eliminar no es la cabeza, recorre la lista para encontrar el nodo y lo elimina.</li>
 *     <li>Decrementa el contador `size` si se elimina un nodo.</li>
 * </ul>
 */
public void deleteNode(T data) {
    if (head == null)
        return;

    if (head.getData().equals(data)) {
        head = head.getNext();
        size--;
        return;
    }

    NodeGeneric<T> current = head;
    while (current.getNext() != null) {
        if (current.getNext().getData().equals(data)) {
            current.setNext(current.getNext().getNext());
            size--;
            return;
        }
        current = current.getNext();
    }
}
```

#### `print()`

Imprime todos los elementos de la lista en orden desde la cabeza hasta el final.

```java
/**
 * Método print:
 * Imprime todos los elementos de la lista en orden desde la cabeza hasta el final.
 *
 * <p><b>Complejidad:</b> O(n).</p>
 * <ul>
 *     <li>Recorre la lista desde la cabeza hasta el último nodo.</li>
 *     <li>Imprime el dato de cada nodo seguido de una flecha.</li>
 *     <li>Finaliza con "END" para indicar el final de la lista.</li>
 * </ul>
 */
public void print() {
    if (head == null) {
        System.out.println("END");
        return;
    }
    NodeGeneric<T> current = head;
    while (current.getNext() != null) {
        System.out.print(current.getData() + " -> ");
        current = current.getNext();
    }
    System.out.println(current.getData() + " -> END");
}
```

#### `getSize()`

Retorna el número de elementos en la lista.

```java
/**
 * Método getSize:
 * Retorna el número de elementos en la lista.
 *
 * @return El tamaño actual de la lista.
 *
 * <p><b>Complejidad:</b> O(1).</p>
 * <ul>
 *     <li>Retorna el valor del contador `size`.</li>
 * </ul>
 */
public int getSize() {
    return size;
}
```

### Ejemplo de Uso

```java
package Materia.App;

import Materia.Listas.ListaEnlazadaGenerica;

public class App {
    public static void main(String[] args) {
        // Crear una lista enlazada genérica para almacenar Strings
        ListaEnlazadaGenerica<String> lista = new ListaEnlazadaGenerica<>();

        // Añadir elementos a la lista
        lista.appendToTail("Primer");
        lista.appendToTail("Segundo");
        lista.appendToTail("Tercero");
        lista.appendToTail("Cuarto");

        // Imprimir la lista
        lista.print(); // Salida: Cima -> Primer -> Segundo -> Tercero -> Cuarto -> END

        // Obtener el tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.getSize()); // Salida: 4

        // Eliminar un elemento de la lista
        lista.deleteNode("Segundo");
        lista.print(); // Salida: Cima -> Primer -> Tercero -> Cuarto -> END

        // Obtener el tamaño de la lista después de la eliminación
        System.out.println("Tamaño de la lista después de eliminar 'Segundo': " + lista.getSize()); // Salida: 3

        // Eliminar un elemento que no existe (no afecta la lista)
        lista.deleteNode("Quinto");
        lista.print(); // Salida: Cima -> Primer -> Tercero -> Cuarto -> END
        System.out.println("Tamaño de la lista después de intentar eliminar 'Quinto': " + lista.getSize()); // Salida: 3
    }
}
```

**Salida Esperada:**

```
Cima -> Primer -> Segundo -> Tercero -> Cuarto -> END
Tamaño de la lista: 4
Cima -> Primer -> Tercero -> Cuarto -> END
Tamaño de la lista después de eliminar 'Segundo': 3
Cima -> Primer -> Tercero -> Cuarto -> END
Tamaño de la lista después de intentar eliminar 'Quinto': 3
```

---

## Funcionamiento de las Listas Enlazadas

### Estructura de una Lista Enlazada

Una **Lista Enlazada (Linked List)** consta de una serie de nodos, donde cada nodo contiene:

1. **Dato (Data):** El valor o contenido que almacena el nodo.
2. **Referencia al Siguiente Nodo (Next):** Un puntero que apunta al siguiente nodo en la lista.

En una lista enlazada simple, cada nodo solo tiene una referencia al siguiente nodo. En listas enlazadas dobles, cada nodo también tiene una referencia al nodo anterior, lo que facilita la navegación en ambas direcciones.

### Operaciones Básicas

1. **Inserción:**
   - **Al Final (appendToTail):** Añadir un nodo al final de la lista.
   - **Al Inicio (push):** Añadir un nodo al inicio de la lista.

2. **Eliminación:**
   - **Eliminar por Valor (deleteNode):** Remover el primer nodo que contiene un valor específico.
   - **Eliminar por Índice:** Remover un nodo en una posición determinada.

3. **Búsqueda:**
   - **Buscar por Valor:** Encontrar la posición de un nodo que contiene un valor específico.
   - **Buscar por Índice:** Acceder a un nodo en una posición determinada.

4. **Recorrido:**
   - **Imprimir la Lista:** Mostrar todos los elementos de la lista en orden.

5. **Obtención de Tamaño:**
   - **getSize:** Obtener el número total de nodos en la lista.

### Complejidad de Operaciones

| Operación            | Complejidad Temporal |
|----------------------|----------------------|
| Inserción al Final   | O(n)                 |
| Inserción al Inicio  | O(1)                 |
| Eliminación por Valor| O(n)                 |
| Búsqueda             | O(n)                 |
| Recorrido            | O(n)                 |
| Obtener Tamaño       | O(1)                 |

**Nota:** En la implementación proporcionada, `appendToTail` tiene una complejidad de O(n) porque es necesario recorrer toda la lista hasta el último nodo. Para optimizar esta operación, se puede mantener una referencia al último nodo (`tail`), reduciendo la complejidad a O(1).

---

## Usos Comunes de las Listas Enlazadas

Las listas enlazadas son versátiles y se utilizan en diversas aplicaciones debido a sus características de inserción y eliminación eficientes. Algunos usos comunes incluyen:

1. **Implementación de Otras Estructuras de Datos:**
   - **Pilas (Stacks):** Utilizan listas enlazadas para añadir y eliminar elementos desde un extremo.
   - **Colas (Queues):** Emplean listas enlazadas para mantener el orden de procesamiento.
   - **Listas Doblemente Enlazadas:** Utilizadas en navegadores web para el historial de páginas visitadas.

2. **Sistemas Operativos:**
   - **Gestión de Procesos:** Listas enlazadas se utilizan para mantener la lista de procesos en ejecución.
   - **Memoria Dinámica:** Administrar bloques de memoria libres y utilizados.

3. **Bases de Datos:**
   - **Índices:** Estructuras de índices en bases de datos pueden utilizar listas enlazadas para almacenar referencias.

4. **Juegos y Aplicaciones en Tiempo Real:**
   - **Listas de Entidades:** Mantener y gestionar entidades en juegos, como personajes y objetos.

5. **Navegadores Web:**
   - **Historial de Navegación:** Guardar el historial de páginas visitadas usando listas enlazadas.

6. **Aplicaciones de Texto y Edición:**
   - **Buffers de Texto:** Mantener y manipular el contenido de texto de manera eficiente.

---

## Comparación entre `ListaEnlazada` y `ListaEnlazadaGenerica<T>`

| Característica              | `ListaEnlazada`                     | `ListaEnlazadaGenerica<T>`               |
|-----------------------------|-------------------------------------|------------------------------------------|
| **Tipo de Datos**           | Enteros (`int`)                     | Genérico (`T`)                            |
| **Flexibilidad**            | Limitado a enteros                  | Puede manejar cualquier tipo de dato     |
| **Reutilización**           | Menor reutilización en diferentes contextos | Mayor reutilización en diferentes contextos |
| **Implementación de Nodos** | Utiliza la clase `Node`             | Utiliza la clase genérica `NodeGeneric<T>` |
| **Uso de Generics**         | No                                  | Sí                                        |
| **Ejemplos de Uso**         | Manejo específico de enteros         | Manejo de diferentes tipos de datos como Strings, Objetos, etc. |
| **Complejidad de Métodos**  | O(n) para inserción al final, O(1) para obtener tamaño | O(n) para inserción al final, O(1) para obtener tamaño |
| **Comparación de Valores**  | Usa `==` para comparar valores      | Usa `equals` para comparar datos genéricos |

**Conclusión:**

- **`ListaEnlazada`** es adecuada cuando se necesita manejar exclusivamente datos de tipo entero.
- **`ListaEnlazadaGenerica<T>`** ofrece mayor flexibilidad al permitir manejar cualquier tipo de dato, facilitando su reutilización en diferentes contextos y aplicaciones.

---

## Conclusión

Las clases `ListaEnlazada` y `ListaEnlazadaGenerica<T>` proporcionan implementaciones eficientes de la estructura de datos **Lista Enlazada (Linked List)** en Java utilizando listas enlazadas simples. Mientras que `ListaEnlazada` está especializada en almacenar enteros, `ListaEnlazadaGenerica<T>` ofrece una solución más flexible y reutilizable para manejar diferentes tipos de datos. Ambas clases facilitan operaciones básicas como inserción, eliminación, impresión y obtención del tamaño de la lista, aunque la implementación genérica añade una capa adicional de flexibilidad.

Implementar listas enlazadas de manera genérica es una buena práctica que promueve la reutilización y la escritura de código más limpio y mantenible. Al entender y utilizar estas implementaciones, se pueden diseñar sistemas y algoritmos más eficientes y robustos.
