package ADT.Trimestre1.Clase.BasesBasico;

import java.sql.*;
public class Conector {
    Connection conexion;
    public Conector(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e){
            System.out.println("Error:"+e.getMessage());
        }
    }

    public Connection conexion_bd(){
        try{
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/XEPDB1","alumno", System.getenv().getOrDefault("DB_PASSWORD", "password"));
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }
        return conexion;
    }
}
