package vos;

import java.sql.Date;

public class Camion 
{
	private int idCamion; 
	private Date fechaLlegada; 
	private Date fechaSalida; 
	private String nombreAgente; 
	private int carga; 
	private int cantidadContenedores;
	private int idPuerto; 
	
	public Camion(int iC, Date fL, Date fS, String nA, int c, int cC, int iP)
	{
		idCamion = iC;
		fechaLlegada = fL; 
		fechaSalida = fS; 
		nombreAgente = nA; 
		carga = c; 
		cantidadContenedores = cC; 
		idPuerto = iP;
	}
}
