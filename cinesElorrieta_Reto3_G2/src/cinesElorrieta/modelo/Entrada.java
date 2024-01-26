package cinesElorrieta.modelo;

import java.util.Date;
import java.util.Objects;

public class Entrada {

	private String idEntrada = null;
	private String precio = null;
	private Date fechaCompra = null;

	private Sesion sesion = null;
	private Cliente cliente = null;

	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", precio=" + precio + ", fechaCompra=" + fechaCompra + ", sesion="
				+ sesion + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaCompra, idEntrada, precio, sesion);
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
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaCompra, other.fechaCompra)
				&& Objects.equals(idEntrada, other.idEntrada) && Objects.equals(precio, other.precio)
				&& Objects.equals(sesion, other.sesion);
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

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
