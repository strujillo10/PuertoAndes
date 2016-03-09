package vos;

import java.sql.Date;

public class Registro 
{
	private int idRegistro; 
	private Date fechaLlegada;
	private Date fechaSalida; 
	private String muelle; 
	private int idPuertoDestino;
	private int idPuertoSalida; 
	private int idBuque; 
	private int idPuerto; 
	
	public Registro(int iR, Date fL, Date fS, String m, int iPD, int iPS, int iB, int iP)
	{
		idRegistro = iR; 
		fechaLlegada = fL;
		fechaSalida = fS; 
		muelle = m; 
		idPuertoDestino = iPD; 
		idPuertoSalida = iPS; 
		idBuque = iB; 
		idPuerto = iP; 
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
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

	public String getMuelle() {
		return muelle;
	}

	public void setMuelle(String muelle) {
		this.muelle = muelle;
	}

	public int getIdPuertoDestino() {
		return idPuertoDestino;
	}

	public void setIdPuertoDestino(int idPuertoDestino) {
		this.idPuertoDestino = idPuertoDestino;
	}

	public int getIdPuertoSalida() {
		return idPuertoSalida;
	}

	public void setIdPuertoSalida(int idPuertoSalida) {
		this.idPuertoSalida = idPuertoSalida;
	}

	public int getIdBuque() {
		return idBuque;
	}

	public void setIdBuque(int idBuque) {
		this.idBuque = idBuque;
	}

	public int getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(int idPuerto) {
		this.idPuerto = idPuerto;
	}
	
	
}
