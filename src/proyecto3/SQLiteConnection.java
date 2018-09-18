/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author FuryCoder
 */
public class SQLiteConnection {
    
    public Connection connect(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/test.db");
            System.out.println("Conexion exitosa");
            return conn;
        }catch(SQLException e){
            System.out.println("Error en la conexion");
            System.err.println(e.getMessage());
        }   
        return null;
    }
    
    public void close(Connection conn){
        try{
            conn.close();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
}
