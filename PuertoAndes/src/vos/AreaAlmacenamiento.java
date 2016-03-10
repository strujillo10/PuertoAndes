package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AreaAlmacenamiento 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	@JsonProperty(value="ocupacionActual")
	private int ocupacionActual;
	
	public AreaAlmacenamiento(@JsonProperty(value="id")int nId, @JsonProperty(value="capacidad")int nCapacidad,
			@JsonProperty(value="ocupacionActual")int nOcupacion)
	{
		id = nId; 
		capacidad = nCapacidad;
		ocupacionActual = nOcupacion;
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

	public int getOcupacionActual() {
		return ocupacionActual;
	}

	public void setOcupacionActual(int ocupacionActual) {
		this.ocupacionActual = ocupacionActual;
	}
	
}
