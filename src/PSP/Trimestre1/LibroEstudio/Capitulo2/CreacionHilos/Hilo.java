package PSP.Trimestre1.LibroEstudio.Capitulo2.CreacionHilos;

public class Hilo extends Thread{
    private final String nombre;

    public Hilo (String nom) {
        this.nombre = nom;
    }

    @Override
    public void run(){
        System.out.println("Hola, soy el hilo "+nombre);
    }
}
