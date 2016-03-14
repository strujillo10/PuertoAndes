package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bodega 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idArea")
	private int idArea; 
	
	@JsonProperty(value="plataformaExterna")
	private String plataformaExterna; 
	
	@JsonProperty(value="cantidadCuartosFrios")
	private int cantidadCuartosFrios;
	
	@JsonProperty(value="separacionColumnas")
	private int separacionColumnas; 
	
	@JsonProperty(value="ancho")
	private int ancho; 
	
	@JsonProperty(value="largo")
	private int largo;
	
	
	public Bodega(@JsonProperty(value="id")int nId, @JsonProperty(value="idArea")int nIdArea,
		 @JsonProperty(value="plataformaExterna")String nPlataforma,
			@JsonProperty(value="cantidadCuartosFrios")int nCantidad, @JsonProperty(value="separacionColumnas")int nSeparacion,
			@JsonProperty(value="ancho")int nAncho, @JsonProperty(value="largo")int nLargo)
	{
		id = nId; 
		idArea = nIdArea; 
		plataformaExterna = nPlataforma; 
		cantidadCuartosFrios = nCantidad; 
		separacionColumnas = nSeparacion; 
		ancho = nAncho; 
		largo = nLargo; 
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


	public String getPlataformaExterna() {
		return plataformaExterna;
	}

	public void setPlataformaExterna(String plataformaExterna) {
		this.plataformaExterna = plataformaExterna;
	}

	public int getCantidadCuartosFrios() {
		return cantidadCuartosFrios;
	}

	public void setCantidadCuartosFrios(int cantidadCuartosFrios) {
		this.cantidadCuartosFrios = cantidadCuartosFrios;
	}

	public int getSeparacionColumnas() {
		return separacionColumnas;
	}

	public void setSeparacionColumnas(int separacionColumnas) {
		this.separacionColumnas = separacionColumnas;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	
}
