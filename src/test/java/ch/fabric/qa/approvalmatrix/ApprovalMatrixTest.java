package ch.fabric.qa.approvalmatrix;

/**
 * Tests Approval Matrix full flow
 *
 * @author lucian.puscasu@agys.ch
 */


import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import ch.fabric.qa.BaseTest;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ApprovalMatrixTest extends BaseTest {

    private LoginPage loginPage;
    private Environments environment;
    private LandingPage landingPage;
    private AppsPage appsPage;
    private Sidebar sidebar;
    private DiagramsPage diagramsPage;

    @Parameters({"environment"})
    @BeforeTest
    public void setuUp(Environments environment) {
        ChromeDriverManager.getInstance().setup();
        this.environment = environment;
    }

    @Test
    public void ApprovalMatrixTest() throws FileNotFoundException {
        loginPage = new LoginPage(new ChromeDriver());
        loginPage.load(CredentialsUtils.getProperty("url"));
        loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
        loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
        landingPage = loginPage.returnLandingPage();
        landingPage.clickMenus();
        appsPage = landingPage.returnAppsPage();
        appsPage.clickOneApp();
        sidebar.clickDiagram();
        diagramsPage = sidebar.returnDiagramsPage2();
        diagramsPage.clickApprovalMatrixDropDown();
        diagramsPage.ApprovalMatrixLabelEdit();
        diagramsPage.ApprovalMatrixCodeEdit();
        diagramsPage.ApprovalMatrixDescriptionEdit();
        diagramsPage.clickTargetsTab();
        diagramsPage.clickNewTargets();
        diagramsPage.clickTargetElementDropDown();
        diagramsPage.clickParallelGatewayOption();
        diagramsPage.clickApprovalMatrixDecisionDropDown();
        diagramsPage.clickApprovalMatrixDecisionsApprove();
        diagramsPage.clickApprovalMatrixTargetLabel();
        diagramsPage.clickConnectorPropertiesDescription();
        diagramsPage.clickConnectorPropertiesStatusName();
        diagramsPage.clickConnectorPropertiesStatusCode();
        diagramsPage.clickConnectorPropertiesAddNotifications();
        diagramsPage.clickNotificationName();
        diagramsPage.clickNotificationAddRecipients();
        diagramsPage.clickTextTab();
        diagramsPage.clickEmailField();
        diagramsPage.clickOnAddButtonPlus();
        diagramsPage.clickSubjectTextField();
        diagramsPage.clickEmailBodyField();
        diagramsPage.clickSaveNotifications();
        diagramsPage.clickSaveNewTarget();
        diagramsPage.clickLevelsTab();
        diagramsPage.clickAddLevelButton();
        diagramsPage.clickLevelApprovalTime();
        diagramsPage.clickHoursDropDown();
        diagramsPage.clickHoursOptionInDropDown();
        diagramsPage.clickIfExpiresDropDown();
        diagramsPage.clickPropagatePreviousDecisionOption();
        diagramsPage.clickContinueIfRejected();
        diagramsPage.clickAssignRuleMenu();
        diagramsPage.clickRuleEditorName();
        diagramsPage.clickRuleEditorDescription();
        diagramsPage.clickAddANewCondition();
        diagramsPage.clickInsertSpecialIdentificatorFieldLeft();
        diagramsPage.clickVariablesTab();
        diagramsPage.clickProcessInstanceDdl();
        diagramsPage.clickProcessInstanceGenderValue();
        diagramsPage.clickEquationDropDown();
        diagramsPage.clickSelectEqualsFromDropDown();
        diagramsPage.clickInsertSpecialIdentificatorFieldRight();
        diagramsPage.clickVariablesTab();
        diagramsPage.clickProcessInstanceDdl();
        diagramsPage.clickProcessInstanceGenderValue();
        diagramsPage.clickNewUserGroup();
        diagramsPage.clickRightDropDown();
        diagramsPage.clickEvaluateDropDownOption();
        diagramsPage.clickProlonger();
        diagramsPage.clickNotificationsTab();
        diagramsPage.clickConnectorPropertiesAddNotifications();
        diagramsPage.clickNotificationName();
        diagramsPage.clickNotificationAddRecipients();
        diagramsPage.clickTextTab();
        diagramsPage.clickEmailField();
        diagramsPage.clickSubjectTextField();
        diagramsPage.clickEmailBodyField();
        diagramsPage.clickSaveButtonNotification2();
        diagramsPage.clickTaskDetailsTab();
        diagramsPage.clickNewValuesTaskSubject();
        diagramsPage.clickNewCustomTaskSubject();
        diagramsPage.clickSaveButtonNotification2();
        diagramsPage.clickPriorityLevelDropDown();
        diagramsPage.clickDeadlineField();
        diagramsPage.clickContinueIfRejected2();
        diagramsPage.clickSaveButtonRuleEditor();
        diagramsPage.clickSaveLevelEditor();


    }

    @AfterTest
    public void tearDown() {
        loginPage.quit();
        landingPage.quit();
        appsPage.quit();
        diagramsPage.quit();
    }
}