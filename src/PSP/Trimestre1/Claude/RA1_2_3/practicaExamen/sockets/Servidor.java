package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[]args){
        //Se instancia el monitor compartido
        RegistroHumedad registros = new RegistroHumedad();

        try{
            //se crea el socket Servidor escuchando en el puerto 5000
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado en el puerto 5000");

            //aceptamos las dos conexiones
            Socket s1 = servidor.accept();
            Socket s2 = servidor.accept();

            //se crean los hilos inyectandoles su respectivo socket
            //hay que ejecutar si o si primero el productor para que se le asgine el hilo y la  conexion bien
            Hilo_productor hProductor = new Hilo_productor(s1, registros);
            Hilo_consulta hConsulta = new Hilo_consulta(s2, registros);

            hProductor.setPriority(Thread.MAX_PRIORITY);
            hConsulta.setPriority(Thread.MIN_PRIORITY);
            //se inicia la ejecucion de los hilos
            hProductor.start();
            hConsulta.start();
            System.out.println(hProductor.isAlive() + " es el estado del Hilo Productor");
            System.out.println(hConsulta.isAlive() + " es el estado del Hilo Consultor");
            //el hilo principal(Servidor) espera a que los otros hilos acaben
            hProductor.join();
            hConsulta.join();

            //cierre de recursos
            servidor.close();
            System.out.println("Servidor finalizado");

        }catch(IOException  | InterruptedException e){
            System.out.println("Error: "+e.getMessage());
        }

    }
}
