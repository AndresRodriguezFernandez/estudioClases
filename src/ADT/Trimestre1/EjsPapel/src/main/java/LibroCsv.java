import com.opencsv.bean.CsvBindByName;

public class LibroCsv {
    @CsvBindByName(column = "Titulo")
    private String titulo;

    @CsvBindByName(column = "Autor")
    private String autor;

    @CsvBindByName(column = "NumPaginas")
    private int numPaginas;

    @CsvBindByName(column = "PrecioVenta")
    private double precio;

    public LibroCsv(){ }

    public LibroCsv(String titulo, String autor, int numPaginas, double precio){
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precio = precio;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setNumPaginas(int numPaginas){
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas(){
        return this.numPaginas;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    @Override
    public String toString(){
        return "Titulo: " + this.titulo + "  |  Autor: " + this.autor
                + "  |  NumPags: " + this.numPaginas + "  |  Precio: " + this.precio;
    }
}
