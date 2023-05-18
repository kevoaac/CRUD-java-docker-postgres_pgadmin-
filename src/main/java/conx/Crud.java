package conx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD: Create Read Update Delete
public class Crud {

	private Connection connection;
	private PreparedStatement sentencia;
	boolean estadoOP;

	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

	public boolean crear(Producto producto) throws SQLException {
		String sql = null;
		estadoOP = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO productos(nombre, tipo, cantidad, precio)"
					+ "VALUES(?,?,?,?)";
			sentencia = connection.prepareStatement(sql);
			// No pasamos el ID porque este se genera automaticamante en la tabla de la base
			// de datos.
			sentencia.setString(1, producto.getNombre());
			sentencia.setString(2, producto.getTipo());
			sentencia.setInt(3, producto.getCantidad());
			sentencia.setDouble(4, producto.getPrecio());

			estadoOP = sentencia.executeUpdate() > 0;
			connection.commit();
			sentencia.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOP;
	}

	public Producto leerProducto(int id) throws SQLException {
		ResultSet resultados = null;// Contenedor donde guardamos las sentencias SQL
		Producto p = new Producto();

		String sql = null;
		estadoOP = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM productos WHERE id = ?";
			sentencia = connection.prepareStatement(sql);
			sentencia.setInt(1, id);

			resultados = sentencia.executeQuery();

			if (resultados.next()) {// Siempre que haya un siguiente resultado, ejecutar:
				connection.setAutoCommit(false);//no se si sea necesario

				p.setId(resultados.getInt(1));
				p.setNombre(resultados.getString(2));
				p.setTipo(resultados.getString(3));
				p.setCantidad(resultados.getInt(4));
				p.setPrecio(resultados.getDouble(5));

			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//No se si es necesario agregar...
			// estadoOP = sentencia.executeUpdate() > 0;
			// connection.commit();
			// sentencia.close();
			// connection.close();
		return p;
	}

	public List<Producto> obtenerProductos()throws SQLException{
		ResultSet resultado = null;
		List<Producto> listaProductos = new ArrayList<>(); 

		String sql = null;
		estadoOP = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "SELECT * FROM productos";
			sentencia = connection.prepareStatement(sql);
			resultado = sentencia.executeQuery();

			while(resultado.next()){
				Producto p = new Producto();

				p.setId(resultado.getInt(1));
				p.setNombre(resultado.getString(2));
				p.setTipo(resultado.getString(3));
				p.setCantidad(resultado.getInt(4));
				p.setPrecio(resultado.getDouble(5));

				listaProductos.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//No se si es necesario agregar...
			// estadoOP = sentencia.executeUpdate() > 0;
			// connection.commit();
			// sentencia.close();
			// connection.close();
		
		return listaProductos;
	}

	public boolean actualizar(int id, Producto p) throws SQLException {
		String sql = null;
		estadoOP = false;
		connection = obtenerConexion();
		connection.setAutoCommit(false);
		
		sql = "UPDATE productos SET nombre=?, tipo=?, cantidad=?, precio=? WHERE id =?";
		sentencia = connection.prepareStatement(sql);

		try {
			sentencia.setString(1, p.getNombre());
			sentencia.setString(2, p.getTipo());
			sentencia.setInt(3, p.getCantidad());
			sentencia.setDouble(4, p.getPrecio());
			sentencia.setInt(5, id);

			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		estadoOP = sentencia.executeUpdate()>0;
		connection.commit();
		sentencia.close();
		connection.close();
		
		return true;
	}	

	

}