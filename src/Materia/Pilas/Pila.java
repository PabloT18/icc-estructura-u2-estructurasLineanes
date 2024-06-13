package Materia.Pilas;

import java.util.EmptyStackException;

import Materia.Models.Node;

public class Pila {
    private Node top;

    public Pila() {
        this.top = null;
    }

    // Push: Añadir un elemento a la cima de la pila
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop: Retirar el elemento de la cima de la pila
    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    // Peek: Obtener el valor del elemento en la cima sin retirarlo
    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    // isEmpty: Verificar si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

}
