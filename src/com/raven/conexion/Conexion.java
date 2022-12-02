/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.conexion;

import java.sql.*;

public class Conexion {
    
    public static Connection getConexion(){
        String url="jdbc:sqlserver://localhost:1433;"
                + "database=clienteBD;"
                + "user=loginCliente;"
                + "password=cliente;"
                + "encrypt=true;trustServerCertificate=true;";
        try {
            Connection con = DriverManager.getConnection(url);
            System.out.println("conectó :p");
            return con;
        }catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public static void main(String[] args) {
        Conexion p=new Conexion();
        p.getConexion();
    }
}
