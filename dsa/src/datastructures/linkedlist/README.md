# LinkedList - Lista Enlazada Simple

## 📋 Descripción

Una **LinkedList** (Lista Enlazada Simple) es una estructura de datos lineal donde cada elemento (nodo) contiene datos y una referencia al siguiente nodo en la secuencia. A diferencia de los arrays, los elementos no se almacenan en ubicaciones de memoria contiguas.

## 🏗️ Estructura de Datos

### Nodo (Node)
```java
class Node {
    int value;    // Dato almacenado
    Node next;    // Referencia al siguiente nodo
}
```

### Lista
```java
public class LinkedList {
    private Node head;  // Primer nodo de la lista
    private Node tail;  // Último nodo de la lista
    private int size;   // Número de elementos
}
```

## 🔄 Operaciones Implementadas

### 1. Construcción
- **`LinkedList(int value)`** - Crea lista con un elemento inicial
- **`LinkedList()`** - Crea lista vacía

### 2. Inserción
- **`append(int value)`** - Agrega elemento al final
- **`prepend(int value)`** - Agrega elemento al inicio
- **`insert(int index, int value)`** - Inserta en posición específica

### 3. Eliminación
- **`removeFirst()`** - Elimina primer elemento
- **`removeLast()`** - Elimina último elemento
- **`remove(int index)`** - Elimina elemento en posición específica

### 4. Acceso y Modificación
- **`get(int index)`** - Obtiene nodo por índice
- **`set(int index, int value)`** - Modifica valor por índice

### 5. Utilidades
- **`printList()`** - Imprime todos los elementos
- **`reverse()`** - Invierte el orden de la lista
- **`isEmpty()`** - Verifica si la lista está vacía

## ⏱️ Análisis de Complejidad

| Operación | Complejidad Temporal | Complejidad Espacial |
|-----------|---------------------|---------------------|
| **Access** | O(n) | O(1) |
| **Search** | O(n) | O(1) |
| **Insertion (head/tail)** | O(1) | O(1) |
| **Insertion (middle)** | O(n) | O(1) |
| **Deletion (head/tail)** | O(1) | O(1) |
| **Deletion (middle)** | O(n) | O(1) |
| **Reverse** | O(n) | O(1) |

## 🎯 Ventajas y Desventajas

### ✅ Ventajas
- **Inserción/eliminación eficiente** en posiciones conocidas
- **Tamaño dinámico** - crece y decrece según necesidad
- **No desperdicia memoria** - solo usa lo necesario
- **Fácil inserción/eliminación** al inicio y final

### ❌ Desventajas
- **Acceso secuencial** - no hay acceso directo por índice
- **Memoria extra** - cada nodo requiere espacio para puntero
- **No cache-friendly** - nodos pueden estar dispersos en memoria
- **Búsqueda lenta** - requiere recorrer desde el inicio

## 🔧 Implementación Detallada

### Algoritmo de Inversión (Reverse)
```java
public void reverse() {
    Node current = head;
    head = tail;
    tail = current;
    
    Node after = current.next;
    Node before = null;
    
    for (int i = 0; i < size; i++) {
        after = current.next;
        current.next = before;
        before = current;
        current = after;
    }
}
```

**Explicación:**
1. Intercambia head y tail
2. Usa tres punteros: current, before, after
3. Invierte las conexiones nodo por nodo
4. Complejidad: O(n) tiempo, O(1) espacio

## 🚀 Casos de Uso Comunes

### 1. **Implementación de Pilas (Stack)**
```java
// Push: prepend()
// Pop: removeFirst()
// Peek: get(0)
```

### 2. **Implementación de Colas (Queue)**
```java
// Enqueue: append()
// Dequeue: removeFirst()
// Front: get(0)
```

### 3. **Sistemas de Historial**
- Navegador web (back button)
- Editor de texto (undo operations)
- Sistema de comandos

### 4. **Algoritmos de Ordenamiento**
- Merge Sort (división de listas)
- Quick Sort (particionamiento)

## 📝 Ejemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        // Crear lista vacía
        LinkedList list = new LinkedList();
        
        // Agregar elementos
        list.prepend(22);  // [22]
        list.append(33);   // [22, 33]
        list.append(44);   // [22, 33, 44]
        
        // Mostrar lista
        list.printList();  // List: < 22, 33, 44 >
        
        // Insertar en posición específica
        list.insert(1, 55); // [22, 55, 33, 44]
        
        // Obtener elemento
        Node node = list.get(1);
        System.out.println("Valor: " + node.value); // 55
        
        // Invertir lista
        list.reverse();     // [44, 33, 55, 22]
        list.printList();
    }
}
```

## 🔍 Comparación con Arrays

| Aspecto | LinkedList | Array |
|---------|------------|-------|
| **Acceso** | O(n) | O(1) |
| **Inserción inicio** | O(1) | O(n) |
| **Inserción final** | O(1) | O(1)* |
| **Eliminación inicio** | O(1) | O(n) |
| **Memoria** | Dinámica | Fija |
| **Cache** | No optimizado | Optimizado |

*O(1) si hay espacio disponible

## 🎓 Conceptos de Aprendizaje

### Punteros y Referencias
- Cada nodo apunta al siguiente
- Manejo de referencias null
- Prevención de memory leaks

### Recursión
- Algoritmos recursivos en listas
- División y conquista
- Casos base y recursivos

### Gestión de Memoria
- Creación y destrucción de nodos
- Garbage collection
- Prevención de referencias circulares

## 🚨 Errores Comunes

1. **No verificar null** antes de acceder a nodos
2. **No actualizar size** en operaciones de inserción/eliminación
3. **Referencias circulares** accidentales
4. **Memory leaks** por no limpiar referencias
5. **Índices fuera de rango** en operaciones de acceso

## 📚 Referencias y Lectura Adicional

- [GeeksforGeeks - Linked List Data Structure](https://www.geeksforgeeks.org/data-structures/linked-list/)
- [Cormen, Leiserson, Rivest, Stein - Introduction to Algorithms]
- [Sedgewick, Wayne - Algorithms, 4th Edition]

---

*Esta implementación proporciona una base sólida para entender las listas enlazadas y sus aplicaciones en algoritmos más complejos.*
