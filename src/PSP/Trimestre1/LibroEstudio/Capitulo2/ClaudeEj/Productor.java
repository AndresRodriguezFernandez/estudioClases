package PSP.Trimestre1.LibroEstudio.Capitulo2.ClaudeEj;

class Productor extends Thread {
    private Buffer buffer;
    Productor(Buffer b) { buffer = b; }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.poner(i);
            }
        } catch (InterruptedException e) { }
    }
}

class Consumidor extends Thread {
    private Buffer buffer;
    Consumidor(Buffer b) { buffer = b; }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.sacar();
            }
        } catch (InterruptedException e) { }
    }
}
