package ch.fabric.qa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

/**
 * Groups common test methods.
 * 
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class BaseTest {

	private String loggingMessage;
	private Object[] loggingArgs;

	protected void startLogging(String message, Object... args) {
		this.loggingMessage = message;
		this.loggingArgs = args;
		log.info("********************************************************************************************");
		log.info(this.getClass().getSimpleName() + " " + message + " STARTED", args);
		log.info("                                                              ");
	}

	private void endLoggingPass(String message, Object... args) {
		log.info(this.getClass().getSimpleName() + " " + message + " PASSED", args);
		log.info("********************************************************************************************");
		log.info(" ");
	}

	private void endLoggingFail(String message, Object... args) {
		log.info(this.getClass().getSimpleName() + " " + message + " FAILED", args);
		log.info("********************************************************************************************");
		log.info(" ");
	}

	@AfterMethod
	public void endLogging(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			endLoggingPass(loggingMessage, loggingArgs);
		}

		if (testResult.getStatus() == ITestResult.FAILURE) {
			Throwable e = testResult.getThrowable();
			log.error("Error message: " + e.getMessage());
			endLoggingFail(loggingMessage, loggingArgs);
		}
	}




}