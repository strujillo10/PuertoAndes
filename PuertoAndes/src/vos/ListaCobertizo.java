package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCobertizo {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="cobertizos")
	private List<Cobertizo> cobertizos;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaCobertizo( @JsonProperty(value="cobertizos")List<Cobertizo> cobertizos){
		this.cobertizos = cobertizos;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Cobertizo> getCobertizos() {
		return cobertizos;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setCobertizo(List<Cobertizo> cobertizos) {
		this.cobertizos = cobertizos;
	}
}
