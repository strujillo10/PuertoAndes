package vos;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
public class ListaRFC5 
{

	/**
	 * Lista
	 */
	@JsonProperty(value="rfc5s")
	private List<RFC5> rfc5s;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRFC5( @JsonProperty(value="rfc5s")List<RFC5> rfc5s){
		this.rfc5s = rfc5s;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RFC5> getRFC6s() {
		return rfc5s;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setRFC5s(List<RFC5> rfc5s) {
		this.rfc5s = rfc5s;
	}

}