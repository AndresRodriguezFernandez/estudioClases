package PSP.Trimestre1.Claude.Tema2.DescargaThreadFactory.DescargaThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[]args){
        ExecutorService ejecutor = Executors.newFixedThreadPool(3, new FabricaDescargadores());
        for(int i = 1; i <= 8; i++) {
            Descarga desc = new Descarga(i);
            ejecutor.execute(desc);
        }

        ejecutor.shutdown();

        try{
            ejecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Todas las descargas finalizadas.");

    }
}
