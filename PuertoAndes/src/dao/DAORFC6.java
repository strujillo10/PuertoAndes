package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import vos.RFC1;
import vos.RFC6;

public class DAORFC6 
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
	public DAORFC6() 
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
	public ArrayList<RFC6> darRFC6s() throws SQLException, Exception 
	{
		ArrayList<RFC6> rfc6 = new ArrayList<RFC6>();

		String sql = "select a.*, b.nombre_sitio, b.dimension, b.tipo_de_carga, b.plataforma_externa, b.cantidad_de_cuartos_frios, b.ANCHO_EN_METROS,"
				+ "b.LARGO_EN_METROS, b.SEPARACION_ENTRE_COLUMNAS, b.AREA_CUARTO_FRIO, b.AREA_UTILIZADA_CUARTO, b.DIMENSIONES_CUARTO"
				+ "FROM ("
				+ "(select *"
				+ "from AREA_DE_ALMACENAMIENTO) a"
				+ "inner join"
				+ "("
				+ "(Select id_Area, 'N/A' as nombre_sitio, dimension, tipo_de_carga,"
				+ "'N/A' as plataforma_externa, 0 as cantidad_de_cuartos_frios, 0 AS ANCHO_EN_METROS,"
				+ "0 AS LARGO_EN_METROS, 0 AS SEPARACION_ENTRE_COLUMNAS, null AS AREA_CUARTO_FRIO"
				+ ",null AS AREA_UTILIZADA_CUARTO, null AS DIMENSIONES_CUARTO "
				+ "FROM PATIOS)"
				+ "UNION"
				+ "(SELECT id_Area, 'N/A' as nombre_sitio, dimension, tipo_de_carga,"
				+ "'N/A' as plataforma_externa, 0 as cantidad_de_cuartos_frios, 0 AS ANCHO_EN_METROS,"
				+ "0 AS LARGO_EN_METROS, 0 AS SEPARACION_ENTRE_COLUMNAS, null AS AREA_CUARTO_FRIO"
				+ ",null AS AREA_UTILIZADA_CUARTO, null AS DIMENSIONES_CUARTO"
				+ "FROM COBERTIZOS)"
				+ "UNION"
				+ "("
				+ "select id_area, nombre as Nombre_Sitio, 'N/A' as dimension, 'N/A' as tipo_de_carga,"
				+ "'N/A' as plataforma_externa, 0 as cantidad_de_cuartos_frios, 0 AS ANCHO_EN_METROS,"
				+ "0 AS LARGO_EN_METROS, 0 AS SEPARACION_ENTRE_COLUMNAS, null AS AREA_CUARTO_FRIO"
				+ ",null AS AREA_UTILIZADA_CUARTO, null AS DIMENSIONES_CUARTO"
				+ "from sitios"
				+ ")"
				+ "UNION"
				+ "("
				+ "select x.id_area, 'N/A' as Nombre_Sitio, 'N/A' as dimension, "
				+ "'N/A' as tipo_de_carga, x.plataforma_externa, x.CANTIDAD_DE_CUARTOS_FRIOS, x.ANCHO_EN_METROS, x.LARGO_EN_METROS,"
				+ "x.SEPARACION_ENTRE_COLUMNAS, f.AREA as area_cuarto_frio, f.AREA_UTILIZADA as area_utilizada_cuarto,"
				+ "f.DIMENSIONES as dimensiones_cuarto"
				+ "from bodegas x left join CUARTOS_FRIOS f on x.id = f.ID_BODEGA)"
				+ ") b on a.id = b.id_area)";
		
		String sql2 = "select a.*, b.nombre_sitio, b.dimension, b.tipo_de_carga, b.plataforma_externa, b.cantidad_de_cuartos_frios, b.ANCHO_EN_METROS,b.LARGO_EN_METROS, b.SEPARACION_ENTRE_COLUMNAS, b.AREA_CUARTO_FRIO, b.AREA_UTILIZADA_CUARTO, b.DIMENSIONES_CUARTO FROM ((select * from AREA_DE_ALMACENAMIENTO) a inner join((Select id_Area, 'N/A' as nombre_sitio, dimension, tipo_de_carga,'N/A' as plataforma_externa, 0 as cantidad_de_cuartos_frios, 0 AS ANCHO_EN_METROS,0 AS LARGO_EN_METROS, 0 AS SEPARACION_ENTRE_COLUMNAS, null AS AREA_CUARTO_FRIO,null AS AREA_UTILIZADA_CUARTO, null AS DIMENSIONES_CUARTO FROM PATIOS)UNION(SELECT id_Area, 'N/A' as nombre_sitio, dimension, tipo_de_carga,'N/A' as plataforma_externa, 0 as cantidad_de_cuartos_frios, 0 AS ANCHO_EN_METROS,0 AS LARGO_EN_METROS, 0 AS SEPARACION_ENTRE_COLUMNAS, null AS AREA_CUARTO_FRIO,null AS AREA_UTILIZADA_CUARTO, null AS DIMENSIONES_CUARTO FROM COBERTIZOS)UNION(select id_area, nombre as Nombre_Sitio, 'N/A' as dimension, 'N/A' as tipo_de_carga,'N/A' as plataforma_externa, 0 as cantidad_de_cuartos_frios, 0 AS ANCHO_EN_METROS,0 AS LARGO_EN_METROS, 0 AS SEPARACION_ENTRE_COLUMNAS, null AS AREA_CUARTO_FRIO,null AS AREA_UTILIZADA_CUARTO, null AS DIMENSIONES_CUARTO from sitios)UNION(select x.id_area, 'N/A' as Nombre_Sitio, 'N/A' as dimension,'N/A' as tipo_de_carga, x.plataforma_externa, x.CANTIDAD_DE_CUARTOS_FRIOS, x.ANCHO_EN_METROS, x.LARGO_EN_METROS,x.SEPARACION_ENTRE_COLUMNAS, f.AREA as area_cuarto_frio, f.AREA_UTILIZADA as area_utilizada_cuarto,f.DIMENSIONES as dimensiones_cuarto from bodegas x left join CUARTOS_FRIOS f on x.id = f.ID_BODEGA)) b on a.id = b.id_area)";

		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int nId = Integer.parseInt(rs.getString("ID"));
			String nTipo = rs.getString("TIPO");
			int nCapacidadEnToneladas = Integer.parseInt(rs.getString("CAPACIDAD_EN_TONELADAS"));
			int nOcupacionActual = Integer.parseInt(rs.getString("OCUPACION_ACTUAL"));
			String nEstado = rs.getString("ESTADO");
			String nNombreSitio = rs.getString("NOMBRE_SITIO");
			String nDimension = rs.getString("DIMENSION");
			String nTipoDeCarga = rs.getString("TIPO_DE_CARGA");
			String nPlataformaExterna = rs.getString("PLATAFORMA_EXTERNA");
			int nCantidadDeCuartosFrios = Integer.parseInt(rs.getString("CANTIDAD_DE_CUARTOS_FRIOS"));
			int nAnchoEnMetros = Integer.parseInt(rs.getString("ANCHO_EN_METROS"));
			int nLargoEnMetros = Integer.parseInt(rs.getString("LARGO_EN_METROS"));
			int nSeparacionEntreColumnas = Integer.parseInt(rs.getString("SEPARACION_ENTRE_COLUMNAS"));
			String nAreaCuartoFrios = rs.getString("AREA_CUARTO_FRIO");
			String nAreaUtilizada = rs.getString("AREA_UTILIZADA_CUARTO");
			String nDimensionesCuarto = rs.getString("DIMENSIONES_CUARTO");
			rfc6.add(new RFC6(nId, nTipo, nCapacidadEnToneladas, nOcupacionActual, 
					nEstado, nNombreSitio, nDimension, nTipoDeCarga, nSeparacionEntreColumnas, 
					nAnchoEnMetros, nLargoEnMetros, nPlataformaExterna, nCantidadDeCuartosFrios, nDimensionesCuarto, nAreaUtilizada, nAreaCuartoFrios));
		}
		return rfc6;
	}
}
