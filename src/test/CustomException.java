package test;

//CustomException.java
public class CustomException extends Exception {
	// Constructor with no arguments
	public CustomException() {
		super("Default Custom Exception Message");
	}

	// Constructor that accepts a message
	public CustomException(String message) {
		super(message);
	}

	// Constructor that accepts a message and a cause
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	// Constructor that accepts a cause
	public CustomException(Throwable cause) {
		super(cause);
	}
}
