package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.Buque;
import vos.BuqueRoro;

public class DAOBuqueRoro 
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
	public DAOBuqueRoro() 
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
	public ArrayList<BuqueRoro> darBuquesR() throws SQLException, Exception 
	{
		ArrayList<BuqueRoro> buqueR = new ArrayList<BuqueRoro>();

		String sql = "SELECT * FROM BUQUE_RORO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String nombre = rs.getString("NOMRE");
			String procedencia = rs.getString("PROCEDENCIA");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			Time horaLlegada = rs.getTime("HORA_LLEGADA");
			Time horaSalida = rs.getTime("HORA_SALIDA");
			String destino = rs.getString("DESTINO");
			int buqueId = Integer.parseInt(rs.getString("BUQUE_ID"));
			buqueR.add(new BuqueRoro(id, nombre, procedencia, fechaLlegada, fechaSalida, horaLlegada, horaSalida, destino, buqueId));
		}
		return buqueR;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<BuqueRoro> buscarBuqueRPorId(int id) throws SQLException, Exception 
	{
		ArrayList<BuqueRoro> buqueR = new ArrayList<BuqueRoro>();

		String sql = "SELECT * FROM BUQUE_RORO WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			String nombre = rs.getString("NOMRE");
			String procedencia = rs.getString("PROCEDENCIA");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			Time horaLlegada = rs.getTime("HORA_LLEGADA");
			Time horaSalida = rs.getTime("HORA_SALIDA");
			String destino = rs.getString("DESTINO");
			int buqueId = Integer.parseInt(rs.getString("BUQUE_ID"));
			buqueR.add(new BuqueRoro(id2, nombre, procedencia, fechaLlegada, fechaSalida, horaLlegada, horaSalida, destino, buqueId));
		}
		return buqueR;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addBuqueR(BuqueRoro buqueR) throws SQLException, Exception 
	{
		String sql = "INSERT INTO BUQUE_RORO VALUES (";
		sql += buqueR.getId() + ",'";
		sql += buqueR.getNombre() + "','";
		sql += buqueR.getProcedencia() + "',";
		sql += "TO_DATE('" + buqueR.getFechaLlegada() + "','YYYY-MM-DD HH24:MI:SS'),";
		sql += "TO_DATE('" + buqueR.getFechaSalida() + "','YYYY-MM-DD HH24:MI:SS'),";
		sql += "TO_TIMESTAMP('" + buqueR.getHoraLlegada() + "','YYYY-MM-DD HH24:MI:FF'),";
		sql += "TO_TIMESTAMP('" + buqueR.getHoraSalida() + "','YYYY-MM-DD HH24:MI:FF'),'";
		sql += buqueR.getDestino() + "',";
		sql += buqueR.getBuqueId() + ")";

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
	public void updateBuqueR(BuqueRoro buqueR) throws SQLException, Exception 
	{
		String sql = "UPDATE BUQUE_RORO SET ";
		sql += "nomre='" + buqueR.getNombre() + "',";
		sql += "procedencia='" + buqueR.getProcedencia() + "',";
		sql += "fecha_llegada='" + buqueR.getFechaLlegada() + "',";
		sql += "fecha_salida='" + buqueR.getFechaSalida() + "',";
		sql += "hora_llegada='" + buqueR.getHoraLlegada() + "',";
		sql += "hora_salida='" + buqueR.getHoraSalida() + "',";
		sql += "destino='" + buqueR.getDestino() + "',";
		sql += "buque_id='" + buqueR.getBuqueId() + "',";
		sql += " WHERE id = " + buqueR.getId();

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
	public void deleteBuqueR(BuqueRoro buqueR) throws SQLException, Exception 
	{

		String sql = "DELETE FROM BUQUE_RORO";
		sql += " WHERE id = " + buqueR.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}