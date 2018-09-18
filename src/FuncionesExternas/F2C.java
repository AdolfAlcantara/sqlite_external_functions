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
public class F2C extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
            int fahr = Integer.parseInt(value_text(0));
        int cels = fahr-32;
        cels*=5;
        cels/=9;
        result(cels);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
