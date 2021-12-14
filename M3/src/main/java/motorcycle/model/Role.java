package motorcycle.model;


public enum Role {
	SUPER_ADMIN("SUPER_ADMIN"), ADMIN("ADMIN"), USER("USER");
	
	private final String value;
	
	Role(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static Role fromValue(String value) {
		Role[] var1 = values();

		for (Role c : var1) {
			if (c.value.equals(value)) {
				return c;
			}
		}
		throw new IllegalArgumentException("Invalid role value: " + value);
	}
}
