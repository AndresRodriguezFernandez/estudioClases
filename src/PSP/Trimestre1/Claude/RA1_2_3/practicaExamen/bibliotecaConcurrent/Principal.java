package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.bibliotecaConcurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Principal {
    public static void main(String[] args) {
        BlockingQueue<Integer> cola = new ArrayBlockingQueue<>(5);
        AtomicInteger contador = new AtomicInteger(0);

        ExecutorService ejecutor = Executors.newFixedThreadPool(3);
        ejecutor.execute(new Productor(cola));
        ejecutor.execute(new Consumidor(contador, cola));
        ejecutor.execute(new Consumidor(contador, cola));

        ejecutor.shutdown();
        try{
            ejecutor.awaitTermination(1, TimeUnit.MINUTES);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Total procesadas: "+contador.get());
    }
}
