package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Patio 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idArea")
	private int idArea;
	
	@JsonProperty(value="dimension")
	private String dimension;
	
	@JsonProperty(value="tipoCarga")
	private String tipoCarga;
	
	public Patio(@JsonProperty(value="id")int nId, @JsonProperty(value="idArea")int nIdArea,
			@JsonProperty(value="dimension")String nDimension, @JsonProperty(value="tipoCarga")String nTipo)
	{
		id = nId; 
		idArea = nIdArea; 
		dimension = nDimension;
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

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
}
