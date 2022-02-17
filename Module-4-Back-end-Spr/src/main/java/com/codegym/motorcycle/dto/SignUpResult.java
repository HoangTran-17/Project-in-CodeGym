package com.codegym.motorcycle.dto;

import com.codegym.motorcycle.model.Customer;
import com.codegym.motorcycle.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpParam {
    private String name;
    private String phone;
    private String password;
    private String address;

    @Override
    public String toString() {
        return "SignUpParam{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Customer toCustomer() {
        return new Customer(name,phone,address,password );
    }

}


