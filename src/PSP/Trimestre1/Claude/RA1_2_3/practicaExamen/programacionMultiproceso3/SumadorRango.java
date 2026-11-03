package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso3;

public class SumadorRango {
    public static int calcularSuma(int n1, int n2){
        int sumaFinal = 0;
        for(int i = n1; i <= n2 ; i++){
            sumaFinal+=i;
        }
        return sumaFinal;
    }

    public static void main(String[] args){
        if (args.length < 2){
            System.out.println("Faltan argumentos");
            return;
        }

        try{
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            if (n1 < 0 || n2 < 0){
                System.err.println("Los argumentos deben de ser enteros positivos");
                return;
            }
            if(n1 > n2){
                System.err.println("El numero 1 es mas grande que el numero 2");
                return;
            }

            int resultado = calcularSuma(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println(resultado);
        }catch(NumberFormatException e){
            System.err.println("los argumentos deben de ser número enteros.");
        }
    }
}
