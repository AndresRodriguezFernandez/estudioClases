package PSP.Trimestre1.Clase.Ej16PSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public void comprobarPalindromo(String frase) {
        String fraseInvertida =new  StringBuilder(frase).reverse().toString();
        if (fraseInvertida.equals(frase)) {
            System.out.println("La frase es palindroma, es igual");
        }else {
            System.out.println("La frase no es palindroma, NO es igual.");
        }
    }

    public static void main(String[] args) throws IOException {
        Hijo h = new Hijo();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea = "";
        while ((linea = br.readLine())!= null) {
            if (linea.equals("fin")) {
                break;
            }
            h.comprobarPalindromo(linea);
        }
    }
}
