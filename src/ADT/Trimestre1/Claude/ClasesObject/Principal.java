package ADT.Trimestre1.Claude.ClasesObject;

import java.io.*;

public class Principal {
    public static void main(String [] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("personas.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Persona p1 = new Persona("Pepito", "Suarez", 20);
        Persona p2 = new Persona("Venganito", "Fernandez", 34);

        oos.writeObject(p1);
        oos.writeObject(p2);

        fos.close();
        oos.close();

        FileInputStream fis = new FileInputStream("personas.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        try{
            while(true) {
                Persona p =(Persona) ois.readObject();
                System.out.println(p.toString());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (EOFException e){
            System.out.println("Se ha terminado de leer el fichero.");
        }
    }
}
