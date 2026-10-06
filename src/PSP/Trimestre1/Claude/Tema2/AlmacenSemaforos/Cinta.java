package PSP.Trimestre1.Claude.Tema2.AlmacenSemaforos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Cinta {
    private ArrayList<Integer> almacen = new ArrayList<>();
    private Semaphore piezas = new Semaphore(0);
    private Semaphore colocar = new Semaphore(3);
    private Semaphore mutex = new Semaphore(1);
    public void colocar(int pieza) throws InterruptedException {
        colocar.acquire();
        mutex.acquire();
        almacen.add(pieza);
        System.out.println("Operario colocó pieza "+pieza+ " en cinta. Num piezas: "+ almacen.size());
        piezas.release();
        mutex.release();
    }

    public int retirar() throws InterruptedException {
        piezas.acquire();
        mutex.acquire();
        int piezaRetirar = almacen.removeFirst();
        System.out.println("Empaquetador retiró pieza "+piezaRetirar + " de la cinta. Num piezas: "+almacen.size());
        mutex.release();    //es mejor que primero se suelte el mutex
        colocar.release();  //y después avisar, asi el siguiente hilo no se encuentra el mutex aun cogido
        return piezaRetirar;
    }
}
