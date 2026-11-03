package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.programacionMultiproceso2;

public class FiltroPares {
    public static int contador(int num1, int num2){
        int contadorPares = 0;
        for (int i = num1; i <= num2; i++){
            if (i % 2== 0){
                contadorPares++;
            }
        }
        return contadorPares;
    }

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Faltan argumentos");
            return;
        }
        try{
            int resultado = contador(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println(resultado);
        }catch(NumberFormatException e){
            System.err.println("Los argumentos debden de ser numero enteros");
        }

    }
}
