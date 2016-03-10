package vos;

import java.sql.Date;
import java.sql.Time;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	public Usuario(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre)
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
