package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Carga 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="peso")
	private int peso;
	
//	@JsonProperty(value="area")
//	private AreaAlmacenamiento area;
//	
//	@JsonProperty(value="buque")
//	private Buque buque;
	
	public Carga(@JsonProperty(value="id")int nId, @JsonProperty(value="tipo")String nTipo,
			@JsonProperty(value="peso")int nPeso)
	{
		id = nId; 
		tipo = nTipo;
		peso = nPeso;
//		area = nArea;
//		buque = nBuque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

//	public AreaAlmacenamiento getArea() {
//		return area;
//	}
//
//	public void setArea(AreaAlmacenamiento area) {
//		this.area = area;
//	}
//
//	public Buque getBuque() {
//		return buque;
//	}
//
//	public void setBuque(Buque buque) {
//		this.buque = buque;
//	}
	
}
