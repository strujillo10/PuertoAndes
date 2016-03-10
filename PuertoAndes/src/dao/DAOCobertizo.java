package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Carga;
import vos.Cobertizo;

public class DAOCobertizo 
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
	public DAOCobertizo() 
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
	public ArrayList<Cobertizo> darCobertizos() throws SQLException, Exception 
	{
		ArrayList<Cobertizo> cobertizos = new ArrayList<Cobertizo>();

		String sql = "SELECT * FROM COBERTIZOS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idArea = Integer.parseInt(rs.getString("ID_AREA"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			String dimension = rs.getString("DIMENSION");
			String tipo = rs.getString("TIPO_DE_CARGA");
			cobertizos.add(new Cobertizo(id, idArea, capacidad, ocupacion, dimension, tipo));
		}
		return cobertizos;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Cobertizo> buscarCobertizoPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Cobertizo> cobertizos = new ArrayList<Cobertizo>();

		String sql = "SELECT * FROM COBERTIZOS WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			int idArea = Integer.parseInt(rs.getString("ID_AREA"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			String dimension = rs.getString("DIMENSION");
			String tipo = rs.getString("TIPO_DE_CARGA");
			cobertizos.add(new Cobertizo(id2, idArea, capacidad, ocupacion, dimension, tipo));
		}
		return cobertizos;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addCobertizo(Cobertizo cobertizo) throws SQLException, Exception 
	{
		String sql = "INSERT INTO COBERTIZOS VALUES (";
		sql += cobertizo.getId() + ",'";
		sql += cobertizo.getIdArea() + ",'";
		sql += cobertizo.getCapacidad() + ",'";
		sql += cobertizo.getOcupacionTotal() + ",'";
		sql += cobertizo.getDimensionTotal() + ",'";
		sql += cobertizo.getTipoCarga() + ")";

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
	public void updateCobertizo(Cobertizo cobertizo) throws SQLException, Exception 
	{
		String sql = "UPDATE COBERTIZOS SET ";
		sql += "id_area='" + cobertizo.getIdArea() + "',";
		sql += "capacidad='" + cobertizo.getCapacidad() + "',";
		sql += "ocupacion_actual='" + cobertizo.getOcupacionTotal() + "',";
		sql += "dimension='" + cobertizo.getDimensionTotal() + "',";
		sql += "tipo_de_carga='" + cobertizo.getTipoCarga() + "',";
		sql += " WHERE id = " + cobertizo.getId();

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
	public void deleteCobertizo(Cobertizo cobertizo) throws SQLException, Exception 
	{

		String sql = "DELETE FROM COBERTIZOS";
		sql += " WHERE id = " + cobertizo.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}