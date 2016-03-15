package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.RFC1;

public class DAORFC1 
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
	public DAORFC1() 
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
	public ArrayList<RFC1> darRFC1s() throws SQLException, Exception 
	{
		ArrayList<RFC1> rfc1 = new ArrayList<RFC1>();

		String sql = "Select ID, NOMBRE, REGISTRO_DE_CAPITANIA, "
				+ "AGENCIA_MARITIMA, CANTIDAD_DE_CONTENEDORES, DESTINO,"
				+ " FECHA_LLEGADA, FECHA_SALIDA, HORA_LLEGADA,HORA_SALIDA, "
				+ "PROCEDENCIA, CAPACIDAD_EN_TEUS "
				+ "From( "
				+ " (Select b.*, m.DESTINO, m.FECHA_LLEGADA, m.FECHA_SALIDA, m.HORA_LLEGADA,m.HORA_SALIDA,m.PROCEDENCIA, 0 as CAPACIDAD_EN_TEUS "
				+ "From BUQUE_MULTIPROPOSITO m, buque b "
				+ "where m.BUQUE_ID = b.id) " 
				+ "UNION "
				+ "(Select b.*, r.DESTINO, r.FECHA_LLEGADA, r.FECHA_SALIDA, r.HORA_LLEGADA, r.HORA_SALIDA, r.PROCEDENCIA, 0 as CAPACIDAD_EN_TEUS " 
				+ "From BUQUE_RORO r,buque b " 
				+ "where r.BUQUE_ID = b.id AND r.NOMRE = b.NOMBRE) " 
				+ "UNION "
				+ "(Select b.*, p.DESTINO, p.FECHA_LLEGADA, p.FECHA_SALIDA, p.HORA_LLEGADA, p.HORA_SALIDA, p.PROCEDENCIA, p.CAPACIDAD_EN_TEUS as CAPACIDAD_EN_TEUS "
				+ "From BUQUE_PORTACONTENEDORES p, buque b "
				+ "where p.BUQUE_ID = b.ID) ) "
				+ "ORDER by ID";


		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int nId = Integer.parseInt(rs.getString("ID"));
			String nNombre = rs.getString("NOMBRE");
			String nRegistro = rs.getString("REGISTRO_DE_CAPITANIA");
			String nAgencia = rs.getString("AGENCIA_MARITIMA");
			int nCantidad = Integer.parseInt(rs.getString("CANTIDAD_DE_CONTENEDORES"));
			String nDestino = rs.getString("DESTINO");
			Date nFechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date nFechaSalida = rs.getDate("FECHA_SALIDA");
			Time nHoraLlegada = rs.getTime("HORA_LLEGADA");
			Time nHoraSalida = rs.getTime("HORA_SALIDA");
			String nProcedencia = rs.getString("PROCEDENCIA");
			int nCapacidad = Integer.parseInt(rs.getString("CAPACIDAD_EN_TEUS"));
			rfc1.add(new RFC1(nId, nNombre, nRegistro, nAgencia, nCantidad, nDestino, nFechaLlegada, nFechaSalida, nHoraLlegada, nHoraSalida, nProcedencia, nCapacidad));
		}
		return rfc1;
	}
}
