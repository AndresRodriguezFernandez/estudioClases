package PSP.Trimestre1.Ej1_2;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        String clase = "src/Ej1_2/Programita.java";
        ProcessBuilder pb = new ProcessBuilder("java", clase, "2", "3");
        try{
            Process p = pb.start();
            System.out.println(p.isAlive());
            p.wait(3000);
            System.out.println(p.isAlive());
            p.wait(3000);
            System.out.println(p.isAlive());
        }catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
