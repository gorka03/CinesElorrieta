package cinesElorrieta.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Sala implements Serializable {

	private static final long serialVersionUID = 4183514244251203258L;

	private int idCine = 0;
	private int idSala = 0;
	private String nombre = null;

	private Cine cine = null;

	private ArrayList<Sesion> sesiones = null;

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return Objects.equals(cine, other.cine) && idCine == other.idCine && idSala == other.idSala
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sesiones, other.sesiones);
	}

	@Override
	public String toString() {
		return "Sala [idCine=" + idCine + ", idSala=" + idSala + ", nombre=" + nombre + ", cine=" + cine + ", sesiones="
				+ sesiones + "]";
	}

}
