package Ejercicio_02_sorting;

import Materia.Staks.StackGeneric;

/**
 * Clase StackSorter
 * 
 * Este ejercicio consiste en implementar un algoritmo para ordenar una pila de
 * enteros
 * de manera que los elementos más pequeños queden en el tope de la pila.
 * 
 * Ejemplo de uso:
 * StackSorter stackSorter = new StackSorter();
 * StackGeneric<Integer> stack = new StackGeneric<>();
 * stack.push(4);
 * stack.push(2);
 * stack.push(5);
 * stack.push(1);
 * StackGeneric<Integer> stackSorted = stackSorter.sortStack(stack);
 * stackSorted.printAllNodes(); // Salida: 1 -> 2 -> 4 -> 5 -> END
 */
public class StackSorter {

    /**
     * Método sortStack
     * 
     * Ordena una pila de enteros de manera que los elementos más pequeños queden en
     * el tope.
     * 
     * @param stack La pila de enteros a ordenar
     * @return La pila ordenada
     */
    public StackGeneric<Integer> sortStack(StackGeneric<Integer> stack) {
        StackGeneric<Integer> sortedStack = new StackGeneric<>();

        // Mientras la pila original no esté vacía
        while (!stack.isEmpty()) {
            // Sacar el elemento de la pila original
            Integer element = stack.pop();

            // Mover los elementos de sortedStack de vuelta a la pila original si son
            // mayores que el elemento actual
            while (!sortedStack.isEmpty() && element > sortedStack.peek()) {
                stack.push(sortedStack.pop());
            }

            // Poner el elemento en sortedStack
            sortedStack.push(element);
        }

        // Devolver la pila ordenada
        return sortedStack;
    }
}
