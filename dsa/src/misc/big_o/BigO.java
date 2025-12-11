package misc.big_o;

/**
 * Clase para demostrar diferentes notaciones de complejidad Big O
 * 
 * Esta clase contiene ejemplos prácticos de algoritmos con diferentes
 * complejidades temporales para ilustrar el análisis de Big O.
 * 
 * Notaciones cubiertas:
 * - O(1): Tiempo constante
 * - O(n): Tiempo lineal
 * - O(n²): Tiempo cuadrático
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class BigO {

    /**
     * Ejemplo de complejidad O(n) - Tiempo Lineal
     * 
     * Este método imprime n elementos, realizando n operaciones.
     * El tiempo de ejecución crece linealmente con el tamaño de entrada.
     * 
     * Complejidad: O(n) tiempo, O(1) espacio
     * 
     * @param n El número de elementos a imprimir
     */
    public static void printItems(int n){
        for (int i=0;i<n;i++){ // Realiza n operaciones, por lo tanto O(n)
            System.out.println(i);
        }
    }

    /**
     * Ejemplo de complejidad O(n²) - Tiempo Cuadrático
     * 
     * Este método tiene dos loops anidados, cada uno ejecutándose n veces.
     * El número total de operaciones es n × n = n².
     * 
     * Complejidad: O(n²) tiempo, O(1) espacio
     * 
     * @param n El tamaño de entrada para ambos loops
     */
    public static void printItems2(int n){
        // Dos loops anidados -> O(n × n) = O(n²)
        for (int i=0;i<n;i++){ // Loop principal O(n)
            for (int j=0;j<n;j++){ // Loop anidado O(n)
                System.out.println(i + " " + j);
            }
        }
    }

    /**
     * Ejemplo de complejidad O(1) - Tiempo Constante
     * 
     * Este método siempre realiza la misma cantidad de operaciones,
     * independientemente del tamaño de entrada.
     * 
     * Complejidad: O(1) tiempo, O(1) espacio
     * 
     * @param n El número a imprimir (el tamaño no afecta el tiempo de ejecución)
     */
    public static void printNumber(int n){
        System.out.println(n); // Complejidad constante - siempre 1 operación
    }
}
