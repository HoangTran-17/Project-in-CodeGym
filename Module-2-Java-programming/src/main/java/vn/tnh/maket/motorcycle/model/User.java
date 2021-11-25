package vn.tnh.maket.motorcycle.model;

public class User {
	private int id;
	private String name;
	private UserStatus status;
	private Role role;
	private String phone;
	private String email;
	private String address;
	private String password;
	
	public User() {
	}
	
	public User(int userId, String name, String phone, String email, String address, String password) {
		this .id = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	public User(int userId, String name, UserStatus status, Role role, String phone, String email, String address, String password) {
		this .id = userId;
		this.name = name;
		this.status = status;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	

	public int getId() { return id; }
	public void setId(int id) {
		this .id = id;
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	public String toString() {
		return String.format("%d,%s,%d,%s,%s,%s,%s,%s",
				id, name, status.getValue(),
				role.getValue(), phone, email, address, password);
	}
	
	public static void transferFields(User oldUser, User newUser) {
		oldUser .id = newUser.id;
		oldUser.status = newUser.status;
		oldUser.name = newUser.name;
		oldUser.phone = newUser.phone;
		oldUser.email = newUser.email;
		oldUser.address = newUser.address;
		oldUser.password = newUser.password;
	}
}
