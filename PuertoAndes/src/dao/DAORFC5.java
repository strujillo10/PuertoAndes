package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.RFC5;
import vos.RFC6;

public class DAORFC5 
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
	public DAORFC5() 
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
	public ArrayList<RFC5> darRFC5s() throws SQLException, Exception 
	{
		ArrayList<RFC5> rfc5 = new ArrayList<RFC5>();

		String sql = "select m.*, c.TIPO, C. PESO, C.DESTINO AS CIUDAD_DESTINO from MOVIMIENTOS m left OUTER JOIN CARGA c on m.ID_CARGA_MOVIDA = c.ID";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) 
		{
			int pId = Integer.parseInt(rs.getString("ID"));
			String pOrigen = rs.getString("ORIGEN");
			String pDestino = rs.getString("DESTINO");
			int pIdOrigen = Integer.parseInt(rs.getString("ID_ORIGEN"));
			int pIdDestino = Integer.parseInt(rs.getString("ID_DESTINO"));
			Date nFechaOrden = rs.getDate("FECHA_ORDEN");
			Date nFechaRealizacion = rs.getDate("FECHA_REALIZACION");
			int pidCarga = Integer.parseInt(rs.getString("ID_CARGA_MOVIDA"));
			String pTipo = rs.getString("TIPO");
			int pPeso = Integer.parseInt(rs.getString("PESO"));
			String pCiudadDestino = rs.getString("CIUDAD_DESTINO");
			RFC5 aAgregar = new RFC5(pId, pOrigen, pDestino, pIdOrigen, pIdDestino, nFechaOrden, nFechaRealizacion, pidCarga, pTipo, pPeso, pCiudadDestino);
			rfc5.add(aAgregar);
			
		}
		return rfc5;
	}
}
