package datastructures.doublylinkedlist;

/**
 * Implementación de una Lista Enlazada Doble (Doubly Linked List)
 *
 * Una DoublyLinkedList es una estructura de datos lineal donde cada nodo
 * contiene datos y referencias tanto al nodo siguiente como al nodo anterior.
 * Esta característica permite navegación bidireccional.
 *
 * Características:
 * - Navegación bidireccional
 * - Acceso optimizado desde head o tail según proximidad
 * - Eliminación eficiente sin necesidad de buscar nodo anterior
 * - Implementación natural de Deque (cola de doble extremo)
 *
 * @author Luis Núñez
 * @version 1.0
 */
public class DoublyLinkedList {
    private Node head;   // Referencia al primer nodo de la lista
    private Node tail;   // Referencia al último nodo de la lista
    private int length;  // Número de elementos en la lista

    /**
     * Clase interna que representa un nodo de la lista enlazada doble
     * Cada nodo contiene un valor y referencias al nodo siguiente y anterior
     */
    class Node {
        int value;  // Dato almacenado en el nodo
        Node next;  // Referencia al siguiente nodo
        Node prev;  // Referencia al nodo anterior

        /**
         * Constructor del nodo
         * @param value El valor a almacenar en el nodo
         */
        public Node(int value) {
            this.value = value;
            this.next = null;  // Inicialmente no hay siguiente nodo
            this.prev = null;  // Inicialmente no hay nodo anterior
        }
    }

    /**
     * Constructor que crea una lista con un elemento inicial
     * Complejidad: O(1)
     *
     * @param value El valor del primer elemento de la lista
     */
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Agrega un elemento al final de la lista
     * Complejidad: O(1)
     *
     * @param value El valor a agregar al final de la lista
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            // Si la lista está vacía, el nuevo nodo es tanto head como tail
            head = newNode;
            tail = newNode;
        } else {
            // Conectar el nuevo nodo al final y actualizar referencias
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    /**
     * Agrega un elemento al inicio de la lista
     * Complejidad: O(1)
     *
     * @param value El valor a agregar al inicio de la lista
     */
    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            append(value);
        } else {
            // Conectar el nuevo nodo al inicio y actualizar referencias
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;

        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        length--;
        return temp;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;

        temp.next = null;
        temp.prev = null;

        length--;

        return temp;

    }

    /**
     * Obtiene el nodo en el índice especificado (optimizado)
     * Complejidad: O(n/2) ≈ O(n) - optimizado para empezar desde head o tail
     *
     * @param index El índice del nodo a obtener (0-based)
     * @return El nodo en el índice especificado, o null si el índice es inválido
     */
    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        if (index < length / 2) {
            // Si está en la primera mitad, empezar desde head
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            // Si está en la segunda mitad, empezar desde tail
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    /**
     * Modifica el valor del nodo en el índice especificado
     * Complejidad: O(n/2) ≈ O(n) - debido a la llamada a get() optimizado
     *
     * @param index El índice del nodo a modificar
     * @param value El nuevo valor para el nodo
     * @return true si la modificación fue exitosa, false si el índice es inválido
     */
    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length ) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index==length) {
            append(value);
            return true;
        }

        Node before = get(index - 1);
        Node after = before.next;

        Node temp = new Node(value);

        before.next = temp;
        after.prev = temp;

        temp.prev = before;
        temp.next = after;

        length++;

        return true;
    }

    public void printList() {
        DoublyLinkedList.Node current = head;

        System.out.print("List: < ");
        while (current != null){
            if (current.next != null) {
                System.out.print(current.value + ", ");
            } else {
                System.out.print(current.value + " ");
            }
            current = current.next;
        }
        System.out.println(">");
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

}
