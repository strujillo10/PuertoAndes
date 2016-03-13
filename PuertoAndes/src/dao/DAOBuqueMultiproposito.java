package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.Buque;
import vos.BuqueMultiproposito;
import vos.BuquePortaContenedores;

public class DAOBuqueMultiproposito {
	/**
	 * Arraylits de recursos que se usan para la ejecuci�n de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexi�n a la base de datos
	 */
	private Connection conn;

	/**
	 * M�todo constructor que crea DAOAlmacen
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOBuqueMultiproposito() 
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
	 * M�todo que, usando la conexi�n a la base de datos, saca todos los almacenes de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM ALMACEN;
	 * @return Arraylist con los almacenes de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<BuqueMultiproposito> darBuquesM() throws SQLException, Exception 
	{
		ArrayList<BuqueMultiproposito> buqueM = new ArrayList<BuqueMultiproposito>();

		String sql = "SELECT * FROM BUQUE_MULTIPROPOSITO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String nombre = rs.getString("NOMRE");
			String tipo = rs.getString("TIPO_DE_CARGA");
			String procedencia = rs.getString("PROCEDENCIA");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			Time horaLlegada = rs.getTime("HORA_LLEGADA");
			Time horaSalida = rs.getTime("HORA_SALIDA");
			String destino = rs.getString("DESTINO");
			int buqueId = Integer.parseInt(rs.getString("BUQUE_ID"));
			buqueM.add(new BuqueMultiproposito(id, nombre, tipo, procedencia, fechaLlegada, fechaSalida, procedencia, horaLlegada, horaSalida, destino, buqueId));
		}
		return buqueM;
	}

	/**
	 * M�todo que busca el/los Almacen con el nombre que entra como par�metro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<BuqueMultiproposito> buscarBuqueMPorId(int id) throws SQLException, Exception 
	{
		ArrayList<BuqueMultiproposito> buqueM = new ArrayList<BuqueMultiproposito>();

		String sql = "SELECT * FROM BUQUE_MULTIPROPOSITO WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			String nombre = rs.getString("NOMRE");
			String tipo = rs.getString("TIPO_DE_CARGA");

			String procedencia = rs.getString("PROCEDENCIA");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			Time horaLlegada = rs.getTime("HORA_LLEGADA");
			Time horaSalida = rs.getTime("HORA_SALIDA");
			String destino = rs.getString("DESTINO");

			int buqueId = Integer.parseInt(rs.getString("BUQUE_ID"));
			buqueM.add(new BuqueMultiproposito(id2, nombre, tipo, procedencia, fechaLlegada, fechaSalida, procedencia, horaLlegada, horaSalida, destino, buqueId));
		}
		return buqueM;
	}

	/**
	 * M�todo que agrega el video que entra como par�metro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addBuqueM(BuqueMultiproposito buqueP) throws SQLException, Exception 
	{
		String sql = "INSERT INTO BUQUE_PORTACONTENEDORES VALUES (";
		sql += buqueP.getId() + ",'";
		sql += buqueP.getNombre() + ",'";
		sql += buqueP.getTipoCarga() + ",'";
		sql += buqueP.getProcedencia() + ",'";
		sql += buqueP.getFechaLlegada() + ",'";
		sql += buqueP.getFechaSalida() + ",'";
		sql += buqueP.getHoraLlegada() + ",'";
		sql += buqueP.getHoraSalida() + ",'";
		sql += buqueP.getDestino() + ",'";
		sql += buqueP.getBuqueId() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * M�todo que actualiza el almacen que entra como par�metro en la base de datos.
	 * @param almacen - el almacen a actualizar. almacen !=  null
	 * <b> post: </b> se ha actualizado el almacen en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateBuqueM(BuqueMultiproposito buqueP) throws SQLException, Exception 
	{
		String sql = "UPDATE BUQUE_PORTACONTENEDORES SET ";
		sql += "nomre='" + buqueP.getNombre() + "',";
		sql += "tipo_de_carga='" + buqueP.getTipoCarga() + "',";
		sql += "procedencia='" + buqueP.getProcedencia() + "',";
		sql += "fecha_llegada='" + buqueP.getFechaLlegada() + "',";
		sql += "fecha_salida='" + buqueP.getFechaSalida() + "',";
		sql += "hora_llegada='" + buqueP.getHoraLlegada() + "',";
		sql += "hora_salida='" + buqueP.getHoraSalida() + "',";
		sql += "destino='" + buqueP.getDestino() + "',";
		sql += " WHERE id = " + buqueP.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * M�todo que elimina el almacen que entra como par�metro en la base de datos.
	 * @param almacen - el almacen a borrar. almacen !=  null
	 * <b> post: </b> se ha borrado el almacen en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteBuqueM(BuqueMultiproposito buqueP) throws SQLException, Exception 
	{

		String sql = "DELETE FROM BUQUE_PORTACONTENEDORES";
		sql += " WHERE id = " + buqueP.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}