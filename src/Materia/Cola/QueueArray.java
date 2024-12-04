package Materia.Cola;

import java.util.NoSuchElementException;

/**
 * 
 * @author Pablo Torres ptorres@ups.edu.ec
 * 
 * 
 *         Clase QueueArray:
 *         Implementa una estructura de datos de cola (FIFO) utilizando un
 *         arreglo
 *         circular.
 *         Las operaciones principales (`enqueue`, `dequeue`, `peek`, `isEmpty`,
 *         `size`)
 *         tienen una complejidad de O(1).
 * 
 *         Características:
 *         - Soporta un tamaño inicial definido y se redimensiona dinámicamente
 *         cuando
 *         es necesario.
 *         - Maneja operaciones de inserción y eliminación de manera eficiente
 *         sin
 *         necesidad de desplazamientos de elementos.
 */
public class QueueArray {

    private int[] data; // Arreglo para almacenar los elementos de la cola
    private int front; // Índice del frente de la cola
    private int rear; // Índice del final de la cola
    private int size; // Número de elementos en la cola
    private int capacity; // Capacidad actual del arreglo

    private static final int DEFAULT_CAPACITY = 10; // Capacidad por defecto

    /**
     * Constructor por defecto que inicializa la cola con una capacidad por defecto.
     */
    public QueueArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor que inicializa la cola con una capacidad específica.
     * 
     * @param capacity Capacidad inicial de la cola.
     */
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    /**
     * Método enqueue:
     * Añade un nuevo elemento al final de la cola.
     * 
     * @param value Valor del elemento que se desea añadir.
     * 
     *              Complejidad: O(1) amortizado.
     *              - Si la cola está llena, se redimensiona el arreglo para
     *              aumentar su capacidad.
     *              - Inserta el elemento en la posición `rear` y actualiza el
     *              índice `rear` de manera circular.
     */
    public void enqueue(int value) {
        if (size == capacity) {
            resize(2 * capacity); // Duplica la capacidad cuando está llena
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
    }

    /**
     * Método dequeue:
     * Retira y retorna el elemento al frente de la cola.
     * 
     * @return El valor del elemento retirado.
     * @throws NoSuchElementException Si la cola está vacía.
     * 
     *                                Complejidad: O(1).
     *                                - Recupera el elemento en la posición `front`.
     *                                - Actualiza el índice `front` de manera
     *                                circular.
     *                                - Decrementa el tamaño y redimensiona el
     *                                arreglo si es necesario.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        int value = data[front];
        front = (front + 1) % capacity;
        size--;

        // Redimensiona el arreglo si el tamaño es un cuarto de la capacidad
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }

        return value;
    }

    /**
     * Método peek:
     * Retorna el valor del elemento al frente de la cola sin retirarlo.
     * 
     * @return El valor del elemento al frente de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     * 
     *                                Complejidad: O(1).
     *                                - Solo accede al valor almacenado en la
     *                                posición `front`.
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return data[front];
    }

    /**
     * Método isEmpty:
     * Verifica si la cola está vacía.
     * 
     * @return `true` si la cola no contiene elementos, de lo contrario `false`.
     * 
     *         Complejidad: O(1).
     *         - Solo verifica si el tamaño es 0.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Método size:
     * Retorna el número de elementos en la cola.
     * 
     * @return El tamaño actual de la cola.
     * 
     *         Complejidad: O(1).
     *         - Solo retorna el valor del contador `size`.
     */
    public int size() {
        return size;
    }

    /**
     * Método resize:
     * Redimensiona el arreglo `data` a una nueva capacidad.
     * 
     * @param newCapacity La nueva capacidad del arreglo.
     */
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        // Copia los elementos existentes al nuevo arreglo de manera lineal
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % capacity];
        }
        data = newData;
        front = 0;
        rear = size;
        capacity = newCapacity;
    }

    /**
     * Método printAllElements:
     * Imprime todos los elementos de la cola en orden.
     */
    public void printAllElements() {
        System.out.print("Front -> ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % capacity] + " -> ");
        }
        System.out.println("Rear");
    }

}