package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets2;

import java.io.*;
import java.net.*;
import java.util.*;

public class SensorBascula {
    public static void main(String[]args){
        Socket cliente;

        try{
            Random r = new Random();
            cliente = new Socket(InetAddress.getLocalHost(), 7500);
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            for(int i = 0; i < 5; i++){
                double peso = r.nextDouble(40-2)+2;
                salida.println(peso);
            }
            salida.close();
            cliente.close();
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}
