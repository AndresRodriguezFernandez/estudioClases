package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso;

public class ContadorDivisores {
    public static void iniciarDivision(int numeroInicial, int numeroFinal){
        int contadorDivisores = 0;
        for(int i = numeroInicial; i <= numeroFinal; i++){
            if(i % 4 == 0){
                contadorDivisores++;
            }
        }
        System.out.println(contadorDivisores);
    }

    public static void main(String[] args) {
        int numero1 = Integer.parseInt(args[0]);
        int numero2 = Integer.parseInt(args[1]);
        iniciarDivision(numero1, numero2);
    }
}
