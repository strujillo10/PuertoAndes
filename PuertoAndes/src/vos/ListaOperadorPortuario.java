package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaOperadorPortuario {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="operadores")
	private List<OperadorPortuario> operadores;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaOperadorPortuario( @JsonProperty(value="operadores")List<OperadorPortuario> operadores){
		this.operadores = operadores;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<OperadorPortuario> getOperadores() {
		return operadores;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setOperador(List<OperadorPortuario> operadores) {
		this.operadores = operadores;
	}
}
