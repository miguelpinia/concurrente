package concurrente.tarea1.solucion1;

import java.util.Random;

/**
 * Representa el productor en el problema del Productor-Consumidor. Se elige el
 * nombre de Bob para seguir el ejemeplo de la Fábula mostrada en clase.
 *
 * @author miguel
 */
public class Bob implements Runnable {

    private static final String MESSAGE = "PRODUCTOR: Entrando\nPRODUCTOR: Poniendo %d unidades de comida\nPRODUCTOR: Saliendo\n\n\n";
    private final Random _random;
    private final Yard _yard;

    /**
     * Constructor que recibe el campo donde se pondrá la comida.
     *
     * @param yard El campo donde se pondrá la comida.
     */
    public Bob(Yard yard) {
        _random = new Random();
        _yard = yard;
    }

    /**
     * Sobreescritura del método run de la interfaz Runnable. Este método se
     * encarga de poner comida en el campo si es que no hay.
     */
    @Override
    public void run() {
        while (true) {
            if (_yard.getTotalFood() == 0) {
                int totalFood = _random.nextInt(100);
                _yard.setTotalFood(totalFood);
                System.out.println(String.format(MESSAGE, totalFood));
            }
        }
    }

}
