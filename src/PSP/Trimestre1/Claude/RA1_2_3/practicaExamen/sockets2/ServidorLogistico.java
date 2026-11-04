package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets2;

import java.net.*;
import java.io.*;

public class ServidorLogistico {
    public static void main(String[]args){
        PlataformPesaje pp = new PlataformPesaje();

        try{
            ServerSocket servidor = new ServerSocket(7500);
            System.out.println("Servidor iniciado en el puerto 7500");

            //aceptamos las conexiones
            Socket s1 = servidor.accept();
            Socket s2 = servidor.accept();

            //se delegan las tareas a hilos
            HiloBascula hb = new HiloBascula(s1, pp);
            HiloOperador ho = new HiloOperador(s2, pp);

            hb.setPriority(Thread.MAX_PRIORITY);
            ho.setPriority(Thread.MIN_PRIORITY);

            hb.start();
            ho.start();

            System.out.println("Estado del hilo registrador de peso: "+hb.isAlive());
            System.out.println("Estado del hilo consultor de peso: "+ho.isAlive());

            //esperamos a que terminen ambos procesos
            hb.join();
            ho.join();


            //cerramos los recursos
            servidor.close();
            System.out.println("servidor finalizado");
        }catch(InterruptedException | IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
