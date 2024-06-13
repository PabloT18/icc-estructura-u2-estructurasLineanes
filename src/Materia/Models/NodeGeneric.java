package Materia.Models;

public class NodeGeneric<T> {
    public T data;
    public NodeGeneric<T> next;

    public NodeGeneric(T data) {
        this.data = data;
    }
}