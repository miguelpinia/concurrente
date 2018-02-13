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
    private int _totalFood;

    /**
     * Función que permite consumir la cantidad de comida especificada.
     *
     * @param food La cantidad de comida a consumir.
     * @return El total de comida restante.
     */
    public synchronized int eat(int food) {
        if (_totalFood < food) {
            _totalFood = 0;
        } else {
            _totalFood -= food;
        }
        return _totalFood;
    }

    /**
     * Regresa el total de comida que hay en el campo.
     *
     * @return EL total de comida disponible.
     */
    public synchronized int getTotalFood() {
        return _totalFood;
    }

    /**
     * Establece el total de la comida.
     *
     * @param totalComida El nuevo total de comida.
     */
    public synchronized void setTotalFood(int totalComida) {
        _totalFood = totalComida;
    }

}
