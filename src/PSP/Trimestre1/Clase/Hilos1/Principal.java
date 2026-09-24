package PSP.Trimestre1.Clase.Hilos1;

public class Principal {
    public static void main(String[] args) {
        HiloUnion uno = new HiloUnion("uno", 1);
        HiloUnion dos = new HiloUnion("dos", 2);
        uno.start();
        dos.start();
        try {
            uno.join();
            dos.join();
            System.out.println("unión de hilos realizada");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}

