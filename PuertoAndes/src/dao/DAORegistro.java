package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Registro;

public class DAORegistro 
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
	 * Método constructor que crea DAORegistro
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAORegistro() 
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
	 * Método que, usando la conexión a la base de datos, saca todos los registros de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM REGISTRO;
	 * @return Arraylist con los registros de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Registro> darRegistros() throws SQLException, Exception 
	{
		ArrayList<Registro> registros = new ArrayList<Registro>();

		String sql = "SELECT * FROM REGISTRO";

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
	 * Método que busca el/los Registro con el id que entra como parámetro.
	 * @param id - Id de el/los registros a buscar
	 * @return Arraylist con los registros encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Registro> buscarRegistroPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Registro> registros = new ArrayList<Registro>();

		String sql = "SELECT * FROM REGISTRO WHERE ID ='" + id + "'";

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

		return registros;
	}

	/**
	 * Método que agrega el registro que entra como parámetro a la base de datos.
	 * @param registro - el registro a agregar. registro !=  null
	 * <b> post: </b> se ha agregado el registro a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el registro baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el registro a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addRegistro(Registro registro) throws SQLException, Exception 
	{
		String sql = "INSERT INTO REGISTRO (";
		sql += video.getId() + ",'";
		sql += video.getName() + "',";
		sql += video.getDuration() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el registro que entra como parámetro en la base de datos.
	 * @param Registro - el registro a actualizar. registro !=  null
	 * <b> post: </b> se ha actualizado el registro en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el registro.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateRegistro(Registro registro) throws SQLException, Exception 
	{
		String sql = "UPDATE REGISTRO SET ";
		sql += "name='" + video.getName() + "',";
		sql += "duration=" + video.getDuration();
		sql += " WHERE id = " + video.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el registro que entra como parámetro en la base de datos.
	 * @param registro - el registro a borrar. registro !=  null
	 * <b> post: </b> se ha borrado el registro en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el registro.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteUsuario(Registro registro) throws SQLException, Exception 
	{

		String sql = "DELETE FROM USUARIO";
		sql += " WHERE id = " + registro.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}