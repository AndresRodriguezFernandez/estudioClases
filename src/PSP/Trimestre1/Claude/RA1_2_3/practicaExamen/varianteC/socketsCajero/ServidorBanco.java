package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.socketsCajero;

import java.net.*;
import java.io.*;

public class ServidorBanco {
    public static void main(String[] args){
        GestorSaldo gs = new GestorSaldo();

        try{
            ServerSocket servidor = new ServerSocket(8000);
            System.out.println("Servidor iniciado en el puerto 8000");

            //aceptamos las conexiones
            Socket s1 = servidor.accept();
            Socket s2 = servidor.accept();

            //se delegan las tareas a los hilos
            HiloIngresos h1 = new HiloIngresos(s1, gs);
            HiloApp h2 = new HiloApp(s2, gs);

            h1.setPriority(Thread.MAX_PRIORITY);
            h2.setPriority(Thread.MIN_PRIORITY);

            h1.start();
            h2.start();

            System.out.println("Estado del hilo ingresos: "+h1.isAlive());
            System.out.println("Estado del hilo de la app: "+h2.isAlive());

            //esperamos a que terminen ambos procesos/hilos
            h1.join();
            h2.join();

            //cerramos los recursos
            servidor.close();
            System.out.println("Servidor finalizado.");

        }catch(InterruptedException | IOException e){
            e.printStackTrace();
        }
    }
}
