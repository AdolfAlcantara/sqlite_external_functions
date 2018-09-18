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
public class Factorial extends Function{

    public int getFactorial(int number){
        if(number==1){
            return 1;
        }else{
            return getFactorial(number-1)*number;
        }
    }
    
    @Override
    protected void xFunc() throws SQLException {
        if(args()!=1){
            throw new SQLException ("Se necesita solo un argumento" + args());
        }
        try{
            int fact = Integer.parseInt(value_text(0));
            if(fact%2!=0){
                System.out.println("El numero no es par");
                result(0);
            }else{
                result(getFactorial(fact));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
