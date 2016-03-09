package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Registro 
{
	@JsonProperty(value="idRegistro")
	private int idRegistro; 
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada;
	
	@JsonProperty(value="fechaSalida")
	private Date fechaSalida; 
	
	@JsonProperty(value="muelle")
	private String muelle; 
	
	@JsonProperty(value="idPuertoDestino")
	private int idPuertoDestino;
	
	@JsonProperty(value="idPuertoSalida")
	private int idPuertoSalida; 
	
	@JsonProperty(value="idBuque")
	private int idBuque; 
	
	@JsonProperty(value="idPuerto")
	private int idPuerto; 
	
	public Registro(@JsonProperty(value="idRegistro")int iR, @JsonProperty(value="fechaLlegada")Date fL, 
			@JsonProperty(value="fechaSalida")Date fS, @JsonProperty(value="muelle")String m, 
			@JsonProperty(value="idPuertoDestino")int iPD, @JsonProperty(value="idPuertoSalida")int iPS, 
			@JsonProperty(value="idBuque")int iB, @JsonProperty(value="idPuerto")int iP)
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
