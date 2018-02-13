package concurrente.tarea1.solucion2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa el consumidor dentro del problema Productor-Consumidor. Se
 * representa como una mascota que sale al campo para comer.
 *
 * @author miguel
 */
public class Pet implements Runnable {

    private final Yard _yard;
    private static final int CAPACITY = 1;
    private final String _name;

    /**
     * Recibe el campo donde comera y el nombre del animal.
     * @param yard El campo donde comerá.
     * @param name El nombre del animal.
     */
    public Pet(Yard yard, String name) {
        _yard = yard;
        _name = name;
    }

    /**
     * Sobreescritura del método run de la interfaz Runnable. Este método se
     * encarga de permitir que el animal coma mientras haya comida. Esta
     * implementación simula la solución de latas, usando métodos wait() y
     * notify().
     */
    @Override
    public void run() {
        while (true) {
            synchronized (_yard) {
                if (!_yard.getCan()) {
                    try {
                        _yard.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (_yard.getTotalFood() > 0) {
                    int restante = _yard.eat(CAPACITY);
                    System.out.println(String.format("CONSUMIDOR: Queda %d unidades de comida", restante));
                    if (restante == 0) {
                        System.out.println("CONSUMIDOR: No hay comida\nCONSUMIDOR: Saliendo animal \n\n\n");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        _yard.notify();
                    }
                }
            }
        }
    }

}
