package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Buque 
{
	@JsonProperty(value="idBuque")
	private int idBuque; 
	
	@JsonProperty(value="registro")
	private int registro; 
	
	@JsonProperty(value="nombreBuque")
	private String nombreBuque; 
	
	@JsonProperty(value="nombreAgente")
	private String nombreAgente; 
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	@JsonProperty(value="cantidadContenedores")
	private int cantidadContenedores; 
	
	@JsonProperty(value="carga")
	private int carga; 
	
	public Buque(@JsonProperty(value="idBuque")int iB, @JsonProperty(value="registro")int r, 
			@JsonProperty(value="nombreBuque")String nB, @JsonProperty(value="nombreAgente")String nA, 
			@JsonProperty(value="tipo")String t, @JsonProperty(value="capacidad")int c, 
			@JsonProperty(value="cantidadContenedores")int cC, @JsonProperty(value="carga")int car)
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
