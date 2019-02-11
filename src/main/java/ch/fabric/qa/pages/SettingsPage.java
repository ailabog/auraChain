package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains locators, methods specific to Settings Page
 *
 * @author aila.bogasieru@agys.ch
 */


public class SettingsPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(SettingsPage.class);

    private By visibilityIcon = By.xpath("//i[text()='visibility_off']");

    protected SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickVisibility() {
        logger.info("Displaying visibility..");
        WebDriverUtils.clickOnElementWithWait(driver, visibilityIcon);
    }
}
