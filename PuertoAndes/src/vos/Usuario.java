package vos;

public class Usuario 
{
	private int idUsuario;
	private String nombre; 
	private String registro; 
	private String tipo;
	private int importador; 
	private String rut; 
	
	public Usuario(int iU, String n, String r, String t, int i, String nRut)
	{
		idUsuario = iU;
		nombre = n; 
		registro = r; 
		tipo = t; 
		importador = i; 
		rut = nRut;
	}
}
