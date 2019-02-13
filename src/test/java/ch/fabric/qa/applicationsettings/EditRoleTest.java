package ch.fabric.qa.applicationsettings;

import ch.fabric.qa.BaseTest;
import ch.fabric.qa.pages.ApplicationSettingsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Slf4j
public class EditRoleTest extends BaseTest{

	private LoginPage loginPage;
	private LandingPage landingPage;
	private ApplicationSettingsPage applicationSettingsPage;

	public void envLogin(){
	}

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void C982EditRole() throws FileNotFoundException {
		log.info("Starting the C982 Edit role test...");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		applicationSettingsPage = landingPage.returnApplicationSettingsPage();
		applicationSettingsPage.editUser();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
	}
}
