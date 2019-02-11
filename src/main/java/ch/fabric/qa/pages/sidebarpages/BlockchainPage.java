package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class that implements locators methods and returns for Blockchain page
 *
 * @author aila.bogasieru@agys.ch
 */

public class BlockchainPage extends BasePage {

    private static By arrowAddFunction = By.xpath("//i[text()='arrow_right']");
    private static By detailsTab = By.xpath("//div//div[text()='Details']");
    private static By parametersTab = By.xpath("//div//div[text()='Parameters']");
    private static By returnVariablesTab = By.xpath("//div//div[text()='Return Variables']");
    private static By functionNameTxtBox = By.xpath("//input//div[text()='Function Name']");
    private static By functionDescriptionTxtBox = By.xpath("//input//div[text()='Description']");
    private static By checkBoxFunction = By.xpath("//i[text()='check_box_outline_blank']");
    private static By moreActionFunction = By.xpath("//button//i[text()='more_horiz']");
    private static By deleteActionFunction = By.xpath("//div[text()='Delete Function']");
    private static By editActionFunction = By.xpath("//div//i[text()='create']");
    private static By previewActionFunction = By.xpath("//div[text()='Preview Function Code']");
    private static By cancelActionFunction = By.xpath("//i[text()='cancel'");
    private static By removeNoAction = By.xpath("//button//div[text()='No']");
    private static By removeYesAction = By.xpath("//button//div[text()='Yes']");
    private static By addAssignment = By.xpath("//button//div[text()='Add Assignment']");
    private static By descriptionAssign = By.xpath("//textarea//div[text()='Description']");
    private static By expressionTxtBox = By.xpath("//div//div[text()='Expression']");
    private static By noVarAvailable = By.xpath("//div/div[text()='No Variables Available']");
    private static By addDeclarationBtmn = By.xpath("//button//div[text()='Add Declaration']");
    private static By arrowDeclaration = By.xpath("//i[text()='arrow_drop_down']");
    private static By deleteDeclaration = By.xpath("//i[text()='delete']");
    private static By variableName = By.xpath("//input//div[text()='Variable Name']");
    private static By variableType = By.xpath("//div//div[text()='Variable Type']");
    private static By variableInteger = By.xpath("//div//div[text()='Integer']");
    private static By variableFloat = By.xpath("//div//div[text()='Float']");
    private static By variableBoolean = By.xpath("//div//div[text()='Boolean']");
    private static By variableString = By.xpath("//div//div[text()='String']");
    private static By variableByte = By.xpath("//div//div[text()='Byte']");
    private static By editAssign = By.xpath("//i[text()='create']");
    private static By deleteAssign = By.xpath("//i[text()='delete']");
    private static By startValueFor = By.xpath("//input//div[text()='Start Value']");
    private static By endValueFor = By.xpath("//input//div[text()='End Value']");
    private static By increasingDirectionFor = By.xpath("//div//div[text()='Increasing']");
    private static By decreasingDirectionFor = By.xpath("//div//div[text()='Decreasing']");
    private static By stepByFor = By.xpath("//input//div[text()='Step By']");

