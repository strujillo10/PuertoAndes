package vos;

import java.sql.Date;
import java.sql.Time;

import org.codehaus.jackson.annotate.JsonProperty;

public class Camion 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="procedencia")
	private String procedencia; 
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada;
	
	@JsonProperty(value="fechaSalida")
	private Date fechaSalida; 
	
	@JsonProperty(value="empresaOperaria")
	private String empresaOperaria; 
	
	@JsonProperty(value="horaLlegada")
	private Time horaLlegada; 
	
	@JsonProperty(value="horaSalida")
	private Time horaSalida; 
	
	@JsonProperty(value="cantidadContenedores")
	private int cantidadContenedores; 
	
	@JsonProperty(value="destino")
	private String destino; 
	
	public Camion(@JsonProperty(value="id")int nId, @JsonProperty(value="procedencia")String nProcedencia,
			@JsonProperty(value="fechaLlegada")Date nFechaLlegada, @JsonProperty(value="fechaSalida")Date nFechaSalida,
			@JsonProperty(value="empresaOperaria")String nEmpresa, @JsonProperty(value="horaLlegada")Time nHoraLlegada,
			@JsonProperty(value="horaSalida")Time nHoraSalida, @JsonProperty(value="cantidadContenedores")int nCantidad,
			@JsonProperty(value="destino")String nDestino)
	{
		id = nId; 
		procedencia = nProcedencia; 
		fechaLlegada = nFechaLlegada; 
		fechaSalida = nFechaSalida; 
		empresaOperaria = nEmpresa; 
		horaLlegada = nHoraLlegada; 
		horaSalida = nHoraSalida;
		cantidadContenedores = nCantidad; 
		destino = nDestino; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getEmpresaOperaria() {
		return empresaOperaria;
	}

	public void setEmpresaOperaria(String empresaOperaria) {
		this.empresaOperaria = empresaOperaria;
	}

	public Time getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Time getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public int getCantidadContenedores() {
		return cantidadContenedores;
	}

	public void setCantidadContenedores(int cantidadContenedores) {
		this.cantidadContenedores = cantidadContenedores;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
}
