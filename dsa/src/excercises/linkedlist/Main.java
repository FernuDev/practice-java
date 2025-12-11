package excercises.linkedlist;

/**
 * Clase principal para demostrar algoritmos avanzados de LinkedList
 * 
 * Este programa muestra el uso de algoritmos especializados:
 * - Detección de nodo medio usando Tortoise and Hare
 * - Detección de ciclos
 * - Eliminación de duplicados
 * - Búsqueda del k-ésimo elemento desde el final
 * - Conversión binaria a decimal
 * - Particionamiento de listas
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Crear una nueva lista con elemento inicial
        LinkedList list = new LinkedList(1);

        // Agregar elementos para crear una lista de prueba
        list.append(2);
        list.append(5);
        list.append(4);
        list.append(5);  // Duplicado intencional

        // ===== DEMOSTRACIÓN DEL ALGORITMO TORTOISE AND HARE =====
        // Encontrar el nodo medio de la lista
        System.out.println("Middle Node: " + list.findMiddleNode().value);
        
        // La lista actual es: [1, 2, 5, 4, 5]
        // El nodo medio es el que contiene el valor 5 (índice 2)
    }
}