    public BlockchainPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){
        return super.driver;
    }

    public static Logger logger = LoggerFactory.getLogger(BlockchainPage.class);

    public void clickAddFunctionArrow() {
        logger.info("Go to Add function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowAddFunction);
    }

    public void goToDetailstab() {
        logger.info("Go to Detail Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, detailsTab);
    }

    public void goToParametersTab() {
        logger.info("Go to Detail Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, parametersTab);
    }

    public void goToReturnVariablesTab() {
        logger.info("Go to Detail Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, returnVariablesTab);
    }

    public void enterFunctionName(String functionNameValue) {
        logger.info("Entering function name..");
        WebDriverUtils.enterTextBox(super.driver, functionNameTxtBox, functionNameValue);
    }

    public void enterFunctionDescription(String functionDescriptionValue) {
        logger.info("Entering function description..");
        WebDriverUtils.enterTextBox(super.driver, functionDescriptionTxtBox, functionDescriptionValue);
    }

    public void checkCheckbox() {
        WebDriverUtils.clickOnElementWithWait(super.driver, checkBoxFunction);
    }

    public void removeFunction() {
        logger.info("Removing my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, cancelActionFunction);
    }

    public void removeNoFunction() {
        logger.info("Not removing my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, removeNoAction);
    }

    public void removeYesFunction() {
        logger.info("Actual removing my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, removeYesAction);
    }

    public void moreActions() {
        WebDriverUtils.clickOnElementWithWait(super.driver, moreActionFunction);
    }

    public void deleteFunction() {
        logger.info("Deleting my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, deleteActionFunction);
    }

    public void editFunction() {
        logger.info("Editing my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, editActionFunction);
    }

    public void previewFunction() {
        logger.info("Previewing my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, previewActionFunction);
    }

    public void selectVar() {
        logger.info("Previewing my function..");
        WebDriverUtils.clickOnElementWithWait(super.driver, noVarAvailable);
    }

    public void editAssignment() {
        logger.info("Adding new declaration..");
        WebDriverUtils.clickOnElementWithWait(super.driver, editAssign);
    }

    public void deleteAssignment() {
        logger.info("Adding new declaration..");
        WebDriverUtils.clickOnElementWithWait(super.driver, deleteAssign);
    }

    public void clickAddAssignment() {
        logger.info("Adding an assignment..");
        WebDriverUtils.clickOnElementWithWait(super.driver, addAssignment);
    }

    public void enterDescription(String descriptionAssignValue) {
        logger.info("Entering description for my assignment..");
        WebDriverUtils.enterTextBox(super.driver, descriptionAssign, descriptionAssignValue);
    }

    public void enterExpession(String expressionAssignValue) {
        logger.info("Entering description for my assignment..");
        WebDriverUtils.enterTextBox(super.driver, expressionTxtBox, expressionAssignValue);
    }

    public void clickAddDeclaration() {
        logger.info("Adding new declaration..");
        WebDriverUtils.clickOnElementWithWait(super.driver, addDeclarationBtmn);
    }

    public void expandDeclaration() {
        logger.info("Expanding declaration..");
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowDeclaration);
    }

    public void removeDeclaration() {
        logger.info("Removing the declaration created..");
        WebDriverUtils.clickOnElementWithWait(super.driver, deleteDeclaration);
    }

    public void selectVariable() {
        WebDriverUtils.clickOnElementWithWait(super.driver, variableType);
    }

    public void enterVariableName(String variableNameValue) {
        logger.info("Entering variable name..");
        WebDriverUtils.enterTextBox(super.driver, variableName, variableNameValue);
    }

    public void selectInteger() {
        WebDriverUtils.clickOnElementWithWait(super.driver, variableInteger);
    }

    public void selectFloat() {
        WebDriverUtils.clickOnElementWithWait(super.driver, variableFloat);
    }

    public void selectBoolean() {
        WebDriverUtils.clickOnElementWithWait(super.driver, variableBoolean);
    }

    public void selectString() {
        WebDriverUtils.clickOnElementWithWait(super.driver, variableString);
    }

    public void selectByte() {
        WebDriverUtils.clickOnElementWithWait(super.driver, variableByte);
    }

    public void enterStartValueFor(String startValue) {
        logger.info("Entering start value..");
        WebDriverUtils.enterTextBox(super.driver, startValueFor, startValue);
    }

    public void enterEndtValueFor(String endValue) {
        logger.info("Entering end value..");
        WebDriverUtils.enterTextBox(super.driver, endValueFor, endValue);
    }

    public void selectDirectionIncreasing() {
        WebDriverUtils.clickOnElementWithWait(super.driver, increasingDirectionFor);
    }

    public void selectDirectionDecreasing() {
        WebDriverUtils.clickOnElementWithWait(super.driver, decreasingDirectionFor);
    }

    public void enterStepBy(String StepByValue) {
        WebDriverUtils.enterTextBox(super.driver, stepByFor, StepByValue);
    }
}
