package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.socketsCajero;

import java.util.*;
import java.net.*;
import java.io.*;

public class AppCliente {
    public static void main(String[]args){
        Socket cliente;

        try{
            cliente = new Socket(InetAddress.getLocalHost(), 8000);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            for (int i = 0; i< 5; i++){
                salida.println("CONSULTAR");
                String respuesta = entrada.readLine();
                System.out.println("Petición "+i+" :"+respuesta);
            }
            entrada.close();
            salida.close();
            cliente.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
