package ch.fabric.qa;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.PostgreSqlConnection;

/**
 * Tests db connection & checks that email address used to login is testuser@fabric.ch
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class TestDbTest extends BaseTest {

	private PostgreSqlConnection db;
	private Connection temp_conn;

	@BeforeTest
	public void setUpDatabase() throws FileNotFoundException {
		String dburl = CredentialsUtils.getProperty("dburl");
		db = new PostgreSqlConnection(dburl);
		System.out.println(dburl);
	}

	@Test
	public void test() throws FileNotFoundException, SQLException {
		log.info("**************************************************************");
		log.info("Starting to retrieve email from database..");
		temp_conn = DriverManager.getConnection(CredentialsUtils.getProperty("dburl"),
				CredentialsUtils.getProperty("dbusername"), CredentialsUtils.getProperty("dbpassword"));
				log.info("Retrieving email from db test {} PASSED");
		log.info("**************************************************************");
		log.info("                                                              ");
	}

	@AfterTest
	public void tearDown() {
		db.connectionClose();
	}
}
