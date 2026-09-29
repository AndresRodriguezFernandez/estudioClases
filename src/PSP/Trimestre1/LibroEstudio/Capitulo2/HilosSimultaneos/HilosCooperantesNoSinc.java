package PSP.Trimestre1.LibroEstudio.Capitulo2.HilosSimultaneos;

public class HilosCooperantesNoSinc {
    private static final int NUM_HILOS = 10;
    private static final int CUENTA_TOTAL = 100000;
    public static void main(String[]args) {
        Contador c = new Contador();
        Hilo[] hilos = new Hilo[NUM_HILOS];
        for(int i = 0; i < NUM_HILOS; i++) {
            hilos[i] = new Hilo(i, CUENTA_TOTAL/NUM_HILOS, c);
            hilos[i].start();
        }

        for(int i = 0; i < hilos.length; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e) {
                System.out.println("La ejecución se ga pausado");
            }
        }
        System.out.println("Cuenta global final: "+ c.getCuenta());
    }
}
