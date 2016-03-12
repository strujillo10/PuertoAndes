package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ibm.wsdl.FaultImpl;

import dao.DAOAdministrador;
import dao.DAOAreaAlmacenamiento;
import dao.DAOBodega;
import dao.DAOBuque;
import dao.DAOBuqueMultiproposito;
import dao.DAOBuquePortacontenedores;
import dao.DAOBuqueRoro;
import dao.DAOCamion;
import dao.DAOCarga;
import dao.DAOCobertizo;
import dao.DAOContenedor;
import dao.DAOCuartoFrio;
import dao.DAOEquipoApoyo;
import dao.DAOExportador;
import dao.DAOFactura;
import dao.DAOImportador;
import dao.DAOOperadorPortuario;
import dao.DAOPatio;
import dao.DAOSitio;
import dao.DAOUsuario;
import vos.Administrador;
import vos.AreaAlmacenamiento;
import vos.Bodega;
import vos.Buque;
import vos.BuqueMultiproposito;
import vos.BuquePortaContenedores;
import vos.BuqueRoro;
import vos.Camion;
import vos.Carga;
import vos.Cobertizo;
import vos.Contenedor;
import vos.CuartoFrio;
import vos.EquipoApoyo;
import vos.Exportador;
import vos.Factura;
import vos.Importador;
import vos.ListaAdministrador;
import vos.ListaAreaAlmacenamiento;
import vos.ListaBodega;
import vos.ListaBuque;
import vos.ListaBuqueMultiproposito;
import vos.ListaBuquePortacontenedores;
import vos.ListaBuqueRoro;
import vos.ListaCamion;
import vos.ListaCarga;
import vos.ListaCobertizo;
import vos.ListaContenedor;
import vos.ListaCuartoFrio;
import vos.ListaEquipoApoyo;
import vos.ListaExportador;
import vos.ListaFactura;
import vos.ListaImportador;
import vos.ListaOperadorPortuario;
import vos.ListaPatio;
import vos.ListaSitio;
import vos.ListaUsuario;
import vos.OperadorPortuario;
import vos.Patio;
import vos.Sitio;
import vos.Usuario;


public class PuertoAndesMaster 
{
	//Atributo estático que contiene el path relativo del archivo que tiene los datos de la conexión
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	//Atributo estático que contiene el path absoluto del archivo que tiene los datos de la conexión
	private  String connectionDataPath;
	
	//Atributo que guarda el usuario que se va a usar para conectarse a la base de datos
	private String user;

	//Atributo que guarda la clave que se va a usar para conectarse a la base de datos
	private String password;

	//Atributo que guarda el URL que se va a usar para conectarse a la base de datos
	private String url;

	//Atributo que guarda el driver que se va a usar para conectarse a la base de datos
	private String driver;
	
	//Conexión a la base de datos
	private Connection conn;

