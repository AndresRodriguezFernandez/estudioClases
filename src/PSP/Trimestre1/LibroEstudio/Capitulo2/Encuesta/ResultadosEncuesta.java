package PSP.Trimestre1.LibroEstudio.Capitulo2.Encuesta;

import java.util.HashMap;
import java.util.Set;

public class ResultadosEncuesta {
    private final HashMap<String, Integer> totalPorRespuesta = new HashMap<>();
    private final HashMap<String, Integer> totalPorZona = new HashMap<>();

    public synchronized void anotaRespuesta(String zona, String respuesta) {
        Integer numRespValor = this.totalPorRespuesta.get(respuesta);
        if(numRespValor == null) {
            this.totalPorRespuesta.put(respuesta, 1);
        }else{
            this.totalPorRespuesta.put(respuesta, numRespValor+1);
        }
        Integer numRespZona = this.totalPorZona.get(zona);
        if(numRespZona == null) {
            this.totalPorZona.put(zona, 1);
        }else{
            this.totalPorZona.put(zona, numRespZona+1);
        }
    }

     public synchronized Set <String> obtenZonas(){
        return this.totalPorZona.keySet();
    }

    public synchronized Set <String> obtenRespuestas(){
        return this.totalPorRespuesta.keySet();
    }

    synchronized public int obtenNumRespuestasZona(String zona){
        return this.totalPorZona.get(zona);
    }

    public synchronized int obtenNumRespuestas(String respuesta) {
        return this.totalPorRespuesta.get(respuesta);
    }
}
