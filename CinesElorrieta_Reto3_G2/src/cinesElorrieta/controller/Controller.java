package cinesElorrieta.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import cinesElorrieta.modelo.Pelicula;
import cinesElorrieta.modelo.Sala;

public class Controller {

	public ArrayList<Pelicula> getAll() {

		return null;
	}

	public Pelicula getByNombre(String nombre) {

		return null;
	}
	// Bienvenida

	/**
	 * It makes the program waits 3 seconds.
	 */
	private static void esperar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

	// Cines

	public void seleccionarCine(String nombre) {

	}

	public void seleccionarPeliulasCine(String nombre) {

	}

	// Sesion
	public void seleccionarSesion(Date fecha, Time horario, double precio, Sala sala) {

	}

	// Resumen

	public void seleccionarResumen(String nombre, Date fecha, Time horario, double precio, Sala sala) {

	}

	// Login

	public void usuario(String username , String contrasenna  ) {
		
	}
	
	// Registro

	public void nuevoCliente(String dni, String nombre, String apellidos, String sexo, String contrasenna, String userName) {
		
	}
	
	//Factura
	
	public void crearFactura() {
		
	}
	
}