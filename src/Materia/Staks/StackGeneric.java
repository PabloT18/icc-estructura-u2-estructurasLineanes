package Materia.Staks;

import java.util.EmptyStackException;

import Materia.Models.NodeGeneric;

/**
 * Clase StackGeneric:
 * Implementa una estructura de datos de pila genérica (LIFO, "Last In, First
 * Out")
 * utilizando una lista enlazada genérica.
 * Las operaciones principales (`push`, `pop`, `peek`, `isEmpty`, `size`)
 * tienen una complejidad de O(1) debido al uso de referencias directas a la
 * cima de la pila.
 *
 * Características principales:
 * - La pila permite añadir elementos a la cima y retirarlos también desde la
 * cima, siguiendo el orden LIFO.
 * - Es adecuada para escenarios como gestión de llamadas (call stack),
 * reversión de datos, y algoritmos de recorrido.
 *
 * Complejidades:
 * - Espacial: O(n), donde n es el número de elementos en la pila.
 * - Temporal: Todas las operaciones principales tienen una complejidad de O(1).
 *
 * Atributos:
 * - `top`: Referencia al elemento en la cima de la pila.
 * - `size`: Contador del número de elementos en la pila.
 *
 * @param <T> El tipo de elementos que esta pila puede contener.
 * @autor Pablo Torres ptorres@ups.edu.ec
 */
public class StackGeneric<T> {

    private NodeGeneric<T> top; // Nodo en la cima de la pila
    private int size; // Número de elementos en la pila

    /**
     * Constructor de la clase StackGeneric.
     * Inicializa una pila vacía con la cima como null y tamaño 0.
     */
    public StackGeneric() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Método push:
     * Añade un nuevo elemento a la cima de la pila.
     *
     * @param data El dato del elemento que se desea añadir.
     *
     *             <p>
     *             <b>Complejidad:</b> O(1).
     *             </p>
     *             <ul>
     *             <li>Crea un nuevo nodo con el dato proporcionado.</li>
     *             <li>Enlaza el nuevo nodo al nodo actualmente en la cima.</li>
     *             <li>Actualiza la referencia `top` para que apunte al nuevo
     *             nodo.</li>
     *             <li>Incrementa el contador `size`.</li>
     *             </ul>
     */
    public void push(T data) {
        NodeGeneric<T> newNode = new NodeGeneric<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    /**
     * Método pop:
     * Retira y retorna el elemento en la cima de la pila.
     *
     * @return El dato del elemento retirado.
     * @throws EmptyStackException Si la pila está vacía.
     *
     *                             <p>
     *                             <b>Complejidad:</b> O(1).
     *                             </p>
     *                             <ul>
     *                             <li>Verifica si la pila está vacía; si es así,
     *                             lanza una excepción.</li>
     *                             <li>Recupera el dato del nodo en la cima.</li>
     *                             <li>Actualiza la referencia `top` al siguiente
     *                             nodo.</li>
     *                             <li>Decrementa el contador `size`.</li>
     *                             </ul>
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

    /**
     * Método peek:
     * Retorna el dato del elemento en la cima de la pila sin retirarlo.
     *
     * @return El dato del elemento en la cima de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     *
     *                             <p>
     *                             <b>Complejidad:</b> O(1).
     *                             </p>
     *                             <ul>
     *                             <li>Verifica si la pila está vacía; si es así,
     *                             lanza una excepción.</li>
     *                             <li>Retorna el dato almacenado en el nodo en la
     *                             cima.</li>
     *                             </ul>
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    /**
     * Método isEmpty:
     * Verifica si la pila está vacía.
     *
     * @return <code>true</code> si la pila no contiene elementos, de lo contrario
     *         <code>false</code>.
     * 
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Método size:
     * Retorna el número de elementos en la pila.
     *
     * @return El tamaño actual de la pila.
     * 
     */
    public int size() {
        return size;
    }

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
}
