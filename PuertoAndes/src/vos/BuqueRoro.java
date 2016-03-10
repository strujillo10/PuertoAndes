package vos;

import java.sql.Date;
import java.sql.Time;

import org.codehaus.jackson.annotate.JsonProperty;

public class BuqueRoro 
{
	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value="nombre")
	private String nombre; 
	
	@JsonProperty(value="registroCapitania")
	private String registroCapitania; 
	
	@JsonProperty(value="procedencia")
	private String procedencia; 
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada; 
	
	@JsonProperty(value="fechaSalida")
	private Date fechaSalida; 
	
	@JsonProperty(value="agenciaMaritima")
	private String agenciaMaritima; 
	
	@JsonProperty(value="horaLlegada")
	private Time horaLlegada;
	
	@JsonProperty(value="horaSalida")
	private Time horaSalida; 
	
	@JsonProperty(value="destino")
	private String destino; 
	
	@JsonProperty(value="buqueId")
	private int buqueId;
	
	public BuqueRoro(@JsonProperty(value="id")int nId, @JsonProperty(value="nombre")String nNombre,
			@JsonProperty(value="registroCapitania")String nRegistro,
			@JsonProperty(value="procedencia")String nProcedencia, @JsonProperty(value="fechaLlegada")Date nFechaLlegada,
			@JsonProperty(value="fechaSalida")Date nFechaSalida, @JsonProperty(value="agenciaMaritima")String nAgencia,
			@JsonProperty(value="horaLlegada")Time nHoraLlegada, @JsonProperty(value="horaSalida")Time nHoraSalida,
			@JsonProperty(value="destino")String nDestino,
			@JsonProperty(value="buqueId")int nBuqueId)
	{
		id = nId; 
		nombre = nNombre; 
		registroCapitania = nRegistro; 
		procedencia = nProcedencia; 
		fechaLlegada = nFechaLlegada; 
		fechaSalida = nFechaSalida; 
		agenciaMaritima = nAgencia; 
		horaLlegada = nHoraLlegada; 
		horaSalida = nHoraSalida; 
		destino = nDestino; 
		buqueId = nBuqueId; 
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

	public String getRegistroCapitania() {
		return registroCapitania;
	}

	public void setRegistroCapitania(String registroCapitania) {
		this.registroCapitania = registroCapitania;
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

	public String getAgenciaMaritima() {
		return agenciaMaritima;
	}

	public void setAgenciaMaritima(String agenciaMaritima) {
		this.agenciaMaritima = agenciaMaritima;
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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getBuqueId() {
		return buqueId;
	}

	public void setBuqueId(int buqueId) {
		this.buqueId = buqueId;
	}
	
}