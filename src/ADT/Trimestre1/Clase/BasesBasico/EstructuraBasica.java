package ADT.Trimestre1.Clase.BasesBasico;

import java.sql.*;

public class EstructuraBasica {
    public static void main(String[] args){


        Connection conexion = null;

        //PASO 1: Cargar el driver y conectar con la base de datos=====================
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/basedatos", "usuario", "password");
        }catch(SQLException e){
            System.out.println("Eror"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Clase no encontrada: "+e.getMessage());
        }



        //PASO 2: Ejecutar la consulta:=====================

        try{
            Statement s = conexion.createStatement();
            //para preparedStatement la cosa cambia
            ResultSet rs = s.executeQuery("SELECT * FORM ALUMNOS");


            //PASO 3: Recorrer el resultado===============

            while(rs.next()){
                System.out.println(rs.getString("columna"));
            }

            rs.close();
            s.close();

        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error al cerrar la conexión: "+e.getMessage());
            }
        }
    }
}
