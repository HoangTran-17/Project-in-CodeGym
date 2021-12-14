package motorcycle.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegex {
	private static Pattern pattern;
	
	private static final String PHONE_NUMBER_REGEX = "(0[3|5|7|8|9])+([0-9]{8})";
	
	public static final String NAME_REGEX = "^[ A-Za-z]{6,20}$";
	
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static final String PASSWORD_REGEX = "^[A-Za-z0-9]{6,12}$";
	
	
	public static boolean validatePhoneNumber(String regex) {
		pattern = Pattern.compile(PHONE_NUMBER_REGEX);
		return validate(pattern, regex);
	}
	
	public static boolean validateName(String regex) {
		pattern = Pattern.compile(NAME_REGEX);
		return validate(pattern, regex);
	}
	
	public static boolean validateEmail(String regex) {
		pattern = Pattern.compile(EMAIL_REGEX);
		return validate(pattern, regex);
	}
	
	public static boolean validatePassword(String regex) {
		pattern = Pattern.compile(PASSWORD_REGEX);
		return validate(pattern, regex);
	}
	
	
	private static boolean validate(Pattern pattern, String regex) {
		Matcher matcher = pattern.matcher(regex);
		return matcher.matches();
	}
}
