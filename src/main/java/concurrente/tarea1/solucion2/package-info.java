/**
 * Segunda solución usando interrupciones. En esta solución se modelan
 * tres clases, la primera de ellas representa a Bob que es el productor e
 * implementa la interfaz Runnable, la segunda de ellas representa la mascota
 * que es el consumidor e igual implementa a la interfaz Runnable. Una tercera
 * clase es el campo donde se va a depositar la comida por parte del productor
 * y va a ir a consumir la mascota (el consumidor). En las clases de productor y
 * consumidor, se encuentran implementados los métodos de consumo y producción
 * usando interrupciones vía los métodos wait() y notify().
 *
 * La simulación se encuentra en el archivo <b>Ejercicio2.java.</b>
 */
package concurrente.tarea1.solucion2;
