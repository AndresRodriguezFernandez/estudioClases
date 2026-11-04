package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.socketsCajero;

public class GestorSaldo {
    private int saldoMovimiento;
    private boolean operacionPendiente;

    public synchronized void ingresar(int ingreso)throws InterruptedException{
        while(operacionPendiente){
            wait();
        }
        this.saldoMovimiento=ingreso;
        this.operacionPendiente=true;
        notifyAll();
    }

    public synchronized int consultarMovimientos()throws InterruptedException{
        while(!operacionPendiente){
            wait();
        }
        this.operacionPendiente=false;
        notifyAll();
        return this.saldoMovimiento;
    }
}
