# Estructuras de Datos Lineales

## Getting Started

Este proyecto es un ejercicio práctico sobre cómo implementar estructuras de datos lineales básicas en Java. Incluye ejemplos de pilas, colas y sus versiones genéricas.

Este repositorio se refiere a la segunda unidad de Estructuras de Datos, donde el primer capítulo cubre estructuras de datos lineales: Pilas, Colas y Listas Enlazadas.

## Requisitos
- Java JDK 11 o superior
- Git 2.20 o superior

## Pilas y Colas

### Pilas
Una pila es una estructura de datos lineal que sigue el principio LIFO (Last In, First Out, "Último en Entrar, Primero en Salir"). Esto significa que el último elemento añadido a la pila será el primero en ser removido. Las operaciones principales para una pila son:
- **Push:** Añadir un elemento a la parte superior de la pila.
- **Pop:** Remover el elemento de la parte superior de la pila.
- **Peek:** Recuperar el elemento en la parte superior de la pila sin removerlo.
- **isEmpty:** Verificar si la pila está vacía.

#### Implementación de la Clase `Stack`
La clase `Stack` implementa una pila utilizando una lista enlazada. Mantiene una referencia al tope (`top`) de la pila, lo que permite realizar operaciones de inserción y eliminación de manera eficiente con una complejidad de **O(1)**.

- **`push(int value)`:** Añade un nuevo elemento al tope de la pila.
  - Crea un nuevo nodo y lo enlaza al nodo actual en el tope.
  - Actualiza la referencia `top` al nuevo nodo.
  - **Complejidad:** O(1).

- **`pop()`:** Remueve y retorna el elemento al tope de la pila.
  - Si la pila está vacía, lanza una excepción.
  - Recupera el valor del nodo en el tope.
  - Actualiza la referencia `top` al siguiente nodo.
  - **Complejidad:** O(1).

- **`peek()`:** Retorna el valor del elemento al tope de la pila sin removerlo.
  - Si la pila está vacía, lanza una excepción.
  - **Complejidad:** O(1).

- **`isEmpty()`:** Verifica si la pila está vacía.
  - Retorna `true` si `top` es `null`, de lo contrario `false`.
  - **Complejidad:** O(1).

- **`size()`:** Retorna el número de elementos en la pila.
  - Retorna el valor de la variable `size`.
  - **Complejidad:** O(1).

**Importancia de Manejar el `top`:**
Mantener una referencia al tope de la pila es crucial para garantizar que las operaciones de `push` y `pop` se realicen en tiempo constante **O(1)**. Sin esta referencia, se requeriría recorrer toda la lista para añadir o remover elementos, incrementando la complejidad de las operaciones a **O(n)**.

### Colas
Una cola es una estructura de datos lineal que sigue el principio FIFO (First In, First Out, "Primero en Entrar, Primero en Salir"). Esto significa que el primer elemento añadido a la cola será el primero en ser removido. Las operaciones principales para una cola son:
- **Add:** Añadir un elemento al final de la cola.
- **Remove:** Remover el elemento del frente de la cola.
- **Peek:** Recuperar el elemento al frente de la cola sin removerlo.
- **isEmpty:** Verificar si la cola está vacía.

#### Implementación de la Clase `Queue`
La clase `Queue` implementa una cola utilizando una lista enlazada. Mantiene referencias al frente (`front`) y al final (`rear`) de la cola, lo que permite realizar operaciones de inserción y eliminación de manera eficiente con una complejidad de **O(1)**.

- **`enqueue(int value)`:** Añade un nuevo elemento al final de la cola.
  - Si la cola está vacía, el nuevo nodo se convierte tanto en el frente como en el final.
  - Si no está vacía, el nuevo nodo se enlaza al final actual (`rear.next`) y luego se actualiza la referencia `rear` al nuevo nodo.
  - **Complejidad:** O(1).

