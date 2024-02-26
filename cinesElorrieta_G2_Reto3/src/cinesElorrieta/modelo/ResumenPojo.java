package cinesElorrieta.modelo;

import java.io.Serializable;
import java.util.Objects;

public class ResumenPojo implements Serializable {

	private static final long serialVersionUID = -8615787095542610976L;

	private String cine = null;
	private String pelicula = null;
	private String duracion = null;
	private String fecha = null;
	private String horario = null;
	private String sala = null;
	private String precio = null;
	

	public ResumenPojo(String cine, String pelicula, String duracion, String fecha, String horario, String sala,
			String precio) {
		super();
		this.cine = cine;
		this.pelicula = pelicula;
		this.duracion = duracion;
		this.fecha = fecha;
		this.horario = horario;
		this.sala = sala;
		this.precio = precio;
	}


	public String getCine() {
		return cine;
	}


	public void setCine(String cine) {
		this.cine = cine;
	}


	public String getPelicula() {
		return pelicula;
	}


	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cine, duracion, fecha, horario, pelicula, precio, sala);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumenPojo other = (ResumenPojo) obj;
		return Objects.equals(cine, other.cine) && Objects.equals(duracion, other.duracion)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(horario, other.horario)
				&& Objects.equals(pelicula, other.pelicula) && Objects.equals(precio, other.precio)
				&& Objects.equals(sala, other.sala);
	}


	@Override
	public String toString() {
		return "ResumenPojo [cine=" + cine + ", pelicula=" + pelicula + ", duracion=" + duracion + ", precio=" + precio
				+ ", fecha=" + fecha + ", horario=" + horario + ", sala=" + sala + "]";
	}

	
	
	
}
