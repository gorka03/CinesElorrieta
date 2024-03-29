package cinesElorrieta.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cine implements Serializable {

	private static final long serialVersionUID = -6446255501059242662L;

	private int idCine = 0;
	private String nombre = null;
	private String direccion = null;

	private ArrayList<Sala> salas = null;

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, idCine, nombre, salas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return Objects.equals(direccion, other.direccion) && idCine == other.idCine
				&& Objects.equals(nombre, other.nombre) && Objects.equals(salas, other.salas);
	}

	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", nombre=" + nombre + ", direccion=" + direccion + ", salas=" + salas + "]";
	}

}
