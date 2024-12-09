package Materia.Models;

/**
 * Clase Node:
 * Representa un nodo en la lista enlazada utilizada por la cola.
 */
public class Node {
    private int value; // Valor del nodo
    private Node next; // Referencia al siguiente nodo

    /**
     * Constructor del nodo.
     * 
     * @param value Valor que se almacenará en el nodo.
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}