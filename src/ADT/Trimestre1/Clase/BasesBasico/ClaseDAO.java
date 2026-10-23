package ADT.Trimestre1.Clase.BasesBasico;

import java.sql.*;

public class ClaseDAO {
    public Conector conector;
    public static Connection conexion;

    public ClaseDAO(){
        conector = new Conector();
    }

    public void inciar_conexion(){
        conexion = conector.conexion_bd();
    }

    public void terminar_conexion(){
        try{
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void insertar_registro(String dni, String nombre, String apellidos, String numero_matricula){
        String dml = "INSERT INTO ALUMNOS "+"(dni, nombre, apellidos , numero_matricula)"+" VALUES ('" +dni + "', '"+nombre+"', '"+apellidos+"', '"+numero_matricula+"' )";
        try{
            Statement sentencia;
            sentencia = conexion.createStatement();
            int registros = sentencia.executeUpdate(dml);
            System.out.println("Resgistros afectados: "+registros);
            sentencia.close();
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public ArrayList<Clase> cargar_registros(ArrayList<Clase> lista){
        Statement s;
        ResultSet rs = null;
        try{
            s = conexion.createStatement();
            rs = s.executeQuery("SELECT * FROM ALUMNOS");
            while(rs.next()){
                System.out.println("Nombre"+rs.getString(2)+" Apellidos: "+rs.getString(3)+" DNI:"+rs.getString(1));
                //se usa el getString(numero_columno) para obtener los datos de la tabla
                lista.add(new Clase(rs.getString(1), rs.getString(2).......));
            }
            s.close();
            System.out.println("Fin de carga de resgistros EN ARRAYLIST");
            //ponemos ese mensaje porque estabamos añadiendo los registros en el arraylist lista

        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return lista;
    }

    public void actualizar_registro(String nombre, String dni){
        try{
            String dml = "UPDATE ALUMNOS SET NOMBRE = ? WHERE DNI = ?";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setString(1, nombre);
            sentenciaPreparada.setString(2, dni);
            System.out.println("Sentencia final: "+sentenciaPreparada.toString());
            int registrosAfectados = sentenciaPreparada.executeUpdate();
            System.out.println("Resgistros afectados: "+registrosAfectados);
            sentenciaPreparada.close();
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void eliminar_registro(String dni){
        String sql = "DELETE FROM Aalumno WHERE id = ?";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dni);
            int filasAfectadas = ps.executeUpdate();
            System.out.println("Filas eliminadas: "+filasAfectadas);
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}
