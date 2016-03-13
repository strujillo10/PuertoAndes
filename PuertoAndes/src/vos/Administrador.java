package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Administrador 
{
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	

	
	public Administrador(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre)
	{
		id = nId;
		nombre = nNombre; 
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

}
