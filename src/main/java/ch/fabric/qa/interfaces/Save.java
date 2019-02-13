package ch.fabric.qa.interfaces;

import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains helper for New save functionality
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class Save {


    private By saveButton = By.xpath("//button//div[text()='Save']");

    private static WebDriver driver;

    public static Save setDriver(WebDriver driver){
    Save save = new Save();
    save.driver = driver;
    return save;
    }

    public Save save() {
        log.info("saving the info..");
        WebDriverUtils.clickOnElementWithWait(driver, saveButton);
        return this;
    }
}
