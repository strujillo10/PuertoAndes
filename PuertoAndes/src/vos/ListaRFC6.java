package vos;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
public class ListaRFC6 
{

	/**
	 * Lista
	 */
	@JsonProperty(value="rfc6s")
	private List<RFC6> rfc6s;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRFC6( @JsonProperty(value="rfc6s")List<RFC6> rfc6s){
		this.rfc6s = rfc6s;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RFC6> getRFC6s() {
		return rfc6s;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setRFC6s(List<RFC6> rfc6s) {
		this.rfc6s = rfc6s;
	}

}
