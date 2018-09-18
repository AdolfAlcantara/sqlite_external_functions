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
public class COMPARE extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args()!=2){
            throw new SQLException ("Se necesita dos argumentos" + args());
        }
        try{
            String word = value_text(0);
            String word2 = value_text(1);
            result(Integer.toString(word.compareTo(word2)));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
