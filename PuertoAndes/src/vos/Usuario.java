package vos;

public class Usuario 
{
	private int idUsuario;
	private String nombre; 
	private String registro; 
	private String tipo;
	private int importador; 
	private String rut; 
	
	public Usuario(int iU, String n, String r, String t, int i, String nRut)
	{
		idUsuario = iU;
		nombre = n; 
		registro = r; 
		tipo = t; 
		importador = i; 
		rut = nRut;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getImportador() {
		return importador;
	}

	public void setImportador(int importador) {
		this.importador = importador;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	
	
}
