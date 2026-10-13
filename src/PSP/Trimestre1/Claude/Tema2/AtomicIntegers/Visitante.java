package PSP.Trimestre1.Claude.Tema2.AtomicIntegers;

public class Visitante implements Runnable{
    private ContadorVisitas cont;

    public Visitante(ContadorVisitas con){
        this.cont=con;
    }

    @Override
    public void run(){
        cont.registrarVisitas();
        System.out.println("Visita registrada por "+Thread.currentThread().getName());
    }
}
