package cinesElorrieta.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cinesElorrieta.modelo.Sesion;

public class GestorTicket {

	private static final String NOMBRE_FICHERO = "ticket.txt";
	private static final String RUTA_FICHERO = "C://Users//in1dm3-v//Desktop//fichero";

	public void generarTicket(ArrayList<Sesion> sesiones) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter);

			for (Sesion sesion : sesiones) {
				printWriter.println(sesion.toString());
			}

		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} catch (Exception e) {
			System.out.println("Exception - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}

}
