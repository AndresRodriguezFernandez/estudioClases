package PSP.Trimestre1.Claude.Tema2.AlmacenPiezas;

import java.util.Random;

public class Operario extends Thread{
    Random r;
    Cinta c;
    int id;

    public Operario(Cinta c, int id) {
        this.c = c;
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0; i < 6; i++) {
            try {
                r = new Random();
                c.colocar(id*100+i);
                int tiempo = r.nextInt(100, 301);
                sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
