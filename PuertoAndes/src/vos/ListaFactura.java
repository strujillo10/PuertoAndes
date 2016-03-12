package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFactura 
{
	/**
	 * List con los videos
	 */
	@JsonProperty(value="facturas")
	private List<Factura> facturas;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaFactura( @JsonProperty(value="facturas")List<Factura> facturas){
		this.facturas = facturas;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Factura> getFacturas() {
		return facturas;
	}

	/**
	 * Método que asigna la lista de videos que entra como parametro
	 * @param  videos - List con los videos ha agregar
	 */
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
}