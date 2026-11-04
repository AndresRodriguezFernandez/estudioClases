package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.sockets2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HiloBascula extends Thread{
    private Socket cliente;
    private PlataformPesaje pp;

    public HiloBascula(Socket cliente, PlataformPesaje pp){
        this.cliente=cliente;
        this.pp = pp;
    }

    @Override
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String linea;
            for(int i = 0; i < 5; i++){
                linea = br.readLine();
                if(linea != null){
                    double peso = Double.parseDouble(linea.trim());
                    pp.registrarPeso(peso);
                    System.out.println("Hilo básculo registró: "+peso);

                }
            }
            br.close();
            cliente.close();
        }catch(InterruptedException | IOException e){
            System.out.println("error: "+e.getMessage());
        }
    }
}
