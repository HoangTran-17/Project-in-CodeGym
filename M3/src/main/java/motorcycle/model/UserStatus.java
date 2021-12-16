package motorcycle.model;

public enum UserStatus {
	LOCKED("LOCKED"), AVAILABLE("AVAILABLE");
	
	private final String value;
	
	UserStatus(String value) { this.value = value; }
	
	public String getValue() {	return this.value; }
	
	public static UserStatus fromValue(String value) {
		UserStatus[] var1 = values();
		for (UserStatus c : var1) {
			if (c.value.equals(value)) {
				return c;
			}
		}
		throw new IllegalArgumentException("Invalid user status value: " + value);
	}
}
