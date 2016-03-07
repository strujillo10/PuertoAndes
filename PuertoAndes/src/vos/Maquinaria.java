package vos;

public class Maquinaria 
{
	private int idMaquina; 
	private int capacidad; 
	private int cantidad; 
	private String tipo; 
	private int idPuerto; 
	private int idOperador; 
	
	public Maquinaria(int m, int cap, int can, String t, int p, int op)
	{
		idMaquina = m; 
		capacidad = cap; 
		cantidad = can; 
		tipo = t; 
		idPuerto = p; 
		idOperador = op; 
	}
}
