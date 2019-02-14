package ch.fabric.qa.interfaceBuilder;

import ch.fabric.qa.BaseTest;
import ch.fabric.qa.interfaces.Save;
import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.sidebarpages.GenerateDocumentsPage;
import ch.fabric.qa.pages.sidebarpages.InterfaceBuilderPage;
import ch.fabric.qa.utils.GenerateRandomData;
import ch.fabric.qa.utils.WebDriverUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Slf4j
public class NewUserInterfaceTest extends BaseTest {

    private LoginPage loginPage;
    private LandingPage landingPage;
    private AppsPage appsPage;
    private Sidebar sidebar;
    private InterfaceBuilderPage interfaceBuilderPage;
    private WebDriverUtils webDriverUtils;

    private static final String APP_DESCRIPTION = GenerateRandomData.generateRandomString(10);
    private static final String APP_NAME = GenerateRandomData.generateRandomString(10);

    @BeforeTest
    public void setuUp() {
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void C870NewUserInterface() throws FileNotFoundException {
        log.info("Starting the C870 New User Interface test...");
        loginPage = new LoginPage(new ChromeDriver());
        loginPage.login();
        landingPage = loginPage.returnLandingPage();
        landingPage.clickMenus();
        appsPage = landingPage.returnAppsPage();
        appsPage.clickCreateNew();
        appsPage.clickApplicationName();
        appsPage.enterAppsName(APP_NAME);
        appsPage.clickApplicationDescription();
        appsPage.enterAppDescription(APP_DESCRIPTION);
        appsPage.uploadFileToApp("src\\test\\resources\\images\\cat.jpg");
        Save.setDriver(appsPage.getDriver()).save();
        sidebar.returnInterfaceBuilderPage();


    }

    @AfterTest
    public void tearDown() {
        loginPage.quit();
        landingPage.quit();
        appsPage.quit();
        interfaceBuilderPage.quit();
    }
}