package concurrente.tarea1.solucion2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa el productor en el problema del Productor-Consumidor. Se elige el
 * nombre de Bob para seguir el ejemeplo de la Fábula mostrada en clase.
 *
 * @author miguel
 */
public class Bob implements Runnable {

    private static final String MENSAJE = "PRODUCTOR: Entrando\nPRODUCTOR: Poniendo %d unidades de comida\nPRODUCTOR: Saliendo\n\n\n";
    private final Yard _yard;
    private final Random _random;

    /**
     * Constructor que recibe el campo donde se pondrá la comida.
     *
     * @param yard El campo donde se pondrá la comida.
     */
    public Bob(Yard yard) {
        _yard = yard;
        _random = new Random();
    }

    /**
     * Sobreescritura del método run de la interfaz Runnable. Este método se
     * encarga de poner comida en el campo si es que no hay. Utiliza la solución
     * usando latas para esperar o entrar a depositar comida, así como métodos
     * wait() y notify() para esperar o depositar comida si es el caso.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (_yard) {
                if (_yard.getCan()) {
                    try {
                        _yard.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Bob.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (_yard.getTotalFood() == 0) {
                    int depositado = 1 + _random.nextInt(100);
                    _yard.setTotalFood(depositado);
                    System.out.println(String.format(MENSAJE, depositado));
                    _yard.notify();
                }
            }
        }
    }

}
