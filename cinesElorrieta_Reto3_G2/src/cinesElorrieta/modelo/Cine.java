package cinesElorrieta.modelo;

import java.util.Objects;

public class Cine {

	private Integer idCine = null;
	private String nombre = null ;
	private String direccion = null;
	
	
	
	public Cine() {
		
	}


	/**
	 * Contructor sobrecargado
	 * 
	 * @param idCine
	 * @param nombre
	 * @param direccion
	 */

	public Cine(Integer idCine, String nombre, String direccion) {
		super();
		this.idCine = idCine;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, idCine, nombre);
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
		return Objects.equals(direccion, other.direccion) && Objects.equals(idCine, other.idCine)
				&& Objects.equals(nombre, other.nombre);
	}


	public Integer getIdCine() {
		return idCine;
	}


	public void setIdCine(Integer idCine) {
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


	
	
	
}
	
	