package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC1 
{
	/**
	 * List con los videos
	 */
	@JsonProperty(value="rfc1s")
	private List<RFC1> rfc1s;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRFC1( @JsonProperty(value="rfc1s")List<RFC1> rfc1s){
		this.rfc1s = rfc1s;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RFC1> getRFC1s() {
		return rfc1s;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setRFC1s(List<RFC1> rfc1s) {
		this.rfc1s = rfc1s;
	}
}
