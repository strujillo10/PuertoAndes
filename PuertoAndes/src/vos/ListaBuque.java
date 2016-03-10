package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBuque {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="buques")
	private List<Buque> buques;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaBuque( @JsonProperty(value="buques")List<Buque> buques){
		this.buques = buques;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Buque> getBuques() {
		return buques;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setBuque(List<Buque> buques) {
		this.buques = buques;
	}
}
