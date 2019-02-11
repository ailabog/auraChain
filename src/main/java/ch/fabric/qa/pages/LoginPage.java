package ch.fabric.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fabric.qa.utils.WebDriverUtils;

/**
 * Tests login page
 *
 * @author aila.bogasieru@agys.ch
 */

public class LoginPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By usernameTextBox = By
            .xpath("//input[@name='username']");
    private By passwordTextBox = By
            .xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button//div[text()='Login']");
    private By landingIcon = By.xpath("//button//i[@class='q-icon fas fa-th']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void usernameLogin(String usernameValue) {
        logger.info("Clearing username value...");
        WebDriverUtils.clearElement(driver, usernameTextBox);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('input[name=username]').dispatchEvent(new Event('input'))");
        logger.info("Entering username...");
        WebDriverUtils.enterTextBox(driver, usernameTextBox, usernameValue);
    }

    public void passwordLogin (String passwordValue) {
        logger.info("Clearing password value...");
        WebDriverUtils.clearElement(driver, passwordTextBox);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('input[name=username]').dispatchEvent(new Event('input'))");
        logger.info("Entering password...");
        WebDriverUtils.enterTextBox(driver, passwordTextBox, passwordValue);
//        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_5000_MILLISECONDS);
    }

    public void login() {
        logger.info("Logging into Smart Fabric...");
        WebDriverUtils.clickOnElementWithWait(driver, loginButton);
    }


    public void clearCookies() {
        WebDriverUtils.clearCookies(driver);
    }

    public LandingPage returnLandingPage() {
       WebDriverUtils.clickOnElementWithWait(driver, loginButton);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.visibilityOfElementLocated(landingIcon));

        return new LandingPage(driver);
    }
}
