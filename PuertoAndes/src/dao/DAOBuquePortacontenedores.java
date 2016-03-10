package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Bodega;

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
	public ArrayList<Bodega> darBodegas() throws SQLException, Exception 
	{
		ArrayList<Bodega> bodegas = new ArrayList<Bodega>();

		String sql = "SELECT * FROM BODEGAS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idArea = Integer.parseInt(rs.getString("ID_AREA"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			String plataforma = rs.getString("PLATAFORMA_EXTERNA");
			int cantidad = Integer.parseInt(rs.getString("CANTIDAD_DE_CUARTOS_FRIOS"));
			int separacion = Integer.parseInt(rs.getString("SEPARACION_ENTRE_COLUMNAS"));
			int ancho = Integer.parseInt(rs.getString("ANCHO_EN_METROS"));
			int largo = Integer.parseInt(rs.getString("LARGO_EN_METROS"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			bodegas.add(new Bodega(id, idArea, ocupacion, plataforma, cantidad, separacion, ancho, largo, capacidad));
		}
		return bodegas;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Bodega> buscarBodegaPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Bodega> bodegas = new ArrayList<Bodega>();

		String sql = "SELECT * FROM BODEGAS WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			int idArea = Integer.parseInt(rs.getString("ID_AREA"));
			int ocupacion = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			String plataforma = rs.getString("PLATAFORMA_EXTERNA");
			int cantidad = Integer.parseInt(rs.getString("CANTIDAD_DE_CUARTOS_FRIOS"));
			int separacion = Integer.parseInt(rs.getString("SEPARACION_ENTRE_COLUMNAS"));
			int ancho = Integer.parseInt(rs.getString("ANCHO_EN_METROS"));
			int largo = Integer.parseInt(rs.getString("LARGO_EN_METROS"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			bodegas.add(new Bodega(id2, idArea, ocupacion, plataforma, cantidad, separacion, ancho, largo, capacidad));
		}
		return bodegas;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addBodega(Bodega bodega) throws SQLException, Exception 
	{
		String sql = "INSERT INTO BODEGAS VALUES (";
		sql += bodega.getId() + ",'";
		sql += bodega.getIdArea() + "',";
		sql += bodega.getOcupacionTotal() + "',";
		sql += bodega.getPlataformaExterna() + "',";
		sql += bodega.getCantidadCuartosFrios() + "',";
		sql += bodega.getSeparacionColumnas() + "',";
		sql += bodega.getAncho() + "',";
		sql += bodega.getLargo() + "',";
		sql += bodega.getCapacidad() + ")";

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
	public void updateBodega(Bodega bodega) throws SQLException, Exception 
	{
		String sql = "UPDATE BODEGAS SET ";
		sql += "id_area='" + bodega.getIdArea() + "',";
		sql += "ocupacion_actual='" + bodega.getOcupacionTotal() + "',";
		sql += "plataforma_externa='" + bodega.getPlataformaExterna() + "',";
		sql += "cantidad_de_cuartos_frios='" + bodega.getCantidadCuartosFrios() + "',";
		sql += "separacion_entre_columnas='" + bodega.getSeparacionColumnas() + "',";
		sql += "ancho_en_metros='" + bodega.getAncho() + "',";
		sql += "largo_en_metros='" + bodega.getLargo() + "',";
		sql += "capacidad=" + bodega.getCapacidad();
		sql += " WHERE id = " + bodega.getId();

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
	public void deleteBodega(Bodega bodega) throws SQLException, Exception 
	{

		String sql = "DELETE FROM BODEGAS";
		sql += " WHERE id = " + bodega.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}