package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaPatio {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="patios")
	private List<Patio> patios;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaPatio( @JsonProperty(value="patios")List<Patio> patios){
		this.patios = patios;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Patio> getPatios() {
		return patios;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setPatio(List<Patio> patios) {
		this.patios = patios;
	}
}
