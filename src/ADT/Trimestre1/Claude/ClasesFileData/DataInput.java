package ADT.Trimestre1.Claude.ClasesFileData;

import java.io.*;

public class DataInput {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("cadena2data.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("hola que tal, salu2");
        dos.writeInt(1407);

        FileInputStream fis = new FileInputStream("cadena2data.txt");
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());

        dos.writeUTF("Hola");
        dos.writeUTF("Que");
        dos.writeUTF("Tal");
        try{
            while(true) {
                System.out.println(dis.readUTF());
            }
        }catch(EOFException e) {
            dos.close();
            dis.close();
        }
        /*También se puede usar una try-wieth-resources para cerra solos los dis y el dos y poner en el catch un mensaje
        * de final de fichero en lugar de cerrarlos explicitamente ahí.*/
    }
}
