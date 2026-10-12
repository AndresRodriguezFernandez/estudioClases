package ADT.Trimestre1.Claude.EjObject;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private double precio;

    public Libro(String titulo, String autor, int anio, double precio){
        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anio;
        this.precio=precio;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAnioPublicacion(int anio){
        this.anioPublicacion=anio;
    }

    public int getAnioPublicacion(){
        return this.anioPublicacion;
    }

    public void setPrecio(double precio){
        this.precio=precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    @Override
    public String toString(){
        return "Titulo: "+this.titulo+" | Autor: "+this.autor+"  |   Año de publicación:"+this.anioPublicacion+"  |  Precio: "+this.precio;
    }
}
