package ch.fabric.qa.apps;

import ch.fabric.qa.interfaces.Save;
import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ch.fabric.qa.BaseTest;
/**
 * Tests edit new app page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class EditAppTest extends BaseTest{

	private LoginPage loginPage;
	private LandingPage landingPage;
	private AppsPage appsPage;
	private DiagramsPage diagramsPage;

	private static final String APP_TO_BE_EDITED = "17/1/12/29/10";
	private static final String EXPECTED_TEXT = "17/1/12/29/10";
	//private static final String DESCRIPTION_TEXT = GenerateRandomData.generateRandomString(8);

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void editApp(){
		log.info("Starting editing an existing application test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		appsPage.clickOnSearchIcon();
		appsPage.searchApp(APP_TO_BE_EDITED);
    	appsPage.assertAppFound(EXPECTED_TEXT);
		appsPage.clickOnEditAppbtn();
		appsPage.SendDescSubstrToDesc();
		Save.setDriver(loginPage.getDriver()).save();
		diagramsPage = appsPage.goToDiagramsPageFromAppsPage();
		Save.setDriver(loginPage.getDriver()).save();
		diagramsPage.savedMessageVisible();
		log.info("Finishing editing an appliocation test..");
   }

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		appsPage.quit();
	}
}
