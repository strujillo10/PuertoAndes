package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.RFC1;
import vos.RFC2;

public class DAORFC2 
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
	public DAORFC2() 
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
	public ArrayList<RFC2> darRFC2s() throws SQLException, Exception 
	{
		ArrayList<RFC2> rfc2 = new ArrayList<RFC2>();

		String sql = "Select e.* , i.tipo AS TIPO_DE_CARGA "
					+ "From( "
					+ "(select Nombre, RUT,ID_USUARIO , count(*) as cantidad_de_veces "
					+ "from exportador "
					+ "group by id_usuario, NOMBRE, RUT) e "
					+ "left  join "
					+ "(select a.ID_BUQUE, a.ID_CARGA, b.tipo, e.ID_USUARIO " 
					+ "from (carga_en_buque a inner join carga b on a.ID_CARGA = b.ID) " 
					+ "inner join BUQUE_DE_EXPORTADOR e on e.ID_BUQUE = a.ID_BUQUE) i "
					+ "on e.ID_USUARIO = i.ID_USUARIO "
					+ ") ";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			String nNombre = rs.getString("NOMBRE");
			int nRut = Integer.parseInt(rs.getString("RUT"));
			int nId = Integer.parseInt(rs.getString("ID_USUARIO"));
			int nCantidad = Integer.parseInt(rs.getString("CANTIDAD_DE_VECES"));
			String nTipo = rs.getString("TIPO_DE_CARGA");
			rfc2.add(new RFC2(nNombre, nRut, nCantidad, nTipo, nId));
		}
		return rfc2;
	}
}
