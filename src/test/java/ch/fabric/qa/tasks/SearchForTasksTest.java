package ch.fabric.qa.tasks;


import ch.fabric.qa.BaseTest;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.TasksPage;
import ch.fabric.qa.utils.CredentialsUtils;
import ch.fabric.qa.utils.GenerateRandomData;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Slf4j
public class SearchForTasksTest extends BaseTest {

    private LoginPage loginPage;
    private LandingPage landingPage;
    private TasksPage tasksPage;

    private static final String USER_TO_BE_SEARCHED = "string123";
    private static final String ROLE_NAME = "My Role";
    private static final String FIRST_NAME = GenerateRandomData.generateRandomString(5);
    private static final String LAST_NAME = GenerateRandomData.generateRandomString(5);
    private static final String EMAIL = GenerateRandomData.generateEmail(10);
    private static final String PASSWORD = GenerateRandomData.generateRandomString(10);

    @BeforeTest
    public void setuUp() {
        ChromeDriverManager.getInstance().setup();
    }

    @Test(priority = 0)
    public void C1117SearchForTasksTest() {
        log.info("Starting the search for tasks test..");
//        loginPage.load(environment.getURL());
        loginPage = new LoginPage(new ChromeDriver());
        loginPage.login();
        landingPage = loginPage.returnLandingPage();
        landingPage.clickMenus();
        tasksPage = landingPage.returnTasksPage();
        tasksPage.searchForTask();
    }

    @AfterTest
    public void tearDown() {
        loginPage.quit();
        landingPage.quit();
        tasksPage.quit();
    }
}