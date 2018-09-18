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
public class BIN2DEC extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
            int bin = Integer.parseInt(value_text(0));
            int expo = 0;
            int digit;
            int decimal=0;
            while(bin!=0){
                digit = bin%10;
                decimal +=digit*(int)Math.pow(2, expo);
                expo++;
                bin/=10;
                result(decimal);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
