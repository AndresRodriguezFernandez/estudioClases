package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets2;

public class PlataformPesaje {

    private double pesoActual;
    private boolean hayPesajePendiente;

    public synchronized void registrarPeso(double peso) throws InterruptedException{
        while(hayPesajePendiente){
            wait();
        }
        this.pesoActual=peso;
        this.hayPesajePendiente=true;
        notifyAll();
    }

    public synchronized double consultarPeso() throws InterruptedException{
        while(!hayPesajePendiente){
            wait();
        }

        this.hayPesajePendiente=false;
        notifyAll();
        return this.pesoActual;
    }
}
