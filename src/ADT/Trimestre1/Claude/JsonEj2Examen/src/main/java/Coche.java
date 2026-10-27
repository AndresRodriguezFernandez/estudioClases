public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private int anyo;

    public Coche() {}

    public Coche(String mat, String marca, String modelo, int anyo) {
        this.matricula=mat;
        this.marca=marca;
        this.modelo=modelo;
        this.anyo=anyo;
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
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnyo() {
        return anyo;
    }
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", anyo=" + anyo + "]";
    }




}
