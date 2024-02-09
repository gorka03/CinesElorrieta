package cinesElorrieta.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cinesElorrieta.utils.DBUtils;

public class GestorRegistro {

	public static boolean guardarUsuarioEnBaseDeDatos(String dni, String nombre, String apellido, String genero,
			String usuario, String contrasenna) {

		boolean insercionExitosa = false;
		Connection connection = null;
		PreparedStatement stm = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);
			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Crear la consulta SQL
			String sql = "INSERT INTO cliente (dni, nombre, apellidos, sexo, contrasenna, userName) VALUES (?, ?, ?, ?, ?, ?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, dni);
			stm.setString(2, nombre);
			stm.setString(3, apellido);
			stm.setString(4, genero);
			stm.setString(5, contrasenna);
			stm.setString(6, usuario);

			// Ejecutar la consulta SQL
			int filasAfectadas = stm.executeUpdate();

			// Verificar si ha insertado
			if (filasAfectadas > 0) {
				insercionExitosa = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (stm != null)
					stm.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}

		return insercionExitosa;
	}
}
