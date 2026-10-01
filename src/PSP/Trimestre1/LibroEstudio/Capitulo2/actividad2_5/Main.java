package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_5;

import java.util.Random;

public class Main {
    static Random r = new Random();
    static final int numeroHilos = 10;
    public static void main(String[]args) {
        int numPartida = 1;
        NumeroOculto no = new NumeroOculto();
        Hilo[] hilos = new Hilo[numeroHilos];

        while(numPartida < 10) {
            System.out.println("----Partida nueva:------");
            int numAzar = r.nextInt(101);
            System.out.println(numAzar);
            no.setnumeroOculto(numAzar);
            no.setidentificador(numPartida);
            for(int i = 0; i < hilos.length; i++) {
                hilos[i] = new Hilo(i, no);
                hilos[i].start();
            }

            numPartida++;
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
