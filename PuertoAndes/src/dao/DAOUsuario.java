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
	 * Arraylits de recursos que se usan para la ejecuci�n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexi�n a la base de datos
	 */
	private Connection conn;

	/**
	 * M�todo constructor que crea DAOUsuario
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOUsuario() 
	{
		recursos = new ArrayList<Object>();
	}

	/**
	 * M�todo que cierra todos los recursos que estan en el arreglo de recursos
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
	 * M�todo que inicializa la connection del DAO a la base de datos con la conexi�n que entra como par�metro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con)
	{
		this.conn = con;
	}


	/**
	 * M�todo que, usando la conexi�n a la base de datos, saca todos los usuarios de la base de datos
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

		FALTA ESTO:
		while (rs.next()) {
			String name = rs.getString("NAME");
			int id = Integer.parseInt(rs.getString("ID"));
			int duration = Integer.parseInt(rs.getString("DURATION"));
			buques.add(new Maquinaria(id, name, duration));
		}
		return usuarios;
	}

	/**
	 * M�todo que busca el/los Usuario con el id que entra como par�metro.
	 * @param id - Id de el/los usuario a buscar
	 * @return Arraylist con los usuarios encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Usuario> buscarUsuarioPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "SELECT * FROM USUARIO WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		FALTA ESTO: 
		while (rs.next()) {
			String name2 = rs.getString("NAME");
			int id = Integer.parseInt(rs.getString("ID"));
			int duration = Integer.parseInt(rs.getString("DURATION"));
			videos.add(new Video(id, name2, duration));
		}

		return usuarios;
	}

	/**
	 * M�todo que agrega el usuarios que entra como par�metro a la base de datos.
	 * @param usuario - el usuario a agregar. usuario !=  null
	 * <b> post: </b> se ha agregado el usuario a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el usuario baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el usuario a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addUsuario(Usuario usuario) throws SQLException, Exception 
	{
		String sql = "INSERT INTO USUARIO (";
		sql += video.getId() + ",'";
		sql += video.getName() + "',";
		sql += video.getDuration() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * M�todo que actualiza el usuario que entra como par�metro en la base de datos.
	 * @param Usuario - el usuario a actualizar. usuario !=  null
	 * <b> post: </b> se ha actualizado el usuario en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateUsuario(Usuario usuario) throws SQLException, Exception 
	{
		String sql = "UPDATE USUARIO SET ";
		sql += "name='" + video.getName() + "',";
		sql += "duration=" + video.getDuration();
		sql += " WHERE id = " + video.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * M�todo que elimina el usuario que entra como par�metro en la base de datos.
	 * @param usuario - el usuario a borrar. usuario !=  null
	 * <b> post: </b> se ha borrado el usuario en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteUsuario(Usuario usuario) throws SQLException, Exception 
	{

		String sql = "DELETE FROM USUARIO";
		sql += " WHERE id = " + usuario.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}