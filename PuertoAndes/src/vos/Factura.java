package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Factura 
{
	@JsonProperty(value="idFactura")
	private int idFactura; 
	
	@JsonProperty(value="medioTransporte")
	private String medioTransporte; 
	
	@JsonProperty(value="numEquipos")
	private int numEquipos; 
	
	@JsonProperty(value="espacio")
	private int espacio; 
	
	@JsonProperty(value="numDias")
	private int numDias; 
	
	@JsonProperty(value="costoTotal")
	private int costoTotal; 
	
	public Factura(@JsonProperty(value="idFactura")int f, @JsonProperty(value="medioTransporte")String mT, 
			@JsonProperty(value="numEquipo")int nE, @JsonProperty(value="espacio")int e, 
			@JsonProperty(value="numDias")int nD, @JsonProperty(value="costoTotal")int cT)
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
