package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Exportador 
{
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="rut")
	private String rut; 
	
	@JsonProperty(value="idUsuario")
	private int idUsuario; 
	
	public Exportador(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre,
		@JsonProperty(value="rut")String nRut, @JsonProperty(value="idUsuario")int nIdUsuario)
	{
		id = nId; 
		nombre = nNombre; 
		rut = nRut; 
		idUsuario = nIdUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
