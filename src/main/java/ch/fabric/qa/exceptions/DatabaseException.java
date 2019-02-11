package ch.fabric.qa.exceptions;

/**
 * Exception that is used for database exception handling.
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 362044320962286949L;

	public DatabaseException() {

	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(Throwable cause) {
		super(cause);
	}

	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}
}