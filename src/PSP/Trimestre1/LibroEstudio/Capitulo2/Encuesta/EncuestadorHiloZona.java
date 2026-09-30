package PSP.Trimestre1.LibroEstudio.Capitulo2.Encuesta;

import java.util.Random;

public class EncuestadorHiloZona extends Thread{
    private final String zona;
    private final ResultadosEncuesta resEnc;

    EncuestadorHiloZona(String zona, ResultadosEncuesta enc) {
        this.zona = zona;
        this.resEnc = enc;
    }

    @Override
    public void run(){
        System.out.println("Comienza el encuestador para la zona "+zona);
        Random r = new Random();
        int numRespuestas = 100 + r.nextInt(200-100)+1;
        for(int i = 0; i < numRespuestas; i++) {
            int numRespuesta = r.nextInt(10);
            String respuesta = null;
            if(numRespuesta > 0) {
                respuesta = "respuesta_"+numRespuesta;
            }

            this.resEnc.anotaRespuesta(this.zona, respuesta);
        }
        System.out.println("Encuestador terminado de la zona "+zona);
    }
}
