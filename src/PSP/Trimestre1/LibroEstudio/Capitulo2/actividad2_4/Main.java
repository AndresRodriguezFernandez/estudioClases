package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_4;

import java.util.Random;

public class Main {
    static Random r = new Random();
    static final int numeroHilos = 10;
    public static void main(String[]args) {
        int numAzar = r.nextInt(101);
        System.out.println(numAzar);
        NumeroOculto no = new NumeroOculto(numAzar);
        Hilo[] hilos = new Hilo[numeroHilos];
        for(int i = 0; i < hilos.length; i++) {
            hilos[i] = new Hilo(i, no);
            hilos[i].start();
        }
        for(int i = 0; i < hilos.length; i++){
            try{
                hilos[i].join();
            }catch(InterruptedException e){
                System.out.println("Se ha interrumpido el proceso.");
            }
        }
        System.out.println("Se ha terminado el proceso.");
    }
}
