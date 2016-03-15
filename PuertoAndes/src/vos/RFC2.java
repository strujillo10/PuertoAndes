package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC2 
{
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="rut")
	private int rut;
	
	@JsonProperty(value="cantidad")
	private int cantidad;
	
	@JsonProperty(value="idUsuario")
	private int idUsuario;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	public RFC2(@JsonProperty(value="nombre")String nNombre,@JsonProperty(value="rut")int nRut,
			@JsonProperty(value="cantidad")int nCantidad,@JsonProperty(value="tipo")String nTipo,
			@JsonProperty(value="idUsuario")int nId)
	{
		nombre = nNombre; 
		rut = nRut; 
		cantidad = nCantidad; 
		tipo = nTipo; 
		idUsuario = nId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
