package Materia.ListasEnlazadas;

import Materia.Models.NodeGeneric;

/**
 * 
 * @author Pablo Torres ptorres@ups.edu.ec
 * 
 *         Clase ListaEnlazadaGenerica:
 *         Implementa una lista enlazada simple genérica que almacena elementos
 *         de cualquier tipo.
 *         Esta estructura de datos permite añadir elementos al final, eliminar
 *         nodos específicos,
 *         imprimir la lista y obtener su tamaño.
 *
 *         Características principales:
 *         - Cada nodo en la lista contiene un dato de tipo genérico y una
 *         referencia al siguiente nodo.
 *         - El tamaño de la lista se actualiza dinámicamente conforme se añaden
 *         o eliminan nodos.
 *
 *         Complejidades:
 *         - Añadir al final (`appendToTail`): O(n), ya que es necesario
 *         recorrer la lista hasta el último nodo.
 *         - Eliminar un nodo (`deleteNode`): O(n), ya que es necesario recorrer
 *         la lista para encontrar el nodo.
 *         - Imprimir (`print`): O(n), recorre todos los nodos para mostrar sus
 *         valores.
 *         - Obtener tamaño (`getSize`): O(1), devuelve el valor de un contador.
 *
 *         Atributos:
 *         - `head`: Referencia al primer nodo de la lista.
 *         - `size`: Contador del número de nodos en la lista.
 *
 * @param <T> El tipo de elementos que esta lista puede contener.
 * @autor Pablo Torres ptorres@ups.edu.ec
 */
public class ListaEnlazadaGenerica<T> {
    public NodeGeneric<T> head; // Referencia al primer nodo de la lista
    private int size = 0; // Contador del número de nodos en la lista

    /**
     * Método appendToTail:
     * Añade un nuevo nodo al final de la lista.
     *
     * @param data Dato del nodo que se desea añadir.
     *
     *             <p>
     *             <b>Complejidad:</b> O(n).
     *             </p>
     *             <ul>
     *             <li>Si la lista está vacía, el nuevo nodo se convierte en la
     *             cabeza.</li>
     *             <li>Si no está vacía, recorre la lista hasta el último nodo y
     *             enlaza el nuevo nodo.</li>
     *             </ul>
     */
    public void appendToTail(T data) {
        if (head == null) {
            head = new NodeGeneric<>(data);
            size++;
            return;
        }

        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new NodeGeneric<>(data));
        size++;
    }

    /**
     * Método deleteNode:
     * Elimina el primer nodo que contiene un dato específico.
     *
     * @param data El dato del nodo que se desea eliminar.
     *
     *             <p>
     *             <b>Complejidad:</b> O(n).
     *             </p>
     *             <ul>
     *             <li>Si la lista está vacía, no realiza ninguna acción.</li>
     *             <li>Si el nodo a eliminar es la cabeza, actualiza la referencia
     *             `head` al siguiente nodo.</li>
     *             <li>Si el nodo a eliminar no es la cabeza, recorre la lista para
     *             encontrar el nodo y lo elimina.</li>
     *             <li>Decrementa el contador `size` si se elimina un nodo.</li>
     *             </ul>
     */
    public void deleteNode(T data) {
        if (head == null)
            return;

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }

        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    /**
     * Método print:
     * Imprime todos los elementos de la lista en orden desde la cabeza hasta el
     * final.
     *
     * <p>
     * <b>Complejidad:</b> O(n).
     * </p>
     * <ul>
     * <li>Recorre la lista desde la cabeza hasta el último nodo.</li>
     * <li>Imprime el dato de cada nodo seguido de una flecha.</li>
     * <li>Finaliza con "END" para indicar el final de la lista.</li>
     * </ul>
     */
    public void print() {
        if (head == null) {
            System.out.println("END");
            return;
        }
        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getData() + " -> END");
    }

    /**
     * Método getSize:
     * Retorna el número de elementos en la lista.
     *
     * @return El tamaño actual de la lista.
     *
     *         <p>
     *         <b>Complejidad:</b> O(1).
     *         </p>
     *         <ul>
     *         <li>Retorna el valor del contador `size`.</li>
     *         </ul>
     */
    public int getSize() {
        return size;
    }
}
