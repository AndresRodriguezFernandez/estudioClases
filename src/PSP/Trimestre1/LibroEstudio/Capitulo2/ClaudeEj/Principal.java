package PSP.Trimestre1.LibroEstudio.Capitulo2.ClaudeEj;

public class Principal {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        Productor prod = new Productor(b);
        Consumidor cons = new Consumidor(b);

        cons.start();
        prod.start();

    }
}
