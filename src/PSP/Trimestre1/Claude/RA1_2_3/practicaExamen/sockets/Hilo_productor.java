package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

import java.net.*;
import java.io.*;

public class Hilo_productor extends Thread{
    private Socket cliente;
    private RegistroHumedad rh;

    public Hilo_productor(Socket cliente, RegistroHumedad rh){
        this.cliente=cliente;
        this.rh=rh;
    }


    @Override
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String linea;
            for (int i = 0; i < 5; i++){
                linea = br.readLine();
                if (linea != null){
                    int hum = Integer.parseInt(linea.trim());
                    rh.almacenar(hum);
                    System.out.println("Hilo productor guardó valor: "+hum);
                }
            }
            br.close();
            cliente.close();
        }catch(InterruptedException | IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
