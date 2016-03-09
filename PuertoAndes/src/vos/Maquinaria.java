package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Maquinaria 
{
	@JsonProperty(value="idMaquina")
	private int idMaquina; 
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	@JsonProperty(value="cantidad")
	private int cantidad; 
	
	@JsonProperty(value="tipo")
	private String tipo; 
	
	@JsonProperty(value="idPuerto")
	private int idPuerto; 
	
	@JsonProperty(value="idOperador")
	private int idOperador; 
	
	public Maquinaria(@JsonProperty(value="idMaquina")int m, @JsonProperty(value="capacidad")int cap, 
			@JsonProperty(value="cantidad")int can, @JsonProperty(value="tipo")String t, 
			@JsonProperty(value="idPuerto")int p, @JsonProperty(value="idOperador")int op)
	{
		idMaquina = m; 
		capacidad = cap; 
		cantidad = can; 
		tipo = t; 
		idPuerto = p; 
		idOperador = op; 
	}

	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(int idPuerto) {
		this.idPuerto = idPuerto;
	}

	public int getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}
	
	
}
