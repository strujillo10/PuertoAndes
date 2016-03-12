package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Factura 
{
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="idCamion")
	private int idCamion;
	
	@JsonProperty(value="idBuque")
	private int idBuque;
	
	@JsonProperty(value="numEquipos")
	private int numEquipos;
	
	@JsonProperty(value="espacio")
	private int espacio;
	
	@JsonProperty(value="numDias")
	private int numDias;
	
	@JsonProperty(value="costoTotal")
	private int costoTotal;
	
	public Factura(@JsonProperty(value="id")int nId, @JsonProperty(value="idCamion")int nIdCamion, 
			@JsonProperty(value="idBuque")int nIdBuque, @JsonProperty(value="numEquipos") int nNumEquipos,
			@JsonProperty(value="espacio")int nEspacio, @JsonProperty(value="numDIas")int nNumDias, 
			@JsonProperty(value="costoTotal")int nCosto)
	{
		id = nId;
		idCamion = nIdCamion; 
		idBuque = nIdBuque; 
		numEquipos = nNumEquipos; 
		espacio = nEspacio; 
		numDias = nNumDias; 
		costoTotal = nCosto; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}

	public int getIdBuque() {
		return idBuque;
	}

	public void setIdBuque(int idBuque) {
		this.idBuque = idBuque;
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