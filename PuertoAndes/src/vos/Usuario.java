package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario 
{
	@JsonProperty(value="idUsuario")
	private int idUsuario;
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="registro")
	private String registro; 
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="importador")
	private int importador; 
	
	@JsonProperty(value="rut")
	private String rut; 
	
	public Usuario(@JsonProperty(value="idUsuario")int iU, @JsonProperty(value="nombre")String n, 
			@JsonProperty(value="registro")String r, @JsonProperty(value="tipo")String t, 
			@JsonProperty(value="importador")int i, @JsonProperty(value="rut")String nRut)
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
