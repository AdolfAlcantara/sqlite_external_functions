/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import FuncionesExternas.Ping;
import FuncionesExternas.PMT;
import FuncionesExternas.BIN2DEC;
import FuncionesExternas.DEC2BIN;
import FuncionesExternas.C2F;
import FuncionesExternas.F2C;
import FuncionesExternas.Factorial;
import FuncionesExternas.HEX2DEC;
import FuncionesExternas.DEC2HEX;
import FuncionesExternas.COMPARE;
import FuncionesExternas.TRIM;
import FuncionesExternas.REPEAT;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.Function;

/**
 *
 * @author FuryCoder
 */
public class Proyecto3 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        SQLiteConnection sqlconn = new SQLiteConnection();
        
        try{
            Connection conn = sqlconn.connect();

            Function.create(conn, Ping.class.getSimpleName(), new Ping());
            Function.create(conn,PMT.class.getSimpleName(),new PMT());
            Function.create(conn,BIN2DEC.class.getSimpleName(),new BIN2DEC());
            Function.create(conn,DEC2BIN.class.getSimpleName(),new DEC2BIN());
            Function.create(conn,C2F.class.getSimpleName(),new C2F());
            Function.create(conn,F2C.class.getSimpleName(),new F2C());
            Function.create(conn,Factorial.class.getSimpleName(),new Factorial());
            Function.create(conn,HEX2DEC.class.getSimpleName(),new HEX2DEC());
            Function.create(conn,DEC2HEX.class.getSimpleName(),new DEC2HEX());
            Function.create(conn,COMPARE.class.getSimpleName(),new COMPARE());
            Function.create(conn,TRIM.class.getSimpleName(),new TRIM());
            Function.create(conn,REPEAT.class.getSimpleName(),new REPEAT());

            Statement stm = conn.createStatement();
            
            stm.execute("select Ping('google.com')");
            System.out.println("Ping: "+stm.getResultSet().getString(1));
            
            stm.execute("select PMT(0.08,10,10000)");
            System.out.println("PMT: "+stm.getResultSet().getString(1));
            
            stm.execute("select BIN2DEC(1110101)");
            System.out.println("BIN2DEC: "+stm.getResultSet().getString(1));
            
            stm.execute("select DEC2BIN(254)");
            System.out.println("DEC2BIN: "+stm.getResultSet().getString(1));
            
            stm.execute("select C2F(100)");
            System.out.println("C2F: "+stm.getResultSet().getString(1));
            
            stm.execute("select F2C(200)");
            System.out.println("F2C: "+stm.getResultSet().getString(1));
            
            stm.execute("select Factorial(4)");
            System.out.println("Factorial: "+stm.getResultSet().getString(1));
            
            stm.execute("select HEX2DEC('43AE')");
            System.out.println("HEX2DEC: "+stm.getResultSet().getString(1));
            
            stm.execute("select DEC2HEX(26)");
            System.out.println("DEC2HEX: "+stm.getResultSet().getString(1));
            
            stm.execute("select COMPARE('hola','hola')");
            System.out.println("COMPARE: "+stm.getResultSet().getString(1));
            
            stm.execute("select TRIM('   2HOLA   ',' ')");
            System.out.println("TRIM:"+stm.getResultSet().getString(1));
            
            stm.execute("select REPEAT('done ',10)");
            System.out.println("REPEAT: "+stm.getResultSet().getString(1));
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
