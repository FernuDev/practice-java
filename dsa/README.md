# DSA-Java: Estructuras de Datos y Algoritmos en Java

## 📋 Descripción del Proyecto

Este repositorio contiene implementaciones completas de estructuras de datos fundamentales y algoritmos en Java, diseñado para el aprendizaje y práctica de conceptos de Ciencias de la Computación. El proyecto incluye implementaciones desde básicas hasta avanzadas, con ejemplos prácticos y análisis de complejidad.

## 🏗️ Estructura del Proyecto

```
DSA-Java/
├── src/
│   ├── datastructures/          # Implementaciones de estructuras de datos
│   │   ├── linkedlist/          # Lista enlazada simple
│   │   └── doublylinkedlist/    # Lista enlazada doble
│   ├── excercises/              # Ejercicios y algoritmos avanzados
│   │   └── linkedlist/          # Algoritmos especializados para listas
│   └── misc/                    # Conceptos misceláneos
│       ├── big_o/               # Análisis de complejidad Big O
│       ├── classes/             # Ejemplos de clases y objetos
│       └── pointers/            # Conceptos de punteros y referencias
└── README.md                    # Este archivo
```

## 🚀 Características Principales

### Estructuras de Datos Implementadas

1. **LinkedList (Lista Enlazada Simple)**
   - Operaciones básicas: append, prepend, insert, remove
   - Algoritmos avanzados: reverse, find middle node
   - Complejidad temporal optimizada

2. **DoublyLinkedList (Lista Enlazada Doble)**
   - Navegación bidireccional
   - Operaciones optimizadas con acceso desde head y tail
   - Implementación completa de CRUD

### Algoritmos y Técnicas

- **Detección de ciclos** (Floyd's Cycle Detection)
- **Eliminación de duplicados** usando HashSet
- **Búsqueda del k-ésimo elemento desde el final**
- **Conversión binaria a decimal**
- **Particionamiento de listas**
- **Análisis de complejidad Big O**

## 📚 Conceptos Cubiertos

### Complejidad Temporal
- **O(1)** - Tiempo constante
- **O(n)** - Tiempo lineal
- **O(n²)** - Tiempo cuadrático

### Técnicas de Algoritmos
- **Two Pointers** (Punteros dobles)
- **Hash Set** para detección de duplicados
- **Tortoise and Hare** para detección de ciclos
- **Partitioning** para reorganización de datos

## 🛠️ Requisitos del Sistema

- **Java 8+**
- **IDE compatible** (IntelliJ IDEA, Eclipse, VS Code)
- **Git** para control de versiones

## 📖 Cómo Usar

### Compilación y Ejecución

```bash
# Compilar un archivo específico
javac src/datastructures/linkedlist/LinkedList.java
javac src/datastructures/linkedlist/Main.java

# Ejecutar el programa principal
java -cp src datastructures.linkedlist.Main
```

### Ejemplo de Uso Básico

```java
// Crear una nueva lista enlazada
LinkedList list = new LinkedList();

// Agregar elementos
list.append(1);
list.append(2);
list.prepend(0);

// Mostrar la lista
list.printList(); // Output: List: < 0, 1, 2 >

// Obtener elemento por índice
Node node = list.get(1);
System.out.println("Valor en índice 1: " + node.value);
```

## 🎯 Casos de Uso Comunes

### LinkedList
- **Implementación de colas y pilas**
- **Gestión de memoria dinámica**
- **Algoritmos de ordenamiento**
- **Sistemas de caché LRU**

### DoublyLinkedList
- **Navegadores web** (historial forward/backward)
- **Editores de texto** (undo/redo)
- **Sistemas de música** (playlist navigation)
- **Implementación de Deque**

## 🔍 Análisis de Complejidad

| Operación | LinkedList | DoublyLinkedList |
|-----------|------------|------------------|
| Access    | O(n)       | O(n)             |
| Search    | O(n)       | O(n)             |
| Insertion | O(1)*      | O(1)*            |
| Deletion  | O(1)*      | O(1)*            |

*O(1) cuando se conoce la posición, O(n) para búsqueda + operación

## 📝 Documentación Adicional

- [LinkedList - Documentación Detallada](src/datastructures/linkedlist/README.md)
- [DoublyLinkedList - Documentación Detallada](src/datastructures/doublylinkedlist/README.md)
- [Big O Analysis - Guía de Complejidad](src/misc/big_o/README.md)

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**Luis Núñez**
- Proyecto educativo para el aprendizaje de estructuras de datos y algoritmos
- Implementaciones optimizadas con análisis de complejidad
- Ejemplos prácticos y casos de uso reales

---

*Este proyecto es parte de un curso de estructuras de datos y algoritmos, diseñado para proporcionar una base sólida en conceptos fundamentales de programación.*
