package ch.fabric.qa.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fabric.qa.utils.WebDriverUtils;

import static ch.fabric.qa.utils.WebDriverUtils.*;

/**
 * Contains locators, methods specific to ApplicationSettings page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class ApplicationSettingsPage extends BasePage {

    private By createNewRoleButton = By.xpath("//button//div[text()='Create a new role']");
    private By addNewUserButton = By.xpath("//button//div[text()='Add new user']");
    private By usersAndRoles = By.linkText("Users and Roles");
    private By browseRoles = By.xpath("//button//div[text()='Browse roles']/parent::button");
    private By usersAndRolesTable = By.xpath("//table[@class='q-table q-table-horizontal-separator']");
    private By search = By.xpath("//input[@placeholder='Search']");
    private By activateEditRole = By.xpath("//i[text()=' more_vert']/ancestor::button");
    private By editRole = By.xpath("//div[text()='Edit role']");
    private By moreIcon = By.xpath("//button//i[text()=' more_vert']");
    private By roleNameTextBox = By.xpath("//div[input[text()='']");
    private By addPermissionIcon = By.xpath("//span[text()='Add permissions']/following-sibling::i");
    private By addUser = By.xpath("//div[text()='Add new user']/ancestor::button");
    private By uploadImageIcon = By.xpath("//i[text()='cloud_upload']");
    private By firstNameTextBox = By.xpath("//div[text()='First name']/preceding-sibling::div/input");
    private By lastNameTextBox = By.xpath("//div[text()='Last name']/preceding-sibling::div/input");
    private By emailAddressTextBox = By.xpath("//div[text()='Email address']/preceding-sibling::div/input");
    private By femaleRadioButton = By.xpath("//span[text()='Female']//parent::div");
    private By maleRadioButton = By.xpath("//span[text()='Male']//parent::div");
    private By inactiveRadioButton = By.xpath("//i[text()='radio_button_unchecked']");
    private By disabledRadioButton = By.xpath("//i[text()='radio_button_unchecked']");
    private By activeRadiobutton = By.xpath("//i[text()='radio_button_unchecked']");
    private By manuallySetPassword = By.xpath("//span[text()='Manually set password']//parent::div/child::div");
    private By rolesOrUsersTable = By.xpath("//table[@class='q-table q-table-horizontal-separator']");
    private By manageAppsLink = By.xpath("//a[text()='Manage Apps']");
    private By nameLabel = By.xpath("//th[text()='Name']");
    private By nameOwner = By.xpath("//th[text()='Owner']");
   // private By manageDocumentsLink = By.xpath("//a[text()='Manage Documents']");  - was removed
    private By nameUILabel = By.xpath("//th[text()='Name']");
    private By DescriptionLabel = By.xpath("//th[text()='Description']");
    private By OwnerLabel = By.xpath("//th[text()='Owner']");
    private By UIusedOnLabel = By.xpath("//th[text()='UI used on']");
    private By settingsLink = By.xpath("//a[text()='Settings']");

    private By componentsFromMarketplaceLink = By.partialLinkText("Marketplace");
    private By syncBtn = By.xpath("//div[@class='q-btn-inner row col items-center justify-center' and text()='SYNC']");
    private By settingsTable = By.id("settings");
    private By addManuallyUsersArrow = By.cssSelector(".manual-add-icon");
    private By uploadImgManuallyUser = By.xpath("//div//i[@class='cloud_upload']");
    private By selectApplication = By.xpath("//div//i[text()='arrow_drop_down']");
    private By initiatorOn = By.xpath("//span[text()='Initiator']");
    private By editorOn = By.xpath("//div//div[text()='Editor']");
    private By reportViewerOn = By.xpath("//div//div[text()='Report Viewer']");
    private By generalStart = By.xpath("//div[@id='pluginSidebarContainer']/div[2]/div[2]/div/div/canvas");
    private By startFromExeternal = By.xpath("//div[@id='pluginSidebarContainer']/div[2]/div[2]/div[2]/div/canvas");
    private By generalEnd = By.xpath("//div[@id='pluginSidebarContainer']/div[2]/div[2]/div[3]/div/canvas");
    private By arrowSelectApp = By.xpath("//i[text()='arrow_drop_down']/ancestor::div[@class='collapse-container']");
    private By exampleSelectApp = By.xpath("//div[@class='q-item-label' and text()='KAqfpjPfXS']");
    private By levelsInitiator = By.xpath("//div//span[text()='Initiator']");
    private By levelsEditor = By.xpath("//div//span[text()='Editor']");
    private By levelsReportViewer = By.xpath("//div//span[text()='ReportViewer']");
    private By checkCheckboxUser = By.xpath("//i[text()='check_box_outline_blank']");
    private By roleNameTxtBox = By.xpath("//div[@class='q-if row no-wrap relative-position q-input q-if-standard text-primary']");
    private By passwordTxtBoxSetManually = By.xpath("//div[text()='Password']//parent::div/child::div/input");
    private By saveRoleOnNew = By.xpath("//div[@data-v-781c4760]//div[text()='Save']/ancestor::button");
    private By closeEditPanelArrow = By.xpath("//div[@data-v-8d24aea8]//i[text()='keyboard_arrow_left']/ancestor::button");
    private By saveOnEdit = By.xpath("//div[@data-v-67500b92]//div[text()='Save']/ancestor::button");
    private By saveAddUser = By.xpath("//div[text()='Save']/ancestor::button[not(contains(@class, 'at-main-save-btn'))]");
    private By manuallyPasswordButton = By.xpath("//div[@class='q-toggle-handle row flex-center']");
    private By newRoleAddUserSave = By.xpath("//div[@data-v-375d40de]//div[text()='Save']/ancestor::button");
    private By browseRolesButton = By.xpath("//div[@class='q-btn-inner row col items-center justify-center' and text()='Browse roles']");
    private By browseRolesElementFromList = By.xpath("//span[@class='role-name']");
    private By addRoleName = By.xpath("//input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private By permissionsSelectApp = By.xpath("//div[@class='col q-input-target ellipsis justify-start q-input-target-placeholder' and text()='Select application']");
    private By selectAutomationTestLucianApp = By.xpath("//div[@class='q-item-label' and text()='AutomationTestLucian']");
    private By newRoleAddUsersButton = By.xpath("//span[text()='Add users']/following::i");
    private By newRoleSelectUserFromList = By.xpath("//span[text()='emil.savin@agys.ch']");
    private By dateTimePickerApp = By.xpath("//h1[text()='DateTimePicker']");
    private By buttonApiApp = By.xpath("//h1[text()='Button_API']");
    private By installButtonAPIApp = By.xpath("//div[@class='q-btn-inner row col items-center justify-center' and text()='INSTALL']");
    private By removeButtonOnApp = By.xpath("//div[@class='q-btn-inner row col items-center justify-center' and text()='REMOVE']");
    private By updateButtonSegment2App = By.xpath("//div[@class='q-btn-inner row col items-center justify-center' and text()='UPDATE']");
    private By segment2App = By.xpath("//h1[text()='Segment2']");
    private By clickUser = By.xpath("//span[@class='email']");
    private By editUserButton = By.xpath("//button//div[text()='Edit user']");
    private By saveRoleEditPermissionsChanges = By.xpath("//div[@data-v-c47111d6]//div[text()='Save']/ancestor::button");
    private By saveRoleEditChanges = By.xpath("//div[@data-v-67500b92]//div[text()='Save']/ancestor::button");

    public static By checkTableRow = By.xpath("//table");
    protected ApplicationSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void editUser(){
        log.info("Click on an user...");
        WebDriverUtils.clickOnElementWithWait(driver, clickUser);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        log.info("Click on the edit user button...");
        WebDriverUtils.clickOnElementWithWait(driver, editUserButton);
        log.info("Editing the role name...");
        WebDriverUtils.clickOnElementWithWait(driver, addRoleName);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        WebDriverUtils.enterTextBoxWithoutClear(driver, addRoleName, "NewRoleNameEdit");
        log.info("Click on add permissions button...");
        WebDriverUtils.clickOnElementWithWait(driver, addPermissionIcon);
        log.info("Click and select an app from the drop down list...");
        WebDriverUtils.clickOnElementWithWait(driver, permissionsSelectApp);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, selectAutomationTestLucianApp);
        log.info("Select the initiator level...");
        WebDriverUtils.clickOnElementWithWait(driver, levelsInitiator);
        log.info("Save the permissions tab...");
        WebDriverUtils.clickOnElementWithWait(driver, saveRoleOnNew);
        log.info("Click on the Add user ...");
        WebDriverUtils.clickOnElementWithWait(driver, newRoleAddUsersButton);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        log.info("Select user from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, newRoleSelectUserFromList);
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        log.info("Save the permissions changes...");
        WebDriverUtils.clickOnElementWithWait(driver, saveRoleEditPermissionsChanges);
        log.info("Save the edit user changes...");
        WebDriverUtils.clickOnElementWithWait(driver, saveRoleEditChanges);


    }

    public void updateElements() {
        log.info("Clicking on the update button on an app...");
        if (WebDriverUtils.findElement(driver, segment2App) == null) {
            WebDriverUtils.clickOnElementWithWait(driver, segment2App);
            WebDriverUtils.clickOnElementWithWait(driver, updateButtonSegment2App);
            log.info("The app was successfully installed...");
        } else {
            log.info("The install button is not working as expected or not existing on any app...");
        }
    }

    public void clickCreateNewRole() {
        log.info("Creating new role...");
        WebDriverUtils.clickOnElementWithWait(driver, createNewRoleButton);
    }

    public void accessSettingsPage() {
        log.info("Accessing the settings page...");
        WebDriverUtils.clickOnElementWithWait(driver, settingsLink);
    }

    public void removeElements() {
        log.info("Click on the Remove button on an app...");
        if (WebDriverUtils.findElement(driver, dateTimePickerApp) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, dateTimePickerApp);
            WebDriverUtils.clickOnElementWithWait(driver, removeButtonOnApp);
            log.info("The app was successfully removed...");
        } else {
            log.info("The remove button is not working as expected...");
        }
    }

    public void installElements() {
        log.info("Clicking on the install button on an app...");
        if (WebDriverUtils.findElement(driver, dateTimePickerApp) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, buttonApiApp);
            WebDriverUtils.clickOnElementWithWait(driver, installButtonAPIApp);
            log.info("The app was successfully updated...");
        } else {
            log.info("The update button is not working as expected...");
        }
    }

    public void syncElements() {
        log.info("Click on components from marketplace tab...");
        WebDriverUtils.clickOnElementWithWait(driver,componentsFromMarketplaceLink);
        log.info("Click on the Sync button...");
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, syncBtn);
    }

    public void createANewRole() {
        log.info("Click on create a new role button...");
        WebDriverUtils.clickOnElementWithWait(driver, createNewRoleButton);
        log.info("Entering a new role name...");
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.enterTextBox(driver, addRoleName, "NewRoleNameTest");
        log.info("Click on add permissions button...");
        WebDriverUtils.clickOnElementWithWait(driver, addPermissionIcon);
        log.info("Click and select an app from the drop down list...");
        WebDriverUtils.clickOnElementWithWait(driver, permissionsSelectApp);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, selectAutomationTestLucianApp);
        log.info("Select the initiator level...");
        WebDriverUtils.clickOnElementWithWait(driver, levelsInitiator);
        log.info("Save the permissions tab...");
        WebDriverUtils.clickOnElementWithWait(driver, saveRoleOnNew);
        log.info("Click on the Add user and select a new user from the drop down...");
        WebDriverUtils.clickOnElementWithWait(driver, newRoleAddUsersButton);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, newRoleSelectUserFromList);
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, newRoleAddUserSave);
    }

    public void browseRoles(){
        log.info("Click on the browse roles button...");
        WebDriverUtils.clickOnElementWithWait(driver, browseRolesButton);
        WebDriverUtils.explicitWait(driver, WAIT_500_MILLISECONDS);
        log.info("Check if the browse role button works...");
        if (WebDriverUtils.findElement(driver, browseRolesElementFromList) != null) {
            log.info("The list gets populated with users...");
        } else {
            log.info("The list is empty or the browse users button is not working as expected...");
        }
    }

    public void addANewUser()  {
        log.info("Click on the add new user button...");
        WebDriverUtils.clickOnElementWithWait(driver, addUser);
        log.info("Entering the first name...");
        WebDriverUtils.clickOnElementWithWait(driver, firstNameTextBox);
        WebDriverUtils.enterTextBox(driver, firstNameTextBox, "FirstNameTest");
        log.info("Entering the last name...");
        WebDriverUtils.clickOnElementWithWait(driver, lastNameTextBox);
        WebDriverUtils.enterTextBox(driver, lastNameTextBox, "LastNameTest");
        log.info("Entering the email...");
        WebDriverUtils.clickOnElementWithWait(driver, emailAddressTextBox);
        WebDriverUtils.enterTextBox(driver, emailAddressTextBox, "email@test.com");
        log.info("Selecting the male gender...");
        WebDriverUtils.clickOnElementWithWait(driver, maleRadioButton);
        log.info("Click on the manually set password button...");
        WebDriverUtils.clickOnElementWithWait(driver, manuallyPasswordButton);
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        log.info("Manually setting the password...");
        WebDriverUtils.clickOnElementWithWait(driver, passwordTxtBoxSetManually);
        WebDriverUtils.enterTextBox(driver, passwordTxtBoxSetManually, "testpassword");
        log.info("Saving the changes...");
        WebDriverUtils.clickOnElementWithWait(driver, newRoleAddUserSave);

    }

    public void clickAddNewUser() {
        log.info("Creating new user..");
        WebDriverUtils.clickOnElementWithWait(driver, addNewUserButton);
    }

    public void closePanel(){

        WebDriverUtils.clickOnElementWithWait(driver, closeEditPanelArrow);
    }

public void searchUserOrRole(String searchEmail){
        WebDriverUtils.enterTextBox(driver, search, searchEmail);
}

public void clickSaveOnNew() {
        log.info("Saving the Role..");
        WebDriverUtils.clickOnElementWithWait(driver, saveRoleOnNew);
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
}

    public void clickSaveOnNewUser() {
        log.info("Saving the Role..");
        WebDriverUtils.clickOnElementWithWait(driver, saveAddUser);
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
    }

    public void clickSaveOnEdit() {
        log.info("Saving the Role..");
        WebDriverUtils.clickOnElementWithWait(driver, saveOnEdit);
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
    }

    public void clikcBrowseRoles() {
        log.info("Browsing role..");
        WebDriverUtils.clickOnElementWithWait(driver, browseRoles);
    }

    public void createNewRole(String roleName) {
        log.info("Entering role name..");
        WebDriverUtils.enterTextBox(driver, roleNameTextBox, roleName);
    }

    public void selectApplication() {
        log.info("Selecting application..");
        WebDriverUtils.clickOnElementWithWait(driver, arrowSelectApp);
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, exampleSelectApp);
    }

    public void addPermission() {
        log.info("Adding new permissions..");
        WebDriverUtils.clickOnElementWithWait(driver, addPermissionIcon);
    }

    public void addUsers() {
        log.info("Adding new user..");
        WebDriverUtils.clickOnElementWithWait(driver, addUser);
    }

    public void checkUserFromTable(String userValue){
        log.info("Checking an user in table..");
        WebDriverUtils.explicitWait(super.driver, WAIT_5000_MILLISECONDS);
        WebDriverUtils.table(driver, userValue, usersAndRolesTable);
//        WebDriverUtils.clickOnElementWithWait(driver, checkCheckboxUser);
    }

    public void enterRoleName(String roleValue) {
        log.info("Entering new role name..");
        WebDriverUtils.enterTextBox(driver, roleNameTxtBox, roleValue);
    }

    public void uploadImageUser(String filePath) {
        log.info("Uploading image for user..");
        WebDriverUtils.uploadFile(driver,uploadImageIcon, filePath );
    }

    public void enterFirstName(String firstName) {
        log.info("Entering First Name..");
        WebDriverUtils.enterTextBox(driver, firstNameTextBox, firstName);

    }

    public void enterLastName(String lastName) {
        log.info("Entering Last Name..");
        WebDriverUtils.enterTextBox(driver, lastNameTextBox, lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        log.info("Entering email address..");
        WebDriverUtils.enterTextBox(driver, emailAddressTextBox, emailAddress);
    }

    public void checkGenre(String option) {
        switch (option) {
            case "Female":
                log.info("Checking radio button Female..");
                WebDriverUtils.clickOnElementWithWait(driver, femaleRadioButton);
                break;
            case "Male":
                log.info("Checking radio button Male..");
                WebDriverUtils.clickOnElementWithWait(driver, maleRadioButton);
                break;
            default:
                log.info("Option not supported", option);
        }
    }
// STATUS HAS BEEN REMOVED FROM THE INTERFACE IT WILL BE ADDED LATER ON

//    public void checkStatus(String option) {
//        switch (option) {
//            case "Inactiv":
//                log.info("Checking radio button Inactive..");
//                WebDriverUtils.clickOnElementWithWait(driver, inactiveRadioButton);
//                break;
//            case "Disabled":
//                log.info("Checking radio button Disabled..");
//                WebDriverUtils.clickOnElementWithWait(driver, disabledRadioButton);
//                break;
//            case "Active":
//                log.info("Checking radio button Active..");
//                WebDriverUtils.clickOnElementWithWait(driver, activeRadiobutton);
//                break;
//            default:
//                log.info("Option not supported", option);
//        }
//    }

    public void actEditRole() {
        log.info("Editing the role..");
        WebDriverUtils.clickOnElementWithWait(driver, activateEditRole);
    }

    public void editRoles() {
        log.info("Editing the role..");
        WebDriverUtils.clickOnElementWithWait(driver, editRole);
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
    }


    public void moreActionsRole() {
        log.info("Displaying more options..");
        WebDriverUtils.clickOnElementWithWait(driver, moreIcon);
    }

    public void manuallySetPassword(String passwordValue) {
        WebDriverUtils.clickOnElementWithWait(driver, manuallySetPassword);
        WebDriverUtils.enterTextBox(driver, passwordTxtBoxSetManually, passwordValue);
    }

    public void addManuallyUsers() {
        log.info("Adding manually users..");
        WebDriverUtils.clickOnElementWithWait(driver, addManuallyUsersArrow);
        WebDriverUtils.uploadFile(driver, uploadImgManuallyUser, "C://Downloads//download (1).png");
    }

    public void selectApplication(String option) {
        log.info("Settings permissions..");
        WebDriverUtils.selectVisibleText(driver, selectApplication, option);
    }

    public void setInitiator() {
        log.info("Set initiator On..");
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, initiatorOn);
    }

    public void setEditor() {
        log.info("Set editor On..");
        WebDriverUtils.clickOnElementWithWait(driver, editorOn);
    }

    public void setReportViewer() {
        log.info("Set report viewer On..");
        WebDriverUtils.clickOnElementWithWait(driver, reportViewerOn);
    }


    public ManageAppsPage returnManageAppsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, manageAppsLink);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(nameLabel));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(nameOwner));
        return new ManageAppsPage(driver);
    }
//MANAGE DOCUMENTS PAGE WAS REMOVED
////    public ManageDocumentsPage returnManageDocumentsPage() {
////        WebDriverUtils.clickOnElementWithWait(driver, manageDocumentsLink);
////        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
////                ExpectedConditions.invisibilityOfElementLocated(nameLabel));
////        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
////                ExpectedConditions.invisibilityOfElementLocated(nameOwner));
////        return new ManageDocumentsPage(driver);
////    }
//
//    public ManageUIsPage returnManageUIsPage() {
//        WebDriverUtils.clickOnElementWithWait(driver, manageDocumentsLink);
//        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
//                ExpectedConditions.invisibilityOfElementLocated(nameUILabel));
//        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
//                ExpectedConditions.invisibilityOfElementLocated(DescriptionLabel));
//        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
//                ExpectedConditions.invisibilityOfElementLocated(OwnerLabel));
//        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
//                ExpectedConditions.invisibilityOfElementLocated(UIusedOnLabel));
//        return new ManageUIsPage(driver);
//    }

//DEOCAMDATA DESIGNUL TREBUIE UPDATAT SI METODA NU MERGE
    public ComponentsFromMarketplacePage returnComponentsFromMarketplace() {
        WebDriverUtils.clickOnElementWithWait(driver, componentsFromMarketplaceLink);
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(createNewRoleButton));
        return new ComponentsFromMarketplacePage(driver);
    }



    public SettingsPage returnSettingsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, settingsLink);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(syncBtn));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.visibilityOfElementLocated(settingsTable));
        return new SettingsPage(driver);
    }
}


		


