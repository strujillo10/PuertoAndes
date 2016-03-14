package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cobertizo 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idArea")
	private int idArea;  
	
	@JsonProperty(value="dimension")
	private String dimensionTotal; 
	
	@JsonProperty(value="tipoCarga")
	private String tipoCarga; 
	
	public Cobertizo(@JsonProperty(value="id")int nId, @JsonProperty(value="idArea")int nIdArea,
			@JsonProperty(value="dimension")String nDimension, @JsonProperty(value="tipoCarga")String nTipo)
	{
		id = nId; 
		idArea = nIdArea;  
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