- **`dequeue()`:** Remueve y retorna el elemento al frente de la cola.
  - Si la cola está vacía, lanza una excepción.
  - Actualiza la referencia `front` al siguiente nodo.
  - Si después de la eliminación la cola queda vacía, también se establece `rear` como `null`.
  - **Complejidad:** O(1).

- **`peek()`:** Retorna el valor del elemento al frente de la cola sin removerlo.
  - Si la cola está vacía, lanza una excepción.
  - **Complejidad:** O(1).

- **`isEmpty()`:** Verifica si la cola está vacía.
  - Retorna `true` si `front` es `null`, de lo contrario `false`.
  - **Complejidad:** O(1).

- **`size()`:** Retorna el número de elementos en la cola.
  - Retorna el valor de la variable `size`.
  - **Complejidad:** O(1).

**Importancia de Manejar Ambos `front` y `rear`:**
Mantener referencias tanto al frente (`front`) como al final (`rear`) de la cola es crucial para garantizar que las operaciones de `enqueue` y `dequeue` se realicen en tiempo constante **O(1)**. Sin estas referencias, se requeriría recorrer toda la lista para añadir o remover elementos, incrementando la complejidad de las operaciones a **O(n)**.

###  Comparación con la Implementación Usando Listas Enlazadas**

| Característica              | Implementación con Array            | Implementación con Lista Enlazada     |
|-----------------------------|-------------------------------------|---------------------------------------|
| **Complejidad de Operaciones** | `enqueue` y `dequeue` en **O(1)** | `enqueue` y `dequeue` en **O(1)**     |
| **Uso de Memoria**          | Memoria contigua; posible espacio desperdiciado o necesidad de redimensionar | Memoria dinámica; sin desperdicio de espacio |
| **Redimensionamiento**      | Necesario para manejar más elementos (potencial costo de **O(n)**) | No necesario |
| **Gestión de Índices**      | Requiere manejo de índices front y rear | Requiere manejo de referencias de nodos |
| **Flexibilidad de Tamaño**  | Limitada por la capacidad del arreglo (a menos que se implemente redimensionamiento) | Dinámica, solo limitada por la memoria disponible |

Ambas implementaciones tienen sus ventajas y desventajas. La elección entre una implementación basada en arreglos o listas enlazadas dependerá de los requisitos específicos de tu aplicación, como la necesidad de redimensionamiento dinámico, la eficiencia en el uso de memoria, y la complejidad de implementación.


## Listas Enlazadas

### Lista Enlazada Simple
Una lista enlazada simple es una estructura de datos lineal en la que cada elemento, o nodo, apunta al siguiente elemento en la secuencia. Cada nodo contiene dos partes: los datos y una referencia (o enlace) al siguiente nodo en la secuencia.

#### Operaciones en una Lista Enlazada Simple
- **Añadir al Final:** Añadir un nuevo nodo al final de la lista.
- **Eliminar Nodo:** Remover un nodo de la lista por su valor.
- **Imprimir:** Mostrar todos los nodos en la lista.
- **Obtener Tamaño:** Retornar el número de nodos en la lista.
- **Obtener por Posición:** Recuperar el valor del nodo en una posición específica desde el final de la lista.

#### Clase Lista Enlazada Simple
La clase `ListaEnlazada` implementa la lista enlazada simple con operaciones básicas.

## Clases Node y NodeGeneric

### Node
La clase `Node` se utiliza para representar un solo elemento en una lista enlazada, pila o cola. Contiene un valor entero y una referencia al siguiente nodo en la estructura.

### NodeGeneric
La clase `NodeGeneric` es una versión genérica de la clase `Node`. Puede contener cualquier tipo de dato (especificado por el parámetro de tipo genérico `T`) y una referencia al siguiente nodo en la estructura.

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


## Contribuir

Para contribuir a este proyecto, por favor crea un fork y envía una solicitud de extracción, o simplemente abre un issue con tus comentarios y sugerencias.

## Autores

- [PABLO TORRES] - Desarrollo inicial

