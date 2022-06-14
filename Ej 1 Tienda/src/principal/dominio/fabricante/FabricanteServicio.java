package principal.dominio.fabricante;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.persistencia.FabricanteDAO;

public class FabricanteServicio {
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    
       
     //Ingresar un producto a la base de datos (sin el codigo)
    public void crearFabricante() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.println("Ingrese nombre del fabricante");
            String nombre = leer.next();
            if (nombre.equals("")){
                throw new Exception("Debe ingresar fabricante");
             }
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);

            dao.guardarFabricante(fabricante);

        } catch (Exception ex) {
//            Logger.getLogger(FabricanteServicio.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            crearFabricante();
        }
    }
}
