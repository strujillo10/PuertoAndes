package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Puerto 
{
	@JsonProperty(value="idPuerto")
	private int idPuerto; 
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="pais")
	private String pais; 
	
	@JsonProperty(value="ciudad")
	private String ciudad; 
	
	@JsonProperty(value="capacidad")
	private int capacidad; 
	
	@JsonProperty(value="localizacion")
	private String localizacion; 
	
	public Puerto(@JsonProperty(value="idPuerto")int idP, @JsonProperty(value="nombre")String n, 
			@JsonProperty(value="pais")String p, @JsonProperty(value="ciudad")String ciu, 
			@JsonProperty(value="capacidad")int c, @JsonProperty(value="localizacion")String loc)
	{
		idPuerto = idP; 
		nombre = n; 
		pais = p; 
		ciudad = ciu; 
		capacidad = c;
		localizacion = loc; 
	}

	public int getIdPuerto() {
		return idPuerto;
	}

	public void setIdPuerto(int idPuerto) {
		this.idPuerto = idPuerto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	
}
