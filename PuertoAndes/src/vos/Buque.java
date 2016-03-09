package vos;

public class Buque 
{
	private int idBuque; 
	private int registro; 
	private String nombreBuque; 
	private String nombreAgente; 
	private String tipo;
	private int capacidad; 
	private int cantidadContenedores; 
	private int carga; 
	
	public Buque(int iB, int r, String nB, String nA, String t, int c, int cC, int car)
	{
		idBuque = iB; 
		registro = r; 
		nombreBuque = nB; 
		nombreAgente = nA; 
		tipo = t; 
		capacidad = c; 
		cantidadContenedores = cC; 
		carga = car; 
	}

	public int getIdBuque() {
		return idBuque;
	}

	public void setIdBuque(int idBuque) {
		this.idBuque = idBuque;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getNombreBuque() {
		return nombreBuque;
	}

	public void setNombreBuque(String nombreBuque) {
		this.nombreBuque = nombreBuque;
	}

	public String getNombreAgente() {
		return nombreAgente;
	}

	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidadContenedores() {
		return cantidadContenedores;
	}

	public void setCantidadContenedores(int cantidadContenedores) {
		this.cantidadContenedores = cantidadContenedores;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	
}
