package Materia;

;

public class QueueGeneric<T> {

    private NodeGeneric<T> first;
    private NodeGeneric<T> last;
    private int size;

    public QueueGeneric() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // Enqueue: Añadir un elemento al final de la cola
    public void add(T data) {
        NodeGeneric<T> newNode = new NodeGeneric<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    // Dequeue: Retirar el elemento del frente de la cola
    public T remove() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return data;
    }

    // Peek: Obtener el valor del elemento en el frente sin retirarlo
    public T peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");

        }
        return first.data;
    }

    // isEmpty: Verificar si la cola está vacía
    public boolean isEmpty() {
        return first == null;
    }

    // Size: Obtener el número de elementos en la cola
    public int size() {
        return size;
    }
}
