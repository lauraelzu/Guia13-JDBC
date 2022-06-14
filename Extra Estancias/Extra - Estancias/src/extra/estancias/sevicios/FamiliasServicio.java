/*

 */
package extra.estancias.sevicios;

import extra.estancias.entidades.Familias;
import extra.estancias.persistencia.FamiliasDAO;
import java.util.Collection;

public class FamiliasServicio {
    
    private FamiliasDAO dao;

    public FamiliasServicio() {
        this.dao = new FamiliasDAO();
    }
    
    //Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
    public void mostraramiliasMasDe3HijosEdadMaximaMenorA10() throws Exception{  
    try{
                Collection<Familias> listaFamilias = dao.listarFamiliasMasDe3HijosEdadMaximaMenorA10();
                if (listaFamilias.isEmpty()){    //validar si la lista devuelta por la consulta está vacía
                    throw new Exception("No hay familias para mostrar");
                }else{
                    for (Familias flias : listaFamilias) {  
                        System.out.println(flias.getNombre()) ; //mostrar sólo el nombre de las familias del ArrayList devuelto en la consulta
                    }
                } 
            } catch (Exception e) {
                throw e;
            }
    }
}
