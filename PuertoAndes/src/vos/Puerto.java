package vos;

public class Puerto 
{
	private int idPuerto; 
	private String nombre; 
	private String pais; 
	private String ciudad; 
	private int capacidad; 
	private String localizacion; 
	
	public Puerto(int idP, String n, String p, String ciu, int c, String loc)
	{
		idPuerto = idP; 
		nombre = n; 
		pais = p; 
		ciudad = ciu; 
		capacidad = c;
		localizacion = loc; 
	}
}
