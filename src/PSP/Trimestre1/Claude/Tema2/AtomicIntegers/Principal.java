package PSP.Trimestre1.Claude.Tema2.AtomicIntegers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {
        ContadorVisitas cv = new ContadorVisitas();
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 200; i++){
            Visitante v = new Visitante(cv);
            es.execute(v);
        }
        es.shutdown();

        try{
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Visitas totales: "+cv.getVisitas());
    }
}
