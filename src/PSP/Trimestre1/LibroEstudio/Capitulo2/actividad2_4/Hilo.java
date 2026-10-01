package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_4;

import java.util.Random;

public class Hilo extends Thread{
    private int nombre;
    private NumeroOculto numOc;

    Hilo(int nombre, NumeroOculto numoc) {
        this.nombre=nombre;
        this.numOc = numoc;
    }

    @Override
    public void run(){
        Random r = new Random();

        int resultado;
        do{
            int num = r.nextInt(101);
            resultado = numOc.propuestaNumero(num);
            System.out.println("Hilo "+this.nombre+" : "+num);
        }while(resultado == 0);
        System.out.println("Ejecucion de hilo "+this.nombre + " finalizada");
    }
}
