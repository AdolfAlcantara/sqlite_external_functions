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
public class PMT extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=3){
            throw new SQLException ("Se necesitan tres argumentos" + args());
        }
        try{
            double tasa = Double.parseDouble(value_text(0));
            tasa = tasa/12;
            double nper = Double.parseDouble(value_text(1));
            double va = Double.parseDouble(value_text(2));
            double total = va*((Math.pow((1+tasa),nper)*tasa)/(Math.pow((1+tasa),nper)-1));
            result(total);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
