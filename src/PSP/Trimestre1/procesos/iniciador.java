package PSP.Trimestre1.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

//Esta clase usa la clase Multiplicador que se encunetra en /src.

public class iniciador {
    public void iniciarMultiplicador(Integer n1, Integer n2) {
        String clase = "src/Multiplicador.java";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
            pb.redirectError(new File("errores.txt"));
            Process p = pb.start();
            InputStreamReader s = new InputStreamReader(p.getInputStream(), "UTF-8");
            BufferedReader b = new BufferedReader(s);
            String salida = b.readLine();
            while ((salida != null) && (salida.length() != 0)) {
                System.out.println(salida);
                salida = b.readLine();
            }
            p.getInputStream().close();
        } catch (Exception e) {
            e.printStackTrace(); }
    }

    public static void main(String[] args) {
        iniciador i = new iniciador();
        i.iniciarMultiplicador(1,2);
    }

}
