package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Contenedor 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="tipo")
	private String tipo; 
	
	@JsonProperty(value="peso")
	private int peso; 
	
	public Contenedor(@JsonProperty(value="id")int nId, @JsonProperty(value="tipo")String nTipo,
			@JsonProperty(value="peso")int nPeso)
	{
		id = nId; 
		tipo = nTipo; 
		peso = nPeso;
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
	
}
