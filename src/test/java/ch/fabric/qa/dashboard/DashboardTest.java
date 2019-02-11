package ch.fabric.qa.dashboard;

import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.DashboardPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.BaseTest;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Tests Dashboard page
 *
 * @author aila.bogasieru@agys.ch
 */

public class DashboardTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private LandingPage landingPage;
	private Environments environment;

	@Parameters({ "environment"})
	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment == null? Environments.TEST : Environments.valueOf(environment);
	}

	@Test
	public void testDashboard() {
		logger.info("Starting the dashboard test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		dashboardPage = landingPage.returnDashboardPage();
		dashboardPage.showMonths();
		dashboardPage.showApplications();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		dashboardPage.quit();
	}
}