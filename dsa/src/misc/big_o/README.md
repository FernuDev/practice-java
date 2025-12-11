# Big O Analysis - Análisis de Complejidad

## 📋 Descripción

El **análisis Big O** es una metodología fundamental en ciencias de la computación para describir la eficiencia de algoritmos en términos de tiempo de ejecución y uso de memoria. Esta sección contiene ejemplos prácticos y explicaciones de las notaciones de complejidad más comunes.

## 🎯 ¿Qué es Big O?

Big O describe el **comportamiento asintótico** de un algoritmo, es decir, cómo se comporta cuando el tamaño de entrada (n) tiende al infinito. Nos ayuda a:

- **Comparar algoritmos** de manera objetiva
- **Predecir el rendimiento** con diferentes tamaños de entrada
- **Identificar cuellos de botella** en el código
- **Tomar decisiones informadas** sobre qué algoritmo usar

## 📊 Notaciones de Complejidad

### O(1) - Tiempo Constante
```java
public static void printNumber(int n) {
    System.out.println(n); // Siempre toma el mismo tiempo
}
```

**Características:**
- ⏱️ **Tiempo:** Constante, independiente del tamaño de entrada
- 💾 **Espacio:** O(1)
- 🎯 **Ejemplos:** Acceso a array por índice, operaciones aritméticas básicas

### O(n) - Tiempo Lineal
```java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) { // n operaciones
        System.out.println(i);
    }
}
```

**Características:**
- ⏱️ **Tiempo:** Proporcional al tamaño de entrada
- 💾 **Espacio:** O(1)
- 🎯 **Ejemplos:** Búsqueda lineal, recorrido de lista, suma de array

### O(n²) - Tiempo Cuadrático
```java
public static void printItems2(int n) {
    for (int i = 0; i < n; i++) {        // n iteraciones
        for (int j = 0; j < n; j++) {    // n iteraciones por cada i
            System.out.println(i + " " + j); // n × n = n² operaciones
        }
    }
}
```

**Características:**
- ⏱️ **Tiempo:** Proporcional al cuadrado del tamaño de entrada
- 💾 **Espacio:** O(1)
- 🎯 **Ejemplos:** Bubble sort, selection sort, comparaciones de pares

## 📈 Jerarquía de Complejidades

```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)
```

| Notación | Nombre | Ejemplo | Rendimiento |
|----------|--------|---------|-------------|
| **O(1)** | Constante | Acceso a array | Excelente |
| **O(log n)** | Logarítmica | Búsqueda binaria | Muy bueno |
| **O(n)** | Lineal | Búsqueda lineal | Bueno |
| **O(n log n)** | Lineal logarítmica | Merge sort | Aceptable |
| **O(n²)** | Cuadrática | Bubble sort | Pobre |
| **O(2ⁿ)** | Exponencial | Fibonacci recursivo | Muy pobre |
| **O(n!)** | Factorial | Permutaciones | Extremadamente pobre |

## 🔍 Análisis Detallado por Ejemplo

### Ejemplo 1: O(1) - Tiempo Constante
```java
public static void printNumber(int n) {
    System.out.println(n); // 1 operación
}
```

**Análisis:**
- **Operaciones:** 1 (independiente de n)
- **Tiempo:** Constante
- **Gráfico:** Línea horizontal

### Ejemplo 2: O(n) - Tiempo Lineal
```java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) { // n iteraciones
        System.out.println(i);    // 1 operación por iteración
    }
}
```

**Análisis:**
- **Operaciones:** n (proporcional al tamaño de entrada)
- **Tiempo:** Lineal
- **Gráfico:** Línea diagonal ascendente

### Ejemplo 3: O(n²) - Tiempo Cuadrático
```java
public static void printItems2(int n) {
    for (int i = 0; i < n; i++) {        // n iteraciones
        for (int j = 0; j < n; j++) {    // n iteraciones anidadas
            System.out.println(i + " " + j); // 1 operación por par
        }
    }
}
```

**Análisis:**
- **Operaciones:** n × n = n²
- **Tiempo:** Cuadrático
- **Gráfico:** Curva exponencial ascendente

