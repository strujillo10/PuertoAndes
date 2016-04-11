package vos;

import java.sql.Date;
import org.codehaus.jackson.annotate.JsonProperty;

public class RFC5 
{
	@JsonProperty(value = "id")
	private int id;
	
	@JsonProperty(value = "origen")
	private String origen;
	
	@JsonProperty(value = "destino")
	private String destino;
	
	@JsonProperty(value = "idOrigen")
	private int idOrigen;
	
	@JsonProperty(value = "idDestino")
	private int idDestino;
	
	@JsonProperty(value = "fechaOrden")
	private Date fechaOrden;
	
	@JsonProperty(value = "fechaRealizacion")
	private Date fechaRealizacion;
	
	@JsonProperty(value = "idCarga")
	private int idCarga;
	
	@JsonProperty(value = "tipo")
	private String tipo;
	
	@JsonProperty(value = "peso")
	private int peso;
	
	@JsonProperty(value = "ciudadDestino")
	private String ciudadDestino;
	
	public RFC5(@JsonProperty(value = "id")int pId, @JsonProperty(value = "origen")String pOrigen, @JsonProperty(value = "destino")String pDestino, 
			@JsonProperty(value = "idOrigen") int pIdOrigen, @JsonProperty(value = "idDestino")int pIdDestino,
			@JsonProperty(value = "fechaOrden")Date pFechaOrden, 
			@JsonProperty(value = "fechaRealizacion")Date pFechaRealizacion, 
			@JsonProperty(value = "idCarga")int pIdCarga,
			@JsonProperty(value = "tipo")String pTipo, @JsonProperty(value = "peso")int pPeso,
			@JsonProperty(value = "ciudadDestino")String pCiudadDestino)
	{
		this.ciudadDestino = pCiudadDestino;
		this.destino = pDestino;
		this.fechaOrden = pFechaOrden;
		this.fechaRealizacion = pFechaRealizacion;
		this.id = pId;
		this.idCarga = pIdCarga;
		this.idDestino = pIdDestino;
		this.origen = pOrigen;
		this.peso = pPeso;
		this.tipo = pTipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public int getIdCarga() {
		return idCarga;
	}

	public void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
}
