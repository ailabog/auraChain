package ch.fabric.qa.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.fabric.qa.pages.sidebarpages.InterfaceBuilderPage;
import ch.fabric.qa.pages.sidebarpages.ApisPage;
import ch.fabric.qa.pages.sidebarpages.DataModelAndCatalogPage;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import ch.fabric.qa.pages.sidebarpages.GenerateDocumentsPage;
import ch.fabric.qa.pages.sidebarpages.ReportsPage;
import ch.fabric.qa.pages.sidebarpages.BlockchainPage;
import ch.fabric.qa.utils.WebDriverUtils;

/**
 * Contains helper for Sidebar functionality
 *
 * @author aila.bogasieru@agys.ch
 */


@Slf4j
public class Sidebar {


    private static By diagram = By.xpath("//a//i[@class='q-icon mdi mdi-drawing']");
    private static By interfaceBuilder = By.xpath("//a//i[@class='q-icon mdi mdi-group']");
    private static By generateDocuments = By.xpath("/html/body/div[1]/div[1]/aside/div/div[1]/div[4]/a");
    private static By apis = By.xpath("//a//i[@class='q-icon mdi mdi-shuffle-variant']");
    private static By dataModelAndCatalogs = By.xpath("//a//i[@class='q-icon mdi mdi-graphql']");
    private static By reports = By.xpath("//a//i[@class='q-icon mdi mdi-signal-cellular-3']");
    private static By blockchain = By.xpath("//a//i[@class='q-icon mdi mdi-bitcoin']");
    private static By task = By.xpath("//div//div[text()='Task']");
    private static By documentBuilderText = By.xpath("//span[text()='Document Builder']");
    private static By apiText = By.xpath("//span[text()='APIs']");
    private static By dataModelText = By.xpath("//span[text()='dataModelText']");
    private static By finishedProcessesTab = By.xpath("//div//div[text()='Finished processes']");
    private static By activeProcessesTab = By.xpath("//div//div[text()='Active processes']");
    private static By eventsText = By.xpath("//span[text()='Events']");
    private static By loopingText = By.xpath("//span[text()='Looping']");
    private static By variablesText = By.xpath("//span[text()='Variables']");
    private static By controlText = By.xpath("//span[text()='Control']");

    private static WebDriver driver;
    /*
     By diagram = By.xpath("//a[@href='#/diagrams']");
    By interfaceBuilder = By.xpath("//a[@href='#/userInterfaces']");
    By generateDocuments = By.xpath("//a[@href='#/documents']");
    By apis = By.xpath("//a[@href='#/api']");
    By dataModelAndCatalogs = By.xpath("//a[@href='#/dataModel']");
    By reports = By.xpath("//a[@href='#/reports']");

     */
    
    public static void setDriver(WebDriver driver){
        Sidebar.driver = driver;
    }
    
    public static void ckeckSidebarElements() {
        if (WebDriverUtils.findElement(driver, diagram) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, diagram);
            log.info("Diagram element was found {}" + diagram);
        } else {
            log.info("Diagram element is not displayed"  + diagram);
        }
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        if (WebDriverUtils.findElement(driver, interfaceBuilder) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, interfaceBuilder);
            log.info("InterfaceBuilder element can be accessed" + interfaceBuilder);
        } else {
            log.info("InterfaceBuilder element is not displayed" + interfaceBuilder);
        }
        if (WebDriverUtils.findElement(driver, apis) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, apis);
            log.info("Api element can be accessed" +  apis);
        } else {
            log.info("Apis element is not displayed" +  apis);
        }
        if (WebDriverUtils.findElement(driver, dataModelAndCatalogs) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, dataModelAndCatalogs);
            log.info("Data Model And Catalogs element can be accessed" + dataModelAndCatalogs);
        } else {
            log.info("Data Model And Catalog element is not displayed"+ dataModelAndCatalogs);
        }
        if (WebDriverUtils.findElement(driver, reports) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, reports);
            log.info("Reports element can be accessed" + reports);
        } else {
            log.info("Reports element cant be accessed" + reports);
        }

        if (WebDriverUtils.findElement(driver, blockchain) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, blockchain);
            log.info("Blockchain element can be accessed" + blockchain);
        } else {
            log.info("Blockchain element cant be accessed" + blockchain);
        }
    }

    public static void clickDiagram() {
        if (WebDriverUtils.findElement(driver, diagram) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, diagram);
        }
    }

    public static void clickInterfaceBuilder() {
        if (WebDriverUtils.findElement(driver, interfaceBuilder) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, interfaceBuilder);
        }
    }

    public static void clickGenerateDocuments() {
        if (WebDriverUtils.findElement(driver, generateDocuments) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, generateDocuments);
        }
    }

    public static void clickApis() {
        if (WebDriverUtils.findElement(driver, apis) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, apis);
        }
    }

    public static void clickDataModelAndCatalog() {
        if (WebDriverUtils.findElement(driver, dataModelAndCatalogs) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, dataModelAndCatalogs);
        }
    }

    public static void clickReports() {
        if (WebDriverUtils.findElement(driver, reports) != null) {
            WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
            WebDriverUtils.clickOnElementWithWait(driver, reports);
        }
    }

    public static void clickSmartContrcatDesigner() {
        if (WebDriverUtils.findElement(driver, blockchain) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, blockchain);
        }
    }

    public static DiagramsPage returnDiagramsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, diagram);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(task));
        return new DiagramsPage(driver);
    }

    public static DiagramsPage returnDiagramsPage2() {
        WebDriverUtils.clickOnElementWithWait(driver, diagram);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        return new DiagramsPage(driver);
    }

    public static InterfaceBuilderPage returnInterfaceBuilderPage() {
        WebDriverUtils.clickOnElementWithWait(driver, interfaceBuilder);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(task));
        return new InterfaceBuilderPage(driver);
    }

    public static GenerateDocumentsPage returnGenerateDocumentsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, generateDocuments);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(documentBuilderText));
        return new GenerateDocumentsPage(driver);
    }

    public static ReportsPage returnReportsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, reports);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.visibilityOfElementLocated(reports));
        return new ReportsPage(driver);
    }

    public static ApisPage returnApis() {
        WebDriverUtils.clickOnElementWithWait(driver, apis);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(apiText));
        return new ApisPage(driver);
    }

    public static DataModelAndCatalogPage returnApisPage() {
        WebDriverUtils.clickOnElementWithWait(driver, dataModelAndCatalogs);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(dataModelText));
        return new DataModelAndCatalogPage(driver);
    }

    public static BlockchainPage returnBlockchainPage() {
        WebDriverUtils.clickOnElementWithWait(driver, blockchain);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(eventsText));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(variablesText));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(controlText));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(loopingText));
        return new BlockchainPage(driver);
    }
}