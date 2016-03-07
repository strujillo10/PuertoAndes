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
}
