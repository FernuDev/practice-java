# LinkedList Exercises - Algoritmos Avanzados

## 📋 Descripción

Esta sección contiene implementaciones avanzadas de algoritmos y técnicas especializadas para listas enlazadas. Incluye algoritmos de detección de ciclos, eliminación de duplicados, búsqueda optimizada y conversiones de datos.

## 🎯 Algoritmos Implementados

### 1. **Detección de Nodo Medio (Find Middle Node)**
```java
public Node findMiddleNode() {
    Node slow = head;
    Node fast = head;
    
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    
    return slow;
}
```

**Técnica:** Tortoise and Hare (Tortuga y Liebre)
- **Complejidad:** O(n) tiempo, O(1) espacio
- **Uso:** Encontrar el nodo medio sin conocer el tamaño de la lista

### 2. **Detección de Ciclos (Has Loop)**
```java
public boolean hasLoop() {
    Node slow = head;
    Node fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true;
        }
    }
    return false;
}
```

**Técnica:** Floyd's Cycle Detection Algorithm
- **Complejidad:** O(n) tiempo, O(1) espacio
- **Uso:** Detectar si una lista tiene un ciclo

### 3. **Eliminación de Duplicados**
```java
public void removeDuplicates() {
    Set<Integer> seen = new HashSet<>();
    Node current = head;
    Node prev = null;
    
    while (current != null) {
        if (seen.contains(current.value)) {
            prev.next = current.next;
        } else {
            seen.add(current.value);
            prev = current;
        }
        current = current.next;
    }
}
```

**Técnica:** Hash Set para tracking
- **Complejidad:** O(n) tiempo, O(n) espacio
- **Uso:** Eliminar valores duplicados manteniendo el primer ocurrencia

### 4. **Búsqueda del K-ésimo Elemento desde el Final**
```java
public Node findKthFromEnd(int k) {
    if (k <= 0) return null;
    
    int size = getSize();
    if (k > size) return null;
    
    int positionFromStart = size - k;
    Node current = head;
    for (int i = 0; i < positionFromStart; i++) {
        current = current.next;
    }
    return current;
}
```

**Técnica:** Cálculo de posición inversa
- **Complejidad:** O(n) tiempo, O(1) espacio
- **Uso:** Encontrar el k-ésimo elemento desde el final

### 5. **Conversión Binaria a Decimal**
```java
public int binaryToDecimal() {
    int size = getSize() - 1;
    int number = 0;
    Node current = head;
    
    while (size >= 0) {
        number += (int) (Math.pow(2, size) * current.value);
        current = current.next;
        size--;
    }
    
    return number;
}
```

**Técnica:** Conversión posicional
- **Complejidad:** O(n) tiempo, O(1) espacio
- **Uso:** Convertir lista binaria a número decimal

### 6. **Particionamiento de Lista**
```java
public Node partition(Node head, int k) {
    if (head == null) return null;
    if (head.next == null) return head;
    
    Node dummy1 = new Node(0);
    Node temp1 = dummy1;
    
    Node dummy2 = new Node(0);
    Node temp2 = dummy2;
    
    Node current = head;
    
    while (current != null) {
        if (current.value < k) {
            temp1.next = current;
            temp1 = temp1.next;
        } else {
            temp2.next = current;
            temp2 = temp2.next;
        }
        current = current.next;
    }
    
    temp2.next = null;
    temp1.next = dummy2.next;
    
    return dummy1.next;
}
```

**Técnica:** Two-pointer con nodos dummy
- **Complejidad:** O(n) tiempo, O(1) espacio
- **Uso:** Reorganizar lista con valores menores a k primero

## 🔍 Análisis Detallado de Algoritmos

### Tortoise and Hare Algorithm
```java
// Ejemplo visual del algoritmo
// Lista: 1 -> 2 -> 3 -> 4 -> 5
// 
// Iteración 1: slow=1, fast=1
// Iteración 2: slow=2, fast=3
// Iteración 3: slow=3, fast=5
// Iteración 4: slow=4, fast=null (termina)
// Resultado: slow apunta al nodo medio (3)
```

**¿Por qué funciona?**
- El puntero rápido se mueve 2 pasos por cada paso del lento
- Cuando el rápido llega al final, el lento está en el medio
- Eficiencia: O(n) vs O(n) + O(n/2) de la aproximación naive

### Floyd's Cycle Detection
```java
// Ejemplo con ciclo: 1 -> 2 -> 3 -> 4 -> 2 (ciclo)
// 
// Iteración 1: slow=1, fast=1
// Iteración 2: slow=2, fast=3
// Iteración 3: slow=3, fast=2
// Iteración 4: slow=4, fast=4 (¡colisión!)
// Resultado: Ciclo detectado
```

