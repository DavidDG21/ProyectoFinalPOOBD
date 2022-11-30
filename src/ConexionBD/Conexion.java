
package ConexionBD;

import java.sql.*;


public class Conexion {
    private String usuario="usersql";
    private String contraseña="root";
    private String port="1433";
    private String server="localhost";
    private String url="";
    private String nombreBD="ingresarLogin";
    
    public Connection establecerConexion(){
        
        url="jdbc:sqlserver://"+server+":"+port+";"+
                "database="+nombreBD+";"+
                "user="+usuario+";"+
                "password="+contraseña+";"+
                "encrypt=true;trustServerCertificate=true;";            
        try{
            Connection con=DriverManager.getConnection(url);
            System.out.println("conexion exitosa");
            return con;        
        } catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
    public static void main(String[] args) {
        Conexion p=new Conexion();
        p.establecerConexion();
    }
}



