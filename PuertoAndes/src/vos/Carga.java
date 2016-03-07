package vos;

public class Carga 
{
	private int idCarga; 
	private String nombre; 
	private String procedencia; 
	private String destino; 
	private int idBuque;
	private int idAlmacen; 
	private int idUsuario;
	
	public Carga(int iC, String n, String p, String d, int iB, int iA, int iU)
	{
		idCarga = iC;
		nombre = n; 
		procedencia = p; 
		destino = d; 
		idBuque = iB;
		idAlmacen = iA;
		idUsuario = iU;
	}
}
