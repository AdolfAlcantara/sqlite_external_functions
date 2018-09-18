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
public class HEX2DEC extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
            String hex_value = value_text(0);
            String values = "0123456789ABCDEF";
            int dec=0;
            for(int i=0;i<hex_value.length();i++){
                char x = hex_value.charAt(i);
                int y = values.indexOf(x);
                dec*=16;
                dec+=y;
            }
            result(dec);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
