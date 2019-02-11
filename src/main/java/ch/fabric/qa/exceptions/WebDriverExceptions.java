package ch.fabric.qa.exceptions;

/**
 * Contains all the exception specific to WebDriver
 *
 * @author aila.bogasieru@agys.ch
 */


public class WebDriverExceptions {
	
	public class WebDriverException extends RuntimeException {

		private static final long serialVersionUID = -4523404377018946855L;

		public WebDriverException() {

		}

		public WebDriverException(String message) {
			super(message);
		}

		public WebDriverException(Throwable cause) {
			super(cause);
		}

		public WebDriverException(String message, Throwable cause) {
			super(message, cause);
		}
	}

}
