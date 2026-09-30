package PSP.Trimestre1.LibroEstudio.Capitulo2.Encuesta;

import java.util.Set;

public class Encuesta {
    private static final int NUM_ZONAS = 20;
    public static void main(String[]args) {
        ResultadosEncuesta res = new ResultadosEncuesta();

        EncuestadorHiloZona[] encuestadores = new EncuestadorHiloZona[NUM_ZONAS];
        for(int i = 0; i  < encuestadores.length; i++) {
            encuestadores[i] = new EncuestadorHiloZona("zona "+ (i+1), res);
            encuestadores[i].start();
        }

        for(int i = 0; i < encuestadores.length; i++) {
            try{
                encuestadores[i].join();
            }catch (InterruptedException e){
                System.out.println("Se ha detenido la ejecución.");
            }
        }

        System.out.println("Encuestados por zonas: ");
        Set<String> zonas = res.obtenZonas();
        int granTotalPorZonas = 0;
        for(String zona: zonas) {
            int totalParaZona = res.obtenNumRespuestasZona(zona);
            System.out.println("Zona: "+zona +" Total para zona: "+totalParaZona);
            granTotalPorZonas += totalParaZona;
        }
        System.out.println("GRAN Total: "+granTotalPorZonas);
        System.out.println();
        System.out.println("Resultados por respuesta: ");
        Set<String> respuestas = res.obtenRespuestas();
        int granTotalRespuestas = 0;
        for(String respuesta: respuestas) {
            int totalParaRespuestas = res.obtenNumRespuestas(respuesta);
            if(respuesta != null) {
                System.out.println(respuesta + " : "+totalParaRespuestas);
            }else{
                System.out.println("NS/NC: "+totalParaRespuestas);
            }
            granTotalRespuestas += totalParaRespuestas;
        }
        System.out.println("GRAN TOTAL RESPUESTAS: "+granTotalRespuestas);
    }
}
