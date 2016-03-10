package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBuqueMultiproposito {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="buquesM")
	private List<BuqueMultiproposito> buquesM;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaBuqueMultiproposito( @JsonProperty(value="buquesM")List<BuqueMultiproposito> buquesM){
		this.buquesM = buquesM;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<BuqueMultiproposito> getBuquesM() {
		return buquesM;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setBuqueM(List<BuqueMultiproposito> buquesM) {
		this.buquesM = buquesM;
	}
}
