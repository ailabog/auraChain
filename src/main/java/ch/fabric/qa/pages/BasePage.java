package ch.fabric.qa.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import ch.fabric.qa.utils.WebDriverUtils;

/**
 * Base page
 * 
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public abstract class BasePage {

	private SoftAssert softAssert = new SoftAssert();
	final protected WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver(){
		return driver;
	}

	public void load(String url) {
		log.info("Loading page {}", url);
		WebDriverUtils.load(driver, url);
		WebDriverUtils.maximizeWindow(driver);
		log.info("Page {} loaded", url);
	}

	protected Object[] assertAll(WebDriver driver, SoftAssert softAssert) {
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			log.error("Soft assert failed: {} ", e.toString());
			driver.quit();
			throw new WebDriverException(e);
		}
		return null;
	}

	public void quit() {
		if (this != null) {
			WebDriverUtils.quit(driver);
		}
	}

	@AfterMethod
	public void test() {
		log.info("End of test...", assertAll(driver, softAssert));
	}
}
