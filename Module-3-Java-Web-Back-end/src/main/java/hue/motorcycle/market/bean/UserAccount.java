package hue.motorcycle.market.bean;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private int id;
    private String name;
//    private UserStatus status;
//    private Role role;
    private List<String> roles;

    private String phone;
    private String email;
    private String address;
    private String password;

    public UserAccount() {
    }

    public UserAccount(int userId, String name, String phone, String email, String address, String password) {
        this .id = userId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public UserAccount(int userId, String name, List<String> roles, String phone, String email, String address, String password) {
        this .id = userId;
        this.name = name;
//        this.status = status;
        this.roles = new ArrayList<String>();
        if (roles != null) {
            this.roles.addAll(roles);
        }
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

//    public UserStatus getStatus() {
//        return status;
//    }
//    public void setStatus(UserStatus status) {
//        this.status = status;
//    }

    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) { this.roles = roles;	}

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

}

