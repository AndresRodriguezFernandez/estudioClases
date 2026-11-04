package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.ej1Multiproceso;

import java.io.*;

public class LanzadorAuditoria {
    private String ruta = "src/PSP/Trimestre1/Claude/RA1_2_3/practicaExamen/varianteC/ej1Multiproceso/AuditorRecibos.java";

    public Process lanzarProceso(Integer n1, Integer n2, String ficheroError){
        ProcessBuilder pb;
        Process p = null;
        try{
            pb = new ProcessBuilder("java", ruta, n1.toString(), n2.toString());
            pb.redirectError(new File(ficheroError));
            p = pb.start();
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
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
                linea=br.readLine();
            }

            br.close();
            isr.close();
            p.getInputStream().close();
        }catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return resultado;
    }

    public static void main(String[]args){
        LanzadorAuditoria la = new LanzadorAuditoria();

        //definimos los extremos de los rangos

        int rango1_1 = 1000;
        int rango1_2 = 5000;

        int rango2_1 = 5001;
        int rango2_2 = 9000;

        Process p1 = la.lanzarProceso(rango1_1, rango1_2, "errores.txt");
        Process p2 = la.lanzarProceso(rango2_1, rango2_2, "errores2.txt");

        try{
            p1.waitFor();
            p2.waitFor();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        int resultado1 = la.leerResultado(p1);
        int resultado2 = la.leerResultado(p2);

        int total = resultado1+resultado2;
        System.out.println("Resultado de "+rango1_1+ " - "+rango1_2+": "+resultado1);
        System.out.println("Resultado de "+rango2_1+ " - "+rango2_2+": "+resultado2);
        System.out.println("Resultado total de ambos rangos: "+total);
    }
}
