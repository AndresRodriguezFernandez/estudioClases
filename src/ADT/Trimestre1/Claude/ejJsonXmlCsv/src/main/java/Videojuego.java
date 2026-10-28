import com.opencsv.bean.CsvBindByName;

public class Videojuego {
    @CsvBindByName(column = "Titulo")
    private String titulo;
    @CsvBindByName(column = "Estudio")
    private String estudio;
    @CsvBindByName(column = "Año")
    private int anio;
    @CsvBindByName(column = "Precio")
    private double precio;

    public Videojuego(){}

    public Videojuego(String titulo, String estudio, int anio, double precio){
        this.titulo=titulo;
        this.estudio=estudio;
        this.anio=anio;
        this.precio=precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString(){
        return "Titulo: "+titulo+" Estudio: "+estudio+" Año: "+anio+" Precio: "+precio;
    }
}
