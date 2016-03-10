package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Buque 
{
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="registroCapitania")
	private String registroCapitania; 
	
	@JsonProperty(value="agenciaMaritima")
	private String agenciaMaritima; 
	
	@JsonProperty(value="cantidadContenedores")
	private int cantidadContenedores; 
	
	public Buque(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre,
			@JsonProperty(value="registroCapitania")String nRegistroCapitania, @JsonProperty(value="agenciaMaritima")String nAgencia,
			@JsonProperty(value="cantidadContenedores")int nCantidad)
	{
		id = nId; 
		nombre = nNombre; 
		registroCapitania = nRegistroCapitania; 
		agenciaMaritima = nAgencia; 
		cantidadContenedores = nCantidad; 
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

	public String getRegistroCapitania() {
		return registroCapitania;
	}

	public void setRegistroCapitania(String registroCapitania) {
		this.registroCapitania = registroCapitania;
	}

	public String getAgenciaMaritima() {
		return agenciaMaritima;
	}

	public void setAgenciaMaritima(String agenciaMaritima) {
		this.agenciaMaritima = agenciaMaritima;
	}

	public int getCantidadContenedores() {
		return cantidadContenedores;
	}

	public void setCantidadContenedores(int cantidadContenedores) {
		this.cantidadContenedores = cantidadContenedores;
	}
}
