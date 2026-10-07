package PSP.Trimestre1.Claude.Tema2.DescargaThreadPool;

import java.util.Random;

public class Descarga implements Runnable{
    private int numeroArchivo;
    private Random r;
    public Descarga(int numArchivo) {
        this.numeroArchivo=numArchivo;
        this.r=new Random();
    }

    @Override
    public void run(){
        System.out.println("Descarga "+this.numeroArchivo+ " iniciada por "+Thread.currentThread().getName());
        int tiempo = r.nextInt(500, 1501);
        try{
            Thread.sleep(tiempo);
        }catch(InterruptedException e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("Descarga "+this.numeroArchivo+" finalizada.");
    }
}
