package Materia.Models;

/**
 * Clase NodeGeneric:
 * Representa un nodo en la lista enlazada utilizada por la cola genérica.
 *
 * @param <T> El tipo de dato que almacena el nodo.
 */
public class NodeGeneric<T> {
    private T data; // Dato almacenado en el nodo
    private NodeGeneric<T> next; // Referencia al siguiente nodo

    /**
     * Constructor del nodo genérico.
     *
     * @param data El dato que se almacenará en el nodo.
     */
    public NodeGeneric(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return El dato del nodo.
     */
    public T getData() {
        return data;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return El siguiente nodo en la lista enlazada.
     */
    public NodeGeneric<T> getNext() {
        return next;
    }

    /**
     * Establece la referencia al siguiente nodo.
     *
     * @param next El siguiente nodo en la lista enlazada.
     */
    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }
}