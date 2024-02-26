package cinesElorrieta.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cinesElorrieta.modelo.Sesion;

public class GestorTicket {

	private static final String NOMBRE_FICHERO = "ticket.txt";
	private static final String RUTA_FICHERO = "//Desktop";

	public void generarTicket(ArrayList<Sesion> sesiones) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter);

			for (int i = 0; i < sesiones.size(); i++) {
				String datos = "-----------------------" + "\n" + "NOMBRE DE LA PELICULA: "
						+ sesiones.get(i).getPelicula().getNombre() + "\n" // Asumiendo que tienes un método getPelicula() en la clase Sesion
						+ "DURACION DE LA PELICULA: "
						+ sesiones.get(i).getPelicula().getDuracion() + "\n" // Asumiendo que tienes un método getDuracion() en la clase Pelicula
						// Resto de los detalles de la sesión
						+ "-----------------------";
				printWriter.println(datos);
			}

			printWriter.println("PRECIO TOTAL CON DESCUENTO: " + sesiones.get(0).getPrecio());

		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				// Manejar la excepción de cierre de archivo
			}
		}
	}

}
