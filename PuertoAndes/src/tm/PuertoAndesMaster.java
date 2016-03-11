package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

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

	public void deleteBuqueR(BuqueRoro buqueR) {
		// TODO Auto-generated method stub
		
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

	public void deleteBuque(Buque buque) {
		// TODO Auto-generated method stub
		
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

	public void deleteCamion(Camion camion) {
		// TODO Auto-generated method stub
		
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

	public void deleteCarga(Carga carga) {
		// TODO Auto-generated method stub
		
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

	public void deleteCobertizo(Cobertizo cobertizo) {
		// TODO Auto-generated method stub
		
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

	public void deleteContenedor(Contenedor contenedor) {
		// TODO Auto-generated method stub
		
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

	public void deleteCuartoFrio(CuartoFrio cuartoFrio) {
		// TODO Auto-generated method stub
		
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

	public void deleteEquipoApoyo(EquipoApoyo equipoApoyo) {
		// TODO Auto-generated method stub
		
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

	public void deleteExportador(Exportador exportador) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * M茅todo que modela la transacci贸n que agrega un solo puerto a la base de datos.
	 * <b> post: </b> se ha agregado el puerto que entra como par谩metro
	 * @param puerto - el puerto a agregar. puerto != null
	 * @throws Exception - cualquier error que se genera agregando el video
	 */
//	public void addAdmin(Administrador admin) throws Exception {
//		DAOAdministrador daoAdministrador = new DAOAdministrador();
//		try 
//		{
//			//////Transacci贸n
//			this.conn = darConexion();
//			daoPuerto.setConn(conn);
//			daoPuerto.addPuerto(puerto);
//			conn.commit();
//
//		} catch (SQLException e) {
//			System.err.println("SQLException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} catch (Exception e) {
//			System.err.println("GeneralException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} finally {
//			try {
//				daoPuerto.cerrarRecursos();
//				if(this.conn!=null)
//					this.conn.close();
//			} catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//	}
//	
//	/**
//	 * M茅todo que modela la transacci贸n que actualiza el puerto que entra como par谩metro a la base de datos.
//	 * <b> post: </b> se ha actualizado el puerto que entra como par谩metro
//	 * @param puerto - puerto a actualizar. puerto != null
//	 * @throws Exception - cualquier error que se genera actualizando los puertos
//	 */
//	public void updatePuerto(Puerto puerto) throws Exception {
//		DAOPuerto daoPuerto = new DAOPuerto();
//		try 
//		{
//			//////Transacci贸n
//			this.conn = darConexion();
//			daoPuerto.setConn(conn);
//			daoPuerto.updatePuerto(puerto);
//
//		} catch (SQLException e) {
//			System.err.println("SQLException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} catch (Exception e) {
//			System.err.println("GeneralException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} finally {
//			try {
//				daoPuerto.cerrarRecursos();
//				if(this.conn!=null)
//					this.conn.close();
//			} catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//	}
//
//	/**
//	 * M茅todo que modela la transacci贸n que elimina el Puerto que entra como par谩metro a la base de datos.
//	 * <b> post: </b> se ha eliminado el puerto que entra como par谩metro
//	 * @param puerto - puerto a eliminar. puerto != null
//	 * @throws Exception - cualquier error que se genera actualizando los puertos
//	 */
//	public void deletePuerto(Puerto puerto) throws Exception {
//		DAOPuerto daoPuerto = new DAOPuerto();
//		try 
//		{
//			//////Transacci贸n
//			this.conn = darConexion();
//			daoPuerto.setConn(conn);
//			daoPuerto.deletePuerto(puerto);
//
//		} catch (SQLException e) {
//			System.err.println("SQLException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} catch (Exception e) {
//			System.err.println("GeneralException:" + e.getMessage());
//			e.printStackTrace();
//			throw e;
//		} finally {
//			try {
//				daoPuerto.cerrarRecursos();
//				if(this.conn!=null)
//					this.conn.close();
//			} catch (SQLException exception) {
//				System.err.println("SQLException closing resources:" + exception.getMessage());
//				exception.printStackTrace();
//				throw exception;
//			}
//		}
//	}
}
