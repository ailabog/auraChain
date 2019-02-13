package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that implements locators methods and returns for API page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class ApisPage extends BasePage  {


    private static By addNewApiBtn = By.xpath("//button//div[text()=' ADD NEW ']");
    private static By consumedLink = By.xpath("//button//div[text()='Consumed']");
    private static By exposedLink = By.xpath("//button//div[text()='Exposed']");
    private static By consumedBtn = By.xpath("//button//i[text()='Consumed']");
    private static By exposedBtn = By.xpath("//button//i[text()='Exposed']");
    private static By nameApi = By.xpath("//div//div[text()='Name']");
    private static By URLApi = By.xpath("//div//div[text()='URL']");
    private static By typeApi = By.xpath("//i[text()='arrow_drop_down']");
    private static By requiresAuth = By.xpath("//div//span[text()='Requires authentication']");
    private static By uploadImg = By.xpath("//div//i[text()='cloud_upload']");
    private static By descriptionApi = By.xpath("//textarea//div[text()='Description']");
    private static By swaggerType = By.xpath("//body/div[5]/div/div[2]/div/div");
    private static By wsdlTypre = By.xpath("/body/div[5]/div/div/div/div");
    private static By cancelBtn = By.xpath("//button//div[text()='Cancel']");
    private static By arrowType = By.xpath("//i[text()='arrow_drop_down']");
    private static By usernameTxt = By.xpath("//input//div[text()='Username']");
    private static By passwordTxt = By.xpath("//input//div[ptext()='Password']");
    private static By clientId = By.xpath("//input//div[text()='Client ID']");
    private static By clientSecret = By.xpath("//input//div[text()='Client Secret']");
    private static By baseURL = By.xpath("//inpout//div[text()='Base URL']");
    private static By noneType = By.xpath("//body/div[5]/div/div/div/div");
    private static By userNameAndPassword = By.xpath("//body/div[5]/div/div[2]/div/div");
    private static By oauth2 = By.xpath("//body/div[5]/div/div[3]/div/div");
    private static By oauth2WithPassword = By.xpath("//body/div[5]/div/div[4]/div/div");


    public ApisPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){
        return super.driver;
    }

    public void addNewApi() {
        log.info("Adding new API..");
        WebDriverUtils.clickOnElementWithWait(super.driver, addNewApiBtn);
    }

    public void clickConsumed() {
        log.info("Go to Consumed APIs list..");
        WebDriverUtils.clickOnElementWithWait(super.driver, consumedLink);
    }

    public void clickExposedc() {
        log.info("Accessing exposed APIs..");
        WebDriverUtils.clickOnElementWithWait(super.driver, exposedLink);
    }

    public void goToConsumed() {
        log.info("Go to Consumed APISs..");
        WebDriverUtils.clickOnElementWithWait(super.driver, consumedBtn);
    }

    public void goToExposed() {
        log.info("Go to Exposed APISs..");
        WebDriverUtils.clickOnElementWithWait(super.driver, exposedBtn);
    }

    public void eneterNameApi(String ApiName) {
        log.info("Entering name for my API...");
        WebDriverUtils.enterTextBox(super.driver, nameApi, ApiName);
    }

    public void eneterURLApi(String ApiURL) {
        log.info("Entering URL for my API...");
        WebDriverUtils.enterTextBox(super.driver, URLApi, ApiURL);
    }

    public void eneterDescriptionApi(String descriptionApiValue) {
        log.info("Entering description for my API...");
        WebDriverUtils.enterTextBox(super.driver, descriptionApi, descriptionApiValue);
    }

    public void selectTypeApi() {
        log.info("Selecting type element..");
        WebDriverUtils.clickOnElementWithWait(super.driver, typeApi);
    }

    public void selectWsdl() {
        WebDriverUtils.clickOnElementWithWait(super.driver, wsdlTypre);
    }

    public void selectSwagger() {
        WebDriverUtils.clickOnElementWithWait(super.driver, swaggerType);
    }

    public void authentication() {
        WebDriverUtils.clickOnElementWithWait(super.driver, requiresAuth);
    }

    public void uploadImg(String filePath) {
        WebDriverUtils.uploadFile(super.driver, uploadImg, filePath);
    }

    public void noneType() {
        WebDriverUtils.clickOnElementWithWait(super.driver, noneType);
    }

    public void usernameAndPasswordType() {
        WebDriverUtils.clickOnElementWithWait(super.driver, userNameAndPassword);
    }

    public void enterUsername(String usernameValue, String passwordValue) {
        log.info("Entering username..");
        WebDriverUtils.enterTextBox(super.driver, usernameTxt, usernameValue);
        log.info("Entering poassword..");
        WebDriverUtils.enterTextBox(super.driver, passwordTxt, passwordValue);
    }

    public void oauth2Type() {
        WebDriverUtils.clickOnElementWithWait(super.driver, oauth2);
    }

    public void oauth2Info(String clientIdValue, String clientSecretValue, String baseURLValue) {
        log.info("Entering Client ID..");
        WebDriverUtils.enterTextBox(super.driver, clientId, clientIdValue);
        log.info("Entering Client Secret..");
        WebDriverUtils.enterTextBox(super.driver, clientSecret, clientSecretValue);
        log.info("Entering Base URL..");
        WebDriverUtils.enterTextBox(super.driver, baseURL, baseURLValue);
    }

    public void oauth2WithPasswordType() {
        WebDriverUtils.clickOnElementWithWait(super.driver, oauth2WithPassword);
    }

    public void cancelApiCraetion() {
        WebDriverUtils.clickOnElementWithWait(super.driver, cancelBtn);
    }

    public void setArrowTypeApi() {
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowType);
    }
}
