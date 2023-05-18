package conx;

import java.sql.SQLException;
import java.util.List;

public class AppConection {
    public static void main(String[] args) throws SQLException {
        // CRUD
        Conexion.getConnection();
        Crud c = new Crud();

        // CREAR:
        // Producto pro = new Producto(1, "Cola", "gaseosa", 3, 1.2);
        // boolean var = c.crear(pro);
        // c.crear(new Producto(1, "Pera", "Fruta", 20, 0.40));
        // c.crear(new Producto(2, "Uva", "Fruta", 30, 1.20));
        // c.crear(new Producto(3, "Sandia", "Fruta", 10, 3.50));
        // c.crear(new Producto(4, "Mantequilla", "Lacteo", 34, 1.40));
        // c.crear(new Producto(5, "Queso Parmesamo", "lacteo", 10, 2.30));


        //READ: 
        // System.out.println(c.leerProducto(11));


        //Leer Lista (SELECT *):
		//1) Forma: con Programacion Funcional:
		// List<Producto> miLista = c.obtenerProductos();
		// miLista.forEach(x-> System.out.println(x));
		
		//2) Forma: usando ForEach Mejorado:
		// for (Producto producto : miLista) {
		// 	System.out.println(miLista);
		// }
    }
}