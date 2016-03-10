package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaImportador {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="importadores")
	private List<Importador> importadores;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaImportador( @JsonProperty(value="importadores")List<Importador> importadores){
		this.importadores = importadores;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Importador> getImportadores() {
		return importadores;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setImportador(List<Importador> importadores) {
		this.importadores = importadores;
	}
}
