package vos;

public class Buque 
{
	private int idBuque; 
	private int registro; 
	private String nombreBuque; 
	private String nombreAgente; 
	private String tipo;
	private int capacidad; 
	private int cantidadContenedores; 
	private int carga; 
	
	public Buque(int iB, int r, String nB, String nA, String t, int c, int cC, int car)
	{
		idBuque = iB; 
		registro = r; 
		nombreBuque = nB; 
		nombreAgente = nA; 
		tipo = t; 
		capacidad = c; 
		cantidadContenedores = cC; 
		carga = car; 
	}
}
