/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesExternas;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;
import org.sqlite.Function;

/**
 *
 * @author FuryCoder
 */
 public class Ping extends Function{

    @Override
    protected void xFunc() throws SQLException {
        
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
           String ip = value_text(0);
           new Socket().connect(new InetSocketAddress(ip,80),5000);
           result(1);
        }catch(IOException e){
            result(0);
        }
    }
   
     
 }