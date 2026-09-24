package ADT.Trimestre1.LibroEstudio.Actividad1_1;

import java.io.File;
import java.util.Scanner;

public class Uno {
    public static void main(String[] args) {
        String directorio = "src/";
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un directorio: ");
        String directorioInt = sc.nextLine();
        File f = new File(directorioInt);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                System.out.println(ficheros[i].getName());
            }
        }else if (!f.exists() || f.equals("")){
            File f2 = new File(directorio);
            File[] ficheros2 = f2.listFiles();
            for (int i = 0; i < ficheros2.length; i++) {
                System.out.println(ficheros2[i].getName());
            }
        }
    }
}
