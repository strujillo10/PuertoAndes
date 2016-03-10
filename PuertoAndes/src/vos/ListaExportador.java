package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaExportador {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="exportadores")
	private List<Exportador> exportadores;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaExportador( @JsonProperty(value="exportadores")List<Exportador> exportadores){
		this.exportadores = exportadores;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Exportador> getExportadores() {
		return exportadores;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setExportador(List<Exportador> exportadores) {
		this.exportadores = exportadores;
	}
}
