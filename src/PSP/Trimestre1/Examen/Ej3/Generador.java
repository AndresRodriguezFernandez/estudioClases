package ejercicio3;
import java.util.*;
import java.util.concurrent.*;

public class Generador implements Runnable{
    private BlockingQueue<Integer> elementos;

    public Generador(BlockingQueue<Integer> elementos) {
        this.elementos = elementos;
    }

    @Override
    public void run(){
        Random r = new Random();
        for (int i = 1; i <= 20; i++){
            int ident;
            try{
                ident = r.nextInt(100)+1;
                elementos.put(ident);
            }catch(InterruptedException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        try{
            elementos.put(-1);
            elementos.put(-1);
        }catch(InterruptedException e){
            System.out.println("Error: "+e.getMessage());
        }
    }//fin del run
}//fin de la clase
