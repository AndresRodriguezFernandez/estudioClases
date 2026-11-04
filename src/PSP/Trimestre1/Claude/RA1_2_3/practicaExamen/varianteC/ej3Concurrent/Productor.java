package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.ej3Concurrent;

import java.util.*;
import java.util.concurrent.*;

public class Productor implements Runnable{
    private BlockingQueue<Integer> cola;

    public Productor(BlockingQueue<Integer> cola){
        this.cola=cola;
    }

    @Override
    public void run(){
        for(int i = 1; i<=20; i++){
            try{
                cola.put(i);
            }catch(InterruptedException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        try{
            cola.put(-1);
            cola.put(-1);
        }catch(InterruptedException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
