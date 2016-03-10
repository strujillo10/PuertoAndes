package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCarga {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="cargas")
	private List<Carga> cargas;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaCarga( @JsonProperty(value="cargas")List<Carga> cargas){
		this.cargas = cargas;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Carga> getCargas() {
		return cargas;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setCarga(List<Carga> cargas) {
		this.cargas = cargas;
	}
}
