package cinesElorrieta.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Pelicula {

	private Integer idPelicula = null;
	private String nombre = null;
	private Integer duracion = null;
	private String genero = null;
	private Double coste = null;

	private ArrayList<Sesion> sesiones = null;
	//hc
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombre=" + nombre + ", duracion=" + duracion + ", genero="
				+ genero + ", coste=" + coste + ", sesiones=" + sesiones + "]";
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
		return Objects.equals(coste, other.coste) && Objects.equals(duracion, other.duracion)
				&& Objects.equals(genero, other.genero) && Objects.equals(idPelicula, other.idPelicula)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sesiones, other.sesiones);
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getCoste() {
		return coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	public ArrayList<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(ArrayList<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

}
