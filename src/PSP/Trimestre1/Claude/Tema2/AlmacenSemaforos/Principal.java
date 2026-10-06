package PSP.Trimestre1.Claude.Tema2.AlmacenSemaforos;

import PSP.Trimestre1.Claude.Tema2.AlmacenPiezas.Cinta;
import PSP.Trimestre1.Claude.Tema2.AlmacenPiezas.Empaquetador;
import PSP.Trimestre1.Claude.Tema2.AlmacenPiezas.Operario;

public class Principal {
    public static void main(String[] args) {
        Cinta cinta = new Cinta();
        Operario[] op = new Operario[2];
        Empaquetador[] emp = new Empaquetador[2];

        for(int i = 0; i < op.length; i++) {
            op[i] = new Operario(cinta, i);
            emp[i] = new Empaquetador(cinta, i);
            op[i].start();
            emp[i].start();
        }

        try{
            for(int i = 0; i < op.length; i++) {
                op[i].join();
                emp[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("la ejecución terminó.");
    }
}
