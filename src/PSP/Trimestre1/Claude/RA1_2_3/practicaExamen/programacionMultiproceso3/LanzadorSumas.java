package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso3;

import java.io.*;

public class LanzadorSumas {

    private String ruta = "src/PSP/Trimestre1/Claude/RA1_2_3/practicaExamen/programacionMultiproceso3/SumadorRango.java";

    public Process lanzarProceso(Integer n1, Integer n2, String ficheroError){
        ProcessBuilder pb;
        Process p = null;
        try{
            pb = new ProcessBuilder("java", ruta, n1.toString(), n2.toString());
            pb.redirectError(new File(ficheroError));
            p = pb.start();
        }catch(IOException e){
            System.err.println("Error de E/S al lanzar el proceso: "+e.getMessage());
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
                linea = br.readLine();
            }

            br.close();
            isr.close();
            p.getInputStream().close();
        }catch(IOException e){
            System.err.println("Error de E/S al leer el resultado "+e.getMessage());
        }catch(NumberFormatException e){
            System.err.println("El proceso hijo no devolvió un número válido "+e.getMessage());
        }
        return resultado;
    }

    public static void main(String[] args){
        LanzadorSumas ls = new LanzadorSumas();

        //definimos los extremos de los rangos por separado para que se puedan modificar desde las variables
        int rango1_1 = 1;
        int rango1_2 = 200;

        int rango2_1 = 201;
        int rango2_2 = 1000;

        Process p1 = ls.lanzarProceso(rango1_1, rango1_2, "errores1.txt");
        Process p2 = ls.lanzarProceso(rango2_1, rango2_2, "errores2.txt");

        //comprobacion de haber lanzado los procesos, opcional
        if(p1 == null || p2 == null){
            System.err.println("No se pudieron lanzar uno o ambos procesos.");
            return;
        }

        try{
            //se espera a que terminen ambos procesos
            p1.waitFor();
            p2.waitFor();

            int resultadoParcial1 = ls.leerResultado(p1);
            int resultadoParcial2 = ls.leerResultado(p2);

            int totalSuma = resultadoParcial1+resultadoParcial2;
            System.out.println(totalSuma);
        }catch(InterruptedException e){
            System.err.println("Error "+e.getMessage());
        }

    }
}
