
import Materia.Cola.Queue;
import Materia.Cola.QueueGeneric;
import Materia.Pilas.Pila;
import Materia.Pilas.StackGeneric;
import Models.Pantalla;

public class App {
        public static void main(String[] args) throws Exception {
                System.out.println("Hello, World!");

                //// IMLPIMENTACIÓN DE PILA
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

                //// IMLPIMENTACIÓN DE PILA GENERICA TIPO PANTALLA
                StackGeneric<Pantalla> stackPersonas = new StackGeneric<>();
                stackPersonas.push(new Pantalla(1, "Home Page", "/home"));
                stackPersonas.push(new Pantalla(2, "Menu Page", "/home/menu"));
                stackPersonas.push(new Pantalla(3, "Settings Page", "/home/menu/settings"));
                System.out.println("Estoy en la pantalla \t" +
                                stackPersonas.peek().getNombre());
                System.out.println("Pantalla destruida \t" +
                                stackPersonas.pop().getNombre());
                stackPersonas.push(new Pantalla(4, "User Page", "/home/menu/user"));
                System.out.println("Estoy en la pantalla \t" +
                                stackPersonas.peek().getNombre());
                System.out.println("Pantalla destruida \t" +
                                stackPersonas.pop().getNombre());
                System.out.println("Pantalla destruida \t" +
                                stackPersonas.pop().getNombre());
                System.out.println("Estoy en la pantalla \t" +
                                stackPersonas.peek().getNombre());

                System.out.println();

                //// IMLPIMENTACIÓN DE COLA GENERICA TIPO PANTALLA
                QueueGeneric<Pantalla> queueGeneric = new QueueGeneric<>();
                queueGeneric.add(new Pantalla(1, "Home Page", "/home"));
                queueGeneric.add(new Pantalla(2, "Menu Page", "/home/menu"));
                queueGeneric.add(new Pantalla(3, "Settings Page", "/home/menu/settings"));
                System.out.println("Estoy en la pantalla \t" +
                                queueGeneric.peek().getNombre());
                System.out.println("Pantalla destruida \t" +
                                queueGeneric.remove().getNombre());
                queueGeneric.add(new Pantalla(4, "User Page", "/home/menu/user"));
                System.out.println("Estoy en la pantalla \t" +
                                queueGeneric.peek().getNombre());
                System.out.println("Pantalla destruida \t" +
                                queueGeneric.remove().getNombre());
                System.out.println("Pantalla destruida \t" +
                                queueGeneric.remove().getNombre());
                System.out.println("Estoy en la pantalla \t" +
                                queueGeneric.peek().getNombre());

                //// IMLPIMENTACIÓN DE COLA INT
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
                System.out.println("¿Cola vacía?: " + (queue.isEmpty() ? "Si" : "NO")); //

        }
}
