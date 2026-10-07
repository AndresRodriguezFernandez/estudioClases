package PSP.Trimestre1.Claude.Tema2.ContadorLocks;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador cont = new Contador();
        Incrementador h1 = new Incrementador(cont);
        Incrementador h2 = new Incrementador(cont);
        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("Valor final: "+cont.getValor());
    }
}
