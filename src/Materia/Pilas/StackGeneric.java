package Materia.Pilas;

import java.util.EmptyStackException;

import Materia.Models.NodeGeneric;

public class StackGeneric<T> {
    private NodeGeneric<T> top;
    private int size;

    public StackGeneric() {
        this.top = null;
        this.size = 0;
    }

    // Push: Añadir un elemento a la cima de la pila
    public void push(T data) {
        NodeGeneric<T> newNode = new NodeGeneric<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop: Retirar el elemento de la cima de la pila
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Peek: Obtener el valor del elemento en la cima sin retirarlo
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // isEmpty: Verificar si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Size: Obtener el número de elementos en la pila
    public int size() {
        return size;
    }

    // Método para imprimir todos los nodos
    public void printAllNodes() {
        NodeGeneric<T> current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

}
