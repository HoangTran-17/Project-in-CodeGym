package vn.tnh.maket.motorcycle.exception;

import java.io.IOException;

public class TextFileException extends RuntimeException{
	public TextFileException(IOException exception) {
		super(exception);
	}
}
