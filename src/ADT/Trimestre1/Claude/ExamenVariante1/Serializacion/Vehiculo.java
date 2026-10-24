package ADT.Trimestre1.Claude.ExamenVariante1.Serializacion;
import java.io.*;

public class Vehiculo implements Serializable{
    private String matricula;
    private String marca;
    private int kilometraje;

    public Vehiculo(String mat, String marca, int km) {
        this.matricula = mat;
        this.marca = marca;
        this.kilometraje = km;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString(){
        return "Matricula: "+this.matricula+" Marca: "+this.marca+" Kilometraje: "+this.kilometraje;
    }
}


