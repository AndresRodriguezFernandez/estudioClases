public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    Producto(){}

    Producto(String codigo, String nombre, double precio, int  stock){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
    }

    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setPrecio(double precio){
        this.precio=precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setStock(int stock){
        this.stock=stock;
    }

    public int getStock(){
        return this.stock;
    }

    @Override
    public String toString(){
        return "Codigo: "+this.codigo+"     |   Nombre: "+this.nombre+"     |   Precio: "+this.precio+"     |   Stock: "+this.stock;
    }
}
