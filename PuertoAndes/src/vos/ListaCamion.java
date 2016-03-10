package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCamion {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="camiones")
	private List<Camion> camiones;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaCamion( @JsonProperty(value="camiones")List<Camion> camiones){
		this.camiones = camiones;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Camion> getCamiones() {
		return camiones;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setCamion(List<Camion> camiones) {
		this.camiones = camiones;
	}
}
