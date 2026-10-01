package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_5;

import java.util.Random;

public class Hilo extends Thread{
    private int id;
    private NumeroOculto numOc;

    public Hilo(int identificador, NumeroOculto numoc) {
        this.id=identificador;
        this.numOc = numoc;
    }

    @Override
    public void run(){
        Random r = new Random();

        int resultado;
        int partida = 1;

        do{
            int num = r.nextInt(101);
            resultado = numOc.propuestaNumero(num, partida);
            System.out.println("Hilo "+this.id+" : "+num);
            if(resultado != 0 && resultado != -1 && numOc.getadivinado()) {
                partida++;
            }
        }while(resultado == 0);
        System.out.println("Ejecucion de hilo "+this.id + " finalizada");
    }
}
