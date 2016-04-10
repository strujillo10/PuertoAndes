package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC6 
{
	@JsonProperty(value = "id")
	private int id;
	
	@JsonProperty(value = "tipo")
	private String tipo;
	
	@JsonProperty(value = "capacidadEnToneladas")
	private int capacidadEnToneladas;
	
	@JsonProperty(value = "ocupacionActual")
	private int ocupacionActual;
	
	@JsonProperty(value = "estado")
	private String estado;
	
	@JsonProperty(value = "nombreSitio")
	private String nombreSitio;
	
	@JsonProperty(value = "dimension")
	private String dimension;
	
	@JsonProperty(value = "tipoDeCarga")
	private String tipoDeCarga;
	
	@JsonProperty(value = "separacionEntreColumnas")
	private int separacionEntreColumnas;
	
	@JsonProperty(value = "anchoEnMetros")
	private int anchoEnMetros;
	
	@JsonProperty(value = "largoEnMetros")
	private int largoEnMetros;
	
	@JsonProperty(value = "plataformaExterna")
	private String plataformaExterna;
	
	@JsonProperty(value = "cantidadDeCuartosFrios")
	private int cantidadDeCuartosFrios;
	
	@JsonProperty(value = "dimensionesCuarto")
	private String dimensionesCuarto;
	
	@JsonProperty(value = "areaUtilizadaCuarto")
	private String areaUtilizadaCuarto;
	
	@JsonProperty(value = "areaCuartoFrio")
	private String areaCuartoFrio;
	
	public RFC6(@JsonProperty(value = "id")int pId, @JsonProperty(value = "tipo")String pTipo, @JsonProperty(value = "capacidadEnToneladas")int pCapacidadEnToneladas
			,@JsonProperty(value = "ocupacionActual")int pOcupacionActual, @JsonProperty(value = "estado")String pEstado, @JsonProperty(value = "nombreSitio")String pNombreSitio
			,@JsonProperty(value = "dimension")String pDimension, @JsonProperty(value = "tipoDeCarga") String pTipoCarga,  
			@JsonProperty(value = "separacionEntreColumnas") int pSeparacionEntreColumnas, @JsonProperty(value = "anchoEnMetros") int pAnchoEnMetros,
			@JsonProperty(value = "largoEnMetros") int pLargoEnMetros, @JsonProperty(value = "plataformaExterna") String pPlataformaExterna, 
			@JsonProperty(value = "cantidadDeCuartosFrios") int pCantidadCuartosFrios, @JsonProperty(value = "dimensionesCuarto") String pDimensionesCuarto
			, @JsonProperty(value = "areaUtilizadaCuarto") String pAreaUtilizadaCuarto, @JsonProperty(value = "areaCuartoFrio") String pAreaCuarto)
	{
		this.anchoEnMetros = pAnchoEnMetros;
		this.areaCuartoFrio = pAreaCuarto;
		this.areaUtilizadaCuarto = pAreaUtilizadaCuarto;
		this.cantidadDeCuartosFrios = pCantidadCuartosFrios;
		this.capacidadEnToneladas = pCapacidadEnToneladas;
		this.dimension = pDimension;
		this.dimensionesCuarto = pDimensionesCuarto;
		this.estado = pEstado;
		this.id = pId;
		this.largoEnMetros = pLargoEnMetros;
		this.nombreSitio = pNombreSitio;
		this.ocupacionActual = pOcupacionActual;
		this.plataformaExterna = pPlataformaExterna;
		this.separacionEntreColumnas = pSeparacionEntreColumnas;
		this.tipo = pTipo;
		this.tipoDeCarga = pTipoCarga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidadEnToneladas() {
		return capacidadEnToneladas;
	}

	public void setCapacidadEnToneladas(int capacidadEnToneladas) {
		this.capacidadEnToneladas = capacidadEnToneladas;
	}

	public int getOcupacionActual() {
		return ocupacionActual;
	}

	public void setOcupacionActual(int ocupacionActual) {
		this.ocupacionActual = ocupacionActual;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreSitio() {
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getTipoDeCarga() {
		return tipoDeCarga;
	}

	public void setTipoDeCarga(String tipoDeCarga) {
		this.tipoDeCarga = tipoDeCarga;
	}

	public int getSeparacionEntreColumnas() {
		return separacionEntreColumnas;
	}

	public void setSeparacionEntreColumnas(int separacionEntreColumnas) {
		this.separacionEntreColumnas = separacionEntreColumnas;
	}

	public int getAnchoEnMetros() {
		return anchoEnMetros;
	}

	public void setAnchoEnMetros(int anchoEnMetros) {
		this.anchoEnMetros = anchoEnMetros;
	}

	public int getLargoEnMetros() {
		return largoEnMetros;
	}

	public void setLargoEnMetros(int largoEnMetros) {
		this.largoEnMetros = largoEnMetros;
	}

	public String getPlataformaExterna() {
		return plataformaExterna;
	}

	public void setPlataformaExterna(String plataformaExterna) {
		this.plataformaExterna = plataformaExterna;
	}

	public int getCantidadDeCuartosFrios() {
		return cantidadDeCuartosFrios;
	}

	public void setCantidadDeCuartosFrios(int cantidadDeCuartosFrios) {
		this.cantidadDeCuartosFrios = cantidadDeCuartosFrios;
	}

	public String getDimensionesCuarto() {
		return dimensionesCuarto;
	}

	public void setDimensionesCuarto(String dimensionesCuarto) {
		this.dimensionesCuarto = dimensionesCuarto;
	}

	public String getAreaUtilizadaCuarto() {
		return areaUtilizadaCuarto;
	}

	public void setAreaUtilizadaCuarto(String areaUtilizadaCuarto) {
		this.areaUtilizadaCuarto = areaUtilizadaCuarto;
	}

	public String getAreaCuartoFrio() {
		return areaCuartoFrio;
	}

	public void setAreaCuartoFrio(String areaCuartoFrio) {
		this.areaCuartoFrio = areaCuartoFrio;
	}
}
