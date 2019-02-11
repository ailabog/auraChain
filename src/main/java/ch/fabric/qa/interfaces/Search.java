package ch.fabric.qa.interfaces;

import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains helper for Search functionality
 *
 * @author aila.bogasieru@agys.ch
 */


public class Search extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(Search.class);

    private static By nameTxtBox = By.xpath("//*[contains(text()='Name']");
    private static WebDriver driver;

    protected Search(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }

    private static void search(String result) {
        logger.info("Searching for {}" + result);
        WebDriverUtils.enterTextBox(driver, nameTxtBox, result);
    }


}