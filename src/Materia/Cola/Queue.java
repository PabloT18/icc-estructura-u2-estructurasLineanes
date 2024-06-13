package Materia.Cola;

import java.util.NoSuchElementException;

import Materia.Models.Node;

public class Queue {

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Enqueue: Añadir un elemento al final de la cola
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

    // Dequeue: Retirar el elemento del frente de la cola
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

    // Peek: Obtener el valor del elemento en el frente sin retirarlo
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return front.value;
    }

    // isEmpty: Verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Size: Obtener el número de elementos en la cola
    public int size() {
        return size;
    }
}
