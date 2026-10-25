import java.sql.*;

public class Conector {
    Connection conexion;
    //al crear una instancia de esta clase se prepara la conexion con la base de datos con los parametros necesarios
    public Conector(){
        try{
            //FIJARSE SI ES ORACLE O MYSQL
            //este ejemplo es SQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public Connection conexion_db(){
        try{
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "app_user", System.getenv().getOrDefault("DB_PASSWORD", "password"));

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conexion;
    }
}
