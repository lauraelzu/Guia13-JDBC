/*

 */
package principal.dominio.producto;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.persistencia.ProductoDAO;

public class ProductoServicio {
    private ProductoDAO dao;  //Establecer relación EntidadServicio-EntidadDAO
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ProductoServicio() {
        this.dao = new ProductoDAO(); //Inicializar la EntidadDAO en el constructor
    }
    
    //Lista el nombre de todos los productos que hay en la tabla producto
    public void mostrarNombreProductos() throws Exception{
        try{
                Collection<Producto> productos = dao.listarProductos();
                if (productos.isEmpty()){    //validar si el producto de la consulta está vacío
                    throw new Exception("No hay productos para mostrar");
                }else{
                    for (Producto producto : productos) {  
                        System.out.println(producto.getNombre()); //mostrar sólo el nombre de los productos del ArrayList devuelto en la consulta
                    }
                } 
            } catch (Exception e) {
                throw e;
            }
    }
    
    //Lista los nombres y los precios de todos los productos de la tabla producto. 
    public void mostrarNombrePrecioProductos() throws Exception{
        try{
                Collection<Producto> productos = dao.listarProductos();
                if (productos.isEmpty()){
                    throw new Exception("No hay productos para mostrar");
                }else{
                    for (Producto producto : productos) {
                        System.out.println(producto.getNombre() + " - $" + producto.getPrecio()); //nombre y precio
                    }
                } 
            } catch (Exception e) {
                throw e;
            }
    }
    
    //Listar aquellos productos que su precio esté entre 120 y 202.
    public void mostrarProductosSegunPrecio() throws Exception{
        try{
                Collection<Producto> productos = dao.listarProductosSegunPrecio();
                if (productos.isEmpty()){
                    throw new Exception("No hay productos entre $120 y $202");
                }else{
                    for (Producto producto : productos) {
                        System.out.println(producto.getNombre() + " - $" + producto.getPrecio()); //nombre y precio
                    }
                } 
            } catch (Exception e) {
                throw e;
            }
    }
    
    //Buscar y listar todos los Portátiles de la tabla producto.
    public void mostrarPortatiles() throws Exception{
        try{
                Collection<Producto> productos = dao.buscarListarPortatiles();
                if (productos.isEmpty()){
                    throw new Exception("No hay portátiles para mostrar");
                }else{
                    for (Producto producto : productos) {
                        System.out.println(producto.getNombre() + " - $" + producto.getPrecio()); //nombre y precio
                    }
                } 
            } catch (Exception e) {
                throw e;
            }
    }
    
    //Listar el nombre y el precio del producto más barato. 
    public void mostrarProductoMasBarato() throws Exception{
        try{
                Collection<Producto> productos = dao.ListarProductoMasBarato();
                if (productos.isEmpty()){
                    throw new Exception("No hay productos para mostrar");
                }else{
                    for (Producto producto : productos) {
                        System.out.println(producto.getNombre() + " - $" + producto.getPrecio()); //nombre y precio
                    }
                } 
            } catch (Exception e) {
                throw e;
            }
    }
    
    //Ingresar un producto a la base de datos (sin el codigo)
    public void crearProducto() throws InputMismatchException, Exception {

        try {
            String nombre = ingresarNombreProducto();
            if (nombre.equals("")){
                throw new Exception("Debe ingresar un producto");
             }
            double precio =ingresarPrecioProducto();

            int codigoFabricante = ingresarCodigoFabricante();
            
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            dao.guardarProducto(producto);

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            crearProducto();
        } catch (Exception ex) {
//            Logger.getLogger(ProductoServicio.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            crearProducto();
        }
    }
    
    public String ingresarNombreProducto(){
        System.out.println("Ingrese nombre del producto");
        return(leer.next());
    }
    
    public double ingresarPrecioProducto() throws InputMismatchException{
        System.out.println("Ingrese el precio");
        return(leer.nextDouble());
    }
    
    public int ingresarCodigoFabricante() throws InputMismatchException{
        System.out.println("Ingrese el código del fabricante");
        return(leer.nextInt());
    }
    
    //Modificar un producto
    public void mofificarProducto() throws Exception{
        
        int opcion = 0;
        do{
            System.out.println("Modificación de un producto\n");
            System.out.println("1) Modificar nombre de un producto\n" +
    "2) Modificar el precio de un producto\n" +
    "3) Modificar el código de un fabricante\n" +
    "4) Salir");
            opcion = leer.nextInt();
           }while(opcion<1 || opcion>4);
        
        System.out.println("Ingresar código del producto");
        int codigo = leer.nextInt();
        
         switch (opcion){
                    case 1:
                            System.out.println("Ingresar nombre nuevo");
                            String nombre = leer.next();
                            dao.modificarNombreProducto(nombre, codigo);
                            break;
                    case 2:
                            System.out.println("Ingresar precio nuevo del producto");
                            double precio = leer.nextDouble();
                            dao.modificarPrecioProducto(precio, codigo);
                            break;
                    case 3:
                            System.out.println("Ingresar código nuevo del fabricante");
                            int codFabri = leer.nextInt();
                            dao.modificarCodFabriProducto(codFabri, codigo);
                            break;
            }
        
    }
    
}
