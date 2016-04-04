package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AreaAlmacenamiento 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="ocupacion")
	private int ocupacion;
	
	public AreaAlmacenamiento(@JsonProperty(value="id")int nId, @JsonProperty(value="capacidad")int nCapacidad,
			@JsonProperty(value="tipo")String nTipo, @JsonProperty(value="ocupacion")int nOcupacion)
	{
		id = nId; 
		capacidad = nCapacidad;
		tipo = nTipo;
		ocupacion = nOcupacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
