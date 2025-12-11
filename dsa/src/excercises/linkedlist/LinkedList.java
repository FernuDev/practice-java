package excercises.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementación avanzada de LinkedList con algoritmos especializados
 * 
 * Esta clase contiene implementaciones de algoritmos avanzados para listas enlazadas,
 * incluyendo detección de ciclos, eliminación de duplicados, búsqueda optimizada
 * y conversiones de datos.
 * 
 * Algoritmos implementados:
 * - Tortoise and Hare (detección de nodo medio y ciclos)
 * - Hash Set para eliminación de duplicados
 * - Búsqueda del k-ésimo elemento desde el final
 * - Conversión binaria a decimal
 * - Particionamiento de listas
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class LinkedList {

    private Node head;  // Referencia al primer nodo de la lista
    private Node tail;  // Referencia al último nodo de la lista

    /**
     * Clase interna que representa un nodo de la lista enlazada
     */
    class Node {
        int value;  // Dato almacenado en el nodo
        Node next;  // Referencia al siguiente nodo

        /**
         * Constructor del nodo
         * @param value El valor a almacenar en el nodo
         */
        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Encuentra el nodo medio de la lista usando el algoritmo Tortoise and Hare
     * Complejidad: O(n) tiempo, O(1) espacio
     * 
     * Algoritmo: El puntero rápido se mueve 2 pasos por cada paso del lento.
     * Cuando el rápido llega al final, el lento está en el medio.
     * 
     * @return El nodo medio de la lista
     */
    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Mover 2 pasos
            slow = slow.next;       // Mover 1 paso
        }

        return slow;
    }

    /**
     * Detecta si la lista tiene un ciclo usando el algoritmo de Floyd (Tortoise and Hare)
     * Complejidad: O(n) tiempo, O(1) espacio
     * 
     * Algoritmo: Si hay un ciclo, el puntero rápido eventualmente alcanzará al lento.
     * 
     * @return true si la lista tiene un ciclo, false en caso contrario
     */
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Mover 1 paso
            fast = fast.next.next;  // Mover 2 pasos

            if (slow == fast) {
                return true;  // Ciclo detectado
            }
        }
        return false;  // No hay ciclo
    }

    /**
     * Elimina valores duplicados de la lista manteniendo la primera ocurrencia
     * Complejidad: O(n) tiempo, O(n) espacio
     * 
     * Algoritmo: Usa un HashSet para trackear valores ya vistos.
     * Si un valor ya existe, se elimina el nodo actual.
     */
    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        int size = getSize();

        while (current != null) {
            if (seen.contains(current.value)) {
                // Eliminar duplicado: saltar el nodo actual
                prev.next = current.next;
                size--; // ⚠️ Importante: reducir tamaño
            } else {
                // Valor único: agregar al set y avanzar prev
                seen.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    /**
     * Encuentra el k-ésimo elemento desde el final de la lista
     * Complejidad: O(n) tiempo, O(1) espacio
     * 
     * Algoritmo: Calcula la posición desde el inicio y recorre hasta esa posición.
     * 
     * @param k La posición desde el final (1-based)
     * @return El nodo en la k-ésima posición desde el final, o null si k es inválido
     */
    public Node findKthFromEnd(int k) {
        if (k <= 0) return null;

        int size = getSize();
        if (k > size) return null;

        // Calcular posición desde el inicio
        int positionFromStart = size - k;
        Node current = head;
        
        // Recorrer hasta la posición calculada
        for (int i = 0; i < positionFromStart; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Convierte una lista que representa un número binario a su equivalente decimal
     * Complejidad: O(n) tiempo, O(1) espacio
     * 
     * Algoritmo: Cada posición representa una potencia de 2, empezando desde 2^(n-1)
     * hasta 2^0. Se suma cada bit multiplicado por su potencia correspondiente.
     * 
     * @return El valor decimal equivalente al número binario representado por la lista
     */
    public int binaryToDecimal(){
        int size = getSize() - 1;
        int number = 0;
        Node current = head;

        while(size >= 0) {
            // Sumar el bit actual multiplicado por su potencia de 2
            number += (int) (Math.pow(2, size) * current.value);
            current = current.next;
            size--;
        }

        return number;
    }

    /**
     * Particiona la lista reorganizando los elementos de manera que todos los valores
     * menores a k aparezcan antes que los valores mayores o iguales a k
     * Complejidad: O(n) tiempo, O(1) espacio
     * 
     * Algoritmo: Usa dos listas dummy para separar elementos menores y mayores/iguales a k,
     * luego las concatena.
     * 
     * @param head El nodo head de la lista a particionar
     * @param k El valor de partición
     * @return El nuevo head de la lista particionada
     */
    public Node partition(Node head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        // Crear nodos dummy para las dos particiones
        Node dummy1 = new Node(0);  // Para valores < k
        Node temp1 = dummy1;

        Node dummy2 = new Node(0);  // Para valores >= k
        Node temp2 = dummy2;

        Node current = head;

        while (current != null) {
            if (current.value < k) {
                // Agregar a la partición de valores menores
                temp1.next = current;
                temp1 = temp1.next;
            } else {
                // Agregar a la partición de valores mayores/iguales
                temp2.next = current;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        // Conectar las dos particiones
        temp2.next = null;        // Terminar la segunda partición
        temp1.next = dummy2.next; // Conectar primera con segunda

        return dummy1.next;       // Retornar el nuevo head
    }

    private int getSize() {
        int size = 0;
        Node current = head;

        while(current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

}