**Matemática detrás del algoritmo:**
- Si hay un ciclo de longitud C, el puntero rápido alcanzará al lento en máximo C pasos
- La distancia entre punteros se reduce en 1 en cada iteración

## 🚀 Casos de Uso Prácticos

### 1. **Sistema de Detección de Ciclos**
```java
// Aplicación: Detectar referencias circulares en estructuras de datos
// Uso: Garbage collection, validación de grafos
public boolean hasCircularReference() {
    return hasLoop();
}
```

### 2. **Optimización de Búsqueda**
```java
// Aplicación: Encontrar elemento medio para dividir lista
// Uso: Merge sort, búsqueda binaria en listas
public Node getMiddleForSplit() {
    return findMiddleNode();
}
```

### 3. **Limpieza de Datos**
```java
// Aplicación: Eliminar duplicados de datasets
// Uso: Procesamiento de logs, limpieza de bases de datos
public void cleanData() {
    removeDuplicates();
}
```

### 4. **Conversión de Formatos**
```java
// Aplicación: Convertir representaciones binarias
// Uso: Procesamiento de archivos, protocolos de red
public int parseBinaryData() {
    return binaryToDecimal();
}
```

## 📊 Comparación de Rendimiento

| Algoritmo | Tiempo | Espacio | Casos de Uso |
|-----------|--------|---------|--------------|
| **Find Middle** | O(n) | O(1) | División de listas |
| **Has Loop** | O(n) | O(1) | Detección de ciclos |
| **Remove Duplicates** | O(n) | O(n) | Limpieza de datos |
| **Find Kth from End** | O(n) | O(1) | Búsqueda inversa |
| **Binary to Decimal** | O(n) | O(1) | Conversión de formatos |
| **Partition** | O(n) | O(1) | Reorganización |

## 🎓 Conceptos de Aprendizaje

### Two Pointers Technique
- **Slow and Fast Pointers:** Para detección de ciclos y nodos medios
- **Left and Right Pointers:** Para búsqueda en arrays ordenados
- **Window Sliding:** Para problemas de subarrays

### Hash Set Optimization
- **Trade-off:** Espacio vs tiempo
- **Aplicación:** Eliminación de duplicados, detección de elementos únicos
- **Alternativa:** Sorting + linear scan (O(n log n) tiempo, O(1) espacio)

### Dummy Nodes Pattern
- **Ventaja:** Simplifica el manejo de casos edge
- **Uso:** Particionamiento, merge de listas
- **Patrón:** Crear nodo temporal, procesar, retornar siguiente

## 📝 Ejercicios de Práctica

### Ejercicio 1: Implementar Reverse con Two Pointers
```java
// Desafío: Invertir lista usando solo dos punteros
public void reverseTwoPointers() {
    // Tu implementación aquí
}
```

### Ejercicio 2: Detectar Punto de Inicio del Ciclo
```java
// Desafío: Si hay ciclo, encontrar dónde comienza
public Node findCycleStart() {
    // Tu implementación aquí
}
```

### Ejercicio 3: Merge Two Sorted Lists
```java
// Desafío: Combinar dos listas ordenadas
public Node mergeSortedLists(Node list1, Node list2) {
    // Tu implementación aquí
}
```

## 🚨 Errores Comunes

1. **No verificar null** en algoritmos de two pointers
2. **Olvidar actualizar size** en removeDuplicates
3. **Referencias circulares** en partition
4. **Índices fuera de rango** en findKthFromEnd
5. **No manejar casos edge** (lista vacía, un elemento)

## 🔧 Optimizaciones Avanzadas

### Optimización de findKthFromEnd
```java
// Versión optimizada con two pointers
public Node findKthFromEndOptimized(int k) {
    Node slow = head;
    Node fast = head;
    
    // Mover fast k posiciones adelante
    for (int i = 0; i < k; i++) {
        if (fast == null) return null;
        fast = fast.next;
    }
    
    // Mover ambos hasta que fast llegue al final
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    
    return slow;
}
```

## 📚 Referencias y Lectura Adicional

- [LeetCode - Linked List Problems](https://leetcode.com/tag/linked-list/)
- [GeeksforGeeks - Linked List Algorithms](https://www.geeksforgeeks.org/data-structures/linked-list/)
- [Cracking the Coding Interview - Chapter 2]
- [Elements of Programming Interviews - Chapter 7]

---

*Estos algoritmos representan las técnicas fundamentales para trabajar con listas enlazadas y son la base para problemas más complejos en entrevistas técnicas y desarrollo de software.*
