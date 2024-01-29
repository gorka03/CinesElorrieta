package cineElorrietaTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cinesElorrieta.modelo.Pelicula;

class PeliculasTest {


	@Test
	public void testGetNombre() {
		// Crear una instancia de Pelicula
		Pelicula pelicula = new Pelicula();

		// Obtener el titulo y verificar si es igual a "Juan"
		assertEquals("Deadpool", pelicula.getNombre());
	}

}