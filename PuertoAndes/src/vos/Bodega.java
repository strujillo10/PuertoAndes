package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bodega 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="idArea")
	private int idArea; 
	
	@JsonProperty(value="ocupacionTotal")
	private int ocupacionTotal;
	
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
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	public Bodega(@JsonProperty(value="id")int nId, @JsonProperty(value="idArea")int nIdArea,
			@JsonProperty(value="ocupacionTotal")int nOcupacion, @JsonProperty(value="plataformaExterna")String nPlataforma,
			@JsonProperty(value="cantidadCuartosFrios")int nCantidad, @JsonProperty(value="separacionColumnas")int nSeparacion,
			@JsonProperty(value="ancho")int nAncho, @JsonProperty(value="largo")int nLargo, 
			@JsonProperty(value="capacidad")int nCapacidad)
	{
		id = nId; 
		idArea = nIdArea; 
		ocupacionTotal = nOcupacion; 
		plataformaExterna = nPlataforma; 
		cantidadCuartosFrios = nCantidad; 
		separacionColumnas = nSeparacion; 
		ancho = nAncho; 
		largo = nLargo; 
		capacidad = nCapacidad;
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

	public int getOcupacionTotal() {
		return ocupacionTotal;
	}

	public void setOcupacionTotal(int ocupacionTotal) {
		this.ocupacionTotal = ocupacionTotal;
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
}
