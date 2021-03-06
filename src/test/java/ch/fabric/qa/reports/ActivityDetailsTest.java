package ch.fabric.qa.reports;


import ch.fabric.qa.BaseTest;
import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import ch.fabric.qa.pages.sidebarpages.ReportsPage;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.WebDriverUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Slf4j
public class ActivityDetailsTest extends BaseTest {

	private LoginPage loginPage;
	private LandingPage landingPage;
	private AppsPage appsPage;
	private Sidebar sidebar;
	private ReportsPage reportsPage;
	private DiagramsPage diagramsPage;
	private WebDriverUtils webDriverUtils;



	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void C942ActivityDetails() throws FileNotFoundException {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickOneApp();
		sidebar.clickDiagram();
		diagramsPage = sidebar.returnDiagramsPage2();
		diagramsPage.clickGeneralStartDropDown();
		diagramsPage.clickStatusNameField();
		diagramsPage.enterStatusCodeField();
		sidebar.clickReports();
		reportsPage = sidebar.returnReportsPage();
		reportsPage.compareStatusNameField();
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		reportsPage.quit();
	}
}