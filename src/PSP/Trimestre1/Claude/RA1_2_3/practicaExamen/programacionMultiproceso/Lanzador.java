package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso;

import java.io.*;
import java.util.*;

public class Lanzador {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ruta = "src/PSP/Trimestre1/Claude/RA1_2_3/practicaExamen/programacionMultiproceso/ContadorDivisores.java";
        Integer[] intervalos = new Integer[4];
        System.out.println("===PRIMER RANGO====");
        System.out.print("Introduce el primer número del rango: ");
        intervalos[0] = sc.nextInt();
        System.out.print("Introduce el ultimo numero del rango: ");
        intervalos[1] = sc.nextInt();
        System.out.println("===SEGUNDO RANGO====");
        System.out.print("Introduce el primer número del rango: ");
        intervalos[2] = sc.nextInt();
        System.out.print("Introduce el ultimo numero del rango: ");
        intervalos[3] = sc.nextInt();
        Process[] procesos = new Process[2];

        for(int i = 0; i < 2; i++){
               ProcessBuilder pb;
               pb = new ProcessBuilder("java", ruta, intervalos[i*2].toString(), intervalos[(i*2)+1].toString());
               pb.redirectErrorStream(true);
            try {
                procesos[i] = pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int totalDivisores = 0;
        for (int j = 0; j < 2; j++){
            Process p = procesos[j];

            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
                String salida = br.readLine();
                int recuento = Integer.parseInt(salida.trim());
                System.out.println("Contador en rango "+j+ " : "+recuento);
                totalDivisores+=recuento;
                br.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                int codigo = p.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Total divisores: "+totalDivisores);
    }
}
