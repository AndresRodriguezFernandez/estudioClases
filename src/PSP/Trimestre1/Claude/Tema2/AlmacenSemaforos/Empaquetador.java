package PSP.Trimestre1.Claude.Tema2.AlmacenSemaforos;

import PSP.Trimestre1.Claude.Tema2.AlmacenPiezas.Cinta;

import java.util.Random;

public class Empaquetador extends Thread{
    Random r;
    PSP.Trimestre1.Claude.Tema2.AlmacenPiezas.Cinta c;
    int id;

    public Empaquetador(Cinta c, int id) {
        this.c = c;
        this.id = id;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i < 6; i++) {
                c.retirar();
                r=new Random();
                int tiempo = r.nextInt(200, 401);
                sleep(tiempo);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
