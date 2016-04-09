package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import vos.AreaAlmacenamiento;
import vos.Buque;
import vos.Camion;
import vos.Carga;

public class DAOCarga 
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
	 * Método que, usando la conexión a la base de datos, saca todos los almacenes de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM ALMACEN;
	 * @return Arraylist con los almacenes de la base de datos.
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

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String tipo = rs.getString("TIPO");
			int peso = Integer.parseInt(rs.getString("PESO"));
			String destino = rs.getString("DESTINO");
			cargas.add(new Carga(id, tipo, peso,destino));
		}
		return cargas;
	}
	
	public ArrayList<Carga> darCargasDeBuque(Buque buque) throws SQLException, Exception 
	{
		ArrayList<Carga> cargas = new ArrayList<Carga>();

		String sql = "SELECT * FROM CARGA_EN_BUQUE INNER JOIN CARGA ON "
				+ "CARGA_EN_BUQUE.ID_CARGA = CARGA.ID WHERE ID_BUQUE = " + buque.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String tipo = rs.getString("TIPO");
			int peso = Integer.parseInt(rs.getString("PESO"));
			String destino = rs.getString("DESTINO");
			cargas.add(new Carga(id, tipo, peso,destino));
		}
		return cargas;
	}
	
	public AreaAlmacenamiento darAreadeCarga(Carga carga) throws SQLException, Exception 
	{
		AreaAlmacenamiento area = null;
		String sql = "SELECT * FROM CARGA_EN_AREA INNER JOIN AREA_DE_ALMACENAMIENTO "
				+ "ON CARGA_EN_AREA.ID_AREA = AREA_DE_ALMACENAMIENTO.ID WHERE "
				+ "CARGA_EN_AREA.ID_CARGA = " + carga.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String tipo = rs.getString("TIPO");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TONELADAS"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			area = new AreaAlmacenamiento(id, capacidad, tipo, ocupacion);
		}
		return area;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Carga> buscarCargaPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Carga> cargas = new ArrayList<Carga>();

		String sql = "SELECT * FROM CARGA WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			String tipo = rs.getString("TIPO");
			int peso = Integer.parseInt(rs.getString("PESO"));
			String destino = rs.getString("DESTINO");
			cargas.add(new Carga(id2, tipo, peso,destino));
		}
		return cargas;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addCarga(Carga carga) throws SQLException, Exception 
	{
		String sql = "INSERT INTO CARGA VALUES (";
		sql += carga.getId() + ",'";
		sql += carga.getTipo() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void addCargaBuque(Carga carga, Buque buque) throws SQLException, Exception 
	{
		String sql = "INSERT INTO CARGA_EN_BUQUE VALUES (";
		sql += carga.getId() + ",";
		sql += buque.getId() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void addCargaAArea(Carga carga, AreaAlmacenamiento area) throws SQLException, Exception 
	{
		java.util.Calendar cal = java.util.Calendar.getInstance(); 
		java.sql.Date timeNow = new Date(cal.getTimeInMillis());
		
		String sql = "INSERT INTO CARGA_EN_AREA VALUES (";
		sql += carga.getId() + ",";
		sql += area.getId() + ",";
		sql += "TO_DATE('" + timeNow + "')";

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
	public void updateCarga(Carga carga) throws SQLException, Exception 
	{
		String sql = "UPDATE CARGA SET ";
		sql += "tipo='" + carga.getTipo() + "',";
		sql += " WHERE id = " + carga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void moverCargaAArea(Carga carga, AreaAlmacenamiento area) throws SQLException, Exception 
	{
		java.util.Calendar cal = java.util.Calendar.getInstance(); 
		java.sql.Date timeNow = new Date(cal.getTimeInMillis()); 
		
		String sql = "UPDATE CARGA_EN_AREA SET ";
		sql += "id_area=" + area.getId() + ",'";
		sql += "fecha_entrada_carga=" + "TO_DATE('" + timeNow + "','YYYY-MM-DD')"; 
		sql += " WHERE id_carga = " + carga.getId();

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
	public void deleteCarga(Carga carga) throws SQLException, Exception 
	{

		String sql = "DELETE FROM CARGA";
		sql += " WHERE id = " + carga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteCargaArea(Carga carga, AreaAlmacenamiento area) throws SQLException, Exception 
	{

		String sql = "DELETE FROM CARGA_EN_AREA";
		sql += " WHERE id = " + carga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}