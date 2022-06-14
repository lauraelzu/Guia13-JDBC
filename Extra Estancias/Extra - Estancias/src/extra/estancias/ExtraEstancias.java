/*

 */
package extra.estancias;

import extra.estancias.sevicios.FamiliasServicio;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtraEstancias {

    public static void main(String[] args) {
        FamiliasServicio fs = new FamiliasServicio();
        
        try{
           System.out.println("\nFamilias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.");
           fs.mostraramiliasMasDe3HijosEdadMaximaMenorA10(); 
        }catch (Exception ex){
            Logger.getLogger(ExtraEstancias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
}
