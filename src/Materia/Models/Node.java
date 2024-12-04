package Materia.Models;

/**
 * Clase Node:
 * Representa un nodo en la lista enlazada utilizada por la cola.
 */
public class Node {
    public int value; // Valor del nodo
    public Node next; // Referencia al siguiente nodo

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
}