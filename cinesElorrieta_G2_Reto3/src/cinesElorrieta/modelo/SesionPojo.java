package cinesElorrieta.modelo;

import java.io.Serializable;
import java.util.Objects;

public class SesionPojo implements Serializable{

	private static final long serialVersionUID = 6870408974764475380L;
	
	private String duracion;
	private double precio;
	private String fecha;
	private String horario;
	private String nombreSala;

	public SesionPojo(String duracion, double precio, String fecha, String horario, String nombreSala) {
		super();
		this.duracion = duracion;
		this.precio = precio;
		this.fecha = fecha;
		this.horario = horario;
		this.nombreSala = nombreSala;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
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

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracion, fecha, horario, nombreSala, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SesionPojo other = (SesionPojo) obj;
		return Objects.equals(duracion, other.duracion) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(horario, other.horario) && Objects.equals(nombreSala, other.nombreSala)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "SesionPojo [duracion=" + duracion + ", precio=" + precio + ", fecha=" + fecha + ", horario=" + horario
				+ ", nombreSala=" + nombreSala + "]";
	}
	

}
