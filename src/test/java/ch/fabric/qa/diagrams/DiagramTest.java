package ch.fabric.qa.diagrams;

import ch.fabric.qa.enums.Environments;
import ch.fabric.qa.pages.AppsPage;
import ch.fabric.qa.pages.LandingPage;
import ch.fabric.qa.pages.LoginPage;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import ch.fabric.qa.pages.sidebarpages.InterfaceBuilderPage;
import ch.fabric.qa.utils.CredentialsUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class DiagramTest {

	private LoginPage loginPage;
	private Environments environment;
	private LandingPage landingPage;
	private AppsPage appsPage;
	private DiagramsPage diagramsPage;
	private InterfaceBuilderPage interfaceBuilderPage;

	private static final String DIAGRAMS_TASK1_NAME = "HumanTask1";
	private static final String DIAGRAMS_TASK_CODE = "01";
	private static final String DIAGRAMS_CUSTOM_TASK_SUBJECT = "Custom Task Subject";
	private static final String DIAGRAMS_CUSTOM_INSTANCE_NAME = "Custom Instance name";
	private static final String DIAGRAMS_TASK_DESCRIPTION = "Descriere task";
	private static final String DIAGRAMS_TASK_DEADLINE = "12";
	private static final String DIAGRAMS_TASK_EXPIRATION_TIMEFRAME = "10";
	private static final String DIAGRAMS_CUSTOM__TASK_SUBJECT_DATA_MODEL_VAR = "primaclas";
	private static final String DIAGRAMS_ESCALATION_TASK_NAME = "escalation task name";
	private static final String DIAGRAMS_SET_CONNECTOR_LABEL = "Catre Parallel Gateway";
	private static final String DIAGRAMS_SET_CONNECTOR_DESCRIPTION = "Descriere connector";
	private static final String DIAGRAMS_SET_CONNECTOR_STS_NAME = "Connector status name";
	private static final String DIAGRAMS_SET_CONNECTOR_STS_CODE = "002";
	private static final String DIAGRAMS_SET_CONNECTOR_NOTIFICATION_NAME = "Notification connector name";

	@Parameters({ "environment"})
	@BeforeTest
	public void setuUp(String environment) {
		ChromeDriverManager.getInstance().setup();
		this.environment = environment == null? Environments.TEST : Environments.valueOf(environment);
	}

	@Test
	public void C1015EditTheDetailsForATaskObject() throws FileNotFoundException {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(CredentialsUtils.getProperty("url"));
		loginPage.usernameLogin(CredentialsUtils.getProperty("username"));
		loginPage.passwordLogin(CredentialsUtils.getProperty("password"));
		landingPage = loginPage.returnLandingPage();
		landingPage.clickMenus();
		appsPage = landingPage.returnAppsPage();
		diagramsPage = appsPage.returnSamsungDiagram();

//**FirstHumanTaskPlugin - Details Tab
		diagramsPage.firstHumanTaskLabelCodeDescription(DIAGRAMS_TASK1_NAME, DIAGRAMS_TASK_CODE, DIAGRAMS_TASK_DESCRIPTION);
		diagramsPage.firstHumanTaskCustomTaskSubject(DIAGRAMS_CUSTOM_TASK_SUBJECT, DIAGRAMS_CUSTOM__TASK_SUBJECT_DATA_MODEL_VAR);
		diagramsPage.firstHumanTaskCustomInstanceName(DIAGRAMS_CUSTOM_INSTANCE_NAME, DIAGRAMS_CUSTOM__TASK_SUBJECT_DATA_MODEL_VAR);
		diagramsPage.firstHumanTaskSetDeadline(DIAGRAMS_TASK_DEADLINE);
		diagramsPage.firstHumanTaskExpirationBehavior(DIAGRAMS_TASK_EXPIRATION_TIMEFRAME);
		diagramsPage.firstHumanTaskselectPriority();
		diagramsPage.firstHumanTaskSetEscalation(DIAGRAMS_ESCALATION_TASK_NAME, DIAGRAMS_CUSTOM__TASK_SUBJECT_DATA_MODEL_VAR);
		//diagramsPage.clickAssignInterface();
		//interfaceBuilderPage = diagramsPage.returnCreateNewInterface();

//**FirstHumanTaskPlugin - Targets Tab
		diagramsPage.firstHumanTaskAccessTargetsTab();
		diagramsPage.firstHumanTaskTargetElementProperties(DIAGRAMS_SET_CONNECTOR_LABEL, DIAGRAMS_SET_CONNECTOR_DESCRIPTION, DIAGRAMS_SET_CONNECTOR_STS_NAME, DIAGRAMS_SET_CONNECTOR_STS_CODE);

	}

	@AfterTest
	public void tearDown() {
		loginPage.quit();
		landingPage.quit();
		diagramsPage.quit();
		//interfaceBuilderPage.quit();
	}
}
