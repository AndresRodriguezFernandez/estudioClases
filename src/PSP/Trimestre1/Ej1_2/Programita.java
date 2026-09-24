package PSP.Trimestre1.Ej1_2;

public class Programita {
    public int sumar(int numero1, int numero2) {
        return numero2+numero1;
    }

    public static void main(String[] args) {
        int numero1Convertido = Integer.parseInt(args[0]);
        int numero2Convertido = Integer.parseInt(args[1]);
        Programita p = new Programita();
        p.sumar(numero1Convertido, numero2Convertido);
    }
}
