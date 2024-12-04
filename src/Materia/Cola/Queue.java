package Materia.Cola;

import java.util.NoSuchElementException;

import Materia.Models.Node;

/**
 * 
 * @author Pablo Torres ptorres@ups.edu.ec
 * 
 * 
 *         Clase Queue:
 *         Implementa una estructura de datos de cola (FIFO, "First In, First
 *         Out")
 *         utilizando una lista enlazada.
 *         Las operaciones principales (`enqueue`, `dequeue`, `peek`, `isEmpty`,
 *         `size`)
 *         tienen una complejidad de O(1)
 *         debido al uso de referencias directas al frente y al final de la
 *         cola.
 * 
 *         Características principales:
 *         - La cola permite añadir elementos al final y retirarlos del frente,
 *         siguiendo el orden FIFO.
 *         - Es adecuada para escenarios como gestión de tareas, sistemas de
 *         impresión,
 *         o simulaciones de colas en algoritmos.
 * 
 *         Complejidades:
 *         - Espacial: O(n), donde n es el número de elementos en la cola.
 *         - Temporal: Todas las operaciones principales tienen una complejidad
 *         de O(1).
 * 
 *         Atributos:
 *         - `front`: Referencia al primer elemento de la cola (frente).
 *         - `rear`: Referencia al último elemento de la cola (final).
 *         - `size`: Contador del número de elementos en la cola.
 */

public class Queue {

    private Node front; // Nodo al frente de la cola
    private Node rear; // Nodo al final de la cola
    private int size; // Número de elementos en la cola

    /**
     * Constructor de la clase Queue.
     * Inicializa una cola vacía con referencias front y rear como null y tamaño 0.
     */
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Método enqueue:
     * Añade un nuevo elemento al final de la cola.
     * 
     * @param value Valor del elemento que se desea añadir.
     * 
     *              <p>
     *              <b>Complejidad:</b> O(1).
     *              </p>
     *              <ul>
     *              <li>Si la cola está vacía, el nuevo nodo se convierte en el
     *              frente y el final.</li>
     *              <li>Si no está vacía, el puntero del nodo final
     *              (<code>rear.next</code>) se actualiza para apuntar al nuevo
     *              nodo,
     *              y el nuevo nodo se convierte en el final.</li>
     *              </ul>
     */
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

    /**
     * Método dequeue:
     * Retira y retorna el elemento al frente de la cola.
     * 
     * @return El valor del elemento retirado.
     * @throws NoSuchElementException Si la cola está vacía.
     * 
     *                                <p>
     *                                <b>Complejidad:</b> O(1).
     *                                </p>
     *                                <ul>
     *                                <li>Si la cola está vacía, lanza una
     *                                excepción.</li>
     *                                <li>Si hay elementos, el puntero
     *                                <code>front</code> se actualiza al siguiente
     *                                nodo.</li>
     *                                <li>Si después de la operación la cola queda
     *                                vacía, <code>rear</code> se establece como
     *                                null.</li>
     *                                </ul>
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

    /**
     * Método peek:
     * Retorna el valor del elemento al frente de la cola sin retirarlo.
     * 
     * @return El valor del elemento al frente de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     * 
     *                                Complejidad: O(1).
     *                                - Solo accede al valor almacenado en el nodo
     *                                `front`.
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return front.value;
    }

    /**
     * Método isEmpty:
     * Verifica si la cola está vacía.
     * 
     * @return `true` si la cola no contiene elementos, de lo contrario `false`.
     * 
     *         Complejidad: O(1).
     *         - Solo evalúa si el nodo `front` es null.
     */
    public boolean isEmpty() {
        return front == null;
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

}
