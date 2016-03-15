package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC2 
{
	/**
	 * List con los videos
	 */
	@JsonProperty(value="rfc2s")
	private List<RFC2> rfc2s;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRFC2( @JsonProperty(value="rfc2s")List<RFC2> rfc2s){
		this.rfc2s = rfc2s;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RFC2> getRFC2s() {
		return rfc2s;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setRFC2s(List<RFC2> rfc2s) {
		this.rfc2s = rfc2s;
	}
}
