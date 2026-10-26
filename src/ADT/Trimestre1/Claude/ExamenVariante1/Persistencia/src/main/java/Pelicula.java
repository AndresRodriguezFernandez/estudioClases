public class Pelicula {
    private String titulo;
    private String director;
    private int anio;
    private int duracionMins;

    public Pelicula(String titulo, String director, int anio, int duracionMins){
        this.titulo=titulo;
        this.director=director;
        this.anio=anio;
        this.duracionMins=duracionMins;
    }

    public Pelicula(){}

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public void setDirector(String director){
        this.director=director;
    }

    public void setAnio(int anio){
        this.anio=anio;
    }

    public void setDuracionMins(int duracionMins){
        this.duracionMins=duracionMins;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String setDirector(){
        return this.director;
    }

    public int getAnio(){
        return this.anio;
    }

    public int getDuracionMins(){
        return this.duracionMins;
    }

    @Override
    public String toString(){
        return "Titulo: "+this.titulo + " Director: "+this.director+" Año: "+this.anio+" Duración en minutos: "+duracionMins;

    }

}