## 📊 Comparación Visual de Rendimiento

```
n=10    n=100   n=1000  n=10000
O(1)    1       1       1       1
O(n)    10      100     1000    10000
O(n²)   100     10000   1000000 100000000
```

## 🎯 Casos de Uso Prácticos

### O(1) - Operaciones Constantes
```java
// Acceso a array por índice
int value = array[index];

// Operaciones de HashMap
map.put(key, value);
map.get(key);

// Operaciones de Stack/Queue (top/front)
stack.peek();
queue.front();
```

### O(n) - Operaciones Lineales
```java
// Búsqueda lineal en array
for (int i = 0; i < array.length; i++) {
    if (array[i] == target) return i;
}

// Recorrido de LinkedList
Node current = head;
while (current != null) {
    process(current);
    current = current.next;
}
```

### O(n²) - Operaciones Cuadráticas
```java
// Bubble Sort
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j + 1]) {
            swap(array, j, j + 1);
        }
    }
}

// Comparación de todos los pares
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        compare(array[i], array[j]);
    }
}
```

## 🚀 Optimización de Algoritmos

### De O(n²) a O(n log n)
```java
// ❌ Ineficiente: O(n²)
public int[] bubbleSort(int[] arr) {
    // Implementación de bubble sort
}

// ✅ Eficiente: O(n log n)
public int[] mergeSort(int[] arr) {
    // Implementación de merge sort
}
```

### De O(n) a O(log n)
```java
// ❌ Ineficiente: O(n)
public int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}

// ✅ Eficiente: O(log n)
public int binarySearch(int[] arr, int target) {
    // Implementación de búsqueda binaria
}
```

## 📝 Ejercicios Prácticos

### Ejercicio 1: Identificar Complejidad
```java
public void mystery(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.println(i + j);
        }
    }
}
```
**Respuesta:** O(n) - El loop interno es constante (10), no depende de n.

### Ejercicio 2: Optimizar Algoritmo
```java
// ¿Cuál es la complejidad de este algoritmo?
public boolean hasDuplicate(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) return true;
        }
    }
    return false;
}
```
**Respuesta:** O(n²) - Compara todos los pares posibles.

## 🎓 Conceptos Avanzados

### Complejidad Espacial
```java
// O(n) espacio
public int[] createArray(int n) {
    int[] result = new int[n]; // n elementos
    return result;
}

// O(1) espacio
public int sum(int[] arr) {
    int total = 0; // 1 variable
    for (int num : arr) {
        total += num;
    }
    return total;
}
```

### Complejidad Amortizada
```java
// ArrayList - inserción O(1) amortizada
// Aunque ocasionalmente O(n) por redimensionamiento
public void add(int value) {
    if (size == capacity) {
        resize(); // O(n) ocasional
    }
    array[size++] = value; // O(1) típico
}
```

## 🚨 Errores Comunes

1. **Confundir mejor caso con complejidad promedio**
2. **Ignorar constantes** (O(2n) = O(n))
3. **No considerar el espacio** (solo tiempo)
4. **Asumir que O(n²) siempre es malo** (depende del contexto)
5. **No considerar el tamaño real de los datos**

## 📚 Referencias y Lectura Adicional

- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
- [Cormen, Leiserson, Rivest, Stein - Introduction to Algorithms]
- [Sedgewick, Wayne - Algorithms, 4th Edition]
- [Khan Academy - Algorithm Analysis](https://www.khanacademy.org/computing/computer-science/algorithms)

## 🎯 Próximos Pasos

Para profundizar en el análisis de complejidad:

1. **Estudiar algoritmos de ordenamiento** y sus complejidades
2. **Analizar estructuras de datos** (HashMap, TreeMap, etc.)
3. **Practicar con problemas de LeetCode** y análisis de complejidad
4. **Implementar versiones optimizadas** de algoritmos ineficientes
5. **Estudiar complejidad espacial** y trade-offs

---

*El análisis Big O es una herramienta fundamental para escribir código eficiente y tomar decisiones informadas sobre algoritmos y estructuras de datos.*
