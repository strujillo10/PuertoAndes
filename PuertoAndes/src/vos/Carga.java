package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Carga 
{
	@JsonProperty(value="idCarga")
	private int idCarga; 
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="procedencia")
	private String procedencia; 
	
	@JsonProperty(value="destino")
	private String destino; 
	
	@JsonProperty(value="idBuque")
	private int idBuque;
	
	@JsonProperty(value="idAlmacen")
	private int idAlmacen; 
	
	@JsonProperty(value="idUsuario")
	private int idUsuario;
	
	public Carga(@JsonProperty(value="idCarga")int iC, @JsonProperty(value="nombre")String n, 
			@JsonProperty(value="procedencia")String p, @JsonProperty(value="destino")String d, 
			@JsonProperty(value="idBuque")int iB, @JsonProperty(value="idAlmacen")int iA, 
			@JsonProperty(value="idUsuario")int iU)
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
