package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Camion 
{
	@JsonProperty(value="idCamion")
	private int idCamion; 
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada; 
	
	@JsonProperty(value="fechaSalida")
	private Date fechaSalida; 
	
	@JsonProperty(value="nombreAgente")
	private String nombreAgente; 
	
	@JsonProperty(value="carga")
	private int carga; 
	
	@JsonProperty(value="cantidadContenedores")
	private int cantidadContenedores;
	
	@JsonProperty(value="idPuerto")
	private int idPuerto; 
	
	public Camion(@JsonProperty(value="idCamion")int iC, @JsonProperty(value="fechaLlegada")Date fL, 
			@JsonProperty(value="fechaSalida")Date fS, @JsonProperty(value="nombreAgente")String nA, 
			@JsonProperty(value="carga")int c, @JsonProperty(value="cantidadContenedores")int cC, 
			@JsonProperty(value="idPuerto")int iP)
	{
		idCamion = iC;
		fechaLlegada = fL; 
		fechaSalida = fS; 
		nombreAgente = nA; 
		carga = c; 
		cantidadContenedores = cC; 
		idPuerto = iP;
	}

	public int getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getNombreAgente() {
		return nombreAgente;
	}

	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getCantidadContenedores() {
		return cantidadContenedores;
	}

	public void setCantidadContenedores(int cantidadContenedores) {
		this.cantidadContenedores = cantidadContenedores;
	}

	public int getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(int idPuerto) {
		this.idPuerto = idPuerto;
	}
	
	
}
