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
 * Class that implements locators methods and returns for NewCatalog page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class NewCatalog extends BasePage {


    private static By saveButton = By.xpath("//*[contains(test)='Save']");
    private static By nameTxtBox = By.xpath("//*[contains(text()='Name']");
    private static By descriptionTxtBox = By.xpath("//*[contains(text()='Description']");
    private static By typeSelect = By.xpath("//*[contains(text()='Type']");
    private static By addColumnsButton = By.xpath("//*contains[text()='+ Add column']");
    private static By removeButton = By.xpath("//input[@class='col q-input-target q-no-input-spinner ellipsis']");

    protected NewCatalog(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){ return super.driver;}

    public void enterCatalogName(WebDriver driver1, String name) {
        log.info("Entering the catalog name {}" + name);
        WebDriverUtils.enterTextBox(driver1, nameTxtBox, name);
    }

    public void enterDescription(WebDriver driver1, String description) {
        log.info("Entering description {}" + description);
        WebDriverUtils.enterTextBox(driver1, descriptionTxtBox, description);
    }

    public void selectType(WebDriver driver1, String columnTypeValue) {
        log.info("Selecting type {} + columnType");
        WebDriverUtils.selectVisibleText(driver1, typeSelect, columnTypeValue);
    }

    public void addColumnAction(WebDriver driver1) {
        log.info("Adding new column to catalog..");
        WebDriverUtils.clickOnElementWithWait(driver1, addColumnsButton);
    }

    public void removeColumn(WebDriver driver1) {
        log.info("Removing column.. ");
        WebDriverUtils.clickOnElementWithWait(driver1, removeButton);
    }

    public void saveCatalog(WebDriver driver1) {
        log.info("Saving the new catalog created..");
        WebDriverUtils.clickOnElementWithWait(driver1, saveButton);
    }
}