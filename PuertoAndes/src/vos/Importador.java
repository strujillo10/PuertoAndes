package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Importador 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="registroAduana")
	private String registroAduana; 
	
	@JsonProperty(value="tipo")
	private String tipo; 
	
	@JsonProperty(value="idUsuario")
	private int idUsuario;
	
	public Importador(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre,
			@JsonProperty(value="registroAduana")String nRegistro, @JsonProperty(value="tipo")String nTipo,
			@JsonProperty(value="idUsuario")int nIdUsuario)
	{
		id = nId; 
		nombre = nNombre; 
		registroAduana = nRegistro; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegistroAduana() {
		return registroAduana;
	}

	public void setRegistroAduana(String registroAduana) {
		this.registroAduana = registroAduana;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
