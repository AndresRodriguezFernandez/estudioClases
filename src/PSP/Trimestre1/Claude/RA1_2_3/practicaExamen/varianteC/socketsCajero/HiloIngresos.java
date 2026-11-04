package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.socketsCajero;

import java.net.*;
import java.io.*;
import java.util.*;

public class HiloIngresos extends Thread{
    private Socket cliente;
    private GestorSaldo gs;

    public HiloIngresos(Socket cliente, GestorSaldo gs){
        this.cliente=cliente;
        this.gs=gs;
    }

    @Override
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String linea;
            for (int i = 0; i< 5; i++){
                linea = br.readLine();
                if (linea != null){
                    int ingreso = Integer.parseInt(linea.trim());
                    gs.ingresar(ingreso);
                    System.out.println("Hilo ingresos ha ingresado "+ingreso + "€");
                }
            }
            br.close();
            cliente.close();
        }catch(InterruptedException | IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
