package ch.fabric.qa.reports;




import ch.fabric.qa.BaseTest;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.sidebarpages.GenerateDocumentsPage;
import ch.fabric.qa.pages.sidebarpages.ReportsPage;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.WebDriverUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoadTheReportsInterfaceTest extends BaseTest {

	private LoginPage loginPage;
	private Environments environment;
	private LandingPage landingPage;
	private AppsPage appsPage;
	private Sidebar sidebar;
	private ReportsPage reportsPage;
	private GenerateDocumentsPage generateDocumentsPage;
	private WebDriverUtils webDriverUtils;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment == null? Environments.TEST : Environments.valueOf(environment);
	}

	@Test
	public void C930LoadThereportsInterface() throws FileNotFoundException {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickOneApp();
		sidebar.clickReports();
		reportsPage = sidebar.returnReportsPage();
		reportsPage.clickZoomPlus();
		reportsPage.clickZoomPlus();
		reportsPage.clickZoomMinus();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		reportsPage.quit();
	}
}