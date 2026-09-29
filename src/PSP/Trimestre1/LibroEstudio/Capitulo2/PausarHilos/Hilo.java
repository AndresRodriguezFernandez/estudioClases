package PSP.Trimestre1.LibroEstudio.Capitulo2.PausarHilos;

import java.util.Random;

public class Hilo extends Thread{
    private final String nombre;

    public Hilo(String nom) {
        this.nombre=nom;
    }

    @Override
    public void run(){
        System.out.println("Soy el hilo "+nombre);
        Random r = new Random();
        for(int i = 0 ; i < 5; i++) {
            int pausa = 10 + r.nextInt(500-10);
            System.out.println("Hilo "+nombre+ " hace pausa de "+pausa);
            try{
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                System.out.println("Se ha interrumpido el proceso");
            }
        }
        System.out.println("Hilo "+nombre+ " ha terminado.");
    }
}
