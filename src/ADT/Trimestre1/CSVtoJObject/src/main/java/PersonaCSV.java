import com.opencsv.bean.CsvBindByName;

public class PersonaCSV {
    @CsvBindByName(column = "Nombre")
    private String nombre;

    @CsvBindByName(column = "Edad")
    private int edad;

    public PersonaCSV(){}

    public PersonaCSV(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "PersonaCSV{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
