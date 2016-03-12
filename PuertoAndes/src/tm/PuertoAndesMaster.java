package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOBodega;
import dao.DAOBuque;
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

	public void addAdmin(Administrador admin) {
		// TODO Auto-generated method stub
		
	}

	public void addAdmins(ListaAdministrador admins) {
		// TODO Auto-generated method stub
		
	}

	public void updateAdmin(Administrador admin) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAdmin(Administrador admin) {
		// TODO Auto-generated method stub
		
	}

	public ListaAreaAlmacenamiento darAreas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaAreaAlmacenamiento buscarAreasPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAreas(ListaAreaAlmacenamiento areas) {
		// TODO Auto-generated method stub
		
	}

	public void updateArea(AreaAlmacenamiento area) {
		// TODO Auto-generated method stub
		
	}

	public void deleteArea(AreaAlmacenamiento area) {
		// TODO Auto-generated method stub
		
	}

	public void addArea(AreaAlmacenamiento area) {
		// TODO Auto-generated method stub
		
	}

	public ListaBodega darBodegas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBodega buscarBodegaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		
	}

	public void addBodegas(ListaBodega bodegas) {
		// TODO Auto-generated method stub
		
	}

	public void updateBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		
	}

	public ListaBuqueMultiproposito darBuquesM() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuqueMultiproposito buscarBuqueMPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuqueM(BuqueMultiproposito buqueM) {
		// TODO Auto-generated method stub
		
	}

	public void addBuquesM(ListaBuqueMultiproposito buquesM) {
		// TODO Auto-generated method stub
		
	}

	public void updateBuqueM(BuqueMultiproposito buqueM) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBuqueM(BuqueMultiproposito buqueM) {
		// TODO Auto-generated method stub
		
	}

	public ListaBuquePortacontenedores darBuquesP() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuquePortacontenedores buscarBuquePPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuqueP(BuquePortaContenedores buqueP) {
		// TODO Auto-generated method stub
		
	}

	public void updateBuqueP(BuquePortaContenedores buqueP) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBuqueP(BuquePortaContenedores buqueP) {
		// TODO Auto-generated method stub
		
	}

	public ListaBuqueRoro darBuquesR() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaBuqueRoro buscarBuqueRPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBuqueR(BuqueRoro buqueR) {
		// TODO Auto-generated method stub
		
	}

	public void addBuquesR(ListaBuqueRoro buquesR) {
		// TODO Auto-generated method stub
		
	}

	public void updateBuqueR(BuqueRoro buqueR) {
		// TODO Auto-generated method stub
		
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

	public void addBuque(Buque buque) {
		// TODO Auto-generated method stub
		
	}

	public void addBuques(ListaBuque buques) {
		// TODO Auto-generated method stub
		
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

	public void updateBuque(Buque buque) {
		// TODO Auto-generated method stub
		
	}

	public ListaCamion darCamiones() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListaCamion buscarCamionPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCamion(Camion camion) {
		// TODO Auto-generated method stub
		
	}

	public void addCamiones(ListaCamion camiones) {
		// TODO Auto-generated method stub
		
	}

	public void updateCamion(Camion camion) {
		// TODO Auto-generated method stub
		
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

	public void addCarga(Carga carga) {
		// TODO Auto-generated method stub
		
	}

	public void addCargas(ListaCarga cargas) {
		// TODO Auto-generated method stub
		
	}

	public void updateCarga(Carga carga) {
		// TODO Auto-generated method stub
		
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

	public void addCobertizo(Cobertizo cobertizo) {
		// TODO Auto-generated method stub
		
	}

	public void addCobertizos(ListaCobertizo cobertizos) {
		// TODO Auto-generated method stub
		
	}

	public void updateCobertizo(Cobertizo cobertizo) {
		// TODO Auto-generated method stub
		
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

	public void addContenedor(Contenedor contenedor) {
		// TODO Auto-generated method stub
		
	}

	public void addContenedores(ListaContenedor contenedores) {
		// TODO Auto-generated method stub
		
	}

	public void updateContenedor(Contenedor contenedor) {
		// TODO Auto-generated method stub
		
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

	public void addCuartoFrio(CuartoFrio cuartoFrio) {
		// TODO Auto-generated method stub
		
	}

	public void addCuartosFrios(ListaCuartoFrio cuartosFrios) {
		// TODO Auto-generated method stub
		
	}

	public void updateCuartoFrio(CuartoFrio cuartoFrio) {
		// TODO Auto-generated method stub
		
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

	public void addEquipoApoyo(EquipoApoyo equipoApoyo) {
		// TODO Auto-generated method stub
		
	}

	public void addEquiposApoyo(ListaEquipoApoyo equiposApoyo) {
		// TODO Auto-generated method stub
		
	}

	public void updateEquipoApoyo(EquipoApoyo equipoApoyo) {
		// TODO Auto-generated method stub
		
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

	public ListaExportador buscarexportadorPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addExportador(Exportador exportador) {
		// TODO Auto-generated method stub
		
	}

	public void addExportadores(ListaExportador exportadores) {
		// TODO Auto-generated method stub
		
	}

	public void updateExportador(Exportador exportador) {
		// TODO Auto-generated method stub
		
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

	public ListaImportador buscarImportadorPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addImportador(Importador importador) {
		// TODO Auto-generated method stub
		
	}

	public void addImportadores(ListaImportador importadores) {
		// TODO Auto-generated method stub
		
	}

	public void updateImportador(Importador importador) {
		// TODO Auto-generated method stub
		
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

	public ListaOperadorPortuario buscarOperadorPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addOperador(OperadorPortuario operador) {
		// TODO Auto-generated method stub
		
	}

	public void addOperadores(ListaOperadorPortuario operadores) {
		// TODO Auto-generated method stub
		
	}

	public void updateOperador(OperadorPortuario operador) {
		// TODO Auto-generated method stub
		
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

	public ListaPatio buscarPatioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addPatio(Patio patio) {
		// TODO Auto-generated method stub
		
	}

	public void addPatios(ListaPatio patios) {
		// TODO Auto-generated method stub
		
	}

	public void updatePatio(Patio patio) {
		// TODO Auto-generated method stub
		
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

	public ListaSitio buscarSitioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addSitio(Sitio sitio) {
		// TODO Auto-generated method stub
		
	}

	public void addSitios(ListaSitio sitios) {
		// TODO Auto-generated method stub
		
	}

	public void updateSitio(Sitio sitio) {
		// TODO Auto-generated method stub
		
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

	public ListaUsuario buscarUsuarioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public void addUsuarios(ListaUsuario usuarios) {
		// TODO Auto-generated method stub
		
	}

	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
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

	public ListaFactura buscarFacturaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFactura(Factura factura) {
		// TODO Auto-generated method stub
		
	}

	public void addFacturas(ListaFactura facturas) {
		// TODO Auto-generated method stub
		
	}

	public void updateFactura(Factura factura) {
		// TODO Auto-generated method stub
		
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
