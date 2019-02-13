package ch.fabric.qa;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.utils.CredentialsUtils;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Tests Landing page
 * 
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class LandingTest extends BaseTest{

	private LoginPage loginPage;
	private LandingPage landingPage;

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void testLanding() {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
   		landingPage.checkDasboardElements();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
	}
}