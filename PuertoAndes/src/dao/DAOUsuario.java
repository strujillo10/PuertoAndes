package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Usuario;

public class DAOUsuario 
{

	/**
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Método constructor que crea DAOUsuario
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOUsuario() 
	{
		recursos = new ArrayList<Object>();
	}

	/**
	 * Método que cierra todos los recursos que estan en el arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos() 
	{
		for(Object ob : recursos)
		{
			if(ob instanceof PreparedStatement)
				try 
				{
					((PreparedStatement) ob).close();
				} 
				catch (Exception ex) 
				{
					ex.printStackTrace();
				}
		}
	}

	/**
	 * Método que inicializa la connection del DAO a la base de datos con la conexión que entra como parámetro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con)
	{
		this.conn = con;
	}


	/**
	 * Método que, usando la conexión a la base de datos, saca todos los usuarios de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM USUARIO;
	 * @return Arraylist con los usuarios de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Usuario> darUsuarios() throws SQLException, Exception 
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "SELECT * FROM USUARIO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID_USUARIO"));
			String name = rs.getString("NAME");
			String registro = rs.getString("REGISTRO");
			String tipo = rs.getString("TIPO");
			int importador = Integer.parseInt(rs.getString("IMPORTADOR"));
			String rut = rs.getString("RUT");
			usuarios.add(new Usuario(id, name, registro, tipo, importador, rut));
		}
		return usuarios;
	}

	/**
	 * Método que busca el/los Usuario con el id que entra como parámetro.
	 * @param id - Id de el/los usuario a buscar
	 * @return Arraylist con los usuarios encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Usuario> buscarUsuarioPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID_USUARIO"));
			String name = rs.getString("NAME");
			String registro = rs.getString("REGISTRO");
			String tipo = rs.getString("TIPO");
			int importador = Integer.parseInt(rs.getString("IMPORTADOR"));
			String rut = rs.getString("RUT");
			usuarios.add(new Usuario(id2, name, registro, tipo, importador, rut));
		}
		return usuarios;
	}

	/**
	 * Método que agrega el usuarios que entra como parámetro a la base de datos.
	 * @param usuario - el usuario a agregar. usuario !=  null
	 * <b> post: </b> se ha agregado el usuario a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el usuario baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el usuario a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addUsuario(Usuario usuario) throws SQLException, Exception 
	{
		String sql = "INSERT INTO USUARIO (";
		sql += usuario.getIdUsuario() + ",'";
		sql += usuario.getNombre() + "',";
		sql += usuario.getRegistro() + "',";
		sql += usuario.getTipo() + "',";
		sql += usuario.getImportador() + "',";
		sql += usuario.getRut() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el usuario que entra como parámetro en la base de datos.
	 * @param Usuario - el usuario a actualizar. usuario !=  null
	 * <b> post: </b> se ha actualizado el usuario en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateUsuario(Usuario usuario) throws SQLException, Exception 
	{
		String sql = "UPDATE USUARIO SET ";
		sql += "nombre='" + usuario.getNombre() + "',";
		sql += "registro=" + usuario.getRegistro() + "',";
		sql += "tipo=" + usuario.getTipo() + "',";
		sql += "importador=" + usuario.getImportador() + "',";
		sql += "rut=" + usuario.getRut() + "',";
		sql += " WHERE id = " + usuario.getIdUsuario();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el usuario que entra como parámetro en la base de datos.
	 * @param usuario - el usuario a borrar. usuario !=  null
	 * <b> post: </b> se ha borrado el usuario en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteUsuario(Usuario usuario) throws SQLException, Exception 
	{
		String sql = "DELETE FROM USUARIO";
		sql += " WHERE ID_USUARIO = " + usuario.getIdUsuario();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}