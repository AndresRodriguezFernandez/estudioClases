package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.ej3Concurrent;

import java.util.*;
import java.util.concurrent.*;
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
            try{
                int id = cola.take();
                if (id == -1){
                    break;
                }else{
                    System.out.println("Transferencia completada: "+id);
                    contador.incrementAndGet();
                }
            }catch(InterruptedException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
