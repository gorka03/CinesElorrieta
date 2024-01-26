package cinesElorrieta.modelo;

import java.util.Objects;

public class Sala {

	private Integer idCine = null;
	private Integer idSala = null;
	private String nombre = null;
	
	public Sala() {
		
	}
	
	/**
	 *Contructor sobrecargado
	 * 
	 * @param idCine
	 * @param idSala
	 * @param nombre
	 */
	public Sala(Integer idCine, Integer idSala, String nombre) {
		super();
		this.idCine = idCine;
		this.idSala = idSala;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Sala [idCine=" + idCine + ", idSala=" + idSala + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCine, idSala, nombre);
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
		return Objects.equals(idCine, other.idCine) && Objects.equals(idSala, other.idSala)
				&& Objects.equals(nombre, other.nombre);
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
	
	
	
}
