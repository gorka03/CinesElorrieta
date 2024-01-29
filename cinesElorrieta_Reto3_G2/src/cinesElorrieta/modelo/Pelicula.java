package cinesElorrieta.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase que define una Pelicula de la BBDD
 */

public class Pelicula implements Serializable {

	private static final long serialVersionUID = -1963071720222039522L;

	private int idPelicula = 0;
	private String nombre = null;
	private int duracion = 0;
	private String genero = null;
	private double coste = 0;

	private ArrayList<Sesion> sesiones = null;

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {

		String nombre = "Deadpool";

		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		int duracion = 2;
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		String genero = "Drama";
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getCoste() {
		double coste = 2;
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
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
		return Objects.hash(coste, duracion, genero, idPelicula, nombre, sesiones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Double.doubleToLongBits(coste) == Double.doubleToLongBits(other.coste) && duracion == other.duracion
				&& Objects.equals(genero, other.genero) && idPelicula == other.idPelicula
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sesiones, other.sesiones);
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombre=" + nombre + ", duracion=" + duracion + ", genero="
				+ genero + ", coste=" + coste + ", sesiones=" + sesiones + "]";
	}

}
