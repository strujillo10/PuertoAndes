package vos;

public class Puerto 
{
	private int idPuerto; 
	private String nombre; 
	private String pais; 
	private String ciudad; 
	private int capacidad; 
	private String localizacion; 
	
	public Puerto(int idP, String n, String p, String ciu, int c, String loc)
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
