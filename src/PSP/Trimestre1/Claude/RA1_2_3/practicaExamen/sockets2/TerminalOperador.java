package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets2;

import java.util.*;
import java.net.*;
import java.io.*;

public class TerminalOperador {
    public static void main(String[]args){
        Socket cliente;

        try{
            cliente=new Socket(InetAddress.getLocalHost(), 7500);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            for(int i = 0; i < 5; i++){
                salida.println("GET_PESO");
                String respuesta = entrada.readLine();
                System.out.println("Petición "+i+ " : "+respuesta);
            }

            entrada.close();
            salida.close();
            cliente.close();
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
