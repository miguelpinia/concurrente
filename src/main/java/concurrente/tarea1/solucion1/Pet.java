package concurrente.tarea1.solucion1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa el consumidor dentro del problema Productor-Consumidor. Se
 * representa como una mascota que sale al campo para comer.
 *
 * @author miguel
 */
public class Pet implements Runnable {

    private static final int CAPACIDAD = 1;
    private final Yard _yard;
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
     * encarga de permitir que el animal coma mientras haya comida.
     */
    @Override
    public void run() {
        int i = 1000;
        while (true) {
            int comida;
            System.out.println(String.format("CONSUMIDOR: Entra animal %s", _name));
            do {
                comida = _yard.come(CAPACIDAD);
                System.out.println(String.format("Queda %d unidades de comida", comida));
                if (comida == 0) {
                    System.out.println("CONSUMIDOR: No hay comida\nCONSUMIDOR: Saliendo animal \n\n\n");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } while (comida > 0);
        }
    }

}
