package Materia.ListasEnlazadas;

import Materia.Models.Node;

public class ListaEnlazada {
    public Node head;
    private int size;

    public void appendToTail(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        size++;

    }

    public void deleteNode(int value) {
        if (head == null)
            return;

        if (head.value == value) {
            head = head.next;
            return;
        }

        // 4-3-1
        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        size--;

    }

    public void print() {
        if (head == null) {
            System.out.println("END");
            return;
        }
        Node current = head;
        while (current.next != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println(current.value + " -> END");
    }

    public int getSize() {
        return size;
    }
}