package cineElorrietaTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cinesElorrieta.modelo.Pelicula;

class PeliculasTest {

	@Test
	public void testGetNombre() {
		// Crear una instancia de Pelicula
		Pelicula pelicula = new Pelicula();

		// Obtener el titulo y verificar si es igual a "Deadpool"
		assertEquals("Deadpool", pelicula.getNombre());
	}

	@Test
	public void testSetNombre() {
		Pelicula pelicula = new Pelicula();
		String nombre = "Deadpool";
		pelicula.setNombre(nombre);
		assertNotNull(nombre);
	}

	@Test
	public void testGetDuracion() {
		// Crear una instancia de Pelicula
		Pelicula pelicula = new Pelicula();

		// Obtener la duracion
		assertEquals(2, pelicula.getDuracion());
	}

	@Test
	public void testSetDuracion() {
		Pelicula pelicula = new Pelicula();
		int duracion = 0;
		pelicula.setDuracion(duracion);
		assertNull(duracion);
	}

	@Test
	public void testGetGenero() {
		// Crear una instancia de Pelicula
		Pelicula pelicula = new Pelicula();

		// Obtener la duracion
		assertEquals("Drama", pelicula.getGenero());
	}

	@Test
	public void testSetGenero() {
		Pelicula pelicula = new Pelicula();
		String genero = "Drama";
		pelicula.setGenero(genero);
		assertNotNull(genero);
	}

	@Test
	public void testGetCoste() {
		// Crear una instancia de Pelicula
		Pelicula pelicula = new Pelicula();

		// Obtener la duracion
		assertEquals(2, pelicula.getCoste());
	}

	@Test
	public void testSetCoste() {
		Pelicula pelicula = new Pelicula();
		int coste = 0;
		pelicula.setCoste(coste);
		assertNotNull(coste);
	}



}