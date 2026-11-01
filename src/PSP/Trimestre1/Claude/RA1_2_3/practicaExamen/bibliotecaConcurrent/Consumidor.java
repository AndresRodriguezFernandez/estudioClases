package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.bibliotecaConcurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumidor implements Runnable{
    private AtomicInteger contador;
    private BlockingQueue<Integer> cola;

    public Consumidor(AtomicInteger cont, BlockingQueue<Integer> cola){
        this.contador=cont;
        this.cola=cola;
    }

    @Override
    public void run(){
        while(true){
            try {
                int id = cola.take();
                if (id == -1){
                    break;
                }else {
                    System.out.println("Incidencia procesada: "+id);
                    contador.incrementAndGet();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
