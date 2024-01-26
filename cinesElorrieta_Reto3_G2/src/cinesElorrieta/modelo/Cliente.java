package cinesElorrieta.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	private String dni = null;
	private String nombre = null;
	private String apellidos = null;
	private String sexo = null;
	private String contrasenna = null;
	private String userName = null;

	private ArrayList<Entrada> entradas = null;

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
				+ ", contrasenna=" + contrasenna + ", userName=" + userName + ", entradas=" + entradas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, contrasenna, dni, entradas, nombre, sexo, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(contrasenna, other.contrasenna)
				&& Objects.equals(dni, other.dni) && Objects.equals(entradas, other.entradas)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sexo, other.sexo)
				&& Objects.equals(userName, other.userName);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}

}
