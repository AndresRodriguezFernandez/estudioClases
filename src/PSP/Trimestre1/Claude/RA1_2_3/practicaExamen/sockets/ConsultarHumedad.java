package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

import java.util.*;
import java.io.*;
import java.net.*;

public class ConsultarHumedad {
    public static void main(String[]args){
        Socket cliente;

        try{
            cliente = new Socket(InetAddress.getLocalHost(), 5000);
            BufferedReader entrada = new BufferedReader (new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            for(int i = 0; i < 5; i++){
                salida.println("OBTENER");
                String respuesta = entrada.readLine();
                System.out.println("Petición "+(i+1) + " - Humedad recibida: "+respuesta);
            }
            entrada.close();
            salida.close();
            cliente.close();

        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}
