package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Administrador 
{
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="idUsuario")
	private int idUsuario;
	
	public Administrador(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre, 
			@JsonProperty(value="idUsuario")int nIdUsuario)
	{
		id = nId;
		nombre = nNombre; 
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
