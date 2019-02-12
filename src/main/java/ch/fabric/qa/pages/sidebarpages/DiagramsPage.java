package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.fabric.qa.utils.WebDriverUtils.WAIT_1000_MILLISECONDS;
import static ch.fabric.qa.utils.WebDriverUtils.WAIT_2000_MILLISECONDS;

/**
 * Class that implements locators methods and returns for Diagrams page
 *
 * @author aila.bogasieru@agys.ch
 */


public class DiagramsPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(DiagramsPage.class);

    private static By savedButton = By.xpath("//div[text()='Saved']");
    //private By task = By.xpath("//div[@id='pluginSidebarContainer']/div/div[2]/div/div/canvas");
    private static By task = By.xpath("//div//div[text()='Task']");
    //private By task = By.xpath ("//canvas");
    private By clickOnGeneralStart = By.xpath("//div[@class='q-item-label' and contains (text(), '1. General start')]");
    private By clickOnGeneralStartStsName = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-diagram-gstart-statusname q-if-has-label q-if-hide-underline q-if-standard text-primary']");
    private By nameForGeneralStart = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-diagram-gstart-statusname q-if-has-label q-if-hide-underline q-if-standard text-primary']//input");
    private By stsCodeForGeneralStart = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-diagram-gstart-statuscode q-if-has-label q-if-hide-underline q-if-standard text-primary']//input");
    private By clickOnTargetsTab = By.xpath("clickOnTargetsTab");
    private By clickOnNewTarget = By.xpath("//div[@class='q-item-label' and contains (text(), '2. Task')]");
    private By clickOnTaskName = By.xpath("//div[@class='q-if-label q-if-label-above'  and .//div[text()='Label']]");
    //private static By targetsTab = By.cssSelector(".q-tab:nth-child(2) .q-tab-label");
	private static By targetsTab = By.xpath("//div[text()='Targets']");
    private static By detailsTab = By.cssSelector("div.q-tab-label");

    //private By detailsTab = By.cssSelector(".q-tab:nth-child(1) .q-tab-label");
    //private By detailsTab = By.xpath("//div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div");
    private static By usersTab = By.cssSelector(".q-tab:nth-child(3) .q-tab-label");
    //private By usersTab = By.xpath("//div[2]/div/div/div[2]/div/div/div/div/div[3]/div/div");
    private static By rulesTab = By.cssSelector(".q-tab:nth-child(4) .q-tab-label");
    //private By rulesTab = By.xpath("//div[2]/div/div/div/div/div[4]/div/div");
    private static By labelTxtBox = By.xpath("//input[@type='text']");
    //private By labelTxtBox = By.xpath("//div[2]/div/div/div/div/div/div[2]/div/input");
    private static By codeTxtBox = By.xpath("//div[@class='q-if row no-wrap relative-position q-input shadow-1 q-px-md c-border-radius at-diagram-task-code q-if-has-label q-if-hide-underline q-if-standard text-primary']//input ");
    //private By codeTxtBox = By.xpath("//div[2]/div/div/div/div[2]/div/input");
    private static By taskSubject = By.xpath("(//button[@type='button'])[11]");
    //private By taskSubject = By.xpath("//div[2]/div/div/div[2]/div/div[3]/div/button");
    //private By taskSubject = By.cssSelector(".row:nth-child(3) > .col-12 > .q-btn");
    private static By customSubjectTextArea = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-task-subject-textarea q-if-hide-underline q-if-standard text-primary']//textarea[@class='col q-input-target q-input-area']");
    private static By customInstanceName = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-task-instance-textarea q-if-hide-underline q-if-standard text-primary']//textarea[@class='col q-input-target q-input-area']");
    private static By varLabel = By.xpath("//button//div[text()='VAR']");
    private static By tableVariables = By.xpath("//div[@class='q-if row no-wrap relative-position q-input q-search at-task-subject-datamodel-search q-if-hide-underline q-if-standard q-if-has-content text-primary']//input");
    private static By backArrow = By.xpath("//button//i[text()='keyboard_arrow_left']");
    private static By variablesTab = By.xpath("//div[@data-tab-name and @data-tab-name='variables']");
    private static By dataModelsTab = By.xpath("//div//div[text()='Data model']");
    private static By descriptionTaskTxt = By.xpath("//textarea[@rows='3' and @class='col q-input-target q-input-area']");
    private static By deadlineTask = By.xpath("//div[@class='q-if row no-wrap relative-position q-input q-pl-md q-if-has-label q-if-hide-underline q-if-standard text-primary']//input");
    private static By hoursTask = By.xpath("//div[@class='q-item-label' and contains (text(),'Hours')]");
    private static By expirationBehaviour = By.xpath("//i[@class='q-icon arrow-button q-pa-xs col-1  material-icons']");
    private static By timeFrameTask = By.xpath("//div[@class='q-if-label' and .//div[text()='Timeframe']]/following-sibling::input");
    private static By descriptionTask = By.xpath("//div[@data-v-1bc98f28 and @class='q-field row no-wrap items-start q-field-responsive q-field-floating q-field-no-label']");
    //private By timeFrameOptions = By.cssSelector(".q-select-highlight .q-item-label");
    private static By timeFrameOptions = By.xpath("//div[@class='q-if row no-wrap relative-position q-select q-pl-md q-if-focusable q-if-hide-underline q-if-standard text-primary']");
    public static By publishButton = By.xpath("//div[text()='Publish']/ancestor::button");
    private static By timeFrameUnit = By.xpath("//div[@class='q-item-label' and contains (text(),'Hours')]");
    //private By processBehaviour = By.cssSelector(".q-if-focused > .q-icon");
    private static By processBehaviourddl = By.xpath("//div[@class='q-if row no-wrap relative-position q-select q-pl-md col-11 q-if-has-label q-if-focusable q-if-hide-underline q-if-standard text-primary']");

    private static By processBehaviourTarget = By.xpath("//i[@class='q-icon material-icons q-item-icon text-plugin-paralel-gateway']");
    private static By savebuttonExpiration = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable q-btn-rectangle q-focusable q-hoverable bg-primary text-white']//div[text()='Save']");
    private static By priorityArrow = By.xpath("//div[@class='q-if-label q-if-label-above'  and .//div[text()='Priority level']]");
    private static By priorityLevel = By.xpath("//div[@class='q-if row no-wrap relative-position q-select q-if-has-label q-if-focusable q-if-hide-underline q-if-standard q-if-has-content text-primary']");
    private static By priorityLevels = By.xpath("//div[@class='q-item-label' and contains (text(),'Highest')]");
    private static By cancelBtn = By.xpath("(//div//div[text()='Cancel']");
    //private By cancelBtn = By.xpath("//div[4]/div[2]/div/div[3]/div/button");

    private static By assignInterface = By.xpath("//span[text()='Assign interface']");
    //private By assignInterface  = By.xpath("(//button[@type='button'])[20]");
    //private By assignInterface = By.xpath("//div[9]/div/button");
    private static By createNewInterface = By.cssSelector(".row:nth-child(2) > .bg-grey-11");
    private static By pagesBtn = By.xpath("//button//div[text()='Pages']");
    private static By layoutBtn = By.xpath("//button//div[text()='Layout']");
    //private By createNewInterface = By.xpath("(//button[@type='button'])[27]");
    private static By setEscalation = By.xpath("//span[@class='col-11 row justify-start' and contains (text(),'Set Escalation')]");
    //private By setEscalation = By.cssSelector(".row:nth-child(10) > .col-12 > .q-btn");
    private static By escalationRadio = By.xpath("//i[@class='q-icon q-checkbox-icon cursor-pointer material-icons' and contains (text(),'check_box_outline_blank')]");
    private static By clickOnEscalateUIFragmentddl = By.xpath("//div[@data-v-18aba99c]//div[@class='q-if-label']");
    private static By clickOnEscalationTaskName = By.xpath("//div[@class='q-if row no-wrap relative-position q-input q-if-hide-underline q-if-standard q-if-has-content text-primary']//textarea[@class='col q-input-target q-input-area']");
    private static By enterEscalationTaskName = By.xpath("//div[@class='q-if row no-wrap relative-position q-input q-if-hide-underline q-if-standard q-if-has-content text-primary']//textarea[@class='col q-input-target q-input-area']");
    private static By createNewInterfaceFromEscalation = By.xpath("//button//div[text()='Create new Interface']");
    private static By newTarget = By.xpath("//button//i[text()='arrow_forward_ios']");
    By assignUser = By.cssSelector(".bg-grey-11");
    By assignRule = By.xpath("//div[2]/div/div/div/div/button");
    //private By approvalMatrix = By.cssSelector(".collapse-container:nth-child(1) .plugin-container:nth-child(2) canvas");
    private static By approvalMatrix = By.xpath("//div[@id='pluginSidebarContainer']/div/div[2]/div[2]/div/canvas");
    //private By approvalMatrix = By.xpath("//div[2]/div/canvas");
    private static By approvalMatrixLabel = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Label']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    By approvalmatrixLabel = By.xpath("//div[2]/div/div/div/div/div/div[2]/div/input");
    private static By approvalMatrixCode = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Code']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By canvas = By.id("canvas-52ed6414-ac24-2c3a-86cd-3bc2c739e1cc");
    //private By approvalMatrixCode = By.xpath("//div[2]/div/div/div/div[2]/div/input");
    By approvalMatrixDescription = By.xpath("//textarea[2]");
    private static By approvalMatrixLevelsTab = By.cssSelector(".q-tab:nth-child(5) .q-tab-label");
    //private By approvalMatrixLevelsTab = By.xpath("//div[2]/div/div/div/div/div[5]/div/div");
    By approvalMatrixAddUser = By.xpath("//div[3]/div/div/div/button");
    private static By approvalMatrixContinueCheck = By.xpath("//div[3]/div[3]/div/div/div/div/div/i");
    private static By approvalMatrixAddRule = By.xpath("//div[3]/div/div/div/button");
    private static By approvalMatrixNameRule = By.xpath("//div[5]/div[2]/div/div[2]/div/div/div[3]/div/div/div/div/div/div[2]/div/input");
    private static By approvalMatrixDescriptionRule = By.cssSelector("q-input-area");

    private static By statement = By.xpath("//div//i[@class='q-icon bg-white q-mr-xs material-icons text-faded']");
    private static By arrowExpression = By.xpath("//div[2]/div/div[2]/button");
    private static By valueMod1 = By.xpath("//body/div[6]/div/div");
    private static By valueVar1 = By.xpath("//body/div[6]/div/div[2]/div/div");
    private static By valueLoc1 = By.xpath("//div[6]/div/div[3]/div/div");
    private static By valueTXT1 = By.xpath("//div[6]/div/div[5]/div/div");
    private static By valueVar2 = By.xpath("//body/div[6]/div/div[2]/div/div");
    private static By valueMod2 = By.xpath("//body/div[6]/div/div/div/div");
    private static By valueLoc2 = By.xpath("//div[6]/div/div[3]/div/div");
    private static By valueLog2 = By.xpath("//div[6]/div/div[4]/div/div");
    private static By valueTXT2 = By.xpath("//div[6]/div/div[5]/div/div");
    private static By arrowExpression1 = By.xpath("(//button[@type='button'])[18]");
    private static By externalTask = By.xpath("//div//div[text()='External task']");
    private static By generateDocuments = By.xpath("//div//div[text()='Generate Document']");
    private static By api = By.xpath("//div//div[text()='API']");
    private static By generalStart = By.xpath("//div//div[text()='General start']");
    private static By startFromExternalSource = By.xpath("//div//div[text()='Start from external source']");
    private static By generalEnd = By.xpath("//div//div[text()='General end']");

    private static By exclusiveGateway = By.xpath("//div//div[text()='Exclusive gateway']");
    private static By parallelGateway = By.xpath("Parallel gateway");
    private static By joinGateway = By.xpath("//div//div[text()='Join gateway']");
    private static By checkDynamicExternalTasks = By.xpath("//div//i[text()='check_box_outline_blank']");
    private static By arrowSmsSubject = By.xpath("//button//span[text()='Sms Subject']");
    private static By arrowTaskSubject = By.xpath("//button//span[text()='Email subject']");
    private static By arrowExpirationBehaviour = By.xpath("//button//span[text()='Expiration Behaviour']");
    private static By customSmSSubject = By.xpath("//div//textarea[@class='col q-input-target q-input-shadow absolute-top']");
    private static By SubjectTxtBox = By.xpath("//input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By attachmentsTxtBox = By.xpath("//input[@class='col q-input-target justify-start']");
    private static By bodyTxtBox = By.xpath("//div[@class='q-editor-content']");
    private static By addDocuments = By.xpath("//button//i[text()='add_ios']");
    private static By documentTemplateArrow = By.xpath("//div//i[@class='q-icon q-if-control material-icons']");
    private static By apiLabel = By.xpath("//div/input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By codeApi = By.xpath("//div//div[text()='Code']");
    private static By descriptionApi = By.xpath("//textarea//div[text()='Description']");
    private static By selectApi = By.cssSelector(".cursor-pointer .q-item-label");
    private static By arrowApiConfigureApi = By.cssSelector(".q-if-focused > .q-icon");
    //private By valueMod = By.xpath("//i//span[@class='q-ripple-container']");
    private static By equals = By.xpath("//div//div[@text()='Equals']");
    private static By removeStatement = By.xpath("//i[text()='delete']");
    private static By diagram = By.cssSelector(".mdi-drawing");

    private static By generalStartDropDown = By.xpath("//div[text()='1. General start']");

    private static By statusNameField = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Status name']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");

    private static By approvalMatrixDropDown = By.xpath("//div[text()='4. Approval Matrix']");
    private static By approvalMatrixDescriptionField = By.xpath("//textarea[@class='col q-input-target q-input-area']");
    private static By targetElement = By.xpath("//div[text()='Target element']");
    private static By targetElementDdl = By.xpath("//div[@class='q-if row no-wrap relative-position q-select q-if-focusable q-if-hide-underline q-if-standard q-if-has-content text-primary']");
    private static By targetElementValue = By.xpath("//div[@class='q-popover scroll column no-wrap animate-popup-down']//div[text()='HumanTask2']");
    private static By connectorLabelDdl = By.xpath("//div[@class='q-if row no-wrap relative-position q-input shadow-1 q-px-md border-r at-diagram-task-label q-if-has-label q-if-hide-underline q-if-standard q-if-has-content text-primary']");
    private static By connectorLabel = By.xpath("//div[@class='q-if row no-wrap relative-position q-input shadow-1 q-px-md c-border-radius at-diagram-task-label q-if-has-label q-if-hide-underline q-if-standard q-if-has-content text-primary']//input");
    private static By targetElementDropDown = By.xpath("//div[@class='col q-input-target ellipsis justify-start']");
    private static By connectorDescription = By.xpath("//div[@class='q-if row no-wrap relative-position q-input shadow-1 q-px-md q-my-sm c-border c-border-radius q-if-has-label q-if-hide-underline q-if-standard text-primary']//textarea[@class='col q-input-target q-input-area']");
    private static By parallelGatewayOption = By.xpath("//div//div[@class='q-item-label' and text()='Parallel gateway']");
    private static By approvalMatrixDecisionsDropDwon = By.xpath("//div[@class='q-if-label' and .//text()='Approval Matrix Decisions']");
    private static By approvalMatrixDecisionsApprove = By.xpath("//div[text()='Approve']");
    private static By connectorStatusName = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-diagram-gstart-statusname q-if-has-label q-if-hide-underline q-if-standard text-primary']//input");
    private static By connectorStatusCode = By.xpath("//div[@class='q-if row no-wrap relative-position q-input at-diagram-gstart-statuscode q-if-has-label q-if-hide-underline q-if-standard text-primary']//input");
    private static By addTargetNotifications = By.xpath("//div//span[@class='col-11 row justify-start' and contains (text(),'Add notifications')]");
    private static By connectorNotificationName = By.xpath("//div[@class='q-if row no-wrap relative-position q-input q-if-has-label q-if-hide-underline q-if-standard text-primary']//input");
    private static By connectorNotificationReceiptTO = By.xpath("//div[@class='q-list']//button[@class='q-btn inline relative-position q-btn-item non-selectable bg-usr col-2 q-btn-rectangle q-btn-flat q-focusable q-hoverable text-white']");
    private static By connectorNotificationReceiptCC = By.xpath("//div[@class='col' and contains (text(),'Add recipients (cc)')]");
    private static By dataModelAtributeEmail = By.xpath("//div[@class=\"q-item-label\" and contains (text(),'primaclass.email (String)')]");
    private static By dataModelCCclassName = By.xpath("//div[@class='q-item-label' and contains (text(),'adouaclas')]");
    private static By dataModelCCAtributeName = By.xpath("//div[@class='q-item-label' and contains (text(),'adouaclas.emailCC (String)')]");
    private By processBehaviour = By.cssSelector(".q-if-focused > .q-icon");

    private static By connectorPropertiesLabel = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Label']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By connectorPropertiesDescription = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Description']]//following-sibling::textarea[@class='col q-input-target q-input-area']");
    private static By connectorPropertiesStatusName = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Status name']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By connectorPropertiesStatusCode = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Status code']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By connectorPropertiesAddNotifications = By.xpath("//span[text()='Add notifications']");
    private static By notificationName = By.xpath("//div[@class='q-if-inner col column' and .//div[text()='Notification name']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By notificationAddRecipients = By.xpath("//div[@class='q-list']//button[@class='q-btn inline relative-position q-btn-item non-selectable bg-usr col-2 q-btn-rectangle q-btn-flat q-focusable q-hoverable text-white']");
    private static By textTab = By.xpath("//div[text()='Text']");
    private static By emailField = By.xpath("//input[@type='email']");
    private static By addPlusButton = By.xpath("//i[text()='add']");
    private static By subjectTextField = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Subject']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By emailBodyField = By.xpath("//div[@class='q-editor-content']");
    private static By saveButton = By.xpath("/html/body/div[5]/div[2]/div/div[1]/div/button[2]");
    private static By levelsTab = By.xpath("//div[text()='Levels']");
    private static By addLevelButton = By.xpath("//span[text()='Add level']");
    private static By levelApprovalTime = By.xpath("//input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By hoursDropDown = By.xpath("//div[@class='col q-input-target ellipsis justify-start' and text()='Hours']");
    private static By hoursOptionInDropDown = By.xpath("//div[@class='q-item-label' and text()='Hours']");
    private static By ifExpiresDropDwon = By.xpath("//div[@data-v-351ffa4b and @data-v-35ffc78b]");
    private static By propagatePreviousDecision = By.xpath("//div[@class='q-item-label' and text()='Propagate previous decision']");
    private static By continueIfRejected = By.xpath("//i[@class='q-icon q-checkbox-icon cursor-pointer material-icons']");
    private static By assignRuleMenu = By.xpath("//span[text()='Assign rule']");
    private static By ruleName = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[1]/div[3]/div[1]/div/div/div/div[1]/div[2]/div[1]/input");
    private static By ruleDescription = By.xpath("//textarea[@class='col q-input-target q-input-area']");
    private static By addANewCondition = By.xpath("//span[text()='Add a new condition']");
    private static By insertSpecialIdentificatorFieldLeft = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/span/div/div/div[2]/div/div[1]/div/div[2]/div/input");
    private static By insertSpecialIdentificatorFieldRight = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/span/div/div/div[4]/div/div[1]/div/div[2]/div/input");
    private static By specialIdentificatorVaraiblesTab = By.xpath("//div[text()='Variables']");
    private static By processInstanceList = By.xpath("//div[text()='ProcessInstance']");
    private static By processInstanceGender = By.xpath("//div[contains(text(), 'ProcessInstance.initiator.gender')]");
    private static By equationDropDown = By.xpath("//div[@class='col-2']//div[@class='col q-input-target ellipsis justify-start']");
    private static By selectEquals = By.xpath("//div[@class='q-item-label' and text()='Equals']");
    private static By saveButtonRuleEditor = By.xpath("/html/body/div[5]/div[2]/div/div[1]/div/button[2]");
    private static By newUserGroup = By.xpath("//span[text()='New user group']");
    private static By tasksDropDown = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div[3]/div/div/div[1]/div/div[2]/div[1]/div[2]");
    private static By tasksDropDownOneValue = By.xpath("///div[@class='q-item-label' and text()='1']");
    private static By saveButtonLevelEditor = By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/button[2]/div[2]/div");
    private static By saveButtonNotifications = By.xpath("/html/body/div[5]/div[2]/div/div[1]/div/button[2]/div[2]/div");
    private static By saveButtonNotifications2 = By.xpath("/html/body/div[6]/div[2]/div/div[1]/div/button[2]/div[2]/div");
    private static By saveButtonNewTarget = By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/button[2]/div[2]/div");
    private static By rightDropDown = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div[3]/div/div/div[3]/div/div[2]/div[1]/div[2]");
    private static By evaluateDropDownOption = By.xpath("//div[text()='Evaluate']");
    private static By prolongerCheck = By.xpath("//span[text()='Prolonger']");
    private static By notificationsTab = By.xpath("//div[text()='Notifications']");
    private static By taskDetailsTab = By.xpath("//div[text()='Task details']");
    private static By newValuesTaskSubject = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/button/div[2]/span");
    private static By newCustomTaskSubject = By.xpath("/html/body/div[6]/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[2]/div/div/textarea[2]");
    private static By newInstanceName = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[1]/button/div[2]/span");
    private static By newCustomInstanceName = By.xpath("/html/body/div[6]/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[2]/div/div/textarea[2]");
    private static By priorityLevelHigh = By.xpath("//div[@class='q-item-label' and text()='High']");
    private static By deadlineField = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div[4]/div/div[1]/div/div/div[1]/div[2]/div[1]/input");
    private static By continueIfRejected2 = By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div[6]/div/div/div/div/span");
    private static By varLabelTaskSubject = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable bg-orange at-task-subject-btn q-btn-rectangle q-btn-flat q-focusable q-hoverable text-white']");
    private static By DataModelVarTaskSubject = By.xpath("//div[@class='q-item-label' and contains (text(),'primaclas')]");
    private static By DataModelAttributeTskSubject = By.xpath("//div[contains(text(), 'primaclas.primuatribut (String)')]");
    private static By InstanceIDTaskSubjectVariable = By.xpath("//div[@class='q-item-label' and contains (text(),'ProcessInstance')]");
    private static By InstanceIDTaskSubjectVariable2 = By.xpath("//div[@class='q-item-label' and contains (text(),'ProcessInstance.id (String)')]");
    private static By TaskSubjectSaveButton = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable q-btn-rectangle q-focusable q-hoverable bg-primary text-white']//div[text()='Save']");
    private static By instanceName = By.xpath("//span[@class='col-11 row justify-start' and contains (text(),'Instance name')]");
    private static By varLabelEscalationTaskName = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable bg-orange q-btn-rectangle q-btn-flat q-focusable q-hoverable text-white q-btn-no-uppercase']");
    private static By varLabelInstanceName = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable bg-orange at-task-instance-btn q-btn-rectangle q-btn-flat q-focusable q-hoverable text-white']");
    private static By deadlineTimeUnit = By.xpath("//div[@class='q-if row no-wrap relative-position q-select q-if-focusable q-if-hide-underline q-if-standard q-if-has-content text-primary']");
    private static By statusCode = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Status code']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private static By primaclasPrimuatributString = By.xpath("//div[contains(text(), 'primaclas.primuatribut (String)')]");

    public static final String STATUS_NAME_FIELD = "StatusNameField";


    public DiagramsPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){
        return super.driver;
    }

    public void clickContinueIfRejected2() {
        logger.info("Click continue if rejected...");
        WebDriverUtils.clickOnElementWithWait(super.driver, continueIfRejected2);
    }

    public void enterStatusCodeField() {
    logger.info("Enter a value in the status code field...");
    WebDriverUtils.enterTextBox(super.driver, statusCode, "StatusCode");
    }

    public void clickDeadlineField() {
        logger.info("Click on the deadline field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, deadlineField);
        WebDriverUtils.enterTextBox(super.driver, deadlineField, "10");
    }

    public void clickPriorityLevelDropDown(){
        logger.info("Click on the priority level drop down...");
        WebDriverUtils.explicitWait(super.driver, WAIT_2000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, priorityLevel);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, priorityLevelHigh);
    }

    public void clickNewCustomInstanceName() {
        logger.info("Click on the custom instance name field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, newCustomInstanceName);
        logger.info("Adding new custom instance name text...");
        WebDriverUtils.enterTextBox(super.driver, newCustomInstanceName, "NewCustomInstanceName");
    }


    public void savedMessageVisible(){
        logger.info("Saved message is searched...");
        if (WebDriverUtils.checkIfElementExists(driver, savedButton, 10)){
        logger.info(("Saved messagea appeared and the app was saved.."));
      } else{
        logger.info("Saved messagea appeared and the app was not saved..");
        }
    }
//    public void clickNewInstanceName() {
//        logger.info("Click on the instance name ");
//        WebDriverUtils.clickOnElementWithWait(super.driver, newInstanceName);
//    }

    public void clickNewCustomTaskSubject() {
        logger.info("Click on the custom task subject field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, newCustomTaskSubject);
        logger.info("Adding new custom task subject text...");
        WebDriverUtils.enterTextBox(super.driver, newCustomTaskSubject, "NewCustomTaskSubject");
    }

    public void clickNewValuesTaskSubject(){
        logger.info("Click on the task subject under new values tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, newValuesTaskSubject);
    }

    public void clickTaskDetailsTab(){
        logger.info("Click on the task details tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, taskDetailsTab);
    }

    public void clickSaveButtonNotification2() {
        logger.info("Click save on the rule editor - notifications tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, saveButtonNotifications2);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
    }

    public void clickNotificationsTab(){
        logger.info("Click the outcomes - notifications tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, notificationsTab);
    }

    public void clickProlonger() {
        logger.info("Click on the prolonger check...");
        WebDriverUtils.clickOnElementWithWait(super.driver, prolongerCheck);
    }

    public void clickEvaluateDropDownOption() {
        logger.info("Click on the Evaluate option from the drop down list...");
        WebDriverUtils.clickOnElementWithWait(super.driver, evaluateDropDownOption);
    }

    public void clickRightDropDown() {
        logger.info("Click on the Right drop down...");
        WebDriverUtils.clickOnElementWithWait(super.driver, rightDropDown);
    }

    public void clickSaveNewTarget() {
        logger.info("Click on save button - new target page...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, saveButtonNewTarget);
    }

    public void publish() {
        logger.info("Click on save button - new target page...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, publishButton);
    }

    public void clickSaveNotifications() {
        logger.info("Click on save button - notifications page...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, saveButtonNotifications);
    }

    public void clickTasksDropDownOneValue() {
        logger.info("Click on the tasks drop down and select value 1...");
        WebDriverUtils.clickOnElementWithWait(super.driver, tasksDropDownOneValue);
    }

    public void clickSaveLevelEditor() {
        logger.info("Click on save button - level editor page...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, saveButtonLevelEditor);
    }

    public void clickTasksDropDown() {
        logger.info("Click on the tasks drop down...");
        WebDriverUtils.clickOnElementWithWait(super.driver, tasksDropDown);
    }

    public void clickNewUserGroup() {
        logger.info("Click to add new user group...");
        WebDriverUtils.clickOnElementWithWait(super.driver, newUserGroup);
    }

    public void clickSaveButtonRuleEditor() {
        logger.info("Click to save the rule...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, saveButtonRuleEditor);
    }

    public void clickInsertSpecialIdentificatorFieldRight() {
        logger.info("Click on the special identificator field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, insertSpecialIdentificatorFieldRight);
    }

    public void clickSelectEqualsFromDropDown() {
        logger.info("Click on the Equals option...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, selectEquals);
    }

    public void clickEquationDropDown() {
        logger.info("Click on the equation drop down...");
        WebDriverUtils.clickOnElementWithWait(super.driver, equationDropDown);
    }

    public void clickProcessInstanceGenderValue() {
        logger.info("Click on the Process Name String option...");
        WebDriverUtils.clickOnElementWithWait(super.driver, processInstanceGender);
    }

    public void clickProcessInstanceDdl(){
        logger.info("Click on the process name option from the list...");
        WebDriverUtils.clickOnElementWithWait(super.driver, processInstanceList);
    }

    public void clickVariablesTab() {
        logger.info("Click on the variables tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, specialIdentificatorVaraiblesTab);
    }

    public void clickAddANewCondition() {
        logger.info("Click on the add a new condition - rule editor...");
        WebDriverUtils.clickOnElementWithWait(super.driver, addANewCondition);
    }

    public void clickInsertSpecialIdentificatorFieldLeft() {
        logger.info("Click on the left special identificator field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, insertSpecialIdentificatorFieldLeft);
    }

    public void clickRuleEditorDescription() {
        logger.info("Click on the rule description field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, ruleDescription);
        logger.info("Clear the rule description field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, ruleDescription);
        logger.info("Enter new rule description...");
        WebDriverUtils.enterTextBox(super.driver, ruleDescription, "RuleDescription");
    }

    public void clickRuleEditorName() {
        logger.info("Click on the rule editor name field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, ruleName);
        logger.info("Clear the rule editor name field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, ruleName);
        logger.info("Enter new rule name...");
        WebDriverUtils.enterTextBox(super.driver, ruleName, "RuleName");
    }

    public void clickAssignRuleMenu() {
        logger.info("Click on the assign rule drop down...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, assignRuleMenu);
    }


    public void clickPropagatePreviousDecisionOption() {
        logger.info("Click on the propagate previous decision drop down option...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, propagatePreviousDecision);
    }


    public void clickIfExpiresDropDown() {
        logger.info("Click on the expiration drop down...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, ifExpiresDropDwon);
    }

    public void clickContinueIfRejected() {
        logger.info ("Click to continue if rejected...");
        WebDriverUtils.clickOnElementWithWait(super.driver, continueIfRejected);
    }

    public void clickHoursOptionInDropDown() {
        logger.info("Select the Hours option from the Hours drop down...");
        WebDriverUtils.clickOnElementWithWait(super.driver, hoursOptionInDropDown);
    }

    public void clickHoursDropDown() {
        logger.info("Click on the hours drop down...");
        WebDriverUtils.clickOnElementWithWait(super.driver, hoursDropDown);
    }

    public void clickLevelApprovalTime() {
        logger.info("Click on the approval time field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, levelApprovalTime);
        logger.info("Clear the approval time field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, levelApprovalTime);
        logger.info("Enter new approval time...");
        WebDriverUtils.enterTextBox(super.driver, levelApprovalTime, "40");
    }

    public void clickAddLevelButton() {
        logger.info("Click to add a new approval matrix level...");
        WebDriverUtils.clickOnElementWithWait(super.driver, addLevelButton);
    }

    public void clickLevelsTab(){
        logger.info("Click on the levels tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, levelsTab);
    }

    public void clickSave(){
        logger.info("Click on the save button after entering the approval matrix email...");
        WebDriverUtils.clickOnElementWithWait(super.driver, saveButton);
    }

    public void clickOnAddButtonPlus(){
        logger.info("Click on the plus button to add the email...");
        WebDriverUtils.clickOnElementWithWait(super.driver, addPlusButton);
    }

    public void clickEmailBodyField() {
        logger.info("Click on the email body field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, emailBodyField);
        logger.info("Enter subject text...");
        WebDriverUtils.enterTextBox(super.driver, emailBodyField, "Hello World!");
    }

    public void clickSubjectTextField() {
        logger.info("Click on the subject field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, subjectTextField);
        logger.info("Clear the subject field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, subjectTextField);
        logger.info("Enter subject text...");
        WebDriverUtils.enterTextBox(super.driver, subjectTextField, "TestSubject");
    }

    public void clickEmailField() {
        logger.info("Click on the email field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, emailField);
        logger.info("Clear the email field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, emailField);
        logger.info("Enter email address...");
        WebDriverUtils.enterTextBox(super.driver, emailField, "lucian.puscasu@agys.ch");
    }

    public void clickTextTab() {
        logger.info("Click on the Text tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, textTab);
    }

    public void clickNotificationAddRecipients(){
        logger.info("Click on the add recipients button...");
        WebDriverUtils.clickOnElementWithWait(super.driver, notificationAddRecipients);
    }

    public void clickConnectorPropertiesAddNotifications(){
        logger.info("Click on the connector properties - add notifications...");
        WebDriverUtils.clickOnElementWithWait(super.driver, connectorPropertiesAddNotifications);
    }

    public void clickNotificationName() {
        logger.info("Click on the notification name field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, notificationName);
        logger.info("Clear the notification name field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, notificationName);
        logger.info("Enter notification name text...");
        WebDriverUtils.enterTextBox(super.driver, notificationName, "NotificationName");
    }


    public void clickConnectorPropertiesStatusCode() {
        logger.info("Click on the connector properties status code field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, connectorPropertiesStatusCode);
        logger.info("Clear the connector properties status code field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, connectorPropertiesStatusCode);
        logger.info("Enter connector properties status code text...");
        WebDriverUtils.enterTextBox(super.driver, connectorPropertiesStatusCode, "ConnectorStatusCode");
    }

    public void clickConnectorPropertiesStatusName() {
        logger.info("Click on the connector properties status name field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, connectorPropertiesStatusName);
        logger.info("Clear the connector properties status name field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, connectorPropertiesStatusName);
        logger.info("Enter connector properties status name text...");
        WebDriverUtils.enterTextBox(super.driver, connectorPropertiesStatusName, "ConnectorStatusName");
    }


    public void clickConnectorPropertiesDescription() {
        logger.info("Click on the connector properties field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, connectorPropertiesDescription);
        logger.info("Clear the approval matrix code field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, connectorPropertiesDescription);
        logger.info("Enter approval matrix code text...");
        WebDriverUtils.enterTextBox(super.driver, connectorPropertiesDescription, "ConnectorDescription");
    }

    public void clickApprovalMatrixTargetLabel() {
        logger.info("Click on the approval matrix target label field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, connectorPropertiesLabel);
        logger.info("Clear the approval matrix code field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, connectorPropertiesLabel);
        logger.info("Enter approval matrix code text...");
        WebDriverUtils.enterTextBox(super.driver, connectorPropertiesLabel, "ConnectorLabel");
    }

    public void clickApprovalMatrixDecisionsApprove() {
        logger.info("Click on the approve option in the approval matrix decision drop-down list...");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixDecisionsApprove);
    }

    public void clickApprovalMatrixDecisionDropDown(){
        logger.info("Click on the approval matrix decision drop down...");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixDecisionsDropDwon);
    }

    public void clickApprovalMatrixDropDown() {
        logger.info("Click on the approval matrix drop down in the list from the right...");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixDropDown);
    }

    public void clickParallelGatewayOption() {
        logger.info("Click on the parallel gateway drop-down option...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_5000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, parallelGatewayOption);
    }

    public void clickNewTargets() {
        logger.info("Click on new target from targets tab...");
        WebDriverUtils.clickOnElementWithWait(super.driver, newTarget);
    }

    public void clickTargetElementDropDown(){
        logger.info("Click on target element dropdown...");
        WebDriverUtils.clickOnElementWithWait(super.driver, targetElementDropDown);
    }

    public void ApprovalMatrixDescriptionEdit() {
        logger.info("Click on the approval matrix description field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixDescriptionField);
        logger.info("Clear the approval matrix code field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, approvalMatrixDescriptionField);
        logger.info("Enter approval matrix code text...");
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixDescriptionField, "Description Sample");
    }

    public void ApprovalMatrixCodeEdit(){
        logger.info("Click on the approval matrix code field...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixCode);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, approvalMatrixCode);
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixCode, "SSS");
    }

    public void ApprovalMatrixLabelEdit() {
        logger.info("Click on the approval matrix label...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixLabel);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clearElement(super.driver, approvalMatrixLabel);
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixLabel, "NewLabel");
    }

    public void ckeckSidebarElements() {
        if (WebDriverUtils.findElement(super.driver, diagram) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, diagram);
            logger.info("Diagram element was found {}" + diagram);
        } else {
            logger.info("Diagram element is not displayed" + diagram);
        }
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        if (WebDriverUtils.findElement(super.driver, task) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, task);
            logger.info("InterfaceBuilder element can be accessed" + task);
        } else {
            logger.info("InterfaceBuilder element is not displayed" + task);
        }
        if (WebDriverUtils.findElement(super.driver, approvalMatrix) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrix);
            logger.info("ApprovalMatrix element is displayed" + approvalMatrix);
        } else {
            logger.info("ApprovalMatrix elements is not displayed" + approvalMatrix);
        }
        if (WebDriverUtils.findElement(super.driver, externalTask) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, externalTask);
            logger.info("ExternalTask element is displayed");
        } else {
            logger.info("ExternalTask elementis not displayed");
        }
        if (WebDriverUtils.findElement(super.driver, generateDocuments) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, generateDocuments);
            logger.info("GenerateDocuments element is displayed" + generateDocuments);
        } else {
            logger.info("GenerateDocumentsPage element is not displayed" + generateDocuments);
        }
        if (WebDriverUtils.findElement(super.driver, api) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, api);
            logger.info("Apis element is displayed" + api);
        } else {
            logger.info("Apis element is not displayed" + api);
        }
        if (WebDriverUtils.findElement(super.driver, generalStart) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, generalStart);
            logger.info("General Task element is displayed" + generalStart);
        } else {
            logger.info("General Task element is not displayed" + generalStart);
        }
        if (WebDriverUtils.findElement(super.driver, startFromExternalSource) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, startFromExternalSource);
            logger.info("Start From External source element is displayed" + startFromExternalSource);
        } else {
            logger.info("Start From External element is not displayed" + startFromExternalSource);
        }

        if (WebDriverUtils.findElement(super.driver, exclusiveGateway) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, exclusiveGateway);
            logger.info("Exclusive Gateway element is displayed" + exclusiveGateway);
        } else {
            logger.info("Exclusive Gateway element is displayed" + exclusiveGateway);
        }
        if (WebDriverUtils.findElement(super.driver, parallelGateway) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, parallelGateway);
            logger.info("Parallel Gateway element is displayed" + parallelGateway);
        } else {
            logger.info("Parallel Gateway element is displayed" + parallelGateway);
        }
        if (WebDriverUtils.findElement(super.driver, joinGateway) != null) {
            WebDriverUtils.clickOnElementWithWait(super.driver, joinGateway);
            logger.info("Join Gateway element is displayed" + joinGateway);
        } else {
            logger.info("Join Gateway element is not displayed" + joinGateway);
        }
    }


    public void firstHumanTaskLabelCodeDescription(String valueTask, String valueCode, String descriptionValue) {
        logger.info("Go to new target..");
        WebDriverUtils.clickOnElementWithWait(driver, clickOnNewTarget);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        logger.info("Clicking on your task label...");
        WebDriverUtils.clickOnElementWithWait(driver, clickOnTaskName);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        logger.info("Entering label for task..");
        WebDriverUtils.enterTextBox(super.driver, labelTxtBox, valueTask);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Entering code for task..");
        WebDriverUtils.enterTextBox(super.driver, codeTxtBox, valueCode);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Clicking on task desc..");
        WebDriverUtils.clickOnElementWithWait(super.driver,descriptionTask );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Entering text for task description..");
        WebDriverUtils.enterTextBox(super.driver, descriptionTaskTxt, descriptionValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void firstHumanTaskCustomTaskSubject(String customTaskSubject, String DataModelvarValue) {
        logger.info("Going to task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, taskSubject);
        WebDriverUtils.enterTextBox(super.driver, customSubjectTextArea, customTaskSubject);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Accessing variables in task subject..");
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, varLabelTaskSubject);
        logger.info("Checking a variable in table..");
        WebDriverUtils.enterTextBox(super.driver, tableVariables,DataModelvarValue );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the Data Model class");
        WebDriverUtils.clickOnElementWithWait(super.driver, DataModelVarTaskSubject );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the Data Model attribute");
        WebDriverUtils.clickOnElementWithWait(super.driver, DataModelAttributeTskSubject);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
//        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
//        logger.info("Click on a variable...");
//        WebDriverUtils.clickOnElementWithWait(super.driver, primaclasPrimuatributString);
        logger.info("Switching to Variables tab");
        WebDriverUtils.clickOnElementWithWait(super.driver, variablesTab);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing InstanceID Task Subject Variable..");
        WebDriverUtils.clickOnElementWithWait(super.driver, InstanceIDTaskSubjectVariable );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, InstanceIDTaskSubjectVariable2);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Saving the task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, TaskSubjectSaveButton);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void firstHumanTaskCustomInstanceName(String valueCustomInstance, String DataModelvarValue)  {
        logger.info("Going to custom instance..");
        WebDriverUtils.clickOnElementWithWait(super.driver, instanceName);
        logger.info("Inserting Custom Instance Name..");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.enterTextBox(super.driver, customInstanceName,valueCustomInstance );
        logger.info("Accessing variables in instance name..");
        WebDriverUtils.clickOnElementWithWait(super.driver, varLabelInstanceName);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Checking a variable in table..");
        WebDriverUtils.enterTextBox(super.driver, tableVariables,DataModelvarValue );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the Data Model class");
        WebDriverUtils.clickOnElementWithWait(super.driver, DataModelVarTaskSubject );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the Data Model attribute");
        WebDriverUtils.clickOnElementWithWait(super.driver, DataModelAttributeTskSubject);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Switching to Variables tab");
        WebDriverUtils.clickOnElementWithWait(super.driver, variablesTab);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing InstanceID Task Subject Variable..");
        WebDriverUtils.clickOnElementWithWait(super.driver, InstanceIDTaskSubjectVariable );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, InstanceIDTaskSubjectVariable2);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Saving the task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, TaskSubjectSaveButton);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void firstHumanTaskSetDeadline(String deadlineValue )  {
//        logger.info("Clicking on deadline..");
//        WebDriverUtils.clickOnElementWithWait(super.driver,clickDeadline);
//        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Entering deadline..");
        WebDriverUtils.enterTextBox(super.driver, deadlineTask, deadlineValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Clicking on time unit");
        WebDriverUtils.clickOnElementWithWait(super.driver, deadlineTimeUnit);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Selecting time for my deadline task..");
        WebDriverUtils.clickOnElementWithWait(super.driver, hoursTask);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void firstHumanTaskselectPriority() {
        logger.info("Selecting priority for task..");
        WebDriverUtils.clickOnElementWithWait(super.driver, priorityArrow);
        WebDriverUtils.clickOnElementWithWait(super.driver, priorityLevels);
    }

    public void firstHumanTaskAccessTargetsTab() {
        logger.info("Go to Targets Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, targetsTab);
    }




    public void firstHumanTaskExpirationBehavior(String timeFrameValue)  {
        logger.info("Going to expiration behaviour");
        WebDriverUtils.clickOnElementWithWait(super.driver, expirationBehaviour);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Inserting time frame value..");
        WebDriverUtils.enterTextBox(super.driver,timeFrameTask, timeFrameValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing time frame unit..");
        WebDriverUtils.clickOnElementWithWait(super.driver, timeFrameOptions);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, timeFrameUnit);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Selecting target for process behaviour..");
        WebDriverUtils.clickOnElementWithWait(super.driver, processBehaviourddl);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, processBehaviourTarget);
        logger.info("Saving the expiration behavior..");
        WebDriverUtils.clickOnElementWithWait(super.driver, savebuttonExpiration);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void firstHumanTaskSetEscalation(String escalationTaskNameValue, String DataModelvarValue)  {
        logger.info("Set escalation..");
        WebDriverUtils.clickOnElementWithWait(super.driver, setEscalation);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Checking the checkbox for escalation..");
        WebDriverUtils.clickOnElementWithWait(super.driver, escalationRadio);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Selecting Escalate UI Fragment..");
        WebDriverUtils.clickOnElementWithWait(super.driver, clickOnEscalateUIFragmentddl);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Inserting escalation task name..");
        WebDriverUtils.enterTextBox(super.driver, enterEscalationTaskName, escalationTaskNameValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Accessing Escalation variables Task Name..");
        WebDriverUtils.clickOnElementWithWait(super.driver, varLabelEscalationTaskName );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Checking a variable in table..");
        WebDriverUtils.enterTextBox(super.driver, tableVariables,DataModelvarValue );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the Data Model class");
        WebDriverUtils.clickOnElementWithWait(super.driver, DataModelVarTaskSubject );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the Data Model attribute");
        WebDriverUtils.clickOnElementWithWait(super.driver, DataModelAttributeTskSubject);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Switching to Variables tab");
        WebDriverUtils.clickOnElementWithWait(super.driver, variablesTab);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing InstanceID Task Subject Variable..");
        WebDriverUtils.clickOnElementWithWait(super.driver, InstanceIDTaskSubjectVariable );
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, InstanceIDTaskSubjectVariable2);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Saving the task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, TaskSubjectSaveButton);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);

    }
    public void firstHumanTaskTargetElementProperties(String connectorLabelValue, String connectorDescriptionValue, String connectorStatusNameValue, String connectorStatusCodeValue)  {
        logger.info("Accessing the target element properties..");
        WebDriverUtils.clickOnElementWithWait(super.driver, targetElement);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choosing the target element..");
        WebDriverUtils.clickOnElementWithWait(super.driver,targetElementDdl);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, targetElementValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Setting the connector label..");
        WebDriverUtils.enterTextBox(super.driver, connectorLabel, connectorLabelValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Inserting the new target description..");
        WebDriverUtils.enterTextBox(super.driver, connectorDescription, connectorDescriptionValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Inserting connector status name");
        WebDriverUtils.enterTextBox(super.driver,connectorStatusName, connectorStatusNameValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Inserting connector status code");
        WebDriverUtils.enterTextBox(super.driver, connectorStatusCode, connectorStatusCodeValue);
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void enterStatusNameField() {
        logger.info("Enter a value in the status name field...");
        WebDriverUtils.enterTextBox(super.driver, statusNameField, STATUS_NAME_FIELD);
    }

    public void clickStatusNameField() {
        logger.info("Click on the status name field from the right...");
        WebDriverUtils.clickOnElementWithWait(super.driver, statusNameField);
    }

    public void clickGeneralStartDropDown() {
        logger.info("Click on general start drop down - from the right...");
        WebDriverUtils.clickOnElementWithWait(super.driver, generalStartDropDown);
    }

    public void enterTxtLabelTask(String valueTask) {
        logger.info("Entering label for task..");
        WebDriverUtils.enterTextBox(super.driver, labelTxtBox, valueTask);
    }

    public void enterTxtCodeTask(String valueCode) {
        logger.info("Entering code for task..");
        WebDriverUtils.enterTextBox(super.driver, codeTxtBox, valueCode);
    }

    public void clickTaskSubject(String customTaskSubject) {
        logger.info("Going to task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, taskSubject);
        WebDriverUtils.enterTextBox(super.driver, customSubjectTextArea, customTaskSubject);
    }

    public void clickVar() {
        logger.info("Accessing variables in task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, varLabel);
    }

    public void searchVariable(String varValue) {
        logger.info("Checking a variable in table..");
        WebDriverUtils.table(driver, varValue, tableVariables);
    }

    public void clickCancel() {
        logger.info("Cancelling task subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, cancelBtn);
    }

    public void backAction() {
        logger.info("Going back..");
        WebDriverUtils.clickOnElementWithWait(super.driver, backArrow);
    }

    public void clickCustomeInstance() {
        logger.info("Going to custom instance..");
        WebDriverUtils.clickOnElementWithWait(super.driver, customInstanceName);
    }

    public void enterTxtCustomInstanceName(String valueCustomInstance) {
        logger.info("Entering text for custom instance name..");
        WebDriverUtils.enterTextBox(super.driver, customSubjectTextArea, valueCustomInstance);
    }

    public void enterDescriptionTak(String descriptionValue) {
        logger.info("Entering text for task description..");
        WebDriverUtils.enterTextBox(super.driver, descriptionTask, descriptionValue);
    }

    public void enterDeadline(String deadlineValue) {
        logger.info("Entering deadline..");
        WebDriverUtils.enterTextBox(super.driver, deadlineTask, deadlineValue);
    }

    public void selectTime() {
        logger.info("Selecting time for my deadline task..");
        WebDriverUtils.clickOnElementWithWait(super.driver, hoursTask);
    }

    public void clickExpirationBehaviour() {
        logger.info("Go to expiration behaviour");
        WebDriverUtils.clickOnElementWithWait(super.driver, expirationBehaviour);
    }

    public void enterTimeFrame(String timeframeValue) {
        logger.info("Entering timeframe for expiration behaviour..");
        WebDriverUtils.enterTextBox(super.driver, timeFrameTask, timeframeValue);
    }

    public void selectTimeFrame() {
        logger.info("Choosing time frame value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, timeFrameOptions);
    }

    public void selectTarget() {
        logger.info("Selecting target for process behaviour..");
        WebDriverUtils.clickOnElementWithWait(super.driver, processBehaviour);
    }

    public void selectPriority(String optionPriority) {
        logger.info("Selecting priority for task..");
        WebDriverUtils.selectVisibleText(super.driver, priorityArrow, optionPriority);
    }


    public void clickAssignInterface() {
        logger.info("Go to Assign interface..");
        WebDriverUtils.clickOnElementWithWait(super.driver, assignInterface);
    }

    public void clickCreateIntreface() {
        logger.info("Create new intreface..");
        WebDriverUtils.clickOnElementWithWait(super.driver, createNewInterface);
    }

    public void clickSetEscalation() {
        logger.info("Set escalation..");
        WebDriverUtils.clickOnElementWithWait(super.driver, setEscalation);
    }

    public void checkEscalation() {
        logger.info("Checking the checkbox for escalation..");
        WebDriverUtils.clickOnElementWithWait(super.driver, escalationRadio);
    }

    public void clickDetailsTab() {
        logger.info("Go to Details Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, detailsTab);
    }

    public void clickTargetsTab() {
        logger.info("Go to Details Tab..");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, targetsTab);
    }

    public void clickUsersTab() {
        logger.info("Go to Details Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, usersTab);
    }

    public void clickRulesTab() {
        logger.info("Go to Details Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, rulesTab);
    }

    public void clickNewTarget() {
        logger.info("Go to new target..");
        WebDriverUtils.clickOnElementWithWait(super.driver, newTarget);
    }

    public void enterTxtLabelMatrix(String labelMatrix) {
        logger.info("Entering label for Matrix..");
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixLabel, labelMatrix);
    }

    public void enterTextCodeMatrix(String codeMatrix) {
        logger.info("Entering code for Matrix..");
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixCode, codeMatrix);
    }

    public void enterTextDescription(String descriptionValue) {
        logger.info("Entreing description for Matrix..");
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixCode, descriptionValue);
    }

    public void dragAndDropElement(By elementCanvas) {
        logger.info("Now I am dropping element {}" + elementCanvas);
        WebDriverUtils.dragAndDrop(super.driver, elementCanvas, canvas);
    }

    public void goToLevelTabMatrix() {
        logger.info("Go to Levels Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixLevelsTab);
    }

    public void addLdevelMatrix() {
        logger.info("Go to Levels Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixLevelsTab);
    }

    public void checkContinueIfReject() {
        logger.info("Check the checkbox continue if reject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixContinueCheck);
    }

    public void addRuleFromMatrix() {
        logger.info("Adding rule to my matrix..");
        WebDriverUtils.clickOnElementWithWait(super.driver, approvalMatrixAddRule);
    }

    public void enterNameRules(String nameRule) {
        logger.info("Creating rule for my matrix..");
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixNameRule, nameRule);
    }

    public void enterDescriptionRules(String descriptionRule) {
        logger.info("Creating rule for my matrix..");
        WebDriverUtils.enterTextBox(super.driver, approvalMatrixDescriptionRule, descriptionRule);
    }

    public void clickStatement() {
        logger.info("Add statement..");
        WebDriverUtils.clickOnElementWithWait(super.driver, statement);
    }

    public void clickArrowExpression1() {
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowExpression);
    }

    public void clickArrowExpression2() {
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowExpression1);
    }

    public void selectMod1() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueMod1);
    }

    public void selectVar1() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueVar1);
    }

    public void selectLoc1() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueLoc1);
    }

    public void selectTXT1() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueTXT1);
    }

    public void selectMod2() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueMod2);
    }

    public void selectVar2() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueVar2);
    }

    public void selectLoc2() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueLoc2);
    }

    public void selectTXT2() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueTXT2);
    }

    public void selectLog2() {
        logger.info("Selecting mod value..");
        WebDriverUtils.clickOnElementWithWait(super.driver, valueLog2);
    }


    public void removeStatement() {
        logger.info("Removing statement..");
        WebDriverUtils.clickOnElementWithWait(super.driver, removeStatement);
    }

    public void clickEquals() {
        WebDriverUtils.clickOnElementWithWait(super.driver, equals);
    }

    public void checkDynamicExternalTask() {
        logger.info("Checking the checkBox for Dynamic external tasks..");
        WebDriverUtils.clickOnElementWithWait(super.driver, checkDynamicExternalTasks);
    }

    public void clickSmsSubjectExternalTask() {
        logger.info("Go to Sms subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowSmsSubject);
    }

    public void clickTaskSubjectExternalTask() {
        logger.info("Go to Sms subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowTaskSubject);
    }

    public void clickExpirationBehaviourExternalTask() {
        logger.info("Go to Sms subject..");
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowExpirationBehaviour);
    }

    public void enterTxtBoxCustomSmsSubject(String smsSubject) {
        logger.info("Entering custom sms subject..");
        WebDriverUtils.enterTextBox(super.driver, customSmSSubject, smsSubject);
    }

    public void enterSubjectEmail(String subjectEmail) {
        logger.info("Entering email subject..");
        WebDriverUtils.enterTextBox(super.driver, SubjectTxtBox, subjectEmail);
    }

    public void enterAttachmentsTxtBox(String attachment) {
        logger.info("Entering attachment..");
        WebDriverUtils.enterTextBox(super.driver, attachmentsTxtBox, attachment);
    }

    public void enterBodyTxtBox(String bodyTxt) {
        logger.info("Entering attachment..");
        WebDriverUtils.enterTextBox(super.driver, bodyTxtBox, bodyTxt);
    }

    public void addDocuments() {
        logger.info("Adding documents..");
        WebDriverUtils.clickOnElementWithWait(super.driver, addDocuments);
    }

    public void goToDocumentTemplate() {
        logger.info("Selecting a document template..");
        WebDriverUtils.clickOnElementWithWait(super.driver, documentTemplateArrow);
    }

    public void enterlabelApi(String labelApi) {
        logger.info("Entering label..");
        WebDriverUtils.enterTextBox(super.driver, apiLabel, labelApi);
    }

    public void enterCodeApi(String codeApiValue) {
        logger.info("Entering code..");
        WebDriverUtils.enterTextBox(super.driver, codeApi, codeApiValue);
    }

    public void enterDescriptionApi(String descriptionApiValue) {
        logger.info("Entering Api description..");
        WebDriverUtils.enterTextBox(super.driver, descriptionApi, descriptionApiValue);
    }

    public void clickConfigureApi() {
        WebDriverUtils.clickOnElementWithWait(super.driver, arrowApiConfigureApi);
    }

    public void selectApi() {
        WebDriverUtils.clickOnElementWithWait(super.driver, selectApi);
    }

    public InterfaceBuilderPage returnInterfaceBuilder() {
        WebDriverUtils.clickOnElementWithWait(super.driver, createNewInterface);
        WebDriverUtils.waitUntil(super.driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(pagesBtn));
        WebDriverUtils.waitUntil(super.driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(layoutBtn));
        return new InterfaceBuilderPage(super.driver);
    }

    public InterfaceBuilderPage returnUserInterefacePageFromEscalation() {
        WebDriverUtils.clickOnElementWithWait(super.driver, createNewInterfaceFromEscalation);
        WebDriverUtils.waitUntil(super.driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(pagesBtn));
        WebDriverUtils.waitUntil(super.driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(layoutBtn));
        return new InterfaceBuilderPage(super.driver);
    }
}