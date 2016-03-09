package vos;

public class Operador 
{
	private int idOperador;
	private String nombre; 
	private String operacion; 
	
	public Operador(int idO, String n, String o)
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
