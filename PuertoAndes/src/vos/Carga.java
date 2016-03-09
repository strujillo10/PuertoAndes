package vos;

public class Carga 
{
	private int idCarga; 
	private String nombre; 
	private String procedencia; 
	private String destino; 
	private int idBuque;
	private int idAlmacen; 
	private int idUsuario;
	
	public Carga(int iC, String n, String p, String d, int iB, int iA, int iU)
	{
		idCarga = iC;
		nombre = n; 
		procedencia = p; 
		destino = d; 
		idBuque = iB;
		idAlmacen = iA;
		idUsuario = iU;
	}

	public int getIdCarga() {
		return idCarga;
	}

	public void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getIdBuque() {
		return idBuque;
	}

	public void setIdBuque(int idBuque) {
		this.idBuque = idBuque;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
