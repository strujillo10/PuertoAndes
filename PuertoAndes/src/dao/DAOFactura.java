package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Factura;

public class DAOFactura 
{
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
	public DAOFactura() 
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
	public ArrayList<Factura> darFacturas() throws SQLException, Exception 
	{
		ArrayList<Factura> facturas = new ArrayList<Factura>();

		String sql = "SELECT * FROM FACTURA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID"));
			int idCamion = Integer.parseInt(rs.getString("ID_CAMION_USADO"));
			int idBuque = Integer.parseInt(rs.getString("ID_BUQUE_USADO"));
			int numEquipos = Integer.parseInt(rs.getString("NUMERO_EQUIPOS_USADOS"));
			int espacio = Integer.parseInt(rs.getString("ESPACIO_USADO"));
			int numDias = Integer.parseInt(rs.getString("NUMERO_DIAS"));
			int costo = Integer.parseInt(rs.getString("COSTO_TOTAL"));	
			facturas.add(new Factura(id, idCamion, idBuque, numEquipos, espacio, numDias, costo));
		}
		return facturas;
	}

	/**
	 * M�todo que busca el/los Almacen con el nombre que entra como par�metro.
	 * @param name - Nombre de el/los almacenes a buscar
	 * @return Arraylist con los almacenes encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Factura> buscarFacturaPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Factura> facturas = new ArrayList<Factura>();

		String sql = "SELECT * FROM FACTURA WHERE ID ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID"));
			int idCamion = Integer.parseInt(rs.getString("ID_CAMION_USADO"));
			int idBuque = Integer.parseInt(rs.getString("ID_BUQUE_USADO"));
			int numEquipos = Integer.parseInt(rs.getString("NUMERO_EQUIPOS_USADOS"));
			int espacio = Integer.parseInt(rs.getString("ESPACIO_USADO"));
			int numDias = Integer.parseInt(rs.getString("NUMERO_DIAS"));
			int costo = Integer.parseInt(rs.getString("COSTO_TOTAL"));	
			facturas.add(new Factura(id2, idCamion, idBuque, numEquipos, espacio, numDias, costo));
		}
		return facturas;
	}

	/**
	 * M�todo que agrega el video que entra como par�metro a la base de datos.
	 * @param almacen - el almacen a agregar. almacen !=  null
	 * <b> post: </b> se ha agregado el almacen a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addFactura(Factura factura) throws SQLException, Exception 
	{
		String sql = "INSERT INTO FACTURA VALUES (";
		sql += factura.getId() + ",'";
		sql += factura.getIdCamion() + ",'";
		sql += factura.getIdBuque() + ",'";
		sql += factura.getNumEquipos() + ",'";
		sql += factura.getEspacio() + ",'";
		sql += factura.getNumDias() + ",'";
		sql += factura.getCostoTotal() + ")";

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
	public void updateFactura(Factura factura) throws SQLException, Exception 
	{
		String sql = "UPDATE FACTURA SET ";
		sql += "id_camion_usado='" + factura.getIdCamion() + "',";
		sql += "id_buque_usado='" + factura.getIdBuque() + "',";
		sql += "numero_equipos_usados='" + factura.getNumEquipos() + "',";
		sql += "espacio_usado='" + factura.getEspacio() + "',";
		sql += "numero_dias='" + factura.getNumDias() + "',";
		sql += "costo_total='" + factura.getCostoTotal() + "',";
		sql += " WHERE id = " + factura.getId();

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
	public void deleteFactura(Factura factura) throws SQLException, Exception 
	{

		String sql = "DELETE FROM FACTURA";
		sql += " WHERE id = " + factura.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}

