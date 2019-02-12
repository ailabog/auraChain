package ch.fabric.qa.user;

import ch.fabric.qa.BaseTest;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ChangeInformationTest extends BaseTest{

	private LoginPage loginPage;
	private Environments environment;
	private LandingPage landingPage;

	public void envLogin(){

	}

	@Parameters({ "environment"})
	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment == null? Environments.TEST : Environments.valueOf(environment);
	}

	@Test
	public void C1122ChangeInformation() throws FileNotFoundException {
		logger.info("Starting the C1122 Change Information test...");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.changeUserInformation();

	}

//	@AfterTest
//	public void tearDown() {
//		loginPage.quit();
//	}
}
