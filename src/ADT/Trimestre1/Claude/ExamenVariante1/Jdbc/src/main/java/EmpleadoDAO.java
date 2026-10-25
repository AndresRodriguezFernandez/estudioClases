import java.sql.*;
public class EmpleadoDAO {
    public Conector conector;
    public static Connection conexion;

    public EmpleadoDAO(){//al crear una instancia de la clase EmpleadoDAo tambien se crea una nueva conexion
        conector=new Conector();
    }

    public void inicar_conexion(){/// inicia la conexion
        conexion=conector.conexion_db();
    }

    public void terminar_conexion(){//termina la conexion
        try{
            conexion.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public String listarPorSalarioMinimo(double salarioMinimo){
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        String resultado = "";
        try{
            String dml = "SELECT id, nombre, departamento, salario FROM EMPLEADOS WHERE salario >= ?";
            sentencia = conexion.prepareStatement(dml);
            sentencia.setDouble(1, salarioMinimo);//EL 1 ES LA POSICION DEL ? EN LA CONSULTA, NO EL NUMERO DE TABLA
            rs = sentencia.executeQuery();
            while(rs.next()){
                resultado = resultado + ", " + "ID:"+rs.getString(1)+" Apellido: "+rs.getString(2)+ "Departamento: "+rs.getString(3)+" Salario: "+rs.getString(4);
                System.out.println("ID:"+rs.getString(1)+" Apellido: "+rs.getString(2)+ "Departamento: "+rs.getString(3)+" Salario: "+rs.getString(4));

            }
            sentencia.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        if(resultado.equals("")){
            return "No hay resultados";
        }else{
            return resultado;
        }
    }
}
