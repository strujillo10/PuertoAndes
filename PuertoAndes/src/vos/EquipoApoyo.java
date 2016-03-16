package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class EquipoApoyo 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="capacidad")
	private String capacidad; 
	
	@JsonProperty(value="tipo")
	private String tipo; 
	
	@JsonProperty(value="idOperario")
	private int idOperario; 
	
	public EquipoApoyo(@JsonProperty(value="id")int nId, @JsonProperty(value="capacidad")String nNombre,
			@JsonProperty(value="tipo")String nTipo, @JsonProperty(value="idOperario")int nCantidad)
	{
		id = nId; 
		capacidad = nNombre; 
		tipo = nTipo;
		idOperario = nCantidad; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return capacidad;
	}

	public void setNombre(String nombre) {
		this.capacidad = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdOperario() {
		return idOperario;
	}

	public void setIdOperario(int cantidadPuerto) {
		this.idOperario = cantidadPuerto;
	}
	
}
