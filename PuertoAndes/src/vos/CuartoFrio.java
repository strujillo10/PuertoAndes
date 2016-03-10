package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class CuartoFrio 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idBodega")
	private int idBodega; 
	
	@JsonProperty(value="area")
	private String area; 
	
	@JsonProperty(value="dimensiones")
	private String dimensiones; 
	
	@JsonProperty(value="areaUtilizada")
	private String areaUtilizada; 
	
	public CuartoFrio(@JsonProperty(value="id")int nId, @JsonProperty(value="idBodega")int nIdBodega,
			@JsonProperty(value="area")String nArea, @JsonProperty(value="dimensiones")String nDimensiones,
			@JsonProperty(value="areaUtilizada")String nAreaUtilizada)
	{
		id = nId; 
		idBodega = nIdBodega; 
		area = nArea; 
		dimensiones = nDimensiones; 
		areaUtilizada = nAreaUtilizada; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getAreaUtilizada() {
		return areaUtilizada;
	}

	public void setAreaUtilizada(String areaUtilizada) {
		this.areaUtilizada = areaUtilizada;
	}
	
}
