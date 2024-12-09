package Materia.Queues;

import java.util.NoSuchElementException;

import Materia.Models.NodeGeneric;

/**
 * 
 * @author Pablo Torres ptorres@ups.edu.ec
 * 
 * 
 *         Clase QueueGeneric:
 *         Implementa una estructura de datos de cola genérica (FIFO, "First In,
 *         First
 *         Out")
 *         utilizando una lista enlazada genérica.
 *         Las operaciones principales (`add`, `remove`, `peek`, `isEmpty`,
 *         `size`)
 *         tienen una complejidad de O(1) debido al uso de referencias directas
 *         al
 *         frente y al final de la cola.
 *
 *         Características principales:
 *         - La cola permite añadir elementos al final y retirarlos del frente,
 *         siguiendo el orden FIFO.
 *         - Es adecuada para escenarios como gestión de tareas, sistemas de
 *         impresión,
 *         o simulaciones de colas en algoritmos.
 *
 * @param <T> El tipo de elementos que esta cola puede contener.
 * @author
 *         Pablo Torres ptorres@ups.edu.ec
 */
public class QueueGeneric<T> {

    private NodeGeneric<T> first; // Nodo al frente de la cola
    private NodeGeneric<T> last; // Nodo al final de la cola
    private int size; // Número de elementos en la cola

    /**
     * Constructor de la clase QueueGeneric.
     * Inicializa una cola vacía con referencias first y last como null y tamaño 0.
     */
    public QueueGeneric() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Método add:
     * Añade un nuevo elemento al final de la cola.
     *
     * @param data El dato del elemento que se desea añadir.
     *
     *             <p>
     *             <b>Complejidad:</b> O(1).
     *             </p>
     *             <ul>
     *             <li>Si la cola está vacía, el nuevo nodo se convierte en el
     *             frente y el final.</li>
     *             <li>Si no está vacía, el puntero del nodo final
     *             (<code>last.next</code>) se actualiza para apuntar al nuevo nodo,
     *             y el nuevo nodo se convierte en el final.</li>
     *             </ul>
     */
    public void enqueue(T data) {
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

    /**
     * Método remove:
     * Retira y retorna el elemento al frente de la cola.
     *
     * @return El dato del elemento retirado.
     * @throws NoSuchElementException Si la cola está vacía.
     *
     *                                <p>
     *                                <b>Complejidad:</b> O(1).
     *                                </p>
     *                                <ul>
     *                                <li>Si la cola está vacía, lanza una
     *                                excepción.</li>
     *                                <li>Si hay elementos, el puntero
     *                                <code>first</code> se actualiza al siguiente
     *                                nodo.</li>
     *                                <li>Si después de la operación la cola queda
     *                                vacía, <code>last</code> se establece como
     *                                null.</li>
     *                                </ul>
     */
    public T dequeue() {
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

    /**
     * Método peek:
     * Retorna el dato del elemento al frente de la cola sin retirarlo.
     *
     * @return El dato del elemento al frente de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     *
     *                                <p>
     *                                <b>Complejidad:</b> O(1).
     *                                </p>
     *                                <ul>
     *                                <li>Solo accede al dato almacenado en el nodo
     *                                <code>first</code>.</li>
     *                                </ul>
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return first.getData();
    }

    /**
     * Método isEmpty:
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, de lo contrario
     *         <code>false</code>.
     *
     *         <p>
     *         <b>Complejidad:</b> O(1).
     *         </p>
     *         <ul>
     *         <li>Solo evalúa si el nodo <code>first</code> es null.</li>
     *         </ul>
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Método size:
     * Retorna el número de elementos en la cola.
     *
     * @return El tamaño actual de la cola.
     *
     *         <p>
     *         <b>Complejidad:</b> O(1).
     *         </p>
     *         <ul>
     *         <li>Solo retorna el valor del contador <code>size</code>.</li>
     *         </ul>
     */
    public int size() {
        return size;
    }

}
