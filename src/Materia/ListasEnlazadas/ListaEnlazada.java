package Materia.ListasEnlazadas;

import Materia.Models.Node;

/**
 * 
 * @author Pablo Torres ptorres@ups.edu.ec
 * 
 *         Clase ListaEnlazada:
 *         Implementa una lista enlazada simple que almacena elementos enteros.
 *         Esta estructura de datos permite añadir elementos al final, eliminar
 *         nodos
 *         específicos,
 *         imprimir la lista y obtener su tamaño.
 *
 *         Características principales:
 *         - Cada nodo en la lista contiene un valor y una referencia al
 *         siguiente nodo.
 *         - El tamaño de la lista se actualiza dinámicamente conforme se añaden
 *         o
 *         eliminan nodos.
 *
 *         Complejidades:
 *         - Añadir al final (`appendToTail`): O(n), ya que es necesario
 *         recorrer la
 *         lista hasta el último nodo.
 *         - Eliminar un nodo (`deleteNode`): O(n), ya que es necesario recorrer
 *         la
 *         lista para encontrar el nodo.
 *         - Imprimir (`print`): O(n), recorre todos los nodos para mostrar sus
 *         valores.
 *         - Obtener tamaño (`getSize`): O(1), devuelve el valor de un contador.
 *
 *         Atributos:
 *         - `head`: Referencia al primer nodo de la lista.
 *         - `size`: Contador del número de nodos en la lista.
 *
 * @author
 *         Pablo Torres ptorres@ups.edu.ec
 */
public class ListaEnlazada {
    public Node head; // Referencia al primer nodo de la lista
    private int size = 0; // Contador del número de nodos en la lista

    /**
     * Método appendToTail:
     * Añade un nuevo nodo al final de la lista.
     *
     * @param value Valor del nodo que se desea añadir.
     *
     *              <p>
     *              <b>Complejidad:</b> O(n).
     *              </p>
     *              <ul>
     *              <li>Si la lista está vacía, el nuevo nodo se convierte en la
     *              cabeza.</li>
     *              <li>Si no está vacía, recorre la lista hasta el último nodo y
     *              enlaza el nuevo nodo.</li>
     *              </ul>
     */
    public void appendToTail(int value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        size++;
    }

    /**
     * Método deleteNode:
     * Elimina el primer nodo que contiene un valor específico.
     *
     * @param value El valor del nodo que se desea eliminar.
     *
     *              <p>
     *              <b>Complejidad:</b> O(n).
     *              </p>
     *              <ul>
     *              <li>Si la lista está vacía, no realiza ninguna acción.</li>
     *              <li>Si el nodo a eliminar es la cabeza, actualiza la referencia
     *              `head` al siguiente nodo.</li>
     *              <li>Si el nodo a eliminar no es la cabeza, recorre la lista para
     *              encontrar el nodo y lo elimina.</li>
     *              <li>Decrementa el contador `size` si se elimina un nodo.</li>
     *              </ul>
     */
    public void deleteNode(int value) {
        if (head == null)
            return;

        if (head.value == value) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
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
     * <li>Imprime el valor de cada nodo seguido de una flecha.</li>
     * <li>Finaliza con "END" para indicar el final de la lista.</li>
     * </ul>
     */
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
