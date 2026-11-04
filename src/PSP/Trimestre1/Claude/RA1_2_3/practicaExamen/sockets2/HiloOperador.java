package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets2;

import java.io.*;
import java.net.Socket;

public class HiloOperador extends Thread{
    private Socket cliente;
    private PlataformPesaje pp;

    public HiloOperador(Socket cliente, PlataformPesaje pp){
        this.cliente=cliente;
        this.pp=pp;
    }

    @Override
    public void run(){
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);

            for(int i = 0; i < 5; i++){
                String linea = entrada.readLine();
                double peso;

                if (linea != null && linea.trim().equals("GET_PESO")){
                    peso = pp.consultarPeso();
                    salida.println(peso);
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
