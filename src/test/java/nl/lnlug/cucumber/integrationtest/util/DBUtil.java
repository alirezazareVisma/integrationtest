package nl.lnlug.cucumber.integrationtest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Utility class to run database scripts for integrations tests
 * 
 * @author azare
 *
 */
public class DBUtil {
	
	private static Connection connection;

	/**
	 * Setup database connection to the given url (any prior connection is
	 * closed first)
	 * 
	 * @param databaseUrl
	 * @throws SQLException
	 */
	public static void openDbConnection(String databaseUrl) throws SQLException {
		closeDbConnection();

		connection = DriverManager.getConnection("jdbc:mysql://"
				+ databaseUrl);
		connection.setAutoCommit(false);
	}

	/**
	 * Close database connection if open
	 * 
	 * @param connection
	 */
	public static void closeDbConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * Close PreparedStatement if open
	 * 
	 * @param statement
	 */
	public static void closePreparedStatement(PreparedStatement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException ex) {
			// Ignore exception
		}
	}

	/**
	 * Close ResultSet if open
	 * 
	 * @param resultSet
	 */
	public static void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException ex) {
			// Ignore exception
		}
	}


}
