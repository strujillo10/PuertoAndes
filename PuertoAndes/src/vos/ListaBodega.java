package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBodega {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="bodegas")
	private List<Bodega> bodegas;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaBodega( @JsonProperty(value="bodegas")List<Bodega> bodegas){
		this.bodegas = bodegas;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Bodega> getBodegas() {
		return bodegas;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setBodega(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}
}
