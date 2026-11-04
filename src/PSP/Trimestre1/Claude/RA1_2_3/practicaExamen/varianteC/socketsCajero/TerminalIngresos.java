package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.socketsCajero;

import java.io.*;
import java.net.*;
import java.util.*;

public class TerminalIngresos {
    public static void main(String[]args){
        Socket cliente;
        try{
            Random r = new Random();
            cliente = new Socket(InetAddress.getLocalHost(), 8000);
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            for (int i = 0; i < 5; i++){
                //((max - min) + 1) para rangos
                int cantidad = r.nextInt(501-10)+10;
                salida.println(cantidad);
            }
            salida.close();
            cliente.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
