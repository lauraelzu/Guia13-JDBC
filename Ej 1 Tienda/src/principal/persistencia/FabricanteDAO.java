package principal.persistencia;

import principal.dominio.fabricante.Fabricante;

public final class FabricanteDAO extends DAO {
    
    //Ingresar un fabricante a la base de datos
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el producto");
            }
            
//            sin el código, la BD está seteada para agregarlo automáticamente
            String sql = "INSERT INTO Fabricante (nombre) " + "VALUES ( '" + fabricante.getNombre() + " ');";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }    
}
