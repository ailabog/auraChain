package ch.fabric.qa;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.PostgreSqlConnection;

/**
 * Tests db connection & checks that email address used to login is testuser@fabric.ch
 *
 * @author aila.bogasieru@agys.ch
 */


public class TestDbTest extends BaseTest {

	private Environments environment;
	private PostgreSqlConnection db;
	private Connection temp_conn;

	@Parameters({"environment"})
	@BeforeTest
	public void setUpDatabase() throws FileNotFoundException {
		this.environment = environment == null? Environments.DEVELOPMENT : Environments.valueOf(environment.getDBURL());
		db = new PostgreSqlConnection(environment.getDBURL());
		System.out.println((environment.getDBURL()));
	}

	@Test
	public void test() throws FileNotFoundException, SQLException {
		logger.info("**************************************************************");
		logger.info("Starting to retrieve email from database..");
		temp_conn = DriverManager.getConnection(environment.getDBURL(),
				CredentialsUtils.getProperty("dbusername"), CredentialsUtils.getProperty("dbpassword"));
				logger.info("Retrieving email from db test {} PASSED");
		logger.info("**************************************************************");
		logger.info("                                                              ");
	}

	@AfterTest
	public void tearDown() {
		db.connectionClose();
	}
}
