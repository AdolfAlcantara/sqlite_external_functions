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
public class TRIM extends Function{
    
    private String trim(String caracter, String cadena_final){
        if(cadena_final.charAt(0)== caracter.charAt(0)){
            cadena_final = cadena_final.substring(1);
            return trim(caracter,cadena_final);
        }
        if(cadena_final.charAt(cadena_final.length()-1)==caracter.charAt(0)){
            cadena_final = cadena_final.substring(0, cadena_final.length()-1);
            return trim(caracter,cadena_final);
        }
        return cadena_final;
    }    
    @Override
    protected void xFunc() throws SQLException {
        if(args()!=2){
            throw new SQLException ("Se necesita dos argumentos" + args());
        }
        try{
         String cadena_final = value_text(0);
         String caracter = value_text(1);
//         if(cadena.charAt(0)== caracter.charAt(0)){
//             cadena_final = cadena_final.substring(1);
//         }
//         if(cadena.charAt(cadena.length()-1)==caracter.charAt(0)){
//             cadena_final = cadena_final.substring(0, cadena_final.length()-1);
//         }
         result(trim(caracter,cadena_final));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
