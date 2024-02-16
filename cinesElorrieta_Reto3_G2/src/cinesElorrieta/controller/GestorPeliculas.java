package cinesElorrieta.controller;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import cinesElorrieta.utils.DBUtils;

public class GestorPeliculas {

	public static ArrayList<String> obtenerPeliculasDelCine(String nombreCine) {

		ArrayList<String> nombresPeliculas = new ArrayList<>();

		String sql = "SELECT DISTINCT p.nombre " + "FROM pelicula p " + "JOIN sesion s ON p.idPelicula = s.idPelicula "

				+ "JOIN cine c ON s.idCine = c.idCine " + "WHERE c.nombre = '" + nombreCine + "' "

				+ "ORDER BY p.nombre";

		Connection connection = null;

		java.sql.Statement statement = null;

		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				String nombrePelicula = resultSet.getString("nombre");

				nombresPeliculas.add(nombrePelicula);

			}

		} catch (SQLException sqle) {

			System.out.println("Error con la BBDD - " + sqle.getMessage());

		} catch (Exception e) {

			System.out.println("Error generico - " + e.getMessage());

		} finally {

			try {

				if (resultSet != null)

					resultSet.close();

			} catch (Exception e) {

			}

			;

			try {

				if (statement != null)

					statement.close();

			} catch (Exception e) {

			}

			;

			try {

				if (connection != null)

					connection.close();

			} catch (Exception e) {

			}

			;

		}

		return nombresPeliculas;

	}

	public static ArrayList<String> obtenerDatosPelicula(int idPelicula) {

		ArrayList<String> datosPelicula = new ArrayList<>();

		String sql = "SELECT p.nombre, p.duracion, p.genero, p.precio, se.fecha, se.horario, s.nombre"

				+ "FROM pelicula p" + "JOIN sesion se ON p.idPelicula = se.idPelicula"

				+ " JOIN sala s ON se.idSala = s.idSala" + "WHERE p.idPelicula = '" + idPelicula + "' ";

		Connection connection = null;

		java.sql.Statement statement = null;

		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				String nombrePelicula = resultSet.getString("nombre");

				String duracion = resultSet.getString("duracion");

				String genero = resultSet.getString("genero");

				double coste = resultSet.getDouble("coste");

				String fecha = resultSet.getString("fecha");

				String horario = resultSet.getString("horario");

				String nombreSala = resultSet.getString("s.nombre");

				datosPelicula.add("Nombre: " + nombrePelicula);

				datosPelicula.add("Duración: " + duracion);

				datosPelicula.add("Género: " + genero);

				datosPelicula.add("Coste: " + coste);

				datosPelicula.add("Fecha: " + fecha);

				datosPelicula.add("Horario: " + horario);

				datosPelicula.add("Sala: " + nombreSala);

			}

		} catch (SQLException sqle) {

			System.out.println("Error con la BBDD - " + sqle.getMessage());

		} catch (Exception e) {

			System.out.println("Error generico - " + e.getMessage());

		} finally {

			try {

				if (resultSet != null)

					resultSet.close();

			} catch (Exception e) {

			}

			;

			try {

				if (statement != null)

					statement.close();

			} catch (Exception e) {

			}

			;

			try {

				if (connection != null)

					connection.close();

			} catch (Exception e) {

			}

			;

		}

		return datosPelicula;

	}

	public static int obtenerIdPeliculaPorNombre(String nombrePelicula) {

		int idPelicula = -1;

		String sql = "SELECT idPelicula FROM pelicula WHERE nombre = '" + nombrePelicula + "'";

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.prepareStatement(sql);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				idPelicula = resultSet.getInt("idPelicula");

			}

		} catch (SQLException sqle) {

			System.out.println("Error con la BBDD - " + sqle.getMessage());

		} catch (Exception e) {

			System.out.println("Error generico - " + e.getMessage());

		} finally {

			try {

				if (resultSet != null)

					resultSet.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

			try {

				if (statement != null)

					statement.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

			try {

				if (connection != null)

					connection.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return idPelicula;

	}

}
