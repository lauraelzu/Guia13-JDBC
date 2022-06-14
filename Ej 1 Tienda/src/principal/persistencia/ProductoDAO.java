/*

 */
package principal.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import principal.dominio.producto.Producto;

public final class ProductoDAO extends DAO {
    
    public Collection <Producto> listarProductos() throws Exception {
        try{
            String sql = "SELECT * FROM Producto";
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        }catch (Exception e){
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    //Listar aquellos productos que su precio esté entre 120 y 202.
    public Collection <Producto> listarProductosSegunPrecio() throws Exception {
        try{
            String sql = "SELECT * FROM Producto WHERE precio BETWEEN 120 and 202";
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        }catch (Exception e){
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    //Buscar y listar todos los Portátiles de la tabla producto.
    public Collection <Producto> buscarListarPortatiles() throws Exception {
        try{
            String sql = "SELECT * FROM Producto WHERE nombre LIKE 'Portátil%'";
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        }catch (Exception e){
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    //Listar el nombre y el precio del producto más barato. 
    public Collection <Producto> ListarProductoMasBarato() throws Exception {
        try{
            String sql = "SELECT nombre, MIN(precio) FROM Producto";
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1)); //sólo trae nombre y precio del más barato
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        }catch (Exception e){
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
        
    //Ingresar un producto a la base de datos
    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
//            sin el código, la BD está seteada para agregarlo automáticamente
            String sql = "INSERT INTO Producto (nombre, precio, codigo_fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' ," + producto.getCodigoFabricante() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    //Modificar nombre de un producto
    public void modificarNombreProducto(String nombreNuevo, int cod) throws Exception{
        try{
            if (nombreNuevo == null || cod == 0){
                throw new Exception ("Faltan datos");
            }
            String sql = "UPDATE Producto SET "
                    + " nombre = '" + nombreNuevo + "' WHERE codigo = '" + cod + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    //Modificar precio de un producto
    public void modificarPrecioProducto(double prec, int cod) throws Exception{
        try{
            if (prec == 0 || cod == 0){
                throw new Exception ("Faltan datos");
            }
            String sql = "UPDATE Producto SET "
                    + " precio = " + prec + " WHERE codigo = '" + cod + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    //Modificar código de fabricante de un producto
    public void modificarCodFabriProducto(int codFabri, int cod) throws Exception{
        try{
            if (codFabri == 0 || cod == 0){
                throw new Exception ("Faltan datos");
            }
            String sql = "UPDATE Producto SET "
                    + " codigo_fabricante = " + codFabri + " WHERE codigo = '" + cod + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
