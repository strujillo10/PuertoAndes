package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Camion;

public class DAOCamion 
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
	 * Método constructor que crea DAOAlmacen
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOCamion() 
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
	 * Método que, usando la conexión a la base de datos, saca todos los camiones de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM CAMION;
	 * @return Arraylist con los camiones de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Camion> darCamiones() throws SQLException, Exception 
	{
		ArrayList<Camion> camiones = new ArrayList<Camion>();

		String sql = "SELECT * FROM CAMION";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String name = rs.getString("NOMBRE_AGENTE");
			int id = Integer.parseInt(rs.getString("ID_CAMION"));
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			int carga = Integer.parseInt(rs.getString("CARGA"));
			int cantiCont = Integer.parseInt(rs.getString("CANTIDAD_CONTENEDORES"));
			int idPuert = Integer.parseInt(rs.getString("ID_PUERTO"));
			camiones.add(new Camion(id, fechaLlegada, fechaSalida, name, carga, cantiCont, idPuert));
		}
		return camiones;
	}

	/**
	 * Método que busca el/los Camion con el id que entra como parámetro.
	 * @param id - Id de el/los camiones a buscar
	 * @return Arraylist con los camiones encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Camion> buscarCamionPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Camion> camiones = new ArrayList<Camion>();

		String sql = "SELECT * FROM CAMION WHERE ID_CAMION ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("NOMBRE_AGENTE");
			int id2 = Integer.parseInt(rs.getString("ID_CAMION"));
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			int carga = Integer.parseInt(rs.getString("CARGA"));
			int cantiCont = Integer.parseInt(rs.getString("CANTIDAD_CONTENEDORES"));
			int idPuert = Integer.parseInt(rs.getString("ID_PUERTO"));
			camiones.add(new Camion(id2, fechaLlegada, fechaSalida, name, carga, cantiCont, idPuert));
		}

		return camiones;
	}

	/**
	 * Método que agrega el camion que entra como parámetro a la base de datos.
	 * @param camion - el camion a agregar. camion !=  null
	 * <b> post: </b> se ha agregado el camion a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el camion baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addCamion(Camion camion) throws SQLException, Exception 
	{
		String sql = "INSERT INTO CAMION VALUES (";
		sql += camion.getIdCamion() + ",'";
		sql += camion.getFechaLlegada() + ",'";
		sql += camion.getFechaSalida() + ",'";
		sql += camion.getNombreAgente() + ",'";
		sql += camion.getCarga() + "',";
		sql += camion.getCantidadContenedores() + ",'";
		sql += camion.getIdPuerto() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el camion que entra como parámetro en la base de datos.
	 * @param camion - el camion a actualizar. camion !=  null
	 * <b> post: </b> se ha actualizado el camion en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateCamion(Camion camion) throws SQLException, Exception 
	{
		String sql = "UPDATE CAMION SET ";
		sql += "id_camion='" + camion.getIdCamion() + "',";
		sql += "fecha_llegada='" + camion.getFechaLlegada() + "',";
		sql += "fecha_salida='" + camion.getFechaSalida() + "',";
		sql += "nombre_agente='" + camion.getNombreAgente() + "',";
		sql += "carga='" + camion.getCarga() + "',";
		sql += "cantidad_contenedores='" + camion.getCantidadContenedores() + "',";
		sql += "id_puerto=" + camion.getIdPuerto();
		sql += " WHERE id_camion = " + camion.getIdCamion();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el camion que entra como parámetro en la base de datos.
	 * @param camion - el camion a borrar. camion !=  null
	 * <b> post: </b> se ha borrado el camion en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteCamion(Camion camion) throws SQLException, Exception 
	{

		String sql = "DELETE FROM CAMION";
		sql += " WHERE id_camion = " + camion.getIdCamion();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}