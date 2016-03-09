package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Operador;

public class DAOOperador 
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
	 * Método constructor que crea DAOOperador
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOOperador() 
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
	 * Método que, usando la conexión a la base de datos, saca todos los operadores de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM OPERADOR;
	 * @return Arraylist con los operadores de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Operador> darOperadores() throws SQLException, Exception 
	{
		ArrayList<Operador> operadores = new ArrayList<Operador>();

		String sql = "SELECT * FROM OPERADOR";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String name = rs.getString("NOMBRE");
			int idOperador = Integer.parseInt(rs.getString("ID_OPERADOR"));
			String operacion = rs.getString("OPERACION");
			operadores.add(new Operador(idOperador, name, operacion));
		}
		return operadores;
	}

	/**
	 * Método que busca el/los Operador con el id que entra como parámetro.
	 * @param id - Id de el/los operadores a buscar
	 * @return Arraylist con los operadores encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Operador> buscarOperadorPorId(int id) throws SQLException, Exception 
	{
		ArrayList<Operador> operadores = new ArrayList<Operador>();

		String sql = "SELECT * FROM OPERADOR WHERE ID_OPERADOR ='" + id + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("NOMBRE");
			int idOperador = Integer.parseInt(rs.getString("ID_OPERADOR"));
			String operacion = rs.getString("OPERACION");
			operadores.add(new Operador(idOperador, name, operacion));
		}
		return operadores;
	}

	/**
	 * Método que agrega el operador que entra como parámetro a la base de datos.
	 * @param operador - el operador a agregar. operador !=  null
	 * <b> post: </b> se ha agregado el operador a la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que el operador baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addOperador(Operador operador) throws SQLException, Exception 
	{
		String sql = "INSERT INTO OPERADOR (";
		sql += operador.getIdOperador() + ",'";
		sql += operador.getNombre() + "',";
		sql += operador.getOperacion() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Método que actualiza el maquinaria que entra como parámetro en la base de datos.
	 * @param Operador - el operador a actualizar. operador !=  null
	 * <b> post: </b> se ha actualizado el operador en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updateOperador(Operador operador) throws SQLException, Exception 
	{
		String sql = "UPDATE OPERADOR SET ";
		sql += "nombre='" + operador.getNombre() + "',";
		sql += "operacion=" + operador.getOperacion();
		sql += " WHERE id_operador = " + operador.getIdOperador();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Método que elimina el operador que entra como parámetro en la base de datos.
	 * @param operador - el operador a borrar. operador !=  null
	 * <b> post: </b> se ha borrado el operador en la base de datos en la transaction actual. pendiente que el puerto master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteOperador(Operador operador) throws SQLException, Exception 
	{

		String sql = "DELETE FROM OPERADOR";
		sql += " WHERE id = " + operador.getIdOperador();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}