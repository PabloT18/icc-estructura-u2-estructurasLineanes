
import Ejercicio_01_sign.SignValidator;
import Ejercicio_02_sorting.StackSorter;
import Ejercicio_03_linkedLists.LinkedListEjr;
import Materia.Cola.Queue;
import Materia.Cola.QueueGeneric;
import Materia.Pilas.Pila;
import Materia.Pilas.StackGeneric;
import Models.Pantalla;

public class App {
        public static void main(String[] args) throws Exception {

                // runPila();
                // runPilaGenericaTipoPantalla();
                // runColaGenericaTipoPantalla();
                // runColaInt();
                // runEjercicio1();

                runEjercicio2();
                runEjercicio3();
        }

        private static void runPila() {
                //// IMPLEMENTACIÓN DE PILA
                Pila pila = new Pila();
                // Añadir elementos a la pila
                pila.push(10);
                pila.push(20);
                pila.push(30);
                // Mostrar el elemento en la cima
                System.out.println("Elemento en la cima: " + pila.peek()); // 30
                System.out.println("Elemento retirado: " + pila.pop()); // 30
                System.out.println("Elemento retirado: " + pila.pop()); // 20
                System.out.println("Elemento en la cima: " + pila.peek()); // 30
                System.out.println();
        }

        private static void runPilaGenericaTipoPantalla() {
                //// IMPLEMENTACIÓN DE PILA GENERICA TIPO PANTALLA
                StackGeneric<Pantalla> stackPersonas = new StackGeneric<>();
                stackPersonas.push(new Pantalla(1, "Home Page", "/home"));
                stackPersonas.push(new Pantalla(2, "Menu Page", "/home/menu"));
                stackPersonas.push(new Pantalla(3, "Settings Page", "/home/menu/settings"));
                System.out.println("Estoy en la pantalla \t" + stackPersonas.peek().getNombre());
                System.out.println("Pantalla destruida \t" + stackPersonas.pop().getNombre());
                stackPersonas.push(new Pantalla(4, "User Page", "/home/menu/user"));
                System.out.println("Estoy en la pantalla \t" + stackPersonas.peek().getNombre());
                System.out.println("Pantalla destruida \t" + stackPersonas.pop().getNombre());
                System.out.println("Pantalla destruida \t" + stackPersonas.pop().getNombre());
                System.out.println("Estoy en la pantalla \t" + stackPersonas.peek().getNombre());
                System.out.println();
        }

        private static void runColaGenericaTipoPantalla() {
                //// IMPLEMENTACIÓN DE COLA GENERICA TIPO PANTALLA
                QueueGeneric<Pantalla> queueGeneric = new QueueGeneric<>();
                queueGeneric.add(new Pantalla(1, "Home Page", "/home"));
                queueGeneric.add(new Pantalla(2, "Menu Page", "/home/menu"));
                queueGeneric.add(new Pantalla(3, "Settings Page", "/home/menu/settings"));
                System.out.println("Estoy en la pantalla \t" + queueGeneric.peek().getNombre());
                System.out.println("Pantalla destruida \t" + queueGeneric.remove().getNombre());
                queueGeneric.add(new Pantalla(4, "User Page", "/home/menu/user"));
                System.out.println("Estoy en la pantalla \t" + queueGeneric.peek().getNombre());
                System.out.println("Pantalla destruida \t" + queueGeneric.remove().getNombre());
                System.out.println("Pantalla destruida \t" + queueGeneric.remove().getNombre());
                System.out.println("Estoy en la pantalla \t" + queueGeneric.peek().getNombre());
                System.out.println();
        }

        private static void runColaInt() {
                //// IMPLEMENTACIÓN DE COLA INT
                Queue queue = new Queue();

                // Añadir elementos a la cola
                queue.enqueue(10);
                queue.enqueue(20);
                queue.enqueue(30);

                // Mostrar el elemento en el frente
                System.out.println("Elemento en el frente: " + queue.peek()); // 10

                // Retirar elementos de la cola
                System.out.println("Elemento retirado: " + queue.dequeue()); // 10
                System.out.println("Elemento retirado: " + queue.dequeue()); // 20

                // Verificar el tamaño de la cola
                System.out.println("Tamaño de la cola: " + queue.size()); // 1

                // Verificar si la cola está vacía
                System.out.println("¿Cola vacía?: " + (queue.isEmpty() ? "Sí" : "No")); // false
                System.out.println();
        }

        private static void runEjercicio1() {
                SignValidator validParenthesis = new SignValidator();

                System.out.println(validParenthesis.isValid("([]){}") ? "Valido" : "Invalido");
                System.out.println(validParenthesis.isValid("({)}") ? "Valido" : "Invalido");

        }

        private static void runEjercicio2() {
                // Crear una instancia de StackSorter para ordenar la pila
                StackSorter stackSorter = new StackSorter();

                // Crear una instancia de StackGeneric para almacenar los enteros
                StackGeneric<Integer> stack = new StackGeneric<>();
                StackGeneric<Integer> stackSorted;

                // Añadir elementos a la pila
                stack.push(4);
                stack.push(2);
                stack.push(5);
                stack.push(1);

                // Imprimir la pila antes de ordenar
                System.out.println("Pila antes de ordenar:");
                stack.printAllNodes();

                // Ordenar la pila y almacenar el resultado en stackSorted
                stackSorted = stackSorter.sortStack(stack);

                // Imprimir la pila después de ordenar
                System.out.println("Pila después de ordenar:");
                stackSorted.printAllNodes();
        }

        private static void runEjercicio3() {
                LinkedListEjr example = new LinkedListEjr();
                System.out.println("Nodo en la posición 1 desde el final: " + example.getByPos(1)); // Debería imprimir
                                                                                                    // 7
                System.out.println("Nodo en la posición 2 desde el final: " + example.getByPos(2)); // Debería imprimir
                                                                                                    // 6
                System.out.println("Nodo en la posición 4 desde el final: " + example.getByPos(5)); // Debería imprimir
                                                                                                    // 1
        }

}
