package PSP.Trimestre1.LibroEstudio.Capitulo2.CreacionHilos;

public class Principal {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Uno");
        Hilo h2 = new Hilo("Dos");
        h1.start();
        h2.start();
    }
}
