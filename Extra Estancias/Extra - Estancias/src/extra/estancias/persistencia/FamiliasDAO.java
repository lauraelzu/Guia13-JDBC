/*
 */
package extra.estancias.persistencia;

import extra.estancias.entidades.Familias;
import java.util.ArrayList;
import java.util.Collection;

public final class FamiliasDAO extends DAO{
    
//Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
    public Collection <Familias> listarFamiliasMasDe3HijosEdadMaximaMenorA10() throws Exception {
    try{
        String sql = "SELECT * FROM familias where num_hijos >= 3 and edad_maxima < 10";
        consultarBase(sql);
        Familias familias = null;
        Collection <Familias> listaFamilias = new ArrayList();
        while (resultado.next()){
            familias = new Familias();
            familias.setId(resultado.getInt(1));
            familias.setNombre(resultado.getString(2));
            familias.setEdad_minima(resultado.getInt(3));
            familias.setEdad_maxima(resultado.getInt(4));
            familias.setNum_hijos(resultado.getInt(5));
            familias.setEmail(resultado.getString(6));
            familias.setId_casa_familia(resultado.getInt(7));
            listaFamilias.add(familias);
        }
        desconectarBase();
        return listaFamilias;
    }catch (Exception e){
        desconectarBase();
        throw new Exception("Error de sistema");
        }
    }
}
