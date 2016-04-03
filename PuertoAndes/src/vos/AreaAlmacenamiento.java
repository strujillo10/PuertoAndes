package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AreaAlmacenamiento 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="ocupacion")
	private int ocupacion;
	
	public AreaAlmacenamiento(@JsonProperty(value="id")int nId, @JsonProperty(value="capacidad")int nCapacidad,
			@JsonProperty(value="ocupacion")int nOcupacion)
	{
		id = nId; 
		capacidad = nCapacidad;
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
}
