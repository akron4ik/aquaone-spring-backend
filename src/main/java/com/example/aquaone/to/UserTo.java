package com.example.aquaone.to;


import com.example.aquaone.HasEmail;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserTo extends BaseTo implements HasEmail, Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 100, message = "please enter correct name, must be minimum 2 characters")
    @SafeHtml
    private String username;

    @NotBlank
    @Size(min = 2, max = 50, message = "please enter correct surname, must be minimum 2 characters")
    @SafeHtml
    private String surname;

    @SafeHtml
    private String organization;

    @Email
    @NotBlank
    @Size(max = 100)
    @SafeHtml // https://stackoverflow.com/questions/17480809
    private String email;

    @NotBlank
    @SafeHtml
    @Size(min = 5, max = 32, message = "length must be between 5 and 32 characters")
    private String password;

    @NotNull
    @Size(min = 7, max = 32, message = "length must be minimum 7 numbers")
    private String phone;

    @NotNull
    @Size(min = 6, max = 300, message = "please enter correct address, must be minimum 6 characters")
    private String address;

    public UserTo() {
    }

    public UserTo(Integer id, String username, String surname, String organization, String email, String password, String phone, String address) {
        super(id);
        this.username = username;
        this.surname = surname;
        this.organization = organization;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", organization='" + organization + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
