package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets;

import java.io.*;
import java.net.*;

public class Hilo_consulta extends Thread{
    private Socket cliente;
    private RegistroHumedad rh;

    public Hilo_consulta(Socket cliente, RegistroHumedad rh){
        this.cliente=cliente;
        this.rh=rh;
    }

    @Override
    public void run(){
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);

            for(int i = 0; i < 5; i++){
                String linea = entrada.readLine();
                int valorHumedad;

                if (linea != null && linea.trim().equals("OBTENER")){
                    valorHumedad = rh.consultar();
                    salida.println(valorHumedad);
                }
            }
            entrada.close();
            salida.close();
            cliente.close();
        }catch(InterruptedException | IOException e){
            System.out.println("Error: "+e.getMessage());
        }

    }
}
