package datastructures.linkedlist;

/**
 * Implementación de una Lista Enlazada Simple (Singly Linked List)
 * Una LinkedList es una estructura de datos lineal donde cada elemento (nodo)
 * contiene datos y una referencia al siguiente nodo en la secuencia.
 * Características:
 * - Inserción/eliminación eficiente en posiciones conocidas: O(1)
 * - Acceso secuencial: O(n)
 * - Tamaño dinámico
 * - No desperdicia memoria
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class LinkedList {
    private Node head;  // Referencia al primer nodo de la lista
    private Node tail;  // Referencia al último nodo de la lista
    private int size;   // Número de elementos en la lista

    /**
     * Clase interna que representa un nodo de la lista enlazada
     * Cada nodo contiene un value y una referencia al siguiente nodo
     */
    static class Node {
        int value;  // Dato almacenado en el nodo
        Node next;  // Referencia al siguiente nodo

        /**
         * Constructor del nodo
         * @param value El value a almacenar en el nodo
         */
        public Node(int value) {
            this.value = value;
            this.next = null;  // Inicialmente no hay siguiente nodo
        }
    }

    /**
     * Constructor que crea una lista con un elemento inicial
     * Complejidad: O(1)
     * 
     * @param value El value del primer elemento de la lista
     */
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    /**
     * Constructor que crea una lista vacía
     * Complejidad: O(1)
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Agrega un elemento al final de la lista
     * Complejidad: O(1)
     * 
     * @param value El value a agregar al final de la lista
     */
    public void append(int value){
        Node newNode = new Node(value);

        if (size == 0){
            // Si la lista está vacía, el nuevo nodo es tanto head como tail
            head = newNode;
        } else {
            // Si la lista no está vacía, conectar el nuevo nodo al final
            tail.next = newNode;
        }
        tail = newNode;  // Actualizar tail al nuevo nodo
        size++;          // Incrementar el tamaño
    }

    /**
     * Agrega un elemento al inicio de la lista
     * Complejidad: O(1)
     * 
     * @param value El value a agregar al inicio de la lista
     */
    public void prepend(int value){
        Node newNode = new Node(value);

        if (size == 0){
            // Si la lista está vacía, el nuevo nodo es tanto head como tail
            head = newNode;
            tail = newNode;
        } else {
            // Conectar el nuevo nodo al head actual y actualizar head
            newNode.next = head;
            head = newNode;
        }
        size++;  // Incrementar el tamaño
    }

    /**
     * Elimina el último elemento de la lista
     * Complejidad: O(n) - debe recorrer toda la lista para encontrar el penúltimo nodo
     * 
     * @return El nodo eliminado, o null si la lista está vacía
     */
    public Node removeLast(){
        if (size == 0) return null;
        
        Node temp = head;
        Node prev = head;

        // Recorrer hasta encontrar el último nodo
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        
        // Actualizar tail al penúltimo nodo y eliminar la referencia
        tail = prev;
        prev.next = null;
        size--;

        // Si la lista queda vacía, limpiar head y tail
        if (size == 0) {
            head = tail = null;
        }

        return temp;
    }

    /**
     * Elimina el primer elemento de la lista
     * Complejidad: O(1)
     * 
     * @return El nodo eliminado, o null si la lista está vacía
     */
    public Node removeFirst() {
        if (size == 0) {
            return null;
        }
        
        Node temp = head;
        if (size == 1) {
            // Si solo hay un elemento, limpiar head y tail
            head = tail = null;
        } else {
            // Mover head al siguiente nodo y limpiar la referencia
            head = head.next;
            temp.next = null;
        }
        size--;
        return temp;
    }

    /**
     * Imprime todos los elementos de la lista
     * Complejidad: O(n)
     */
    public void printList(){
        Node current = head;

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

    /**
     * Obtiene el nodo en el índice especificado
     * Complejidad: O(n)
     * 
     * @param index El índice del nodo a obtener (0-based)
     * @return El nodo en el índice especificado, o null si el índice es inválido
     */
    public Node get(int index){
        if (index < 0 || index >= size){
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     * Modifica el value del nodo en el índice especificado
     * Complejidad: O(n) - debido a la llamada a get()
     * 
     * @param index El índice del nodo a modificar
     * @param value El nuevo value para el nodo
     * @return true si la modificación fue exitosa, false si el índice es inválido
     */
    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Inserta un nuevo elemento en el índice especificado
     * Complejidad: O(n) - debido a la búsqueda del nodo anterior
     *
     * @param index El índice donde insertar el nuevo elemento
     * @param value El value del nuevo elemento
     */
    public void insert(int index, int value){

        if (index < 0 || index > size){
            return;
        }

        if (index == 0){
            prepend(value);
            return;
        }

        if (index == size){
            append(value);
            return;
        }

        // Insertar en el medio de la lista
        Node temp = get(index - 1);
        Node newNode = new Node(value);

        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    /**
     * Elimina el elemento en el índice especificado
     * Complejidad: O(n) - debido a la búsqueda del nodo anterior
     * 
     * @param index El índice del elemento a eliminar
     * @return El nodo eliminado, o null si el índice es inválido
     */
    public Node remove(int index){
        if (index < 0 || index > size){
            return null;
        }

        if (index == 0){
            return removeFirst();
        }

        if (index == size){
            return removeLast();
        }

        // Eliminar del medio de la lista
        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        size--;
        return temp;
    }

    /**
     * Invierte el orden de los elementos en la lista
     * Complejidad: O(n) tiempo, O(1) espacio
     * Algoritmo: Usa tres punteros para invertir las conexiones nodo por nodo
     */
    public void reverse(){
        Node current = head;
        head = tail;
        tail = current;

        Node after = current.next;
        Node before = null;

        for (int i = 0; i < size; i++){
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while(list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Missing nodes cases
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    /**
     * Verifica si la lista está vacía
     * Complejidad: O(1)
     * 
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Imprime el value del primer nodo (head)
     * Complejidad: O(1)
     */
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    /**
     * Imprime el value del último nodo (tail)
     * Complejidad: O(1)
     */
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    /**
     * Imprime el tamaño actual de la lista
     * Complejidad: O(1)
     */
    public void getSize() {
        System.out.println("Size: " + size);
    }
}
