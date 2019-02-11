package ch.fabric.qa.utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.fabric.qa.exceptions.DatabaseException;

public class PostgreSqlConnection {

	protected static final Logger logger = LoggerFactory.getLogger(PostgreSqlConnection.class);
	private Connection connection;
	private String env;


	private static final String SELECT_EMAIL_FROM_IDENTIYDB_EMAIL = "SELECT * FROM public.email WHERE EMAIL = testuser@fabric.ch";

	public PostgreSqlConnection(String databaseUrl) throws FileNotFoundException {

		Properties prop = new Properties();
		env = System.getProperty("environment");
		FileInputStream file = new FileInputStream(
				"src\\test\\resources\\"+env+".properties");
		try {
			prop.load(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			logger.debug("Connecting to DB {} as {} user.", databaseUrl);
			this.connection = DriverManager.getConnection(databaseUrl, prop.getProperty("dbusername"),
					prop.getProperty("dbpassword"));
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e);
		}


	}

	private ResultSet executeQuery(String query, String... params) {
		try {
			PreparedStatement pStmt = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			logger.debug("Executing DB query: {}", query);
			pStmt.clearParameters();
			for (int iCount = 0; iCount < params.length; iCount++) {
				logger.debug("Parameter {} : {}", iCount, params[iCount]);
				pStmt.setString(iCount + 1, params[iCount]);

			}
			return pStmt.executeQuery();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e);
		}
	}

	private void executeUpdateQuery(String query) {
		try {
			logger.debug("Executing DB query: {}", query);
			connection.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new DatabaseException(e);
		}
	}

	public static int countFrom(ResultSet rs) {
		try {
			rs.beforeFirst();
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new DatabaseException("Exception occurred while counting rows in ResultSet", e);
		}
	}

	public void connectionClose() {
		try {
			connection.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new DatabaseException("Error while closing the connection", e);
		}
	}

	public ResultSet getEmail(String email) {
		return executeQuery(SELECT_EMAIL_FROM_IDENTIYDB_EMAIL, email);
	}
}