package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Maquinaria;

public class DAOMaquinaria 
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
	 * Método constructor que crea DAOMaquinaria
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOMaquinaria() 
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
	 * Método que, usando la conexión a la base de datos, saca todos los maquinarias de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM MAQUINARIA;
	 * @return Arraylist con los maquinarias de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Maquinaria> darMaquinarias() throws SQLException, Exception 
	{
		ArrayList<Maquinaria> maquinarias = new ArrayList<Maquinaria>();

		String sql = "SELECT * FROM MAQUINARIA";

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
		return maquinarias;
	}

	/**
	 * Método que busca el/los Factura con el id que entra como parámetro.
	 * @param id - Id de el/los facturas a buscar
	 * @return Arraylist con los facturas encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Maquinaria> buscarMaquinariaPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Maquinaria> maquinarias = new ArrayList<Maquinaria>();

		String sql = "SELECT * FROM MAQUINARIA WHERE ID_FACTURA ='" + id + "'";

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

		return maquinarias;
	}

	/**
	 * Método que agrega el factura que entra como parámetro a la base de datos.
	 * @param factura - el factura a agregar. factura !=  null
	 * <b> post: </b> se ha agregado el factura a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el factura baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addMaquinaria(Maquinaria maquinaria) throws SQLException, Exception 
	{
		String sql = "INSERT INTO FACTURA (";
		sql += video.getId() + ",'";
		sql += video.getName() + "',";
		sql += video.getDuration() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el factura que entra como parámetro en la base de datos.
	 * @param factura - el factura a actualizar. factura !=  null
	 * <b> post: </b> se ha actualizado el factura en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateMaquinaria(Maquinaria maquinaria) throws SQLException, Exception 
	{
		String sql = "UPDATE MAQUINARIA SET ";
		sql += "name='" + video.getName() + "',";
		sql += "duration=" + video.getDuration();
		sql += " WHERE id = " + video.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el factura que entra como parámetro en la base de datos.
	 * @param factura - el factura a borrar. factura !=  null
	 * <b> post: </b> se ha borrado el factura en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteMaquinaria(Maquinaria maquinaria) throws SQLException, Exception 
	{

		String sql = "DELETE FROM MAQUINARIA";
		sql += " WHERE id = " + video.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}