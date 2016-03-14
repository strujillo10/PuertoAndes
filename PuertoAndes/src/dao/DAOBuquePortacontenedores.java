package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.Bodega;
import vos.Buque;
import vos.BuquePortaContenedores;
import vos.BuqueRoro;

public class DAOBuquePortacontenedores 
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
	public DAOBuquePortacontenedores() 
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
	public ArrayList<BuquePortaContenedores> darBuquesP() throws SQLException, Exception 
	{
		ArrayList<BuquePortaContenedores> buqueP = new ArrayList<BuquePortaContenedores>();

		String sql = "SELECT * FROM BUQUE_PORTACONTENEDORES";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			String nombre = rs.getString("NOMRE");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TEUS"));
			String procedencia = rs.getString("PROCEDENCIA");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			Time horaLlegada = rs.getTime("HORA_LLEGADA");
			Time horaSalida = rs.getTime("HORA_SALIDA");
			String destino = rs.getString("DESTINO");
			int buqueId = Integer.parseInt(rs.getString("BUQUE_ID"));
			buqueP.add(new BuquePortaContenedores(id, nombre, capacidad, procedencia, fechaLlegada, fechaSalida, horaLlegada, horaSalida, destino, buqueId));
		}
		return buqueP;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<BuquePortaContenedores> buscarBuquePPorId(int id) throws SQLException, Exception 
	{
		ArrayList<BuquePortaContenedores> buqueP = new ArrayList<BuquePortaContenedores>();

		String sql = "SELECT * FROM BUQUE_PORTACONTENEDORES WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			String nombre = rs.getString("NOMRE");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TEUS"));
			String procedencia = rs.getString("PROCEDENCIA");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaSalida = rs.getDate("FECHA_SALIDA");
			Time horaLlegada = rs.getTime("HORA_LLEGADA");
			Time horaSalida = rs.getTime("HORA_SALIDA");
			String destino = rs.getString("DESTINO");
			int buqueId = Integer.parseInt(rs.getString("BUQUE_ID"));
			buqueP.add(new BuquePortaContenedores(id2, nombre, capacidad, procedencia, fechaLlegada, fechaSalida, horaLlegada, horaSalida, destino, buqueId));
		}
		return buqueP;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addBuqueP(BuquePortaContenedores buqueP) throws SQLException, Exception 
	{
		String sql = "INSERT INTO BUQUE_PORTACONTENEDORES VALUES (";
		sql += buqueP.getId() + ",'";
		sql += buqueP.getNombre() + ",'";
		sql += buqueP.getCapacidad() + ",'";
		sql += buqueP.getRegistroCapitania() + ",'";
		sql += buqueP.getProcedencia() + ",'";
		sql += buqueP.getFechaLlegada() + ",'";
		sql += buqueP.getFechaSalida() + ",'";
		sql += buqueP.getAgenciaMaritima() + ",'";
		sql += buqueP.getHoraLlegada() + ",'";
		sql += buqueP.getHoraSalida() + ",'";
		sql += buqueP.getCantidadContenedores() + ",'";
		sql += buqueP.getDestino() + ",'";
		sql += buqueP.getBuqueId() + ")";

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
	public void updateBuqueP(BuquePortaContenedores buqueP) throws SQLException, Exception 
	{
		String sql = "UPDATE BUQUE_PORTACONTENEDORES SET ";
		sql += "nomre='" + buqueP.getNombre() + "',";
		sql += "capacidad_en_teus='" + buqueP.getCapacidad() + "',";
		sql += "registro_de_capitania='" + buqueP.getRegistroCapitania() + "',";
		sql += "procedencia='" + buqueP.getProcedencia() + "',";
		sql += "fecha_llegada='" + buqueP.getFechaLlegada() + "',";
		sql += "fecha_salida='" + buqueP.getFechaSalida() + "',";
		sql += "agencia_maritima='" + buqueP.getAgenciaMaritima() + "',";
		sql += "hora_llegada='" + buqueP.getHoraLlegada() + "',";
		sql += "hora_salida='" + buqueP.getHoraSalida() + "',";
		sql += "cantidad_de_contenedores='" + buqueP.getNombre() + "',";
		sql += "destino='" + buqueP.getDestino() + "',";
		sql += "buque_id='" + buqueP.getBuqueId() + "',";
		sql += " WHERE id = " + buqueP.getId();

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
	public void deleteBuqueP(BuquePortaContenedores buqueP) throws SQLException, Exception 
	{

		String sql = "DELETE FROM BUQUE_PORTACONTENEDORES";
		sql += " WHERE id = " + buqueP.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
