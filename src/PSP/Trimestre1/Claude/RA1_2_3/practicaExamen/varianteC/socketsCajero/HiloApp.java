package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.socketsCajero;

import java.io.*;
import java.net.*;
import java.util.*;

public class HiloApp extends Thread{
    private Socket cliente;
    private GestorSaldo gs;

    public HiloApp(Socket cliente, GestorSaldo gs){
        this.cliente=cliente;
        this.gs=gs;
    }

    @Override
    public void run(){
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);

            for (int i = 0; i < 5; i++){
                String linea = entrada.readLine();
                int ingreso;

                if (linea != null && linea.trim().equals("CONSULTAR")){
                    ingreso = gs.consultarMovimientos();
                    salida.println(ingreso);
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
