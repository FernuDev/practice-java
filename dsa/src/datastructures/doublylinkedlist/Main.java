package datastructures.doublylinkedlist;

/**
 * Clase principal para demostrar el uso de DoublyLinkedList
 * 
 * Este programa muestra las operaciones de una lista enlazada doble:
 * - Creación con elemento inicial
 * - Inserción al final (append)
 * - Inserción al inicio (prepend)
 * - Eliminación del final (removeLast)
 * - Eliminación del inicio (removeFirst)
 * - Acceso optimizado por índice (get)
 * - Modificación por índice (set)
 * - Inserción en posición específica (insert)
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Crear una nueva lista enlazada doble con elemento inicial
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);

        // ===== PRUEBA DEL MÉTODO APPEND =====
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        doublyLinkedList.append(6);

        System.out.println("\nAppend Method: ");
        doublyLinkedList.printList();  // [7, 4, 5, 6]

        // ===== PRUEBA DEL MÉTODO REMOVE LAST =====
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();

        System.out.println("\nRemove Last Method: ");
        doublyLinkedList.printList();  // Lista vacía

        // ===== PRUEBA DEL MÉTODO PREPEND =====
        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);

        // Aplicar prepend
        doublyLinkedList.prepend(5);

        System.out.println("\nPrepend Method: ");
        doublyLinkedList.printList();  // [5, 1, 2, 3, 4]

        // ===== PRUEBA DEL MÉTODO REMOVE FIRST =====
        doublyLinkedList.removeFirst();
        System.out.println("\nRemove First Method: ");
        doublyLinkedList.printList();  // [1, 2, 3, 4]

        // ===== PRUEBA DEL MÉTODO GET (ACCESO OPTIMIZADO) =====
        System.out.println("\nGetting the 3rd (index 2) element: " + doublyLinkedList.get(2).value);

        // ===== PRUEBA DEL MÉTODO SET =====
        doublyLinkedList.set(3, 10);
        System.out.println("\nSetting the 4th element to 10: ");
        doublyLinkedList.printList();  // [1, 2, 3, 10]

        // ===== PRUEBA DEL MÉTODO INSERT =====
        doublyLinkedList.insert(1, 5);
        System.out.println("\nInserting 5 at index 1: ");
        doublyLinkedList.printList();  // [1, 5, 2, 3, 10]
    }
}
