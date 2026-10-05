package PSP.Trimestre1.Claude.Tema2.AlmacenPiezas;

import java.util.ArrayList;

public class Cinta {
    ArrayList<Integer> almacen = new ArrayList<Integer>(3);

    public synchronized void colocar(int pieza) throws InterruptedException {
        while (almacen.size() == 3) {
            wait();
        }
        almacen.add(pieza);
        System.out.println("Operario colocó pieza "+pieza+ " en cinta. Num piezas: "+almacen.size());
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while(almacen.isEmpty()){
            wait();
        }
        int piezaRetirar = almacen.removeFirst();;
        System.out.println("Empaquetador retiró pieza "+piezaRetirar + " de la cinta. Num piezas: "+almacen.size());
        notifyAll();
        return piezaRetirar;
    }
}
