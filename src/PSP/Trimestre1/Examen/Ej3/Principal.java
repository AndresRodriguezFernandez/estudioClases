package ejercicio3;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Principal {
    static void main() {
        BlockingQueue<Integer> elementos = new ArrayBlockingQueue<>(5);
        AtomicInteger contador = new AtomicInteger(0);

        ExecutorService ejecutor = Executors.newFixedThreadPool(3);
        ejecutor.execute(new Generador(elementos));
        ejecutor.execute(new Revisor(contador, elementos));
        ejecutor.execute(new Revisor(contador, elementos));

        ejecutor.shutdown();
        try{
            ejecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("Contador final: "+contador);
    }//fin main
}//fin clase
