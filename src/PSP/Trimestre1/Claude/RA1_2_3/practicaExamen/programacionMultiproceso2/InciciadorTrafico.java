package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso2;

import java.io.*;
import java.io.IOException;

public class InciciadorTrafico {
    private String ruta = "src/PSP/Trimestre1/Claude/RA1_2_3/practicaExamen/programacionMultiproceso2/FiltroPares.java";

    public Process lanazarProceso(Integer n1, Integer n2){
        ProcessBuilder pb;
        Process p = null;
        try{
            pb = new ProcessBuilder("java",ruta, n1.toString(), n2.toString());
            pb.redirectError(new File("errores.txt"));
            p = pb.start();
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public int leerResultado(Process p){
        int resultado = 0;
        try{
            InputStreamReader isr = new InputStreamReader(p.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String linea = br.readLine();
            while(linea != null && !linea.isEmpty()){
                resultado = Integer.parseInt(linea.trim());
                linea = br.readLine();;
            }

            br.close();
            isr.close();
            p.getInputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String[] args) {
        InciciadorTrafico iniciador = new InciciadorTrafico();

        Process p1 = iniciador.lanazarProceso(1000, 2000);
        Process p2 = iniciador.lanazarProceso(5000, 5400);

        try{
            p1.waitFor();
            p2.waitFor();

            int resultado1 = iniciador.leerResultado(p1);
            int resultado2 = iniciador.leerResultado(p2);

            int totalPares = resultado1+resultado2;

            System.out.println("Matriculas pares en el primer rango: "+resultado1);
            System.out.println("Matriculas pares en el segunda rango: "+resultado2);
            System.out.println("Matriculas pares totales: "+totalPares);

        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
