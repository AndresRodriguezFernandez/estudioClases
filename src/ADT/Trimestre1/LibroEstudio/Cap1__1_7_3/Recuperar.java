package ADT.Trimestre1.LibroEstudio.Cap1__1_7_3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Recuperar {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("src/ADT/Trimestre1/LibroEstudio/Cap1__1_7_3/salida2.txt"));

        try {
            String s;
            int a;
            while (true) {
                s = dis.readUTF();
                a = dis.readInt();
                System.out.println("Nombre: "+s +" Edad: "+a);
            }

        } catch (IOException e) {
        }
        dis.close();
    }
}
