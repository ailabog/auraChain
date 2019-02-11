package ch.fabric.qa.pages;

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

public abstract class BasePage {

	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
	private SoftAssert softAssert = new SoftAssert();
	final protected WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver(){
		return driver;
	}

	public void load(String url) {
		logger.info("Loading page {}", url);
		WebDriverUtils.load(driver, url);
		WebDriverUtils.maximizeWindow(driver);
		logger.info("Page {} loaded", url);
	}

	protected Object[] assertAll(WebDriver driver, SoftAssert softAssert) {
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			logger.error("Soft assert failed: {} ", e.toString());
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
		logger.info("End of test...", assertAll(driver, softAssert));
	}
}
