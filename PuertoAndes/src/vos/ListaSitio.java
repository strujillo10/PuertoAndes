package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaSitio {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="sitios")
	private List<Sitio> sitios;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaSitio( @JsonProperty(value="sitios")List<Sitio> sitios){
		this.sitios = sitios;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Sitio> getSitios() {
		return sitios;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setSitio(List<Sitio> sitios) {
		this.sitios = sitios;
	}
}
