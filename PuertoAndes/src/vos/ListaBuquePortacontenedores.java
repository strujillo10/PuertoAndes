package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import rest.BuquePortacontenedoresServices;

public class ListaBuquePortacontenedores {
	/**
	 * List con los videos
	 */
	@JsonProperty(value="buquesP")
	private List<BuquePortaContenedores> buquesP;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaBuquePortacontenedores( @JsonProperty(value="buquesP")List<BuquePortaContenedores> buquesP){
		this.buquesP = buquesP;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<BuquePortaContenedores> getBuquesP() {
		return buquesP;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setBuqueP(List<BuquePortaContenedores> buquesP) {
		this.buquesP = buquesP;
	}
}
