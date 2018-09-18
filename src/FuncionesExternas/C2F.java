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
public class C2F extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
            int cels = Integer.parseInt(value_text(0));
        int fahr = cels/5;
        fahr*=9;
        fahr+=32;
        result(fahr);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
