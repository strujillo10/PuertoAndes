package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Sitio 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idArea")
	private int idArea;
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	@JsonProperty(value="ocupacionTotal")
	private int ocupacionTotal;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	public Sitio(@JsonProperty(value="id")int nId, @JsonProperty(value="idArea")int nIdArea,
			@JsonProperty(value="capacidad")int nCapacidad, @JsonProperty(value="ocupacionTotal")int nOcupacion,
			@JsonProperty(value="nombre")String nNombre)
	{
		id = nId; 
		idArea = nIdArea; 
		capacidad = nCapacidad; 
		ocupacionTotal = nOcupacion; 
		nombre = nNombre; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupacionTotal() {
		return ocupacionTotal;
	}

	public void setOcupacionTotal(int ocupacionTotal) {
		this.ocupacionTotal = ocupacionTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}