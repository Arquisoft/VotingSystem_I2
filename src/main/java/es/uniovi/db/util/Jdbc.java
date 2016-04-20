package es.uniovi.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

	private static String DRIVER = "org.sqlite.JDBC";
	// private static String URL = "jdbc:sqlite:sqlite/asw.db";
	// private static String URL = "jdbc:sqlite:C:\\sqlite\\asw.db";
	private static String URL = "/home/travis/build/Arquisoft/VotingSystem_I2/sqlite/asw.db";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found in classpath", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
}
