package PSP.Trimestre1;

import java.io.File;

//Esta clase usa la clase Multiplicador que se encunetra en /src.

public class Iniciador {
    public void iniciarMultiplicador(Integer n1, Integer n2, String f) {
        String clase = "C:\\Users\\Andrés\\Documents\\iniciadorProcesos\\src\\Multiplicador.java";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
            pb.directory(new File("C:\\Users\\Andrés\\Documents"));
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(f));
            pb.start();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public static void main(String[] args) {
        Iniciador i = new Iniciador();
        i.iniciarMultiplicador(1, 5, "f1.txt");
        i.iniciarMultiplicador(5, 10, "f2.txt");
        System.out.println("Ok");
    }

}
