package ch.fabric.qa.apps;

import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ch.fabric.qa.BaseTest;
import org.testng.annotations.Parameters;
import java.io.FileNotFoundException;

/**
 * Tests Navigate, browse, search in Apps page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class AppTest extends BaseTest{

	private LoginPage loginPage;
	private LandingPage landingPage;
	private AppsPage appsPage;


	private static final String APP_NAME_SEARCH = "17/1/12/29/10";
	private static final String EXPECTED_TEXT = "17/1/12/29/10";


	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
	}

	@Test(priority=0)
	public void testAppsMoreActionsReports(){
		log.info("Starting Reports from Application test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickMoreActionsApp();
		appsPage.clickReportsActionApp();
		//Reports element to be checked for visiblity
		log.info("Finishing Reports from Application test.");
	}

	@Test(priority=1)
	public void testAppsMoreActionsUserInterface() throws FileNotFoundException {
		log.info("Starting User Interface from Application test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickMoreActionsApp();
		appsPage.clickUserInterfaceActionApp();
		//UserInterface element to be checked for visiblity
		log.info("Finishing User Interface from Application test.");
	}

	@Test(priority=2)
	public void testAppsMoreActionsNavigation() throws FileNotFoundException {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickArchievedApplication();
		appsPage.clickSharedWithYou();
		appsPage.clickYourApplication();
		//Check to see if an unique application developped by the loggerd user is visible
		log.info("Finishing Navigation from Application test.");
	}


	@Test(priority=3)
	public void testAppSearch() throws FileNotFoundException {
		log.info("Starting searching an app from the existing apps test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickOnSearchIcon();
		appsPage.searchApp(APP_NAME_SEARCH);
		appsPage.assertAppFound(EXPECTED_TEXT);
		log.info("Finishing searching an app from the existing app test.");
	}

	@AfterTest
	public void tearDown() {
	    loginPage.quit();
		landingPage.quit();
		appsPage.quit();

	}

}