	/**
	 * Método constructor de la clase PuertoAndesMaster, esta clase modela y contiene cada una de las 
	 * transacciones y la logica de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto PuertoAndesMaster, se inicializa el path absoluto de el archivo de conexión y se
	 * inicializa los atributos que se usan par la conexión a la base de datos.
	 * @param contextPathP - path absoluto en el servidor del contexto del deploy actual
	 */
	public PuertoAndesMaster(String contextPathP) 
	{
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	/*
	 * Método que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexión a la base de datos.
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
	 * Método que  retorna la conexión a la base de datos
	 * @return Connection - la conexión a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexión a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	public ListaAdministrador buscarAdminsPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaAdministrador darAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAdmin(Administrador admin) throws Exception {
		DAOAdministrador daoAdministrador = new DAOAdministrador();
		try 
		{
			this.conn = darConexion();
			daoAdministrador.setConn(conn);
			daoAdministrador.addAdministrador(admin);
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
				daoAdministrador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addAdmins(ListaAdministrador admins) throws Exception {
		DAOAdministrador daoAdministrador = new DAOAdministrador();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAdministrador.setConn(conn);
			for(Administrador administrador : admins.getAdmins())
				daoAdministrador.addAdministrador(administrador);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAdministrador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateAdmin(Administrador admin) throws Exception {
		DAOAdministrador daoAdministrador = new DAOAdministrador();
		try 
		{
			this.conn = darConexion();
			daoAdministrador.setConn(conn);
			daoAdministrador.updateAdministrador(admin);

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
				daoAdministrador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteAdmin(Administrador admin) throws Exception {
		DAOAdministrador daoAdministrador = new DAOAdministrador();
		try 
		{
			this.conn = darConexion();
			daoAdministrador.setConn(conn);
			daoAdministrador.deleteAdministrador(admin);

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
				daoAdministrador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public ListaAreaAlmacenamiento darAreas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaAreaAlmacenamiento buscarAreasPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAreas(ListaAreaAlmacenamiento areas) throws Exception {
		DAOAreaAlmacenamiento daoAreaAlmacenamiento = new DAOAreaAlmacenamiento();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAreaAlmacenamiento.setConn(conn);
			for(AreaAlmacenamiento areaAlmacenamiento : areas.getAreas())
				daoAreaAlmacenamiento.addAreaAlmacenamiento(areaAlmacenamiento);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAreaAlmacenamiento.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateArea(AreaAlmacenamiento area) throws Exception {
		DAOAreaAlmacenamiento daoAreaAlmacenamiento = new DAOAreaAlmacenamiento();
		try 
		{
			this.conn = darConexion();
			daoAreaAlmacenamiento.setConn(conn);
			daoAreaAlmacenamiento.updateAreaAlmacenamiento(area);

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
				daoAreaAlmacenamiento.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteArea(AreaAlmacenamiento area) throws Exception {
		DAOAreaAlmacenamiento daoAreaAlmacenamiento = new DAOAreaAlmacenamiento();
		try 
		{
			this.conn = darConexion();
			daoAreaAlmacenamiento.setConn(conn);
			daoAreaAlmacenamiento.deleteAreaAlmacenamiento(area);

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
				daoAreaAlmacenamiento.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public void addArea(AreaAlmacenamiento area) throws Exception {
		DAOAreaAlmacenamiento daoAreaAlmacenamiento = new DAOAreaAlmacenamiento();
		try 
		{
			this.conn = darConexion();
			daoAreaAlmacenamiento.setConn(conn);
			daoAreaAlmacenamiento.addAreaAlmacenamiento(area);
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
				daoAreaAlmacenamiento.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaBodega darBodegas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBodega buscarBodegaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBodega(Bodega bodega) throws Exception {
		DAOBodega daoBodega = new DAOBodega();
		try 
		{
			this.conn = darConexion();
			daoBodega.setConn(conn);
			daoBodega.addBodega(bodega);
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
				daoBodega.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addBodegas(ListaBodega bodegas) throws Exception {
		DAOBodega daoBodega = new DAOBodega();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBodega.setConn(conn);
			for(Bodega bodega : bodegas.getBodegas())
				daoBodega.addBodega(bodega);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoBodega.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateBodega(Bodega bodega) throws Exception {
		DAOBodega daoBodega = new DAOBodega();
		try 
		{
			this.conn = darConexion();
			daoBodega.setConn(conn);
			daoBodega.updateBodega(bodega);

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
				daoBodega.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteBodega(Bodega bodega) throws Exception {
		DAOBodega daoBodega = new DAOBodega();
		try 
		{
			this.conn = darConexion();
			daoBodega.setConn(conn);
			daoBodega.deleteBodega(bodega);

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
				daoBodega.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public ListaBuqueMultiproposito darBuquesM() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuqueMultiproposito buscarBuqueMPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuqueM(BuqueMultiproposito buqueM) throws Exception {
		DAOBuqueMultiproposito daoBuqueMultiproposito = new DAOBuqueMultiproposito();
		try 
		{
			this.conn = darConexion();
			daoBuqueMultiproposito.setConn(conn);
			daoBuqueMultiproposito.addBuqueM(buqueM);
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
				daoBuqueMultiproposito.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addBuquesM(ListaBuqueMultiproposito buquesM) throws Exception {
		DAOBuqueMultiproposito daoBuqueMultiproposito = new DAOBuqueMultiproposito();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBuqueMultiproposito.setConn(conn);
			for(BuqueMultiproposito buque : buquesM.getBuquesM())
				daoBuqueMultiproposito.addBuqueM(buque);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoBuqueMultiproposito.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateBuqueM(BuqueMultiproposito buqueM) throws Exception {
		DAOBuqueMultiproposito daoBuqueMultiproposito= new DAOBuqueMultiproposito();
		try 
		{
			this.conn = darConexion();
			daoBuqueMultiproposito.setConn(conn);
			daoBuqueMultiproposito.updateBuqueM(buqueM);

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
				daoBuqueMultiproposito.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteBuqueM(BuqueMultiproposito buqueM) throws Exception {
		DAOBuqueMultiproposito daoBuqueMultiproposito = new DAOBuqueMultiproposito();
		try 
		{
			this.conn = darConexion();
			daoBuqueMultiproposito.setConn(conn);
			daoBuqueMultiproposito.deleteBuqueM(buqueM);

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
				daoBuqueMultiproposito.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public ListaBuquePortacontenedores darBuquesP() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuquePortacontenedores buscarBuquePPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuqueP(BuquePortaContenedores buqueP) throws Exception {
		DAOBuquePortacontenedores daoBuquePortacontenedores = new DAOBuquePortacontenedores();
		try 
		{
			this.conn = darConexion();
			daoBuquePortacontenedores.setConn(conn);
			daoBuquePortacontenedores.addBuqueP(buqueP);
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
				daoBuquePortacontenedores.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addBuquesP(ListaBuquePortacontenedores buquesP) throws Exception {
		DAOBuquePortacontenedores daoBuquePortacontenedores = new DAOBuquePortacontenedores();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBuquePortacontenedores.setConn(conn);
			for(BuquePortaContenedores buque : buquesP.getBuquesP())
				daoBuquePortacontenedores.addBuqueP(buque);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoBuquePortacontenedores.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateBuqueP(BuquePortaContenedores buqueP) throws Exception {
		DAOBuquePortacontenedores daoBuquePortacontenedores = new DAOBuquePortacontenedores();
		try 
		{
			this.conn = darConexion();
			daoBuquePortacontenedores.setConn(conn);
			daoBuquePortacontenedores.updateBuqueP(buqueP);

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
				daoBuquePortacontenedores.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteBuqueP(BuquePortaContenedores buqueP) throws Exception {
		DAOBuquePortacontenedores daoBuquePortacontenedores = new DAOBuquePortacontenedores();
		try 
		{
			this.conn = darConexion();
			daoBuquePortacontenedores.setConn(conn);
			daoBuquePortacontenedores.deleteBuqueP(buqueP);

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
				daoBuquePortacontenedores.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public ListaBuqueRoro darBuquesR() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuqueRoro buscarBuqueRPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuqueR(BuqueRoro buqueR) throws Exception {
		DAOBuqueRoro daoBuqueRoro = new DAOBuqueRoro();
		try 
		{
			this.conn = darConexion();
			daoBuqueRoro.setConn(conn);
			daoBuqueRoro.addBuqueR(buqueR);
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
				daoBuqueRoro.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addBuquesR(ListaBuqueRoro buquesR) throws Exception {
		DAOBuqueRoro daoBuqueRoro = new DAOBuqueRoro();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBuqueRoro.setConn(conn);
			for(BuqueRoro buqueRoro : buquesR.getBuquesR())
				daoBuqueRoro.addBuqueR(buqueRoro);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoBuqueRoro.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateBuqueR(BuqueRoro buqueR) throws Exception {
		DAOBuqueRoro daoBuqueRoro = new DAOBuqueRoro();
		try 
		{
			this.conn = darConexion();
			daoBuqueRoro.setConn(conn);
			daoBuqueRoro.updateBuqueR(buqueR);

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
				daoBuqueRoro.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteBuqueR(BuqueRoro buqueR) throws Exception {
		DAOBuqueRoro daoBuqueRoro = new DAOBuqueRoro();
		try 
		{
			this.conn = darConexion();
			daoBuqueRoro.setConn(conn);
			daoBuqueRoro.deleteBuqueR(buqueR);

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
				daoBuqueRoro.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaBuque darBuques() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuque buscarBuquePorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuque(Buque buque) throws Exception {
		DAOBuque daoBuque = new DAOBuque();
		try 
		{
			this.conn = darConexion();
			daoBuque.setConn(conn);
			daoBuque.addBuque(buque);
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
				daoBuque.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addBuques(ListaBuque buques) throws Exception {
		DAOBuque daoBuque = new DAOBuque();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBuque.setConn(conn);
			for(Buque buque : buques.getBuques())
				daoBuque.addBuque(buque);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoBuque.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteBuque(Buque buque) throws Exception {
		DAOBuque daoBuque = new DAOBuque();
		try 
		{
			this.conn = darConexion();
			daoBuque.setConn(conn);
			daoBuque.deleteBuque(buque);

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
				daoBuque.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateBuque(Buque buque) throws Exception {
		DAOBuque daoBuque = new DAOBuque();
		try 
		{
			this.conn = darConexion();
			daoBuque.setConn(conn);
			daoBuque.updateBuque(buque);

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
				daoBuque.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaCamion darCamiones() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaCamion buscarCamionPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCamion(Camion camion) throws Exception {
		DAOCamion daoCamion = new DAOCamion();
		try 
		{
			this.conn = darConexion();
			daoCamion.setConn(conn);
			daoCamion.addCamion(camion);
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
				daoCamion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCamiones(ListaCamion camiones) throws Exception {
		DAOCamion daoCamion = new DAOCamion();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCamion.setConn(conn);
			for(Camion camion : camiones.getCamiones())
				daoCamion.addCamion(camion);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoCamion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCamion(Camion camion) throws Exception {
		DAOCamion daoCamion = new DAOCamion();
		try 
		{
			this.conn = darConexion();
			daoCamion.setConn(conn);
			daoCamion.updateCamion(camion);

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
				daoCamion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCamion(Camion camion) throws Exception {
		DAOCamion daoCamion = new DAOCamion();
		try 
		{
			this.conn = darConexion();
			daoCamion.setConn(conn);
			daoCamion.deleteCamion(camion);

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
				daoCamion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaCarga darCargas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaCarga buscarCargaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCarga(Carga carga) throws Exception {
		DAOCarga daoCarga = new DAOCarga();
		try 
		{
			this.conn = darConexion();
			daoCarga.setConn(conn);
			daoCarga.addCarga(carga);
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
				daoCarga.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCargas(ListaCarga cargas) throws Exception {
		DAOCarga daoCarga = new DAOCarga();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCarga.setConn(conn);
			for(Carga carga : cargas.getCargas())
				daoCarga.addCarga(carga);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoCarga.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCarga(Carga carga) throws Exception {
		DAOCarga daoCarga = new DAOCarga();
		try 
		{
			this.conn = darConexion();
			daoCarga.setConn(conn);
			daoCarga.updateCarga(carga);

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
				daoCarga.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCarga(Carga carga) throws Exception {
		DAOCarga daoCarga = new DAOCarga();
		try 
		{
			this.conn = darConexion();
			daoCarga.setConn(conn);
			daoCarga.deleteCarga(carga);

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
				daoCarga.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaCobertizo darCobertizos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaCobertizo buscarCobertizoPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCobertizo(Cobertizo cobertizo) throws Exception {
		DAOCobertizo daoCobertizo = new DAOCobertizo();
		try 
		{
			this.conn = darConexion();
			daoCobertizo.setConn(conn);
			daoCobertizo.addCobertizo(cobertizo);
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
				daoCobertizo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCobertizos(ListaCobertizo cobertizos) throws Exception {
		DAOCobertizo daoCobertizo = new DAOCobertizo();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCobertizo.setConn(conn);
			for(Cobertizo cobertizo : cobertizos.getCobertizos())
				daoCobertizo.addCobertizo(cobertizo);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoCobertizo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCobertizo(Cobertizo cobertizo) throws Exception {
		DAOCobertizo daoCobertizo = new DAOCobertizo();
		try 
		{
			this.conn = darConexion();
			daoCobertizo.setConn(conn);
			daoCobertizo.updateCobertizo(cobertizo);

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
				daoCobertizo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCobertizo(Cobertizo cobertizo) throws Exception {
		DAOCobertizo daoCobertizo = new DAOCobertizo();
		try 
		{
			this.conn = darConexion();
			daoCobertizo.setConn(conn);
			daoCobertizo.deleteCobertizo(cobertizo);

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
				daoCobertizo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaContenedor darContenedores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaContenedor buscarContenedorPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addContenedor(Contenedor contenedor) throws Exception {
		DAOContenedor daoContenedor = new DAOContenedor();
		try 
		{
			this.conn = darConexion();
			daoContenedor.setConn(conn);
			daoContenedor.addContenedor(contenedor);
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
				daoContenedor.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addContenedores(ListaContenedor contenedores) throws Exception {
		DAOContenedor daoContenedor = new DAOContenedor();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoContenedor.setConn(conn);
			for(Contenedor contenedor : contenedores.getContenedores())
				daoContenedor.addContenedor(contenedor);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoContenedor.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateContenedor(Contenedor contenedor) throws Exception {
		DAOContenedor daoContenedor = new DAOContenedor();
		try 
		{
			this.conn = darConexion();
			daoContenedor.setConn(conn);
			daoContenedor.updateContenedor(contenedor);

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
				daoContenedor.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteContenedor(Contenedor contenedor) throws Exception {
		DAOContenedor daoContenedor = new DAOContenedor();
		try 
		{
			this.conn = darConexion();
			daoContenedor.setConn(conn);
			daoContenedor.deleteContenedor(contenedor);

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
				daoContenedor.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaCuartoFrio darCuartosFrios() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaCuartoFrio buscarCuartoFrioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCuartoFrio(CuartoFrio cuartoFrio) throws Exception {
		DAOCuartoFrio daoCuartoFrio = new DAOCuartoFrio();
		try 
		{
			this.conn = darConexion();
			daoCuartoFrio.setConn(conn);
			daoCuartoFrio.addCuarto(cuartoFrio);
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
				daoCuartoFrio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCuartosFrios(ListaCuartoFrio cuartosFrios) throws Exception {
		DAOCuartoFrio daoCuartoFrio = new DAOCuartoFrio();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCuartoFrio.setConn(conn);
			for(CuartoFrio cuartoFrio : cuartosFrios.getCuartos())
				daoCuartoFrio.addCuarto(cuartoFrio);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoCuartoFrio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCuartoFrio(CuartoFrio cuartoFrio) throws Exception {
		DAOCuartoFrio daoCuartoFrio = new DAOCuartoFrio();
		try 
		{
			this.conn = darConexion();
			daoCuartoFrio.setConn(conn);
			daoCuartoFrio.updateCuarto(cuartoFrio);

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
				daoCuartoFrio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCuartoFrio(CuartoFrio cuartoFrio) throws Exception {
		DAOCuartoFrio daoCuartoFrio = new DAOCuartoFrio();
		try 
		{
			this.conn = darConexion();
			daoCuartoFrio.setConn(conn);
			daoCuartoFrio.deleteCuarto(cuartoFrio);

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
				daoCuartoFrio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaEquipoApoyo darEquiposApoyo() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaEquipoApoyo buscarequipoApoyoPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEquipoApoyo(EquipoApoyo equipoApoyo) throws Exception {
		DAOEquipoApoyo daoEquipoApoyo = new DAOEquipoApoyo();
		try 
		{
			this.conn = darConexion();
			daoEquipoApoyo.setConn(conn);
			daoEquipoApoyo.addEquipo(equipoApoyo);
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
				daoEquipoApoyo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addEquiposApoyo(ListaEquipoApoyo equiposApoyo) throws Exception {
		DAOEquipoApoyo daoEquipoApoyo = new DAOEquipoApoyo();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoEquipoApoyo.setConn(conn);
			for(EquipoApoyo equipoApoyo : equiposApoyo.getEquipos())
				daoEquipoApoyo.addEquipo(equipoApoyo);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoEquipoApoyo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateEquipoApoyo(EquipoApoyo equipoApoyo) throws Exception {
		DAOEquipoApoyo daoEquipoApoyo = new DAOEquipoApoyo();
		try 
		{
			this.conn = darConexion();
			daoEquipoApoyo.setConn(conn);
			daoEquipoApoyo.updateEquipo(equipoApoyo);

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
				daoEquipoApoyo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteEquipoApoyo(EquipoApoyo equipoApoyo) throws Exception {
		DAOEquipoApoyo daoEquipoApoyo = new DAOEquipoApoyo();
		try 
		{
			this.conn = darConexion();
			daoEquipoApoyo.setConn(conn);
			daoEquipoApoyo.deleteEquipo(equipoApoyo);

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
				daoEquipoApoyo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaExportador darExportadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaExportador buscarExportadorPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addExportador(Exportador exportador) throws Exception {
		DAOExportador daoExportador = new DAOExportador();
		try 
		{
			this.conn = darConexion();
			daoExportador.setConn(conn);
			daoExportador.addExportador(exportador);
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
				daoExportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addExportadores(ListaExportador exportadores) throws Exception {
		DAOExportador daoExportador = new DAOExportador();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoExportador.setConn(conn);
			for(Exportador exportador : exportadores.getExportadores())
				daoExportador.addExportador(exportador);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoExportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateExportador(Exportador exportador) throws Exception {
		DAOExportador daoExportador = new DAOExportador();
		try 
		{
			this.conn = darConexion();
			daoExportador.setConn(conn);
			daoExportador.updateExportador(exportador);

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
				daoExportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteExportador(Exportador exportador) throws Exception {
		DAOExportador daoExportador = new DAOExportador();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoExportador.setConn(conn);
			daoExportador.deleteExportador(exportador);

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
				daoExportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaImportador darImportadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaImportador buscarImportadorPorId(int id) throws Exception {
		ArrayList<Importador> importadors;
		DAOImportador daoImportador = new DAOImportador();
		try 
		{
			this.conn = darConexion();
			daoImportador.setConn(conn);
			importadors = daoImportador.buscarImportadorPorId(id);

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
				daoImportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaImportador(importadors);
	}

	public void addImportador(Importador importador) throws Exception {
		DAOImportador daoImportador = new DAOImportador();
		try 
		{
			this.conn = darConexion();
			daoImportador.setConn(conn);
			daoImportador.addImportador(importador);
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
				daoImportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addImportadores(ListaImportador importadores) throws Exception {
		DAOImportador daoImportador = new DAOImportador();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoImportador.setConn(conn);
			for(Importador importador : importadores.getImportadores())
				daoImportador.addImportador(importador);;
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoImportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateImportador(Importador importador) throws Exception {
		DAOImportador daoImportador = new DAOImportador();
		try 
		{
			this.conn = darConexion();
			daoImportador.setConn(conn);
			daoImportador.updateImportador(importador);

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
				daoImportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteImportador(Importador importador) throws Exception {
		DAOImportador daoImportador = new DAOImportador();
		try 
		{
			this.conn = darConexion();
			daoImportador.setConn(conn);
			daoImportador.deleteImportador(importador);

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
				daoImportador.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaOperadorPortuario darOperadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaOperadorPortuario buscarOperadorPorId(int id) throws Exception {
		ArrayList<OperadorPortuario> operadorPortuarios;
		DAOOperadorPortuario daoOperadorPortuario = new DAOOperadorPortuario();
		try 
		{
			this.conn = darConexion();
			daoOperadorPortuario.setConn(conn);
			operadorPortuarios = daoOperadorPortuario.buscarOperadorPorId(id);

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
				daoOperadorPortuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaOperadorPortuario(operadorPortuarios);
	}

	public void addOperador(OperadorPortuario operador) throws Exception {
		DAOOperadorPortuario daoOperadorPortuario = new DAOOperadorPortuario();
		try 
		{
			this.conn = darConexion();
			daoOperadorPortuario.setConn(conn);
			daoOperadorPortuario.addOperador(operador);
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
				daoOperadorPortuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addOperadores(ListaOperadorPortuario operadores) throws Exception {
		DAOOperadorPortuario daoOperadorPortuario = new DAOOperadorPortuario();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoOperadorPortuario.setConn(conn);
			for(OperadorPortuario operadorPortuario : operadores.getOperadores())
				daoOperadorPortuario.addOperador(operadorPortuario);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoOperadorPortuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateOperador(OperadorPortuario operador) throws Exception {
		DAOOperadorPortuario daoOperadorPortuario = new DAOOperadorPortuario();
		try 
		{
			this.conn = darConexion();
			daoOperadorPortuario.setConn(conn);
			daoOperadorPortuario.updateOperador(operador);

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
				daoOperadorPortuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public void deleteOperador(OperadorPortuario operador) throws Exception {
		DAOOperadorPortuario daoOperadorPortuario = new DAOOperadorPortuario();
		try 
		{
			this.conn = darConexion();
			daoOperadorPortuario.setConn(conn);
			daoOperadorPortuario.deleteOperador(operador);

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
				daoOperadorPortuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}		
	}

	public ListaPatio darPatios() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaPatio buscarPatioPorId(int id) throws Exception {
		ArrayList<Patio> patios;
		DAOPatio daoPatio = new DAOPatio();
		try 
		{
			this.conn = darConexion();
			daoPatio.setConn(conn);
			patios = daoPatio.buscarPatioPorId(id);

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
				daoPatio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaPatio(patios);
	}

	public void addPatio(Patio patio) throws Exception {
		DAOPatio daoPatio = new DAOPatio();
		try 
		{
			this.conn = darConexion();
			daoPatio.setConn(conn);
			daoPatio.addPatio(patio);
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
				daoPatio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addPatios(ListaPatio patios) throws Exception {
		DAOPatio daoPatio = new DAOPatio();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoPatio.setConn(conn);
			for(Patio patio : patios.getPatios())
				daoPatio.addPatio(patio);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoPatio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updatePatio(Patio patio) throws Exception {
		DAOPatio daoPatio = new DAOPatio();
		try 
		{
			this.conn = darConexion();
			daoPatio.setConn(conn);
			daoPatio.updatePatio(patio);

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
				daoPatio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public void deletePatio(Patio patio) throws Exception {
		DAOPatio daoPatio = new DAOPatio();
		try 
		{
			this.conn = darConexion();
			daoPatio.setConn(conn);
			daoPatio.deletePatio(patio);

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
				daoPatio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaSitio darSitios() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaSitio buscarSitioPorId(int id) throws Exception {
		ArrayList<Sitio> sitios;
		DAOSitio daoSitio = new DAOSitio();
		try 
		{
			this.conn = darConexion();
			daoSitio.setConn(conn);
			sitios = daoSitio.buscarSitioPorId(id);

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
				daoSitio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaSitio(sitios);
	}

	public void addSitio(Sitio sitio) throws Exception {
		DAOSitio daoSitio = new DAOSitio();
		try 
		{
			this.conn = darConexion();
			daoSitio.setConn(conn);
			daoSitio.addSitio(sitio);
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
				daoSitio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addSitios(ListaSitio sitios) throws Exception {
		DAOSitio daoSitio = new DAOSitio();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoSitio.setConn(conn);
			for(Sitio sitio : sitios.getSitios())
				daoSitio.addSitio(sitio);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoSitio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateSitio(Sitio sitio) throws Exception {
		DAOSitio daoSitio = new DAOSitio();
		try 
		{
			this.conn = darConexion();
			daoSitio.setConn(conn);
			daoSitio.updateSitio(sitio);

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
				daoSitio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public void deleteSitio(Sitio sitio) throws Exception {
		DAOSitio daoSitio = new DAOSitio();
		try 
		{
			this.conn = darConexion();
			daoSitio.setConn(conn);
			daoSitio.deleteSitio(sitio);

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
				daoSitio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaUsuario darUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaUsuario buscarUsuarioPorId(int id) throws Exception {
		ArrayList<Usuario> usuarios;
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			usuarios = daoUsuario.buscarUsuarioPorId(id);

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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaUsuario(usuarios);
	}

	public void addUsuario(Usuario usuario) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.addUsuario(usuario);
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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addUsuarios(ListaUsuario usuarios) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoUsuario.setConn(conn);
			for(Usuario usuario : usuarios.getUsuarios())
				daoUsuario.addUsuario(usuario);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateUsuario(Usuario usuario) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.updateUsuario(usuario);

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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteUsuario(Usuario usuario) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.deleteUsuario(usuario);

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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}		
	}

	public ListaFactura darFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaFactura buscarFacturaPorId(int id) throws Exception {
		ArrayList<Factura> facturas;
		DAOFactura daoFactura = new DAOFactura();
		try 
		{
			this.conn = darConexion();
			daoFactura.setConn(conn);
			facturas = daoFactura.buscarFacturaPorId(id);

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
				daoFactura.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFactura(facturas);
	}

	public void addFactura(Factura factura) throws Exception {
		DAOFactura daoFactura = new DAOFactura();
		try 
		{
			this.conn = darConexion();
			daoFactura.setConn(conn);
			daoFactura.addFactura(factura);
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
				daoFactura.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addFacturas(ListaFactura facturas) throws Exception {
		DAOFactura daoFactura = new DAOFactura();
		try 
		{
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFactura.setConn(conn);
			for(Factura factura : facturas.getFacturas())
				daoFactura.addFactura(factura);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoFactura.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateFactura(Factura factura) throws Exception {
		DAOFactura daoFactura = new DAOFactura();
		try 
		{
			this.conn = darConexion();
			daoFactura.setConn(conn);
			daoFactura.updateFactura(factura);

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
				daoFactura.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteFactura(Factura factura) throws Exception {
		DAOFactura daoFactura = new DAOFactura();
		try 
		{
			this.conn = darConexion();
			daoFactura.setConn(conn);
			daoFactura.deleteFactura(factura);

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
				daoFactura.cerrarRecursos();
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
