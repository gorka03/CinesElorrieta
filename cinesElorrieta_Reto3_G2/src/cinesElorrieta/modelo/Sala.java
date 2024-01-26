package cinesElorrieta.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Sala {

	private Integer idCine = null;
	private Integer idSala = null;
	private String nombre = null;

	private Cine cine = null;

	private ArrayList<Sesion> sesiones = null;

	@Override
	public String toString() {
		return "Sala [idCine=" + idCine + ", idSala=" + idSala + ", nombre=" + nombre + ", cine=" + cine + ", sesiones="
				+ sesiones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cine, idCine, idSala, nombre, sesiones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(cine, other.cine) && Objects.equals(idCine, other.idCine)
				&& Objects.equals(idSala, other.idSala) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sesiones, other.sesiones);
	}

	public Integer getIdCine() {
		return idCine;
	}

	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public ArrayList<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(ArrayList<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

}
