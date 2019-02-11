package ch.fabric.qa.utils;


import ch.qos.logback.core.joran.action.Action;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class WebDriverUtils {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverUtils.class);

    public static final long WAIT_60_SECONDS = 60;
    public static final long WAIT_40_SECONDS = 40;
    public static final long WAIT_20_SECONDS = 20;
    public static final long WAIT_10_SECONDS = 10;
    public static final long WAIT_5_SECONDS = 5;
    public static final long WAIT_100_SECONDS = 100;

    public static final long WAIT_500_MILLISECONDS = 500;
    public static final long WAIT_1000_MILLISECONDS = 1000;
    public static final long WAIT_1500_MILLISECONDS = 1500;
    public static final long WAIT_2000_MILLISECONDS = 2000;
    public static final long WAIT_5000_MILLISECONDS = 5000;

    public static final String SRC_ATTRIBUTE = "src";
    public static final String PLACEHOLDER_ATTRIBUTE = "placeholder";
    public static final String HREF_ATTRIBUTE = "href";
    public static final String CHECKED_ATTRIBUTE = "checked";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String BORDER_CSS_ATTRIBUTE = "border";
//    static boolean found;

    /**
     * Enters provided text, if it is not "N/A", into field specified by locator.
     *
     * @param driver
     * @param locator
     * @param text
     */
    public static void enterTextBox(WebDriver driver, By locator, String text) {
        logger.debug("Writing \" {} \" to element: {}", text, locator);
        waitUntil(driver, WAIT_100_SECONDS, ExpectedConditions.elementToBeClickable(locator));
        WebElement element = findElement(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Selects provided option by text, if it is not "N/A", in field specified by
     * locator.
     *
     * @param driver
     * @param locator
      */

    public static void uploadFiles(WebDriver driver, By locator, String filePath) {
    String appimage = new String (new File(filePath).getAbsolutePath());
    WebElement element = findElement(driver, locator);
    element.sendKeys(appimage);
    //driver.findElement(By.id("urid")).sendKeys(filePath);
    }

    public static void selectDropDown(WebDriver driver, By locator, String option) {
        logger.debug("Selecting \" {} \" in element: {}", option, locator);
        waitUntil(driver, WAIT_100_SECONDS, ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript(
                "var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }",
                findElement(driver, locator), option);
    }

    public static void driverGoBack(WebDriver driver) {
        driver.navigate().back();
    }

    public static void selectDropDownIndex(WebDriver driver, By locator, Integer i) {
        logger.debug("Selecting \" {} \" in element: {}", i, locator);
        waitUntil(driver, WAIT_100_SECONDS, ExpectedConditions.elementToBeClickable(locator));

        selectByID(driver, locator, i);

    }

    public static void switchToTab(WebDriver driver, int tab) {
        logger.debug("Switching to tab: {}", tab);
        try {
            driver.switchTo().window((String) driver.getWindowHandles().toArray()[tab]);
        } catch (NoSuchWindowException e) {
            logger.error("Tab {} does not exist", tab);
            driver.quit();
            throw new WebDriverException(e);
        }
    }

    public static void waitUntil(WebDriver driver, long timeOutInSeconds, ExpectedCondition<?> expectedCondition) {
        try {
            logger.debug("Waiting for expected condition {}", expectedCondition);
            new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
        } catch (TimeoutException e) {
            logger.error("Timeout occurred while waiting for expected condition to be met");
            driver.quit();
            throw new WebDriverException(e);
        } catch (org.openqa.selenium.WebDriverException e1) {
            logger.error("WebDriverException thrown: {}", e1.getMessage());
            driver.quit();
            throw new WebDriverException(e1);
        }
    }

    public static void dragAndDrop(WebDriver driver, By locatorfrom, By locatorTo) {
        Actions builder = new Actions(driver);
        Action dragAndDrop = (Action) builder.clickAndHold((WebElement) locatorfrom)
                .moveToElement((WebElement) locatorTo)
                .release((WebElement) locatorTo)
                .build();
        ((org.openqa.selenium.interactions.Action) dragAndDrop).perform();
    }

    public static void explicitWait(WebDriver driver, long millis) {
        try {
            logger.debug("Waiting for {} milliseconds", millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            logger.error("Thread.sleep() interrupted");
            driver.quit();
            throw new WebDriverException(e);
        }
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        findElement(driver, locator).click();
        logger.debug("Clicked on element: {}", locator);
    }

    public static void clickOnElementWithWait(WebDriver driver, By locator) {
        waitUntil(driver, WAIT_100_SECONDS, ExpectedConditions.elementToBeClickable(locator));
        clickOnElement(driver, locator);
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        try {
            logger.debug("Finding element {}", locator);
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            logger.error("Element {} was not found", locator);
            driver.quit();
            throw new WebDriverException(e);
        } catch (org.openqa.selenium.WebDriverException e1) {
            logger.error("WebDriverException thrown: {}", e1.getMessage());
            driver.quit();
            throw new WebDriverException(e1);
        }
    }

    public static void selectVisibleText(WebDriver driver, By locator, String option)
            throws NoSuchElementException, UnexpectedTagNameException {
        try {
            new Select(findElement(driver, locator)).selectByVisibleText(option);
        } catch (WebDriverException e) {
            logger.error("Element {} was not found", locator);
            driver.quit();
            throw new WebDriverException(e);
        }
    }

    private static void selectByID(WebDriver driver, By locator, Integer i)
            throws NoSuchElementException, UnexpectedTagNameException {
        try {
            new Select(findElement(driver, locator)).selectByIndex(i);
        } catch (WebDriverException e) {
            logger.error("Element {} was not found", locator);
            driver.quit();
            throw new WebDriverException(e);
        }
    }

    public static List<WebElement> findElements(WebDriver driver, By locator) {
        try {
            logger.debug("Finding element {}", locator);
            return driver.findElements(locator);
        } catch (org.openqa.selenium.WebDriverException e) {
            logger.error("WebDriverException thrown: {}", e.getMessage());
            driver.quit();
            throw new WebDriverException(e);
        }
    }

    // @formatter:off
    public static boolean isElementPresent(WebDriver driver, By locator) {
        logger.debug("Checking if element {} is present", locator);
        return findElements(driver, locator).stream().findFirst().isPresent();
    }
    // @formatter:on

    // @formatter:off
    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        logger.debug("Checking if element {} is displayed", locator);
        return findElements(driver, locator).stream().filter(WebElement::isDisplayed).findFirst().isPresent();
    }
    // @formatter:on

    // @formatter:off
    public static int getElementCount(WebDriver driver, By locator) {
        logger.debug("Counts number of {} elements", locator);
        return findElements(driver, locator).size();
    }
    // @formatter:on

    // @formatter:off
    public static boolean isOptionPresentInSelectBox(WebDriver driver, By locator, String option) {
        logger.debug("Cheks if {} is present in {} selectbox", option, locator);
        return new Select(findElement(driver, locator)).getOptions().stream().map(WebElement::getText)
                .anyMatch(optionText -> optionText.equals(option));
    }
    // @formatter:on

    public static String getElementText(WebDriver driver, By locator) {
        logger.debug("Retrieves {} element text", locator);
        waitUntil(driver, WAIT_100_SECONDS, ExpectedConditions.visibilityOfElementLocated(locator));
        return findElement(driver, locator).getText();
    }

    public static void moveToElement(WebDriver driver, By locator) {
        logger.debug("Moves to element {}", locator);
        new Actions(driver).moveToElement(findElement(driver, locator)).build().perform();
    }

    public static void switchToDefaultContent(WebDriver driver) {
        logger.debug("Switches to default content");
        driver.switchTo().defaultContent();
    }

    public static void load(WebDriver driver, String url) {
        logger.debug("Loads url {}", url);
        driver.get(url);
    }

    public static void maximizeWindow(WebDriver driver) {

        logger.debug("Maximizes window");
        driver.manage().window().maximize();
        logger.debug("Window resolution: {}", driver.manage().window().getSize().toString());
    }

    public static void quit(WebDriver driver) {
        logger.debug("Quits driver");
        driver.quit();
    }

    public static void checkCheckbox(WebDriver driver, By locator) {
        if (WebDriverUtils.getElementAttributeValue(driver, locator, CHECKED_ATTRIBUTE) == null) {
            logger.debug("Checkbox located by {} is not checked, clicking to check.", locator);
            WebDriverUtils.clickOnElementWithWait(driver, locator);
        } else {
            logger.debug("Checkbox located by {} already checked, nothing to do.", locator);
        }
    }

    public static String getElementAttributeValue(WebDriver driver, By locator, String attributeName) {
        logger.debug("Retrieves attribute value {} from element {}", attributeName, locator);
        waitUntil(driver, WAIT_100_SECONDS, ExpectedConditions.presenceOfElementLocated(locator));
        return findElement(driver, locator).getAttribute(attributeName);
    }

    public static void uncheckCheckbox(WebDriver driver, By locator) {
        if (WebDriverUtils.getElementAttributeValue(driver, locator, CHECKED_ATTRIBUTE) != null) {
            logger.debug("Checkbox located by {} is checked, clicking to uncheck.", locator);
            WebDriverUtils.clickOnElementWithWait(driver, locator);
        } else {
            logger.debug("Checkbox located by {} already unchecked, nothing to do.", locator);
        }
    }

    public static void scrolltoElement(WebDriver driver, By locator) {
        logger.debug("Scrolling to element {}", locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findElement(driver, locator));
    }

    public static void waitTitleChange(WebDriver driver, int timeout) {

        String initialTitle = driver.getTitle().trim().toUpperCase();
        logger.debug("Initial Title: {}", initialTitle);
        String currentTitle = null;
        int counter = timeout;

        do {
            currentTitle = driver.getTitle().trim().toUpperCase();
            logger.info("Current Title: {}", currentTitle);
            explicitWait(driver, 1000);
            counter--;
            logger.info("Current counter: {}", counter);

            if (counter < 0) {
                logger.info("The timeout was reached and the title did not change....'{}'", initialTitle);
                break;
            }

            logger.info("Current = initial?: {}", currentTitle.equals(initialTitle));

        } while (currentTitle.equals(initialTitle));

        logger.debug("Initial title: {}", initialTitle);
        logger.debug("Last title checked was: {}" + currentTitle);
    }

    public static String getPageTitle(WebDriver driver) {
        logger.debug("Page title is: {}", driver.getTitle());
        return driver.getTitle();
    }

    public static String getCurrentURL(WebDriver driver) {
        logger.debug("Page URL is: {}", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public static void switchToParentFrame(WebDriver driver) {
        logger.debug("Switching to parent frame...");
        driver.switchTo().parentFrame();
    }

    public static void switchAlert(WebDriver driver) {
        logger.debug("Switching alert popup..");
        driver.switchTo().alert().accept();
    }

    public static void clearElement(WebDriver driver, By locator) {
        logger.debug("Clear the text from this text area:");
        WebElement element = findElement(driver, locator);
        element.clear();
//        ((JavascriptExecutor) driver).executeScript("document.querySelector('input[name=password]').dispatchEvent(new Event('input'))");
    }

    // Function 'checkIfElementExists' with time out...
    public static boolean checkIfElementExists(WebDriver driver, By locator, int timeout) {

        int counter = timeout;
        boolean found = false;

        while (counter > 0) {
            if (driver.findElements(locator).size() != 0) {
                logger.debug("Found element: {}", locator);
                logger.debug("Number of elements: {}", driver.findElements(locator).size());
                found = true;
                break;
            }
            logger.debug("Element {} still not found so waiting 1 sec then looping...", locator);
            WebDriverUtils.explicitWait(driver, 1000);
            counter--;
        }
        return found;
    }

    public static void uploadFile(WebDriver driver, By locator, String filePath) {

        String appimage = new String(new File(filePath).getAbsolutePath());
        WebElement element = findElement(driver, locator);
        element.sendKeys(appimage);
        //driver.findElement(By.id("urid")).sendKeys(filePath);

    }

    public static void clearCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public static boolean table(WebDriver driver, String searchableValue, By table) {
        boolean found = false;
        ArrayList<WebElement> rows = (ArrayList<WebElement>) findElement(driver, table).findElements(By.tagName("tr"));
        for (int i = 0, n = rows.size(); i < n && !found; i++) {
            for (WebElement cell : rows.get(i).findElements(By.tagName("span"))) {
                if (cell.getText().equalsIgnoreCase(searchableValue)) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            logger.info("Value {" + searchableValue + "} was found with success");
        } else {

            Assert.assertEquals(found=false, found=true, "Value {" + searchableValue + "} was not found");
        }
        return found;
    }
}
