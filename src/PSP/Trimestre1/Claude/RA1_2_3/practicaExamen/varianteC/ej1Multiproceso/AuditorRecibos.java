package PSP.Trimestre1.Claude.RA1_2_3.practicaExamen.varianteC.ej1Multiproceso;

public class AuditorRecibos {
    public static int contarNumeros(int n1, int n2){
        int totalNumeros = 0;
        for (int i = n1; i <= n2; i++){
            if (i % 10 == 7){
                totalNumeros++;
            }
        }
        return totalNumeros;
    }

    public static void main(String[]args){
        if(args.length < 2){
            System.out.println("Faltan argumentos en el proceso hijo.");
            return;
        }
        try{
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            if(n1 < 0 || n2 < 0){
                System.err.println("Los nuermos deben ser positivos");
                return;
            }
            if (n1 > n2){
                System.err.println("El rango está mal definido: el primer número es más grande que el segundo.");
                return;
            }
            int resultado = contarNumeros(n1, n2);
            System.out.println(resultado);
        }catch(NumberFormatException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
