package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Maquinaria;

public class DAOMaquinaria 
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
	 * M�todo constructor que crea DAOMaquinaria
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOMaquinaria() 
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
	 * M�todo que, usando la conexi�n a la base de datos, saca todos las maquinarias de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM MAQUINARIA;
	 * @return Arraylist con las maquinarias de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Maquinaria> darMaquinarias() throws SQLException, Exception 
	{
		ArrayList<Maquinaria> maquinarias = new ArrayList<Maquinaria>();

		String sql = "SELECT * FROM MAQUINARIA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = Integer.parseInt(rs.getString("ID_MAQUINA"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			int cantidad = Integer.parseInt(rs.getString("CANTIDAD"));
			String tipo = rs.getString("TIPO");
			int idPuerto = Integer.parseInt(rs.getString("ID_PUERTO"));
			int idOperador = Integer.parseInt(rs.getString("ID_OPERADOR"));
			maquinarias.add(new Maquinaria(id, capacidad, cantidad, tipo, idPuerto, idOperador));
		}
		return maquinarias;
	}

	/**
	 * M�todo que busca el/los Maquinaria con el id que entra como par�metro.
	 * @param id - Id de el/los maquinarias a buscar
	 * @return Arraylist con los maquinarias encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Maquinaria> buscarMaquinariaPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Maquinaria> maquinarias = new ArrayList<Maquinaria>();

		String sql = "SELECT * FROM MAQUINARIA WHERE ID_MAQUINA ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int id2 = Integer.parseInt(rs.getString("ID_MAQUINA"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			int cantidad = Integer.parseInt(rs.getString("CANTIDAD"));
			String tipo = rs.getString("TIPO");
			int idPuerto = Integer.parseInt(rs.getString("ID_PUERTO"));
			int idOperador = Integer.parseInt(rs.getString("ID_OPERADOR"));
			maquinarias.add(new Maquinaria(id2, capacidad, cantidad, tipo, idPuerto, idOperador));
		}
		return maquinarias;
	}

	/**
	 * M�todo que agrega el maquinaria que entra como par�metro a la base de datos.
	 * @param maquinaria - el maquinaria a agregar. maquinaria !=  null
	 * <b> post: </b> se ha agregado el maquinaria a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el maquinaria baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addMaquinaria(Maquinaria maquinaria) throws SQLException, Exception 
	{
		String sql = "INSERT INTO MAQUINARIA (";
		sql += maquinaria.getIdMaquina() + ",'";
		sql += maquinaria.getCapacidad() + ",'";
		sql += maquinaria.getCantidad() + ",'";
		sql += maquinaria.getTipo() + ",'";
		sql += maquinaria.getIdPuerto() + "',";
		sql += maquinaria.getIdOperador() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * M�todo que actualiza el maquinaria que entra como par�metro en la base de datos.
	 * @param maquinaria - el maquinaria a actualizar. maquinaria !=  null
	 * <b> post: </b> se ha actualizado el maquinaria en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateMaquinaria(Maquinaria maquinaria) throws SQLException, Exception 
	{
		String sql = "UPDATE MAQUINARIA SET ";
		sql += "capacidad='" + maquinaria.getCapacidad() + "',";
		sql += "cantidad='" + maquinaria.getCantidad() + "',";
		sql += "tipo='" + maquinaria.getTipo() + "',";
		sql += "id_puerto='" + maquinaria.getIdPuerto() + "',";
		sql += "id_operador=" + maquinaria.getIdOperador();
		sql += " WHERE id_maquina = " + maquinaria.getIdMaquina();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * M�todo que elimina el maquinaria que entra como par�metro en la base de datos.
	 * @param maquinaria - el maquinaria a borrar. maquinaria !=  null
	 * <b> post: </b> se ha borrado el maquinaria en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteMaquinaria(Maquinaria maquinaria) throws SQLException, Exception 
	{

		String sql = "DELETE FROM MAQUINARIA";
		sql += " WHERE id_maquina = " + maquinaria.getIdMaquina();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}