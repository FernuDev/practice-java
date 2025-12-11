package misc.classes;

/**
 * Clase de ejemplo que demuestra conceptos básicos de Programación Orientada a Objetos
 * 
 * Esta clase representa una galleta con un color específico y demuestra:
 * - Encapsulación (campos privados con getters/setters)
 * - Constructores
 * - Métodos de acceso y modificación
 * 
 * @author Luis Núñez
 * @version 1.0
 */
public class Cookie {
    private String color;  // Campo privado para encapsulación

    /**
     * Constructor que inicializa la galleta con un color específico
     * 
     * @param color El color de la galleta
     */
    public Cookie(String color) {
        this.color = color;
    }

    /**
     * Obtiene el color actual de la galleta
     * 
     * @return El color de la galleta
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece un nuevo color para la galleta
     * 
     * @param color El nuevo color de la galleta
     */
    public void setColor(String color) {
        this.color = color;
    }
}
