package ch.fabric.qa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

/**
 * Groups common test methods.
 * 
 * @author aila.bogasieru@agys.ch
 */

public class BaseTest {

	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	private String loggingMessage;
	private Object[] loggingArgs;

	protected void startLogging(String message, Object... args) {
		this.loggingMessage = message;
		this.loggingArgs = args;
		logger.info("********************************************************************************************");
		logger.info(this.getClass().getSimpleName() + " " + message + " STARTED", args);
		logger.info("                                                              ");
	}

	private void endLoggingPass(String message, Object... args) {
		logger.info(this.getClass().getSimpleName() + " " + message + " PASSED", args);
		logger.info("********************************************************************************************");
		logger.info(" ");
	}

	private void endLoggingFail(String message, Object... args) {
		logger.info(this.getClass().getSimpleName() + " " + message + " FAILED", args);
		logger.info("********************************************************************************************");
		logger.info(" ");
	}

	@AfterMethod
	public void endLogging(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			endLoggingPass(loggingMessage, loggingArgs);
		}

		if (testResult.getStatus() == ITestResult.FAILURE) {
			Throwable e = testResult.getThrowable();
			logger.error("Error message: " + e.getMessage());
			endLoggingFail(loggingMessage, loggingArgs);
		}
	}




}