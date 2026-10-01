package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_4;

public class NumeroOculto {
    private final int numeroOculto;
    private boolean adivinado = false;

    NumeroOculto(int num) {
        this.numeroOculto=num;
    }

    public synchronized int propuestaNumero(int num) {
        if(num == this.numeroOculto && !adivinado) {
            adivinado = true;
            return 1;
        }else if  (adivinado) {
            return -1;
        }else{
            return 0;
        }
    }
}
