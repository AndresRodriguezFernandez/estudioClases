package PSP.Trimestre1.LibroEstudio.Capitulo2.HilosSimultaneos;

public class Contador {
    private int cuenta = 0;

    public int getCuenta(){
        return cuenta;
    }

    public int incrementa(){
        this.cuenta++;
        return cuenta;
    }
}
