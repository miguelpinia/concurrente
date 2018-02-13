package concurrente.tarea1.solucion1;

/**
 * Clase que representa el campo donde:
 * 
 * - Bob deposita comida si no hay
 * - Un animal consume comida si hay.
 * 
 * @author miguel
 */
public class Yard {

    // Representa el total de comida que hay en el campo.
    private int _totalComida;

    /**
     * Función que permite consumir la cantidad de comida especificada.
     *
     * @param cantidadComida La cantidad de comida a consumir.
     * @return El total de comida restante.
     */
    public synchronized int come(int cantidadComida) {
        if (_totalComida < cantidadComida) {
            _totalComida = 0;
        } else {
            _totalComida -= cantidadComida;        
        }
        return _totalComida;
    }

    /**
     * Regresa el total de comida que hay en el campo.
     *
     * @return EL total de comida disponible.
     */
    public synchronized int getTotalComida() {
        return _totalComida;
    }

    /**
     * Establece el total de la comida.
     *
     * @param totalComida El nuevo total de comida.
     */
    public synchronized void setTotalComida(int totalComida) {
        _totalComida = totalComida;
    }

}
