import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Producto p1 = new Producto("1234A", "Destornillador", 9.99, 2);
        Producto p2 = new Producto("4312B", "Taladro", 39.99, 5);
        Producto p3 = new Producto("789C", "Toalla", 5.99, 20);
        Producto p4 = new Producto("5567D", "Boligrafo", 1.99, 10);

        List<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        GestorProductos.guardarProductos(productos, "src/ADT/Trimestre1/EjerciciosJson/src/main/java/productos.json");
        List<Producto> productosLeer = GestorProductos.leerProdcutos("src/ADT/Trimestre1/EjerciciosJson/src/main/java/productos.json");
        for (Producto i: productosLeer){
            System.out.println(i.toString());
        }
        System.out.print("Introduce un código de producto:");
        String codigo = sc.nextLine();
        System.out.print("Introduce un porcentaje de subida al precio: ");
        double subida = sc.nextDouble();
        GestorProductos.subirPrecio("src/ADT/Trimestre1/EjerciciosJson/src/main/java/productos.json", codigo, subida);
        List<Producto> productosLeer2 = GestorProductos.leerProdcutos("src/ADT/Trimestre1/EjerciciosJson/src/main/java/productos.json");
        for (Producto i: productosLeer2){
            System.out.println(i.toString());
        }
    }
}
