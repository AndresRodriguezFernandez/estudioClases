package ADT.Trimestre1.LibroEstudio.Actividad1_3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nombre;
        do {
            System.out.print("Introduce un nombre: ");
            nombre = sc.nextLine();
            if (!nombre.equals("*")) {
                String c;
                int edad;
                boolean seguir = true;
                try {
                    DataInputStream dis = new DataInputStream(new FileInputStream("src/ADT/Trimestre1/LibroEstudio/Actividad1_3/salida2.txt"));
                    while (seguir){
                        c = dis.readUTF().toUpperCase();
                        edad = dis.readInt();
                        if (c.equals(nombre.toUpperCase())) {
                            System.out.println("Edad: "+edad);
                            seguir = false;
                        }
                    }
                }catch (IOException e ) {
                    System.out.println("No hay ninguan entrada con ese nombre en nuestra base de datos :(");
                }
            }
        }while (!nombre.equals("*"));
    }
}
