package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCuartoFrio {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="cuartos")
	private List<CuartoFrio> cuartos;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaCuartoFrio( @JsonProperty(value="cuartos")List<CuartoFrio> cuartos){
		this.cuartos = cuartos;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<CuartoFrio> getCuartos() {
		return cuartos;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setCuarto(List<CuartoFrio> cuartos) {
		this.cuartos = cuartos;
	}
}
