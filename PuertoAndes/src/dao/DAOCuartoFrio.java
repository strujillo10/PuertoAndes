package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.CuartoFrio;
import vos.EquipoApoyo;

public class DAOCuartoFrio 
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
	public DAOCuartoFrio() 
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
	public ArrayList<CuartoFrio> darCuartos() throws SQLException, Exception 
	{
		ArrayList<CuartoFrio> cuartos = new ArrayList<CuartoFrio>();

		String sql = "SELECT * FROM CUARTOS_FRIOS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idBodega = Integer.parseInt(rs.getString("ID_BODEGA"));
			String area = rs.getString("AREA");
			String dimensiones = rs.getString("DIMENSIONES");
			String areaUtilizada = rs.getString("AREA_UTILIZADA");
			cuartos.add(new CuartoFrio(id, idBodega, area, dimensiones, areaUtilizada));
		}
		return cuartos;
	}

	/**
	 * Método que busca el/los Almacen con el nombre que entra como parámetro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<CuartoFrio> buscarCuartoPorId(int id) throws SQLException, Exception 
	{
		ArrayList<CuartoFrio> cuartos = new ArrayList<CuartoFrio>();

		String sql = "SELECT * FROM CUARTOS_FRIOS WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			int idBodega = Integer.parseInt(rs.getString("ID_BODEGA"));
			String area = rs.getString("AREA");
			String dimensiones = rs.getString("DIMENSIONES");
			String areaUtilizada = rs.getString("AREA_UTILIZADA");
			cuartos.add(new CuartoFrio(id2, idBodega, area, dimensiones, areaUtilizada));
		}
		return cuartos;
	}

	/**
	 * Método que agrega el video que entra como parámetro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addCuarto(CuartoFrio cuarto) throws SQLException, Exception 
	{
		String sql = "INSERT INTO CUARTOS_FRIOS VALUES (";
		sql += cuarto.getId() + ",'";
		sql += cuarto.getIdBodega() + ",'";
		sql += cuarto.getArea() + ",'";
		sql += cuarto.getDimensiones() + ",'";
		sql += cuarto.getAreaUtilizada() + ")";

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
	public void updateCuarto(CuartoFrio cuarto) throws SQLException, Exception 
	{
		String sql = "UPDATE CUARTOS_FRIOS SET ";
		sql += "id_bodega='" + cuarto.getIdBodega() + "',";
		sql += "area='" + cuarto.getArea() + "',";
		sql += "dimensiones='" + cuarto.getDimensiones() + "',";
		sql += "area_utilizada='" + cuarto.getAreaUtilizada() + "',";
		sql += " WHERE id = " + cuarto.getId();

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
	public void deleteCuarto(CuartoFrio cuarto) throws SQLException, Exception 
	{

		String sql = "DELETE FROM CUARTOS_FRIOS";
		sql += " WHERE id = " + cuarto.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}