package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

public class RegistroHumedad {
    private int temperatura;
    private boolean disponible = false;

    public synchronized void almacenar(int temp) throws InterruptedException{
        while (disponible){
            wait();
        }
        this.temperatura=temp;
        this.disponible=true;
        notifyAll();
    }

    public synchronized int consultar() throws InterruptedException{
        while (!disponible){
            wait();
        }
        this.disponible=false;
        notifyAll();
        return this.temperatura;
    }
}
