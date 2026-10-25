import java.util.*;
import java.io.*;

public class Principal {
    public static void main(String[] args){
        EmpleadoDAO em = new EmpleadoDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un salario mínimo: ");
        double salarioM = sc.nextDouble();
        em.inicar_conexion();//se inicia la conexion con la base de datos
        System.out.println(em.listarPorSalarioMinimo(salarioM));
        em.terminar_conexion();//se termina la conexion con la base de datos
    }
}
