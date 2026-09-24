package PSP.Trimestre1.Ej16PSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Padre {
    public void crearProceso(String frase) {
        String clase = "src/Ej16PSP/Hijo.java";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java", clase, frase);
            Process p = pb.start();
            InputStreamReader ior = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(ior);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Padre p = new Padre();
        Scanner sc = new Scanner(System.in);
        String frase;
        Boolean seguir = true;
        do {
            System.out.println("Introduce una palabra/frase: ");
            frase = sc.nextLine().trim().toLowerCase();
            if (frase.equals("fin")) {
                break;
            }else {
                p.crearProceso(frase);
            }
        }while (!frase.equals("fin"));
    }

}
