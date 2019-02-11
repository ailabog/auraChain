package ch.fabric.qa.pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;

/**
 * Contains locators, methods specific to Manage Documents Page
 *
 * @author aila.bogasieru@agys.ch
 */


public class ManageDocumentsPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(ManageDocumentsPage.class);

    private By checkCheckBoxNme = By.xpath("//i[text()='check_box_outline_blank']");
    private By removeDocument = By.xpath("//i[text()='delete']");
    private By recordsPerpage = By.xpath("//div//i[text()='arrow_drop_down']");
    private By navigateRight = By.xpath("//i[text()='chevron_right']");
    private By navigareLeft = By.xpath("//i[text()='chevron_left']");

    protected ManageDocumentsPage(WebDriver driver) {
        super(driver);
    }
}
