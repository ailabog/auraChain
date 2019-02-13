package ch.fabric.qa.user;

import ch.fabric.qa.BaseTest;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Slf4j
public class AccountLogoutTest extends BaseTest{

	private LoginPage loginPage;
	private LandingPage landingPage;

	public void envLogin(){

	}

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void C1121AccountLogout() throws FileNotFoundException {
		log.info("Starting the C1121 Account Logout test...");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.userLogOut();

	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
	}
}
