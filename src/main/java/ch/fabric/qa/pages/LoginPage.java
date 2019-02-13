package ch.fabric.qa.pages;

import ch.fabric.qa.utils.CredentialsUtils;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class LoginPage extends BasePage {

    private By usernameTextBox = By
            .xpath("//input[@name='username']");
    private By passwordTextBox = By
            .xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button//div[text()='Login']");
    private By landingIcon = By.xpath("//button//i[@class='q-icon fas fa-th']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsernameAndPassword(String usernameValue, String passwordValue) {
        log.info("Entering username...");
        WebDriverUtils.enterTextBox(driver, usernameTextBox, usernameValue);
        log.info("Entering password...");
        WebDriverUtils.enterTextBox(driver, passwordTextBox, passwordValue);
    }

    private void usernameLogin(String usernameValue) {
        log.info("Clearing username value...");
        WebDriverUtils.clearElement(driver, usernameTextBox);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('input[name=username]').dispatchEvent(new Event('input'))");
        log.info("Entering username...");
        WebDriverUtils.enterTextBox(driver, usernameTextBox, usernameValue);
    }

    private void passwordLogin (String passwordValue) {
        log.info("Clearing password value...");
        WebDriverUtils.clearElement(driver, passwordTextBox);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('input[name=username]').dispatchEvent(new Event('input'))");
        log.info("Entering password...");
        WebDriverUtils.enterTextBox(driver, passwordTextBox, passwordValue);
//        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_5000_MILLISECONDS);
    }

    public void login() {
        load(CredentialsUtils.getProperty("url"));

        usernameLogin(CredentialsUtils.getProperty("username"));
        passwordLogin(CredentialsUtils.getProperty("password"));

        log.info("Logging into Smart Fabric...");
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
