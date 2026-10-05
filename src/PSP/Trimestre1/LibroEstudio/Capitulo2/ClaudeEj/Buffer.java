package PSP.Trimestre1.LibroEstudio.Capitulo2.ClaudeEj;

class Buffer {
    private int dato;
    private boolean hayDato = false;

    public synchronized void poner(int valor) throws InterruptedException {
        while (hayDato) {          // si ya hay dato, espero a que lo consuman
            wait();
        }
        dato = valor;
        hayDato = true;
        System.out.println("Produzco "+valor);
        notifyAll();               // aviso al consumidor
    }

    public synchronized int sacar() throws InterruptedException {
        while (!hayDato) {         // si no hay dato, espero a que produzcan
            wait();
        }
        hayDato = false;
        System.out.println("Saco "+dato);
        notifyAll();               // aviso al productor
        return dato;
    }
}
