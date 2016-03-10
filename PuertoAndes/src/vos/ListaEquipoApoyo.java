package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEquipoApoyo {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="equipos")
	private List<EquipoApoyo> equipos;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaEquipoApoyo( @JsonProperty(value="equipos")List<EquipoApoyo> equipos){
		this.equipos = equipos;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<EquipoApoyo> getEquipos() {
		return equipos;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setEquipo(List<EquipoApoyo> equipos) {
		this.equipos = equipos;
	}
}
