package ejercicio3;

import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Revisor implements Runnable{
    private AtomicInteger contador;
    private BlockingQueue<Integer> elementos;

    public Revisor(AtomicInteger contador, BlockingQueue<Integer> elementos) {
        this.contador = contador;
        this.elementos = elementos;
    }

    @Override
    public void run(){
        while (true){
            try{
                int id = elementos.take();
                if (id == -1){
                    break;
                }else{
                    System.out.println("Revisado: "+id);
                    contador.incrementAndGet();
                }
            }catch (InterruptedException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }//fin run
}//fin main
