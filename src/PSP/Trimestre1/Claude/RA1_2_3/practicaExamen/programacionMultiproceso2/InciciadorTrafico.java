package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso2;

import java.io.IOException;

public class InciciadorTrafico {
    public static void main(String[] args) {
        String ruta = "src/PSP/Trimestre1/Claude/RA1_2_3/practicaExamen/programacionMultiproceso2/FiltroPares.java";

        Integer[] rangos = {1000, 2000, 5000, 5400};
        Process[] procesos = new Process[2];

        for (int i = 0; i < 2; i++){
            ProcessBuilder pb;
            pb = new ProcessBuilder("java", ruta, rangos[i*2].toString(), rangos[(i*2)+1].toString());
            pb.redirectErrorStream(true);
            try{
                procesos[i] = pb.start();
            }catch(IOException e){
                e.printStackTrace();
            }
        }


    }
}
