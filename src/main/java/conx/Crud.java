package conx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Crud {
	
	//Create Read Update Delete(Metodos)
	
	private Connection connection;
	private PreparedStatement sentencia;
	boolean estadoOP;
	
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
	
	public boolean crear(Producto producto)throws SQLException {
		String sql = null;
		estadoOP = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO productos(nombre, tipo, cantidad, precio)"
					+"VALUES(?,?,?,?)";
			sentencia = connection.prepareStatement(sql);
			//No pasamos el ID porque este se genera automaticamante en la tabla de la base de datos.
			sentencia.setString(1, producto.getNombre());
			sentencia.setString(2, producto.getTipo());
			sentencia.setInt(3, producto.getCantidad());
			sentencia.setDouble(4, producto.getPrecio());
			estadoOP = sentencia.executeUpdate() > 0;
			connection.commit();
			sentencia.close();
			connection.close();
			
			/*Lo que debemos insertar en postgreee:
			 * insert into
			 * producto(nombre,tipo,cantidad,precio)
			 * values("cola","gaseosa",3,1.2)*/
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOP;
	}

}