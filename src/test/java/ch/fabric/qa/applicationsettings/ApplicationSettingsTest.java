package ch.fabric.qa.applicationsettings;

import com.github.javafaker.Faker;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.*;
import ch.fabric.qa.BaseTest;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.GenerateRandomData;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Tests Application Seetings page
 *
 * @author aila.bogasieru@agys.ch
 */

public class ApplicationSettingsTest extends BaseTest{

	private LoginPage loginPage;
	private Environments environment;
	private LandingPage landingPage;
	private ManageAppsPage manageAppsPage;
	private ApplicationSettingsPage applicationSettingsPage;
	private ManageDocumentsPage manageDocumentsPage;
	private ManageUIsPage manageUIsPage;
	private ComponentsFromMarketplacePage componentsFromMarketplacePage;
	private SettingsPageTest settingsPage;
	private static final String USER_TO_BE_SEARCHED = "string123";
	private static final String ROLE_NAME = "My Role";
	private static final String PASSWORD = GenerateRandomData.generateRandomString(10);
	private static Faker faker = new Faker();
	private static final String FIRST_NAME = faker.firstName();
//			firstname().gender("f").gen();
	private static final String LAST_NAME = faker.lastName();
    private static final String EMAIL = FIRST_NAME + "." + LAST_NAME + "@4t35t.com";

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(Environments environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment;
	}
//Done
	@Test(priority=0)
	public void createRoleAndUser(){
		logger.info("Starting creating users and roles test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		applicationSettingsPage = landingPage.returnApplicationSettingsPage();
	    applicationSettingsPage.clickCreateNewRole();
		applicationSettingsPage.addPermission();
//	    applicationSettingsPage.selectApplication();
//		applicationSettingsPage.setInitiator();
//Above methods will be uncommented when the functionality from the application will work
		applicationSettingsPage.clickSaveOnNew();
		applicationSettingsPage.closePanel();

		logger.info("Finishing creating users and roles test.");
   }
//Done
	@Test(priority=1)
	public void addNewUser(){
		logger.info("Starting adding new user test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		applicationSettingsPage = landingPage.returnApplicationSettingsPage();
		applicationSettingsPage.addUsers();
		applicationSettingsPage.enterFirstName(FIRST_NAME );
		applicationSettingsPage.enterLastName(LAST_NAME);
		applicationSettingsPage.enterEmailAddress(EMAIL);
		applicationSettingsPage.checkGenre("Female");
//applicationSettingsPage.checkStatus("Active"); was removed from the app, will be deleted when the design is confirmed
		applicationSettingsPage.manuallySetPassword(PASSWORD);
		applicationSettingsPage.clickSaveOnNewUser();
		logger.info("Finishing adding new user test.");
	}
//Done
	@Test(priority=2)
	public void browseAndSaveRoles(){
		logger.info("Starting browsing roles test..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		applicationSettingsPage = landingPage.returnApplicationSettingsPage();
		applicationSettingsPage.clikcBrowseRoles();
		applicationSettingsPage.actEditRole();
		applicationSettingsPage.editRoles();
		applicationSettingsPage.clickSaveOnEdit();
		logger.info("Finishing browsing roles test.");
	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		applicationSettingsPage.quit();
	}
}
