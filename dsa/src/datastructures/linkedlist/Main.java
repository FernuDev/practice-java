package datastructures.linkedlist;

/**
 * Clase principal para demostrar el uso de LinkedList
 * 
 * Este programa muestra las operaciones básicas de una lista enlazada:
 * - Creación de lista vacía
 * - Inserción al inicio (prepend)
 * - Inserción al final (append)
 * - Inserción en posición específica (insert)
 * - Acceso por índice (get)
 * - Inversión de lista (reverse)
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Crear una nueva lista enlazada vacía
        LinkedList list = new LinkedList();

        // Agregar elementos al inicio y final
        list.prepend(22);  // Lista: [22]
        list.append(33);   // Lista: [22, 33]
        list.append(44);   // Lista: [22, 33, 44]

        // Mostrar la lista actual
        list.printList();
        
        // Acceder a un elemento por índice
        System.out.println("Node at [1]: " + list.get(1).value);

        // Insertar elemento en posición específica
        list.insert(1, 55);  // Lista: [22, 55, 33, 44]
        list.printList();

        // Invertir la lista
        list.reverse();  // Lista: [44, 33, 55, 22]
        list.printList();
    }
}
