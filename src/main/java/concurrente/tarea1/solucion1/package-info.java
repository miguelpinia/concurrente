/**
 * Primera solución usando métodos sincronizados. En esta solución se modelan
 * tres clases, la primera de ellas representa a Bob que es el productor e
 * implementa la interfaz Runnable, la segunda de ellas representa la mascota
 * que es el consumidor e igual implementa a la interfaz Runnable. Una tercera
 * clase es el campo donde se va a depositar la comida por parte del productor
 * y va a ir a consumir la mascota (el consumidor). En esta clase que representa
 * al campo, todas las operaciones que puede realizar están marcadas con la
 * palabra reservada synchronized.
 *
 * La simulación se encuentra en el archivo <b>Ejercicio1.java</b>
 */
package concurrente.tarea1.solucion1;
