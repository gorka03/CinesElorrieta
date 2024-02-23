package cinesElorrieta.controller;

import java.sql.Connection;

import java.sql.DriverManager;



import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import cinesElorrieta.utils.DBUtils;

public class GestorPeliculas {

	public  ArrayList<String> obtenerPeliculasDelCine(String nombreCine) {

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

	

}
