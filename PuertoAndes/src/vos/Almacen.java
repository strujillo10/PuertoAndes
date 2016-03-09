package vos;

public class Almacen 
{
	private int idAlmacen; 
	private String tipo; 
	private String tipoCarga; 
	private String nombre; 
	private int capacidad; 
	private int ancho; 
	private int largo;
	private int plataforma; 
	private int separacion; 
	private int cuartoFrio; 
	private int areaFrio; 
	private int largoFrio; 
	private int anchoFrio; 
	private int altoFrio; 
	private int areaUsada; 
	private int idPuerto; 
	private int lleno; 
	
	public Almacen(int iA, String t, String tC, String n, int c, int a, int l, int p, int s, int cF,
			int aF, int lF, int anF, int alF, int aU, int iP, int llen)
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
