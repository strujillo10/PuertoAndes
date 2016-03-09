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
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Método constructor que crea DAOFactura
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOFactura() 
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
	 * <b>SQL Statement:</b> SELECT * FROM FACTURA;
	 * @return Arraylist con los facturas de la base de datos.
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
			String medio = rs.getString("MEDIO_TRANSPORTE");
			int id = Integer.parseInt(rs.getString("ID_FACTURA"));
			int numEquip = Integer.parseInt(rs.getString("NUM_EQUIPOS"));
			int numDias = Integer.parseInt(rs.getString("NUM_DIAS"));
			int espacio= Integer.parseInt(rs.getString("ESPACIO_USADO"));
			int costo = Integer.parseInt(rs.getString("COSTO_TOTAL"));
			facturas.add(new Factura(id, medio, numEquip, espacio, numDias, costo));
		}
		return facturas;
	}

	/**
	 * Método que busca el/los Factura con el id que entra como parámetro.
	 * @param id - Id de el/los facturas a buscar
	 * @return Arraylist con los facturas encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Factura> buscarFacturaPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Factura> facturas = new ArrayList<Factura>();

		String sql = "SELECT * FROM FACTURA WHERE ID_FACTURA ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			String medio = rs.getString("MEDIO_TRANSPORTE");
			int id2 = Integer.parseInt(rs.getString("ID_FACTURA"));
			int numEquip = Integer.parseInt(rs.getString("NUM_EQUIPOS"));
			int numDias = Integer.parseInt(rs.getString("NUM_DIAS"));
			int espacio= Integer.parseInt(rs.getString("ESPACIO_USADO"));
			int costo = Integer.parseInt(rs.getString("COSTO_TOTAL"));
			facturas.add(new Factura(id2, medio, numEquip, espacio, numDias, costo));
		}
		return facturas;
	}

	/**
	 * Método que agrega el factura que entra como parámetro a la base de datos.
	 * @param factura - el factura a agregar. factura !=  null
	 * <b> post: </b> se ha agregado el factura a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el factura baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addFactura(Factura factura) throws SQLException, Exception 
	{
		String sql = "INSERT INTO FACTURA (";
		sql += factura.getIdFactura() + ",'";
		sql += factura.getMedioTransporte() + ",'";
		sql += factura.getNumEquipos() + ",'";
		sql += factura.getEspacio() + ",'";
		sql += factura.getNumDias() + "',";
		sql += factura.getCostoTotal() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el factura que entra como parámetro en la base de datos.
	 * @param factura - el factura a actualizar. factura !=  null
	 * <b> post: </b> se ha actualizado el factura en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateFactura(Factura factura) throws SQLException, Exception 
	{
		String sql = "UPDATE FACTURA SET ";
		sql += "medio_transporte='" + factura.getMedioTransporte() + "',";
		sql += "num_equipos='" + factura.getNumEquipos() + "',";
		sql += "espacio_usado='" + factura.getEspacio() + "',";
		sql += "num_dias='" + factura.getNumDias() + "',";
		sql += "costo_total=" + factura.getCostoTotal();
		sql += " WHERE id_factura = " + factura.getIdFactura();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el factura que entra como parámetro en la base de datos.
	 * @param factura - el factura a borrar. factura !=  null
	 * <b> post: </b> se ha borrado el factura en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteFactura(Factura factura) throws SQLException, Exception 
	{

		String sql = "DELETE FROM FACTURA";
		sql += " WHERE id_factura = " + factura.getIdFactura();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
