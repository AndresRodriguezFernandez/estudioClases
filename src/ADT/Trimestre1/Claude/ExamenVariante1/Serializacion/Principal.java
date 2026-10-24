package ADT.Trimestre1.Claude.ExamenVariante1.Serializacion;
import java.io.*;
import java.util.*;

public class Principal {
    public static void main(String[]args){
        String fichero = "src/ADT/Trimestre1/Claude/ExamenVariante1/Serializacion/vehiculos.dat";
        FileOutputStream escritor = null;
        FileInputStream lector = null;
        ObjectInputStream lectorO = null;
        ObjectOutputStream escritorO;
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
        for(int i = 0; i < 3; i++){
            lista.add(crearObjecto(sc));
        }
        try{
            escritor = new FileOutputStream(fichero);
            escritorO = new ObjectOutputStream(escritor);
            for(Vehiculo i:lista){//Se escriben los datos del array como objetos individuales recorriendolos
                escritorO.writeObject(i);
            }
            escritorO.close();
            escritor.close();
        }catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }

        //Lectura del fichero
        System.out.println("Leer objeto: ");
        try{
            lector = new FileInputStream(fichero);
            lectorO = new ObjectInputStream(lector);
            Vehiculo v;
            v = (Vehiculo) lectorO.readObject();
            while(true){
                System.out.println(v.toString());
                v=(Vehiculo) lectorO.readObject();
            }
        }catch(EOFException e){
        }catch(ClassNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            lectorO.close();
            lector.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Metodo para introducir los datos por teclado
    public static Vehiculo crearObjecto(Scanner sc){
        System.out.println("Introduce la matricula: ");
        String mat = sc.nextLine().trim().toUpperCase();
        System.out.println("Introduce la marca: ");
        String marca = sc.nextLine().trim();
        System.out.println("Introduce el kilometraje: ");
        int km = sc.nextInt();
        sc.nextLine();
        return new Vehiculo(mat, marca, km);
    }
}
