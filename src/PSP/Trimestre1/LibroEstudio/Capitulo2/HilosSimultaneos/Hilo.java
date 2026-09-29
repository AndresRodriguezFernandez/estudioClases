package PSP.Trimestre1.LibroEstudio.Capitulo2.HilosSimultaneos;

public class Hilo extends Thread{
    int numHilo, miParte, miCuenta = 0;
    private final Contador cont;

    Hilo(int num, int miparte, Contador co) {
        this.numHilo = num;
        this.miParte=miparte;
        this.cont=co;
    }

    public int getMiCuenta(){
        return miCuenta;
    }

    @Override
    public void run(){
        for(int i = 0; i < miParte; i++) {
            this.cont.incrementa();
            miCuenta++;
        }
        System.out.println("Hilo "+numHilo+" terminado. Cuenta: "+ getMiCuenta());
    }
}
