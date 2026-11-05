package ejercicio1;
import java.io.*;

public class Lancador {//no funciona la letra ceta en mi teclado por lo que pongo el nombre de la clase con c
    private String ruta = "src/ejercicio1/ContadorPares.java";
    public Process lancarProceso(Integer n1, Integer n2, String fichError){
        ProcessBuilder pb;
        Process p = null;

        try{
            pb = new ProcessBuilder("java", ruta, n1.toString(), n2.toString());
            pb.redirectError(new File(fichError));
            p = pb.start();
        } catch (IOException e) {
            System.err.println("Error de E/S: "+e.getMessage());
        }
        return p;
    }

    public int leerResultado(Process p){
        int resultado = 0;
        try{
            InputStreamReader isr = new InputStreamReader(p.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            while (linea != null && !linea.isEmpty()){
                resultado=Integer.parseInt(linea.trim());
                linea=br.readLine();
            }
            br.close();
            isr.close();
            p.getInputStream().close();
        }catch (IOException e){
            System.err.println("Error de E/S: "+e.getMessage());
        }catch (NumberFormatException e){
            System.err.println("El proceso no devolvió un número válido: "+e.getMessage());
        }
        return  resultado;
    }

    public static void main(String[]args) {
        Lancador la = new Lancador();

        //definimos los extremos de los rangos
        int rango1_1=2;
        int rango1_2=12;

        int rango2_1=13;
        int rango2_2=23;

        Process p1 = la.lancarProceso(rango1_1, rango1_2, "errores1.txt");
        Process p2 = la.lancarProceso(rango2_1, rango2_2, "errores2.txt");

        //comprobamos haber lancado los procesos
        if (p1==null || p2==null){
            System.err.println("No se pudo lancar alguno/ambos de los procesos");
        }
        try{
            //esperamos a que los procesos terminen
            p1.waitFor();
            p2.waitFor();

            int resultadoParcial1 = la.leerResultado(p1);
            int resultadoParcial2 = la.leerResultado(p2);

            int total = resultadoParcial1+resultadoParcial2;
            System.out.println(total);
        }catch (InterruptedException e){
            System.out.println("Error: "+e.getMessage());
        }
    }//fin main
}//fin clase
