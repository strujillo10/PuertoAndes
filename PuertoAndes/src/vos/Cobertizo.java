package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cobertizo 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idArea")
	private int idArea; 
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="ocupacionTotal")
	private int ocupacionTotal; 
	
	@JsonProperty(value="dimension")
	private String dimensionTotal; 
	
	@JsonProperty(value="tipoCarga")
	private String tipoCarga; 
	
	public Cobertizo(@JsonProperty(value="id")int nId, @JsonProperty(value="idArea")int nIdArea,
			@JsonProperty(value="capacidad")int nCapacidad, @JsonProperty(value="ocupacionTotal")int nOcupacion,
			@JsonProperty(value="dimension")String nDimension, @JsonProperty(value="tipoCarga")String nTipo)
	{
		id = nId; 
		idArea = nIdArea; 
		capacidad = nCapacidad; 
		ocupacionTotal = nOcupacion; 
		dimensionTotal = nDimension;
		tipoCarga = nTipo;
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

	public String getDimensionTotal() {
		return dimensionTotal;
	}

	public void setDimensionTotal(String dimensionTotal) {
		this.dimensionTotal = dimensionTotal;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
}
