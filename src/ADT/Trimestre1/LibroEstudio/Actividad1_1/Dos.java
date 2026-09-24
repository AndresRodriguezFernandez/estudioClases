package ADT.Trimestre1.LibroEstudio.Actividad1_1;

import java.io.File;

public class Dos {
    public static void main(String[] args) {
        String directorio = args[0];
        File directo = new File(directorio);
        if (directo.exists()) {
            File[] ficheros = directo.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                System.out.println(ficheros[i].getName());
            }
        } else if (!directo.exists()) {
            System.out.println("El directorio no existe.");
        }
    }
}
