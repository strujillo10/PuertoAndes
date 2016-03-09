package vos;

import java.sql.Date;

public class Camion 
{
	private int idCamion; 
	private Date fechaLlegada; 
	private Date fechaSalida; 
	private String nombreAgente; 
	private int carga; 
	private int cantidadContenedores;
	private int idPuerto; 
	
	public Camion(int iC, Date fL, Date fS, String nA, int c, int cC, int iP)
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
