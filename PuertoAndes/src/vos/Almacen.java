package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Almacen 
{
	@JsonProperty(value="idAlmacen")
	private int idAlmacen; 
	
	@JsonProperty(value="tipo")
	private String tipo; 
	
	@JsonProperty(value="tipoCarga")
	private String tipoCarga; 
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	@JsonProperty(value="ancho")
	private int ancho; 
	
	@JsonProperty(value="largo")
	private int largo;
	
	@JsonProperty(value="plataforma")
	private int plataforma; 
	
	@JsonProperty(value="separacion")
	private int separacion; 
	
	@JsonProperty(value="cuartoFrio")
	private int cuartoFrio; 
	
	@JsonProperty(value="areaFrio")
	private int areaFrio; 
	
	@JsonProperty(value="largoFrio")
	private int largoFrio; 
	
	@JsonProperty(value="anchoFrio")
	private int anchoFrio; 
	
	@JsonProperty(value="altoFrio")
	private int altoFrio; 
	
	@JsonProperty(value="areaUsada")
	private int areaUsada; 
	
	@JsonProperty(value="idPuerto")
	private int idPuerto; 
	
	@JsonProperty(value="lleno")
	private int lleno; 
	
	public Almacen(@JsonProperty(value="idAlmacen")int iA, @JsonProperty(value="tipo")String t, @JsonProperty(value="tipoCarga")String tC, 
			@JsonProperty(value="nombre")String n, @JsonProperty(value="capacidad")int c, @JsonProperty(value="ancho")int a, 
			@JsonProperty(value="largo")int l, @JsonProperty(value="plataforma")int p, @JsonProperty(value="separacion")int s, 
			@JsonProperty(value="cuartoFrio")int cF,@JsonProperty(value="areaFrio")int aF, @JsonProperty(value="largoFrio")int lF, 
			@JsonProperty(value="anchoFrio")int anF, @JsonProperty(value="altoFrio")int alF, @JsonProperty(value="areaUsada")int aU, 
			@JsonProperty(value="idPuerto")int iP, @JsonProperty(value="lleno")int llen)
	{
		idAlmacen = iA; 
		tipo = t; 
		tipoCarga = tC; 
		nombre = n; 
		capacidad = c; 
		ancho = a; 
		largo = l; 
		plataforma = p; 
		separacion = s; 
		cuartoFrio = cF; 
		areaFrio = aF; 
		largoFrio = lF; 
		anchoFrio = anF; 
		altoFrio = alF; 
		areaUsada = aU; 
		idPuerto = iP; 
		lleno = llen; 		
	}
	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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

	public int getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(int plataforma) {
		this.plataforma = plataforma;
	}

	public int getSeparacion() {
		return separacion;
	}

	public void setSeparacion(int separacion) {
		this.separacion = separacion;
	}

	public int getCuartoFrio() {
		return cuartoFrio;
	}

	public void setCuartoFrio(int cuartoFrio) {
		this.cuartoFrio = cuartoFrio;
	}

	public int getAreaFrio() {
		return areaFrio;
	}

	public void setAreaFrio(int areaFrio) {
		this.areaFrio = areaFrio;
	}

	public int getLargoFrio() {
		return largoFrio;
	}

	public void setLargoFrio(int largoFrio) {
		this.largoFrio = largoFrio;
	}

	public int getAnchoFrio() {
		return anchoFrio;
	}

	public void setAnchoFrio(int anchoFrio) {
		this.anchoFrio = anchoFrio;
	}

	public int getAltoFrio() {
		return altoFrio;
	}

	public void setAltoFrio(int altoFrio) {
		this.altoFrio = altoFrio;
	}

	public int getAreaUsada() {
		return areaUsada;
	}

	public void setAreaUsada(int areaUsada) {
		this.areaUsada = areaUsada;
	}

	public int getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(int idPuerto) {
		this.idPuerto = idPuerto;
	}

	public int getLleno() {
		return lleno;
	}

	public void setLleno(int lleno) {
		this.lleno = lleno;
	}
}
