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
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="estado")
	private String estado;
	
	@JsonProperty(value="ocupacionActual")
	private int ocupacionActual;
	
	public Buque(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre,
			@JsonProperty(value="registroCapitania")String nRegistroCapitania, @JsonProperty(value="agenciaMaritima")String nAgencia,
			@JsonProperty(value="cantidadContenedores")int nCantidad, @JsonProperty(value="capacidad")int nCapacidad,
			@JsonProperty(value="estado")String nEstado, @JsonProperty(value="ocupacionActual")int nOcupacion)
	{
		id = nId; 
		nombre = nNombre; 
		registroCapitania = nRegistroCapitania; 
		agenciaMaritima = nAgencia; 
		cantidadContenedores = nCantidad; 
		capacidad = nCapacidad; 
		ocupacionActual = nOcupacion;
		estado = nEstado; 
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getOcupacionActual() {
		return ocupacionActual;
	}

	public void setOcupacionActual(int ocupacionActual) {
		this.ocupacionActual = ocupacionActual;
	}
	
}
