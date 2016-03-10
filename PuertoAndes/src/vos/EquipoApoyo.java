package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class EquipoApoyo 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="tipo")
	private String tipo; 
	
	@JsonProperty(value="cantidadPuerto")
	private int cantidadPuerto; 
	
	public EquipoApoyo(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre,
			@JsonProperty(value="tipo")String nTipo, @JsonProperty(value="cantidadPuerto")int nCantidad)
	{
		id = nId; 
		nombre = nNombre; 
		tipo = nTipo;
		cantidadPuerto = nCantidad; 
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidadPuerto() {
		return cantidadPuerto;
	}

	public void setCantidadPuerto(int cantidadPuerto) {
		this.cantidadPuerto = cantidadPuerto;
	}
	
}
