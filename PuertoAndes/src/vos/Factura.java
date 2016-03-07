package vos;

public class Factura 
{
	private int idFactura; 
	private String medioTransporte; 
	private int numEquipos; 
	private int espacio; 
	private int numDias; 
	private int costoTotal; 
	
	public Factura(int f, String mT, int nE, int e, int nD, int cT)
	{
		idFactura = f; 
		medioTransporte = mT; 
		numEquipos = nE; 
		espacio = e; 
		numDias = nD; 
		costoTotal = cT;
	}
}
