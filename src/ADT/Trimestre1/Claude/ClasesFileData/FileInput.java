package ADT.Trimestre1.Claude.ClasesFileData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("cadena.txt");
        String cadena = "Hola";
        byte[] s = cadena.getBytes();
        fos.write(s);
        fos.write((byte)'\n');
        fos.close();

        FileInputStream fis = new FileInputStream("cadena.txt");
        int c;
        while((c = fis.read()) != -1) {
            //System.out.print(c);
            System.out.print((char)c);
        }

        fis.close();
    }
}
