# DoublyLinkedList - Lista Enlazada Doble

## 📋 Descripción

Una **DoublyLinkedList** (Lista Enlazada Doble) es una estructura de datos lineal donde cada nodo contiene datos y referencias tanto al nodo siguiente como al nodo anterior. Esta característica permite navegación bidireccional, lo que optimiza ciertas operaciones comparado con las listas enlazadas simples.

## 🏗️ Estructura de Datos

### Nodo (Node)
```java
class Node {
    int value;    // Dato almacenado
    Node next;    // Referencia al siguiente nodo
    Node prev;    // Referencia al nodo anterior
}
```

### Lista
```java
public class DoublyLinkedList {
    private Node head;   // Primer nodo de la lista
    private Node tail;   // Último nodo de la lista
    private int length;  // Número de elementos
}
```

## 🔄 Operaciones Implementadas

### 1. Construcción
- **`DoublyLinkedList(int value)`** - Crea lista con un elemento inicial
- **`DoublyLinkedList()`** - Crea lista vacía

### 2. Inserción
- **`append(int value)`** - Agrega elemento al final
- **`prepend(int value)`** - Agrega elemento al inicio
- **`insert(int index, int value)`** - Inserta en posición específica

### 3. Eliminación
- **`removeFirst()`** - Elimina primer elemento
- **`removeLast()`** - Elimina último elemento
- **`remove(int index)`** - Elimina elemento en posición específica

### 4. Acceso y Modificación
- **`get(int index)`** - Obtiene nodo por índice (optimizado)
- **`set(int index, int value)`** - Modifica valor por índice

### 5. Utilidades
- **`printList()`** - Imprime todos los elementos
- **`getHead()`** - Obtiene el primer nodo
- **`getTail()`** - Obtiene el último nodo
- **`getLength()`** - Obtiene el tamaño de la lista

## ⏱️ Análisis de Complejidad

| Operación | Complejidad Temporal | Complejidad Espacial |
|-----------|---------------------|---------------------|
| **Access** | O(n/2) ≈ O(n) | O(1) |
| **Search** | O(n) | O(1) |
| **Insertion (head/tail)** | O(1) | O(1) |
| **Insertion (middle)** | O(n) | O(1) |
| **Deletion (head/tail)** | O(1) | O(1) |
| **Deletion (middle)** | O(n) | O(1) |
| **Reverse** | O(n) | O(1) |

## 🎯 Ventajas y Desventajas

### ✅ Ventajas
- **Navegación bidireccional** - puede recorrer hacia adelante y atrás
- **Acceso optimizado** - puede empezar desde head o tail según proximidad
- **Eliminación eficiente** - no necesita buscar el nodo anterior
- **Implementación de Deque** - cola de doble extremo natural
- **Operaciones de inserción/eliminación** más eficientes en ciertos casos

### ❌ Desventajas
- **Memoria extra** - cada nodo requiere espacio para dos punteros
- **Complejidad de mantenimiento** - más punteros que actualizar
- **Posibles errores** - más fácil introducir bugs con referencias dobles
- **Overhead de memoria** - aproximadamente 33% más memoria que LinkedList simple

## 🔧 Implementación Detallada

### Algoritmo de Acceso Optimizado (get)
```java
public Node get(int index) {
    if (index < 0 || index >= length) return null;
    
    Node temp = head;
    if (index < length / 2) {
        // Empezar desde head si está en la primera mitad
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
    } else {
        // Empezar desde tail si está en la segunda mitad
        temp = tail;
        for (int i = length - 1; i > index; i--) {
            temp = temp.prev;
        }
    }
    return temp;
}
```

**Explicación:**
1. Verifica si el índice es válido
2. Si el índice está en la primera mitad, recorre desde head
3. Si está en la segunda mitad, recorre desde tail hacia atrás
4. Complejidad: O(n/2) en el peor caso vs O(n) en LinkedList simple

### Algoritmo de Inserción en Medio
```java
public boolean insert(int index, int value) {
    if (index < 0 || index > length) return false;
    
    if (index == 0) {
        prepend(value);
        return true;
    }
    
    if (index == length) {
        append(value);
        return true;
    }
    
    Node before = get(index - 1);
    Node after = before.next;
    Node newNode = new Node(value);
    
    // Actualizar referencias
    before.next = newNode;
    after.prev = newNode;
    newNode.prev = before;
    newNode.next = after;
    
    length++;
    return true;
}
```

## 🚀 Casos de Uso Comunes

### 1. **Implementación de Deque (Double-ended Queue)**
```java
// Front operations: prepend(), removeFirst()
// Back operations: append(), removeLast()
// Peek operations: getHead(), getTail()
```

