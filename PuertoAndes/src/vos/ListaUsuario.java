package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaUsuario {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="usuarios")
	private List<Usuario> usuarios;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaUsuario( @JsonProperty(value="usuarios")List<Usuario> usuarios){
		this.usuarios = usuarios;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
