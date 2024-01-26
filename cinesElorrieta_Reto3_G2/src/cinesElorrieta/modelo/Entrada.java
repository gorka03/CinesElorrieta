package cinesElorrieta.modelo;

import java.util.Objects;

public class Entrada {

	private String idEntrada = null;
	private String precio = null;
	private String fechaCompra = null;

	public Entrada() {

	}

	/**
	 * Constructor sobrecargado
	 * 
	 * @param Dni
	 * @param Nombre
	 * @param Apellidos
	 * @param Sexo
	 * @param Contrasenna
	 * @param UserName
	 */
	public Entrada(String idEntrada, String precio, String fechaCompra) {
		super();
		this.idEntrada = idEntrada;
		this.precio = precio;
		this.fechaCompra = fechaCompra;

	}

	public String getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(String idEntrada) {
		this.idEntrada = idEntrada;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCompra, idEntrada, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(fechaCompra, other.fechaCompra) && Objects.equals(idEntrada, other.idEntrada)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", precio=" + precio + ", fechaCompra=" + fechaCompra + "]";
	}

}
