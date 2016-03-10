package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaContenedor {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="contenedores")
	private List<Contenedor> contenedores;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaContenedor( @JsonProperty(value="contenedores")List<Contenedor> contenedores){
		this.contenedores = contenedores;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Contenedor> getContenedores() {
		return contenedores;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setContenedor(List<Contenedor> contenedores) {
		this.contenedores = contenedores;
	}
}
