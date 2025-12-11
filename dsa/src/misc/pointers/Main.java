package misc.pointers;

import java.util.HashMap;

/**
 * Demostración de conceptos de punteros y referencias en Java
 * 
 * Esta clase ilustra la diferencia entre:
 * - Tipos primitivos (paso por valor)
 * - Objetos (paso por referencia)
 * 
 * Conceptos cubiertos:
 * - Stack vs Heap memory
 * - Referencias vs valores
 * - Mutabilidad de objetos
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        // ===== DEMOSTRACIÓN CON TIPOS PRIMITIVOS =====
        // Los tipos primitivos se pasan por valor
        // num2 solo será igual a num1 en la inicialización
        int num1 = 11;
        int num2 = num1;  // num2 recibe una copia del valor de num1

        num1 = 22;  // Cambiar num1 no afecta a num2

        System.out.println("num1: " + num1);  // 22
        System.out.println("num2: " + num2);  // 11 (no cambió)

        // ===== DEMOSTRACIÓN CON OBJETOS (REFERENCIAS) =====
        // Los objetos se pasan por referencia
        // map1 apunta a un nuevo HashMap en Heap Memory
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.put("value", 11);

        // Cuando hacemos map2 = map1, ambas variables
        // apuntan al mismo HashMap en memoria
        map2 = map1;  // map2 ahora referencia el mismo objeto que map1

        map1.put("value", 22);  // Cambiar map1 también cambia map2

        System.out.println(map1);  // {value=22}
        System.out.println(map2);  // {value=22} (ambos apuntan al mismo objeto)
    }
}
