package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.ej3Concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Principal {
    public static void main(String[]args){
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
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("Contador final: "+contador.get());
    }
}
