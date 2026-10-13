package PSP.Trimestre1.Claude.Tema2.AtomicIntegers;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorVisitas {
    private AtomicInteger visitas = new AtomicInteger(0);
    private AtomicBoolean promoActivada = new AtomicBoolean(false);



    public void registrarVisitas(){
        int v = visitas.incrementAndGet();
        if (v == 50){
            if (promoActivada.compareAndSet(false, true)){
                System.out.println("Promoción activada en la visita 50 por "+Thread.currentThread().getName()+"!");
            }
        }
    }

    public int getVisitas(){
        return visitas.get();
    }
}
