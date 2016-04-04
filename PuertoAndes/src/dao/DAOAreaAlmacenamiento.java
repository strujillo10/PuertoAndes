package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.AreaAlmacenamiento;
import vos.Carga;

public class DAOAreaAlmacenamiento 
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
	public DAOAreaAlmacenamiento() 
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
	 * Método que, usando la conexión a la base de datos, saca todos los almacenes de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM ALMACEN;
	 * @return Arraylist con los almacenes de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<AreaAlmacenamiento> darAreasAlmacenamiento() throws SQLException, Exception 
	{
		ArrayList<AreaAlmacenamiento> areas = new ArrayList<AreaAlmacenamiento>();

		String sql = "SELECT * FROM AREA_DE_ALMACENAMIENTO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TONELADAS"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));

			areas.add(new AreaAlmacenamiento(id,capacidad,ocupacion));
		}
		return areas;
	}
	
	public ArrayList<Carga> darCargasEnArea(AreaAlmacenamiento area) throws SQLException, Exception 
	{
		ArrayList<Carga> cargas = new ArrayList<Carga>();

		String sql = "SELECT * FROM (CARGA_EN_AREA INNER JOIN CARGA ON CARGA_EN_AREA.ID_CARGA = CARGA.ID)"
				+ " WHERE ID_AREA = " + area.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String tipo = rs.getString("TIPO");
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));

			cargas.add(new Carga(id, tipo, nPeso, nArea, nBuque));
		}
		return cargas;
	}
	
	public ArrayList<AreaAlmacenamiento> darAreaConCapacidad(int capacidad) throws SQLException, Exception 
	{
		ArrayList<AreaAlmacenamiento> areas = new ArrayList<AreaAlmacenamiento>();

		String sql = "SELECT * FROM AREA_DE_ALMACENAMIENTO WHERE CAPACIDAD <" + capacidad;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String tipo = rs.getString("TIPO");
			int nCapacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TONELADAS"));
			int nOcupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));

			areas.add(new AreaAlmacenamiento(id, tipo, nCapacidad, nOcupacion));
		}
		return areas;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<AreaAlmacenamiento> buscarAreaAlmacenamientoPorId(int id) throws SQLException, Exception 
	{
		ArrayList<AreaAlmacenamiento> areas = new ArrayList<AreaAlmacenamiento>();

		String sql = "SELECT * FROM AREA_DE_ALMACENAMIENTO WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TONELADAS"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			areas.add(new AreaAlmacenamiento(id2,capacidad,ocupacion));
		}
		return areas;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addAreaAlmacenamiento(AreaAlmacenamiento area) throws SQLException, Exception 
	{
		String sql = "INSERT INTO AREA_DE_ALMACENAMIENTO VALUES (";
		sql += area.getId() + ",";
		sql += area.getCapacidad() + ",";
		sql += area.getOcupacion() + ")";
	

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el almacen que entra como parámetro en la base de datos.
	 * @param almacen - el almacen a actualizar. almacen !=  null
	 * <b> post: </b> se ha actualizado el almacen en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateAreaAlmacenamiento(AreaAlmacenamiento area) throws SQLException, Exception 
	{
		String sql = "UPDATE AREA_DE_ALMACENAMIENTO SET ";
		sql += "capacidad_en_toneladas='" + area.getCapacidad()+ "',";
		sql += "ocupacion_actual='" + area.getOcupacion()+ "',";
		sql += " WHERE id = " + area.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el almacen que entra como parámetro en la base de datos.
	 * @param almacen - el almacen a borrar. almacen !=  null
	 * <b> post: </b> se ha borrado el almacen en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteAreaAlmacenamiento(AreaAlmacenamiento area) throws SQLException, Exception 
	{

		String sql = "DELETE FROM AREA_DE_ALMACENAMIENTO";
		sql += " WHERE id = " + area.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}