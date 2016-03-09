package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Buque;

public class DAOBuque 
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
	 * Método constructor que crea DAOBuque
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOBuque() 
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
	 * <b>SQL Statement:</b> SELECT * FROM BUQUE;
	 * @return Arraylist con los buques de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Buque> darBuques() throws SQLException, Exception 
	{
		ArrayList<Buque> buques = new ArrayList<Buque>();

		String sql = "SELECT * FROM BUQUE";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID_BUQUE"));
			int regis = Integer.parseInt(rs.getString("REGISTRO_CAP"));
			String name = rs.getString("NOMBRE_PUERTO");
			String nameAgen = rs.getString("NOMBRE_AGENTE");
			String tipo = rs.getString("TIPO");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			int capacidadCont = Integer.parseInt(rs.getString("CAPACIDAD_CONTENEDORES"));
			int carga = Integer.parseInt(rs.getString("CARGA"));
			buques.add(new Buque(id, regis, name, nameAgen, tipo, capacidad, capacidadCont, carga));
		}
		return buques;
	}

	/**
	 * Método que busca el/los Buque con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los buques a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Buque> buscarBuquePorId(int id) throws SQLException, Exception 
	{
		ArrayList<Buque> buques = new ArrayList<Buque>();

		String sql = "SELECT * FROM BUQUE WHERE ID_BUQUE ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID_BUQUE"));
			int regis = Integer.parseInt(rs.getString("REGISTRO_CAP"));
			String name = rs.getString("NOMBRE_PUERTO");
			String nameAgen = rs.getString("NOMBRE_AGENTE");
			String tipo = rs.getString("TIPO");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			int capacidadCont = Integer.parseInt(rs.getString("CANTIDAD_CONTENEDORES"));
			int carga = Integer.parseInt(rs.getString("CARGA"));
			buques.add(new Buque(id2, regis, name, nameAgen, tipo, capacidad, capacidadCont, carga));
		}

		return buques;
	}

	/**
	 * Método que agrega el buque que entra como parámetro a la base de datos.
	 * @param buque - el buque a agregar. buque !=  null
	 * <b> post: </b> se ha agregado el buque a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el buque baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addBuque(Buque buque) throws SQLException, Exception 
	{
		String sql = "INSERT INTO BUQUE (";
		sql += buque.getIdBuque() + ",'";
		sql += buque.getRegistro() + ",'";
		sql += buque.getNombreBuque() + ",'";
		sql += buque.getNombreAgente() + ",'";
		sql += buque.getTipo() + ",'";
		sql += buque.getCapacidad() + ",'";
		sql += buque.getCantidadContenedores() + ",'";
		sql += buque.getCarga() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el buque que entra como parámetro en la base de datos.
	 * @param buque - el buque a actualizar. buque !=  null
	 * <b> post: </b> se ha actualizado el buque en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateBuque(Buque buque) throws SQLException, Exception 
	{
		String sql = "UPDATE BUQUE SET ";
		sql += "registro_cap='" + buque.getRegistro() + "',";
		sql += "nombre_buque='" + buque.getNombreBuque() + "',";
		sql += "nombre_agente='" + buque.getNombreAgente() + "',";
		sql += "tipo='" + buque.getTipo() + "',";
		sql += "capacidad='" + buque.getCapacidad() + "',";
		sql += "cantidad_contenedores='" + buque.getCantidadContenedores() + "',";
		sql += "carga='" + buque.getCarga() + "',";
		sql += " WHERE id_buque = " + buque.getIdBuque();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el buque que entra como parámetro en la base de datos.
	 * @param buque - el buque a borrar. buque !=  null
	 * <b> post: </b> se ha borrado el buque en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteBuque(Buque buque) throws SQLException, Exception 
	{

		String sql = "DELETE FROM BUQUE";
		sql += " WHERE id_buque = " + buque.getIdBuque();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
