package conx;

import java.sql.SQLException;

public class AppConection 
{
    public static void main( String[] args ) throws SQLException
    {
        Conexion.getConnection();
        Producto pro = new Producto(1,"cola","gaseosa",3,1.2);
		Crud c = new Crud();
		boolean var = c.crear(pro);

        
    }
}
