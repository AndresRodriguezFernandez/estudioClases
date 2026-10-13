package PSP.Trimestre1.Claude.Tema2.DescargaThreadFactory.DescargaThreadPool;

import java.util.concurrent.ThreadFactory;

public class FabricaDescargadores implements ThreadFactory {
    private int contador = 1;

    public Thread newThread(Runnable r){
        Thread h = new Thread(r);
        h.setName("Descargador-"+this.contador);
        //h.setDaemon(true);
        contador++;
        return h;
    }
}
