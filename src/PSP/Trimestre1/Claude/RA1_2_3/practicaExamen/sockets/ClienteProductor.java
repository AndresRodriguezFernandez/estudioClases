package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClienteProductor {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int puerto = 6000;

        try{
            Socket socket = new Socket(host, puerto);

            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Random rm = new Random();
            for (int i = 0; i  <5; i++){
                int temp = rm.nextInt(51)-10;
                salida.println(temp);
                System.out.println("Enviado: "+temp);
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
