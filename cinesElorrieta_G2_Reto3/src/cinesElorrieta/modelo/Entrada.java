package cinesElorrieta.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 3068127752501631435L;

	private int idEntrada = 0;
	private double precio = 0;
	private Date fechaCompra = null;

	private Sesion sesion = null;
	private Cliente cliente = null;

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
				&& idEntrada == other.idEntrada
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(sesion, other.sesion);
	}

	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", precio=" + precio + ", fechaCompra=" + fechaCompra + ", sesion="
				+ sesion + ", cliente=" + cliente + "]";
	}

}
