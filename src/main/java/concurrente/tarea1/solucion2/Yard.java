package concurrente.tarea1.solucion2;

/**
 * Clase que representa el campo donde:
 *
 * - Bob deposita comida si no hay y la lata esta arriba. - Un animal consume
 * comida si hay y la lata esta abajo.
 *
 * @author miguel
 */
public class Yard {

    private int _totalFood;
    private boolean _can = false;

    /**
     * Establece el total de comida dentro del campo.
     *
     * @param totalFood El total de comida dentro del campo.
     */
    public void setTotalFood(int totalFood) {
        _can = true;
        _totalFood = totalFood;
    }

    /**
     * Función que permite consumir la cantidad de comida especificada. Regresa
     * la cantidad de comida restante.
     *
     * @param food La cantidad de comida a consumir.
     * @return El total de comida restante.
     */
    public int eat(int food) {
        if (food > _totalFood) {
            _totalFood = 0;
            _can = false;
        } else {
            _totalFood -= food;
        }
        return _totalFood;
    }

    /**
     * Regresa el total de comida en el campo.
     *
     * @return el total de comida en el campo.
     */
    public int getTotalFood() {
        return _totalFood;
    }

    /**
     * Regresa el estado de la lata.
     *
     * @return El estado de la lata. True si está arriba, False si está abajo.
     */
    public boolean getCan() {
        return _can;
    }

}
