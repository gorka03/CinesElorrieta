package cineElorrietaTest.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import cinesElorrieta.controller.GestorCines;
import cinesElorrieta.controller.GestorPeliculas;
import cinesElorrieta.controller.GestorSesion;
import cinesElorrieta.modelo.Cine;
import cinesElorrieta.modelo.SesionPojo;

class CinesDisponiblesGTest {
	
	@Test
	public void testObtenerCinesDisponibles() {
		GestorCines gestorCines = new GestorCines();
		List<Cine> cinesDisponibles = gestorCines.obtenerDatosCines();
		assertNotNull(cinesDisponibles);
		assertNotEquals(0, cinesDisponibles.size());
	}

	@Test
	public void testObtenerPeliculasCine() {
		GestorPeliculas gestorPeliculas = new GestorPeliculas();
		List<String> pelisDisponibles = gestorPeliculas.obtenerPeliculasDelCine("Cine Elorrieta Bilbao");
		assertNull(pelisDisponibles);
	}

	@Test
	public void testOrdenarPeliculas() {
	    GestorPeliculas gestorPeliculas = new GestorPeliculas();
	    List<String> pelisDisponibles = gestorPeliculas.obtenerPeliculasDelCine("Cine Elorrieta Bilbao");
	    assertNotNull(pelisDisponibles);
	    Collections.sort(pelisDisponibles);
	    System.out.println("Lista de películas ordenadas:");
	    for (String pelicula : pelisDisponibles) {
	        System.out.println(pelicula);
	    }
	}

	@Test
	public void testFechasPelicula() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");

		assertNotNull(sesionesPelicula);

		for (SesionPojo sesion : sesionesPelicula) {
			String fecha = sesion.getFecha();
			assertNotNull(fecha); 
			System.out.println("Fecha de la sesión: " + fecha);
		}
	}
	
	@Test
	public void testFechasPelicula2() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");


		for (SesionPojo sesion : sesionesPelicula) {
			String fecha = sesion.getFecha();
			assertNull(fecha); 
		}
	}
	@Test
	public void testPrecioPelicula() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");

		assertNotNull(sesionesPelicula);

		for (SesionPojo sesion : sesionesPelicula) {
			double precio = sesion.getPrecio();
			assertNotNull(precio); 
			System.out.println("Fecha de la sesión: " + precio);
		}
	}
	
	@Test
	public void testPrecioPelicula2() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");


		for (SesionPojo sesion : sesionesPelicula) {
			double precio = sesion.getPrecio();
			assertNull(precio); 
		}
	}
	
	@Test
	public void testSesionesPelicula() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");

		assertNotNull(sesionesPelicula);

		
		for (SesionPojo sesion : sesionesPelicula) {
			String duracion = sesion.getDuracion();
			 double precio = sesion.getPrecio();
			String fecha = sesion.getFecha();
			String horario = sesion.getHorario();
			String nombreSala = sesion.getNombreSala();
			
			assertNotNull(duracion + precio + fecha + horario + nombreSala); 
			System.out.println("Sesiones: " + duracion + precio + fecha + horario + nombreSala);
		}
	}
	@Test
	public void testSesionesPelicula2() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");


		for (SesionPojo sesion : sesionesPelicula) {
			String duracion = sesion.getDuracion();
			 double precio = sesion.getPrecio();
			String fecha = sesion.getFecha();
			String horario = sesion.getHorario();
			String nombreSala = sesion.getNombreSala();
			
			assertNull(duracion + precio + fecha + horario + nombreSala); 
		}
	}
	@Test
	public void testSalasFechaPelicula() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");

		assertNotNull(sesionesPelicula);

		
		for (SesionPojo sesion : sesionesPelicula) {
			String fecha = sesion.getFecha();
			String nombreSala = sesion.getNombreSala();
			
			assertNotNull(fecha + nombreSala); 
			System.out.println("Sesiones: " +fecha + nombreSala);
		}
	}
	
	@Test
	public void testSalasFechaPelicula2() {
		GestorSesion gestorSesion = new GestorSesion();
		List<SesionPojo> sesionesPelicula = gestorSesion.obtenerSesionesPelicula("Cine Elorrieta Bilbao", "Arma letal");

		for (SesionPojo sesion : sesionesPelicula) {
			String fecha = sesion.getFecha();
			String nombreSala = sesion.getNombreSala();
			
			assertNull(fecha + nombreSala); 
		}
	}
}

