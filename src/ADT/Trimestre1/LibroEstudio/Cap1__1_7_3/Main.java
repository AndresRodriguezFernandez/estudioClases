package ADT.Trimestre1.LibroEstudio.Cap1__1_7_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/ADT/Trimestre1/LibroEstudio/Cap1__1_7_3/fichero.txt");
        FileOutputStream fos = new FileOutputStream("src/ADT/Trimestre1/LibroEstudio/Cap1__1_7_3/salida.txt");
        int c;
        while ((c =fis.read()) != -1) {
            fos.write(c);
        }
        fis.close();
        fos.close();
    }
}
