package ch.fabric.qa.dashboard;

import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.DashboardPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.BaseTest;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class DashboardTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private LandingPage landingPage;

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void testDashboard() {
		log.info("Starting the dashboard test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
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