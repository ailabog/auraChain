package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains locators, methods specific to Settings Page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class SettingsPage extends BasePage {


    private By visibilityIcon = By.xpath("//i[text()='visibility_off']");

    protected SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickVisibility() {
        log.info("Displaying visibility..");
        WebDriverUtils.clickOnElementWithWait(driver, visibilityIcon);
    }
}
