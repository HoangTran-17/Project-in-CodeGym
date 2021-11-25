package vn.tnh.maket.motorcycle.exception;

public class HMMException extends RuntimeException {
	public HMMException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Hue Motorcycle Market: " + super.getMessage();
	}
}