### 2. **Navegadores Web**
- Historial de navegación (forward/backward)
- Pestañas del navegador
- Cache de páginas visitadas

### 3. **Editores de Texto**
- Sistema de undo/redo
- Navegación entre posiciones
- Historial de cambios

### 4. **Sistemas de Música**
- Playlist con navegación bidireccional
- Control de reproducción (anterior/siguiente)
- Cola de reproducción

### 5. **Sistemas de Caché LRU**
- Implementación eficiente de Least Recently Used
- Acceso rápido a elementos recientes y antiguos

## 📝 Ejemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        // Crear lista con elemento inicial
        DoublyLinkedList dll = new DoublyLinkedList(7);
        
        // Agregar elementos al final
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.printList(); // List: < 7, 4, 5, 6 >
        
        // Agregar elemento al inicio
        dll.prepend(1);
        dll.printList(); // List: < 1, 7, 4, 5, 6 >
        
        // Eliminar del final
        dll.removeLast();
        dll.printList(); // List: < 1, 7, 4, 5 >
        
        // Eliminar del inicio
        dll.removeFirst();
        dll.printList(); // List: < 7, 4, 5 >
        
        // Obtener elemento (optimizado)
        Node node = dll.get(2);
        System.out.println("Elemento en índice 2: " + node.value); // 5
        
        // Insertar en posición específica
        dll.insert(1, 10);
        dll.printList(); // List: < 7, 10, 4, 5 >
        
        // Modificar valor
        dll.set(2, 99);
        dll.printList(); // List: < 7, 10, 99, 5 >
    }
}
```

## 🔍 Comparación con LinkedList Simple

| Aspecto | DoublyLinkedList | LinkedList Simple |
|---------|------------------|-------------------|
| **Memoria por nodo** | 3 campos (value, next, prev) | 2 campos (value, next) |
| **Acceso optimizado** | O(n/2) | O(n) |
| **Eliminación de nodo** | O(1) si se conoce el nodo | O(n) para encontrar anterior |
| **Navegación** | Bidireccional | Unidireccional |
| **Complejidad de código** | Mayor | Menor |
| **Casos de uso** | Deque, navegación | Stack, Queue simple |

## 🎓 Conceptos de Aprendizaje

### Gestión de Referencias Dobles
- Mantener consistencia entre referencias prev/next
- Actualizar correctamente todas las conexiones
- Manejo de casos edge (primer/último nodo)

### Optimización de Acceso
- Algoritmo de búsqueda optimizado
- Decisión inteligente de punto de partida
- Balance entre complejidad y eficiencia

### Patrones de Diseño
- Iterator pattern para navegación
- Strategy pattern para algoritmos de búsqueda
- Template method para operaciones CRUD

## 🚨 Errores Comunes

1. **Referencias inconsistentes** - no actualizar prev y next correctamente
2. **Memory leaks** - no limpiar referencias al eliminar nodos
3. **Índices fuera de rango** - no validar índices antes de acceso
4. **Referencias circulares** - crear ciclos accidentales
5. **No actualizar length** - olvidar incrementar/decrementar contador

## 🔧 Optimizaciones Implementadas

### 1. **Acceso Inteligente**
- Decide automáticamente si empezar desde head o tail
- Reduce el número promedio de operaciones a la mitad

### 2. **Gestión Eficiente de Memoria**
- Limpieza correcta de referencias
- Prevención de memory leaks

### 3. **Validación Robusta**
- Verificación de índices válidos
- Manejo de casos edge (lista vacía, un elemento)

## 📚 Referencias y Lectura Adicional

- [GeeksforGeeks - Doubly Linked List](https://www.geeksforgeeks.org/doubly-linked-list/)
- [Cormen, Leiserson, Rivest, Stein - Introduction to Algorithms]
- [Sedgewick, Wayne - Algorithms, 4th Edition]
- [Wikipedia - Doubly Linked List](https://en.wikipedia.org/wiki/Doubly_linked_list)

## 🎯 Próximos Pasos

Para expandir esta implementación, considera:

1. **Implementar Iterator** para navegación más elegante
2. **Agregar métodos de ordenamiento** (merge sort, quick sort)
3. **Implementar operaciones de conjunto** (union, intersection)
4. **Agregar serialización** para persistencia
5. **Implementar versiones thread-safe** para concurrencia

---

*Esta implementación de DoublyLinkedList proporciona una base sólida para entender las estructuras de datos bidireccionales y sus aplicaciones en sistemas más complejos.*
