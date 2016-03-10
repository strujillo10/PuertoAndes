package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAdministrador {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="admins")
	private List<Administrador> admins;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaAdministrador( @JsonProperty(value="admins")List<Administrador> admins){
		this.admins = admins;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Administrador> getAdmins() {
		return admins;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setAdministradores(List<Administrador> admins) {
		this.admins = admins;
	}
}
