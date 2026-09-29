package PSP.Trimestre1.LibroEstudio.Capitulo2.PausarHilos;

public class Principal {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Uno");
        Hilo h2 = new Hilo("Dos");
        h1.start();
        h2.start();
        try{
            h1.join();
            h2.join();
        }catch (InterruptedException e) {
            System.out.println("El hilo principal se ha interrumpido.");
        }
        System.out.println("Se ha terminado el hilo principal.");
    }
}
