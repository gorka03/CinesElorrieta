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
		assertEquals("Superheroes", pelicula.getGenero());
	}

	@Test
	public void testSetGenero() {
		Pelicula pelicula = new Pelicula();
		String genero = "Superheroes";
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

	@Test
	public void testEquals() {
		Pelicula pelicula1 = new Pelicula(1, "Deadpool", 180, "Superheroes", 7, null);
		Pelicula pelicula2 = new Pelicula(1, "Deadpool", 180, "Superheroes", 7, null);

		// Con esto hacemos la reflexividad para verificar que los datos son correctos 
		assertEquals(pelicula1, pelicula1);
		assertEquals(pelicula2, pelicula2);

		// Simetría, comparas que son identicos 
		assertEquals(pelicula1, pelicula2);
		assertEquals(pelicula2, pelicula1);

		// Confirmamos que todos los campos estan completos 
		assertFalse(pelicula1.equals(null));
		assertFalse(pelicula2.equals(null));

		// Comparación con otro tipo de objeto
		assertFalse(pelicula1.equals("Deadpool"));
		assertFalse(pelicula2.equals("Deadpool"));

	
		Pelicula pelicula3 = new Pelicula(2, "Deadpool", 180, "Superheroes", 10, null);
		assertTrue(pelicula1.equals(pelicula3));
		assertFalse(pelicula2.equals(pelicula3));
	}

	@Test
	public void testToString() {
		Pelicula pelicula = new Pelicula(1, "Deadpool", 180, "Superheroes", 10.99, null);
		String infoPeliculas = "Pelicula [idPelicula=1, nombre=Deadpool, duracion=180, genero=Superheroes, coste=10.99, sesiones=null]";
		assertEquals(infoPeliculas, pelicula.toString());
	}

}