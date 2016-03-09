package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOPuerto;
import vos.Puerto;


public class PuertoAndesMaster 
{
	//Atributo est醫ico que contiene el path relativo del archivo que tiene los datos de la conexi髇
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	//Atributo est醫ico que contiene el path absoluto del archivo que tiene los datos de la conexi髇
	private  String connectionDataPath;
	
	//Atributo que guarda el usuario que se va a usar para conectarse a la base de datos
	private String user;

	//Atributo que guarda la clave que se va a usar para conectarse a la base de datos
	private String password;

	//Atributo que guarda el URL que se va a usar para conectarse a la base de datos
	private String url;

	//Atributo que guarda el driver que se va a usar para conectarse a la base de datos
	private String driver;
	
	//Conexi髇 a la base de datos
	private Connection conn;

	/**
	 * M閠odo constructor de la clase PuertoAndesMaster, esta clase modela y contiene cada una de las 
	 * transacciones y la logica de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto PuertoAndesMaster, se inicializa el path absoluto de el archivo de conexi髇 y se
	 * inicializa los atributos que se usan par la conexi髇 a la base de datos.
	 * @param contextPathP - path absoluto en el servidor del contexto del deploy actual
	 */
	public PuertoAndesMaster(String contextPathP) 
	{
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/*
	 * M閠odo que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexi髇 a la base de datos.
	 */
	private void initConnectionData() 
	{
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * M閠odo que  retorna la conexi髇 a la base de datos
	 * @return Connection - la conexi髇 a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexi髇 a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	
	////////////////////////////////////////
	///////Transacciones////////////////////
	////////////////////////////////////////
	
	/**
	 * M茅todo que modela la transacci贸n que agrega un solo puerto a la base de datos.
	 * <b> post: </b> se ha agregado el puerto que entra como par谩metro
	 * @param puerto - el puerto a agregar. puerto != null
	 * @throws Exception - cualquier error que se genera agregando el video
	 */
	public void addPuerto(Puerto puerto) throws Exception {
		DAOPuerto daoPuerto = new DAOPuerto();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoPuerto.setConn(conn);
			daoPuerto.addPuerto(puerto);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	/**
	 * M茅todo que modela la transacci贸n que actualiza el puerto que entra como par谩metro a la base de datos.
	 * <b> post: </b> se ha actualizado el puerto que entra como par谩metro
	 * @param puerto - puerto a actualizar. puerto != null
	 * @throws Exception - cualquier error que se genera actualizando los puertos
	 */
	public void updatePuerto(Puerto puerto) throws Exception {
		DAOPuerto daoPuerto = new DAOPuerto();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoPuerto.setConn(conn);
			daoPuerto.updatePuerto(puerto);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	/**
	 * M茅todo que modela la transacci贸n que elimina el Puerto que entra como par谩metro a la base de datos.
	 * <b> post: </b> se ha eliminado el puerto que entra como par谩metro
	 * @param puerto - puerto a eliminar. puerto != null
	 * @throws Exception - cualquier error que se genera actualizando los puertos
	 */
	public void deletePuerto(Puerto puerto) throws Exception {
		DAOPuerto daoPuerto = new DAOPuerto();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoPuerto.setConn(conn);
			daoPuerto.deletePuerto(puerto);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
}
