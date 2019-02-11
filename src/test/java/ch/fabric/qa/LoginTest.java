package ch.fabric.qa;

import java.io.FileNotFoundException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.LoginPage;

import ch.fabric.qa.utils.CredentialsUtils;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Tests login page
 * 
 * @author aila.bogasieru@agys.ch
 */

public class LoginTest extends BaseTest{

	private LoginPage loginPage;
	private Environments environment;

	public void envLogin(){

	}

	@Parameters({ "environment"})
	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment == null? Environments.TEST : Environments.valueOf(environment);
	}

	@Test
	public void testLogin() throws FileNotFoundException {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		loginPage.login();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
	}
}
