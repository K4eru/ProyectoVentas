
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar 
{
    public static Connection getConexion() {

        Connection connection = null;
        try { 
           String driverClassName = "com.mysql.jdbc.Driver";
           String driverUrl="jdbc:mysql://localhost:3306/bdgusti";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl, "root","");
            System.out.println("Conexión exitosa");
          
        }catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
        }
        return connection;
    } 
    public static ResultSet getTabla(String Consulta){
        Connection cn=getConexion();
        Statement st;
        ResultSet datos=null;
        try{
            st=cn.createStatement();
            datos=st.executeQuery(Consulta);
            
        }
        catch(Exception e){System.out.println(e.toString());}
        return datos;
    }
    
}
