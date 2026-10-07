package PSP.Trimestre1.Claude.Tema2.ContadorLocks;

public class Incrementador extends Thread{
    private Contador cont;

    public Incrementador(Contador cont) {
        this.cont = cont;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10000; i++) {
            cont.incrementar();
        }
    }
}
