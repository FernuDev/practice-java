package misc.classes;

/**
 * Clase principal para demostrar conceptos básicos de Programación Orientada a Objetos
 * 
 * Este programa muestra:
 * - Creación de objetos
 * - Uso de constructores
 * - Encapsulación con getters y setters
 * - Independencia de objetos
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // Crear dos objetos Cookie independientes
        Cookie cookieOne = new Cookie("green");   // Galleta verde
        Cookie cookieTwo = new Cookie("red");     // Galleta roja

        // Modificar el color de la primera galleta
        cookieOne.setColor("yellow");  // Cambiar de verde a amarillo

        // Mostrar los colores de ambas galletas
        System.out.println("Cookie One Color: " + cookieOne.getColor());  // yellow
        System.out.println("Cookie Two Color: " + cookieTwo.getColor());  // red (no cambió)
        
        // Demostración: Los objetos son independientes
        // Cambiar cookieOne no afecta a cookieTwo
    }
}