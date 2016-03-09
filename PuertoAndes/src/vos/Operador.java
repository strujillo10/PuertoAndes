package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Operador 
{
	@JsonProperty(value="idOperador")
	private int idOperador;
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="operacion")
	private String operacion; 
	
	public Operador(@JsonProperty(value="idOperador")int idO, @JsonProperty(value="nombre")String n, 
			@JsonProperty(value="operacion")String o)
	{
		idOperador = idO;
		nombre = n; 
		operacion = o; 
	}

	public int getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
}
