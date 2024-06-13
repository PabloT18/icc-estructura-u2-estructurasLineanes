package Ejercicio_03_linkedLists;

import Materia.ListasEnlazadas.ListaEnlazada;
import Materia.Models.Node;

public class LinkedListEjr {
    private ListaEnlazada listaEnlazada;

    public LinkedListEjr() {
        listaEnlazada = new ListaEnlazada();
        listaEnlazada.appendToTail(1);
        listaEnlazada.appendToTail(2);
        listaEnlazada.appendToTail(5);
        listaEnlazada.appendToTail(7);
        listaEnlazada.appendToTail(6);
    }

    public int getByPos(int position) {
        int size = listaEnlazada.getSize();
        if (listaEnlazada.head == null || position < 1 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }

        int targetPos = size - position;
        Node current = listaEnlazada.head;

        for (int i = 0; i < targetPos; i++) {
            current = current.next;
        }

        return current.value;
    }

}
