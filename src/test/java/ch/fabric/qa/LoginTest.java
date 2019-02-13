package ch.fabric.qa;

import java.io.FileNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ch.fabric.qa.pages.LoginPage;

import ch.fabric.qa.utils.CredentialsUtils;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Tests login page
 * 
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class LoginTest extends BaseTest{

	private LoginPage loginPage;

	public void envLogin(){

	}

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void testLogin() throws FileNotFoundException {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
	}
}
