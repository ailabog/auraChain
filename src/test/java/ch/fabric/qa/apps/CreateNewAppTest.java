package ch.fabric.qa.apps;

import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import ch.fabric.qa.BaseTest;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.GenerateRandomData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ch.fabric.qa.interfaces.Save;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.AppsPage;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Tests create new app page
 *
 * @author aila.bogasieru@agys.ch
 */

public class CreateNewAppTest extends BaseTest {

	private LoginPage loginPage;
	private Environments environment;
	private LandingPage landingPage;
	private AppsPage appsPage;
	private BasePage basePage;
	private DiagramsPage diagramsPage;

	public static final String APP_DESCRIPTION = GenerateRandomData.generateRandomString(10);
	public static final String APP_NAME = GenerateRandomData.generateRandomString(8);



	@Parameters({ "environment"})
	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment == null? Environments.TEST : Environments.valueOf(environment);
	}

	@Test
	public void testApps(){
		logger.info("Starting creating new appliocation test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickCreateNew();
		appsPage.enterAppsName(APP_NAME);
		appsPage.enterAppDescription(APP_DESCRIPTION);
		appsPage.selectTypeOfApp();
		appsPage.standardApp();
		appsPage.uploadFileToApp("src\\test\\resources\\images\\cat.jpg");
		Save.setDriver(loginPage.getDriver()).save();
		diagramsPage = appsPage.goToDiagramsPageFromAppsPage();
		logger.info("Finishing creating new application test..");
   }

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		appsPage.quit();
		diagramsPage.quit();
	}
}

