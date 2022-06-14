/*

 */
package principal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.dominio.fabricante.FabricanteServicio;
import principal.dominio.producto.ProductoServicio;

public class MainClass {

    public static void main(String[] args) {
       
        ProductoServicio ps = new ProductoServicio();
        FabricanteServicio fs = new FabricanteServicio();
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        int opcion =0;
        
        try {
            //repetir menú hasta que desee salir (9)
            do{
            //verificar que sea una opcion válida entre 1 y 9
                do{
                    System.out.println("Menú\n");
                    System.out.println("1.Listar el nombre de todos los productos que hay en la tabla producto.\n" +
    "2) Lista los nombres y los precios de todos los productos de la tabla producto.\n" +
    "3) Listar aquellos productos que su precio esté entre 120 y 202.\n" +
    "4) Buscar y listar todos los Portátiles de la tabla producto.\n" +
    "5) Listar el nombre y el precio del producto más barato.\n" +
    "6) Ingresar un producto a la base de datos.\n" +
    "7) Ingresar un fabricante a la base de datos\n" +
    "8) Editar un producto con datos a elección\n" +
                            "9) Salir");
                    opcion = leer.nextInt();
                }while(opcion<1 || opcion>9);

               
                switch (opcion){
                    case 1:
                            System.out.println("\nLista de productos - Nombre");
                            ps.mostrarNombreProductos();
                            break;
                    case 2:
                            System.out.println("\nLista de productos - Nombre y precio");
                            ps.mostrarNombrePrecioProductos();
                            break;
                    case 3:
                            System.out.println("\nLista de productos - Precio entre $120 - $202");
                            ps.mostrarProductosSegunPrecio();
                            break;
                    case 4:
                            System.out.println("\nLista de portátiles");
                            ps.mostrarPortatiles();
                            break;
                    case 5:
                            System.out.println("\nProducto más barato");
                            ps.mostrarProductoMasBarato();
                            break;
                    case 6:
                            System.out.println("\nIngresar un producto nuevo");
                            ps.crearProducto();
                            break;
                    case 7:
                            System.out.println("\nIngresar fabricante nuevo");
                            fs.crearFabricante();
                            break;
                    case 8:
                            System.out.println("\nModificar un producto");
                            ps.mofificarProducto();
                            break;
                }
            }while(opcion!=9);             

            
        } catch (Exception ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
