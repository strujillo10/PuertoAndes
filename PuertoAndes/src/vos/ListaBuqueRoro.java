package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBuqueRoro {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="buquesR")
	private List<BuqueRoro> buquesR;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaBuqueRoro( @JsonProperty(value="buquesR")List<BuqueRoro> buquesR){
		this.buquesR = buquesR;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<BuqueRoro> getBuquesR() {
		return buquesR;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setBuqueR(List<BuqueRoro> buquesR) {
		this.buquesR = buquesR;
	}
}