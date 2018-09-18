/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesExternas;

import java.sql.SQLException;
import org.sqlite.Function;

/**
 *
 * @author FuryCoder
 */
public class REPEAT extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=2){
            throw new SQLException ("Se necesita dos argumentos" + args());
        }
        try{
         String word = value_text(0);
         int times = Integer.parseInt(value_text(1));
         String cadena_final="";
         
         while(times>0){
             cadena_final+=word;
             times--;
         }
         result(cadena_final);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
