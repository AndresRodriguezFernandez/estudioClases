package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_5;

import java.util.Random;

public class Hilo extends Thread{
    private int id;
    private NumeroOculto numOc;
    private int partida = 1;

    public Hilo(int identificador, NumeroOculto numoc) {
        this.id=identificador;
        this.numOc = numoc;
    }

    @Override
    public void run(){
        Random r = new Random();
        int resultado;
        do{
            int num = r.nextInt(101);
            resultado = numOc.propuestaNumero(num, partida);
            System.out.println("Hilo "+this.id+" : "+num);
            if(resultado == -1) {
                partida++;
            }else if (resultado >= 1) {
                partida = resultado;
            }else if(resultado == -2) {
                partida++;
                System.out.println("El hilo "+this.id+" ha acertado!");
            }
        }while(partida <= NumeroOculto.numeroPartidas);
        System.out.println("Ejecucion de hilo "+this.id + " finalizada");
    }
}
