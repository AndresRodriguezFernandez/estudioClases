package PSP.Trimestre1.LibroEstudio.Capitulo2.HilosSimultaneos;

public class Contador {
    private int cuenta = 0;

    public synchronized int getCuenta(){
        return cuenta;
    }

    public synchronized int incrementa(){
        this.cuenta++;
        return cuenta;
    }
}
