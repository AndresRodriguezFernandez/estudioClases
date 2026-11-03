package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

import java.util.*;
import java.io.*;
import java.net.*;

public class ProductorHumedad {
    public static void main(String[] args){
        Socket cliente;

        try{
            Random r = new Random();
            cliente = new Socket(InetAddress.getLocalHost(), 5000);
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            for (int i = 0; i < 5; i++){
                //genera un numero entre 30 y 90
                //nextInt(61)+30 serviria
                int numero = r.nextInt(91-30)+30;
                salida.println(numero);
            }
            salida.close();
            cliente.close();
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
