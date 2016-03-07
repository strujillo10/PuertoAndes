package vos;

import java.sql.Date;

public class Registro 
{
	private int idRegistro; 
	private Date fechaLlegada;
	private Date fechaSalida; 
	private String muelle; 
	private int idPuertoDestino;
	private int idPuertoSalida; 
	private int idBuque; 
	private int idPuerto; 
	
	public Registro(int iR, Date fL, Date fS, String m, int iPD, int iPS, int iB, int iP)
	{
		idRegistro = iR; 
		fechaLlegada = fL;
		fechaSalida = fS; 
		muelle = m; 
		idPuertoDestino = iPD; 
		idPuertoSalida = iPS; 
		idBuque = iB; 
		idPuerto = iP; 
	}
}
