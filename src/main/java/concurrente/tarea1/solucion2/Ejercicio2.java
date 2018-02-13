package concurrente.tarea1.solucion2;

public class Ejercicio2 {

    public static void main(String[] args) {
        Yard yard = new Yard();
        Pet pet = new Pet(yard, "Bar");
        Bob bob = new Bob(yard);
        Thread t1 = new Thread(pet);
        Thread t2 = new Thread(bob);
        t1.start();
        t2.start();
    }
}
