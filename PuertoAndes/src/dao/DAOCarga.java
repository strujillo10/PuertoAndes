package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Carga;

public class DAOCarga {

	/**
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Método constructor que crea DAOCarga
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOCarga() 
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
	 * Método que, usando la conexión a la base de datos, saca todos los buques de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM CARGA;
	 * @return Arraylist con los buques de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Carga> darCargas() throws SQLException, Exception 
	{
		ArrayList<Carga> cargas = new ArrayList<Carga>();

		String sql = "SELECT * FROM CARGA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		FALTA ESTO:
		while (rs.next()) {
			String name = rs.getString("NAME");
			int id = Integer.parseInt(rs.getString("ID"));
			int duration = Integer.parseInt(rs.getString("DURATION"));
			buques.add(new Buque(id, name, duration));
		}
		return buques;
	}

	/**
	 * Método que busca la/las Carga con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los cargas a buscar
	 * @return Arraylist con los cargas encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Carga> buscarCargaPorName(String name) throws SQLException, Exception 
	{
		ArrayList<Carga> cargas = new ArrayList<Carga>();

		String sql = "SELECT * FROM CARGA WHERE NAME ='" + name + "'";

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

		return cargas;
	}

	/**
	 * Método que agrega la carga que entra como parámetro a la base de datos.
	 * @param carga - el carga a agregar. carga !=  null
	 * <b> post: </b> se ha agregado el carga a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el carga baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addCarga(Carga carga) throws SQLException, Exception 
	{
		String sql = "INSERT INTO ALMACEN BUQUE (";
		sql += video.getId() + ",'";
		sql += video.getName() + "',";
		sql += video.getDuration() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el carga que entra como parámetro en la base de datos.
	 * @param carga - el carga a actualizar. carga !=  null
	 * <b> post: </b> se ha actualizado el carga en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateCarga(Carga carga) throws SQLException, Exception 
	{
		String sql = "UPDATE CARGA SET ";
		sql += "name='" + video.getName() + "',";
		sql += "duration=" + video.getDuration();
		sql += " WHERE id = " + video.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el carga que entra como parámetro en la base de datos.
	 * @param carga - el carga a borrar. carga !=  null
	 * <b> post: </b> se ha borrado el carga en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteCarga(Carga carga) throws SQLException, Exception 
	{

		String sql = "DELETE FROM CARGA";
		sql += " WHERE id = " + video.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}