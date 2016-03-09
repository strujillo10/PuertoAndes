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

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getMedioTransporte() {
		return medioTransporte;
	}

	public void setMedioTransporte(String medioTransporte) {
		this.medioTransporte = medioTransporte;
	}

	public int getNumEquipos() {
		return numEquipos;
	}

	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}

	public int getEspacio() {
		return espacio;
	}

	public void setEspacio(int espacio) {
		this.espacio = espacio;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
}
