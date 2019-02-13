package ch.fabric.qa.applicationsettings;

import ch.fabric.qa.BaseTest;
import ch.fabric.qa.pages.*;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.GenerateRandomData;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Slf4j
public class InstallElementsTest extends BaseTest {

	private LoginPage loginPage;
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

	@BeforeTest
	public void setuUp() {
		ChromeDriverManager.getInstance().setup();
	}

	//Done
	@Test(priority = 0)
	public void C1105InstallElementsTest() {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.login();
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		applicationSettingsPage = landingPage.returnApplicationSettingsPage();
		applicationSettingsPage.syncElements();
		applicationSettingsPage.installElements();

	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		applicationSettingsPage.quit();
	}
}