package motorcycle.model;

import java.io.Serializable;

public class User implements Serializable {
	private long userId;
	private String name;
	private UserStatus status;
	private Role role;
	private String phone;
	private String address;
	private String password;
	
	public User() {
	}
	
	public User(long userId, String name, String phone,String address, String password) {
		this .userId = userId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}
	
	public User(long userId, String name, UserStatus status, Role role, String phone, String address, String password) {
		this .userId = userId;
		this.name = name;
		this.status = status;
		this.role = role;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}
	

	public long getId() { return userId; }
	public void setId(long id) {
		this .userId = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) { this.role = role;	}
	
	public String getPhoneNumber() {
		return phone;
	}
	public void setPhoneNumber(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
//	public String toString() {
//		return String.format("%d,%s,%d,%s,%s,%s,%s",
//				id, name, status.getValue(),
//				role.getValue(), phone, address, password);
//	}
	
	public static void transferFields(User oldUser, User newUser) {
		oldUser .userId = newUser.userId;
		oldUser.status = newUser.status;
		oldUser.name = newUser.name;
		oldUser.phone = newUser.phone;
		oldUser.address = newUser.address;
		oldUser.password = newUser.password;
	}
}
