package concurrente.tarea1.solucion1;

/**
 * Clase con el método main para probar la solución usando métodos sincronizados
 * dentro de los hilos de ejecución.
 *
 * @author miguel
 */
public class Ejercicio1 {

    public static void main(String args[]) {
        Yard yard = new Yard();
        Pet pet = new Pet(yard, "Foo");
        Bob bob = new Bob(yard);
        Thread t1 = new Thread(pet);
        Thread b1 = new Thread(bob);
        t1.start();
        b1.start();
    }

}
