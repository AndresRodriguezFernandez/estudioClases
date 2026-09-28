package ADT.Trimestre1.LibroEstudio.Cap1__1_7_3;

import java.io.*;

public class Principal2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/ADT/Trimestre1/LibroEstudio/Cap1__1_7_3/salida2.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        String[] nombres = {"Pepito", "Pablito", "Venganito", "Fulanito"};
        int[] edades = {2,65,23,12};

        for (int i =0 ; i < edades.length; i++) {
            dos.writeUTF(nombres[i]);
            dos.writeInt(edades[i]);
        }
        dos.close();
    }
}
