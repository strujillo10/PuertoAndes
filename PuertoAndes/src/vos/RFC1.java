package vos;

import java.sql.Date;
import java.sql.Time;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC1 
{
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="registro")
	private String registro;
	
	
	@JsonProperty(value="agenciaMaritima")
	private String agenciaMaritima;
	
	
	@JsonProperty(value="cantidadContenedores")
	private int cantidadContenedores;
	
	@JsonProperty(value="destino")
	private String destino;
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada;
	
	@JsonProperty(value="fechaSalida")
	private Date fechaSalida;
	
	@JsonProperty(value="horaLlegada")
	private Time horaLlegada;
	
	@JsonProperty(value="horaSalida")
	private Time horaSalida;
	
	@JsonProperty(value="procedencia")
	private String procedencia;
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	public RFC1(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre, 
			@JsonProperty(value="registro")String nRegistro, @JsonProperty(value="agenciaMaritima")String nAgencia, 
			@JsonProperty(value="cantidadContenedores")int nCantidad,@JsonProperty(value="destino")String nDestino,
			@JsonProperty(value="fechaLlegada")Date nFechaLlegada,@JsonProperty(value="fechaSalida")Date nFechaSalida,
			@JsonProperty(value="horaLlegada")Time nHoraLlegada,@JsonProperty(value="horaSalida")Time nHoraSalida,
			@JsonProperty(value="procedencia")String nProcedencia,@JsonProperty(value="capacidad")int nCapacidad)
	{
		id = nId; 
		nombre = nNombre; 
		registro = nRegistro; 
		agenciaMaritima = nAgencia; 
		cantidadContenedores = nCantidad; 
		destino = nDestino; 
		fechaLlegada = nFechaLlegada; 
		fechaSalida = nFechaSalida; 
		horaLlegada = nHoraLlegada; 
		horaSalida = nHoraSalida;
		procedencia = nProcedencia; 
		capacidad = nCapacidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getAgenciaMaritima() {
		return agenciaMaritima;
	}

	public void setAgenciaMaritima(String agenciaMaritima) {
		this.agenciaMaritima = agenciaMaritima;
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

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}	
}	
