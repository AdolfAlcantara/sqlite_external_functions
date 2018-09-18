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
public class DEC2BIN extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
            int decimal = Integer.parseInt(value_text(0));
            int expo=0;
            int digit;
            int bin=0;
            while(decimal!=0){
                digit = decimal%2;
                bin+=digit*Math.pow(10, expo);
                expo++;
                decimal/=2;
            }
            result(bin);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
