package ch.fabric.qa.tasks;

import ch.fabric.qa.BaseTest;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.TasksPage;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.GenerateRandomData;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FilterTasksTest extends BaseTest {

    private LoginPage loginPage;
    private Environments environment;
    private LandingPage landingPage;
    private TasksPage tasksPage;

    private static final String USER_TO_BE_SEARCHED = "string123";
    private static final String ROLE_NAME = "My Role";
    private static final String FIRST_NAME = GenerateRandomData.generateRandomString(5);
    private static final String LAST_NAME = GenerateRandomData.generateRandomString(5);
    private static final String EMAIL = GenerateRandomData.generateEmail(10);
    private static final String PASSWORD = GenerateRandomData.generateRandomString(10);

    @Parameters({"environment"})
    @BeforeTest
    public void setuUp(String environment) {
        ChromeDriverManager.getInstance().setup();
        this.environment = environment == null ? Environments.TEST : Environments.valueOf(environment);
    }

    @Test(priority = 0)
    public void C1118FilterTasksTest() {
        logger.info("Starting the search for tasks test..");
//        loginPage.load(environment.getURL());
        loginPage = new LoginPage(new ChromeDriver());
        loginPage.load(CredentialsUtils.getProperty("url"));
        loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
        loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
        landingPage = loginPage.returnLandingPage();
        landingPage.clickMenus();
        tasksPage = landingPage.returnTasksPage();
        tasksPage.filterByApplications();

    }

    @AfterTest
    public void tearDown() {
        loginPage.quit();
        landingPage.quit();
        tasksPage.quit();
    }
}