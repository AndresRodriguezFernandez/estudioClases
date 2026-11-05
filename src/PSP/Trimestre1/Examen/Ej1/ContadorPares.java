package ejercicio1;

public class ContadorPares {
    public static int contarPares(int n1, int n2){
        int pares = 0;
        for (int i = n1; i <= n2; i++){
            if (i % 2 == 0){
                pares++;
            }
        }
        return pares;
    }

    static void main(String[]args) {
        if (args.length < 2){
            System.out.println("Faltan argumentos");
            return;
        }
        try{
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            if (n1 < 0 || n2 < 0){
                System.err.println("Los argumentos no son positivos");
                return;
            }
            if (n1>n2){
                System.err.println("El numero 1 es mas grande que el numero 2");
                return;
            }
            int resultado = contarPares(n1, n2);
            System.out.println(resultado);
        }catch (NumberFormatException e){
            System.err.println("los argumentos deben ser enteros");
        }
    }//fin main
}//fin clase
