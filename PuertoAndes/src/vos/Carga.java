package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Carga 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	public Carga(@JsonProperty(value="id")int nId, @JsonProperty(value="tipo")String nTipo)
	{
		id = nId; 
		tipo = nTipo; 
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
	
}
