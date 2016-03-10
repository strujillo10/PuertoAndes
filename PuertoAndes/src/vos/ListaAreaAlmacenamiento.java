package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAreaAlmacenamiento {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="areas")
	private List<AreaAlmacenamiento> areas;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaAreaAlmacenamiento( @JsonProperty(value="areas")List<AreaAlmacenamiento> areas){
		this.areas = areas;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<AreaAlmacenamiento> getAreas() {
		return areas;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setArea(List<AreaAlmacenamiento> areas) {
		this.areas = areas;
	}
}
