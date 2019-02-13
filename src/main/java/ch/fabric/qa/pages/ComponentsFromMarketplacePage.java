package ch.fabric.qa.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

/**
 * Contains locators, methods specific to Components From Market place Page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class ComponentsFromMarketplacePage extends BasePage {

    private By updateBtn = By.xpath("//div[text()='UPDATE']");
    private By removeBtn = By.xpath("//div[text()='REMOVE']");
    private By installBtn = By.xpath("//div[text()='INSTALL']");

    protected ComponentsFromMarketplacePage(WebDriver driver) {
        super(driver);
    }

}
