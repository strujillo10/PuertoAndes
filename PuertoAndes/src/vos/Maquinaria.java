package vos;

public class Maquinaria 
{
	private int idMaquina; 
	private int capacidad; 
	private int cantidad; 
	private String tipo; 
	private int idPuerto; 
	private int idOperador; 
	
	public Maquinaria(int m, int cap, int can, String t, int p, int op)
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
