package com.group_22235.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotEmpty(message = "Please enter name")
    private String name;

    @NotEmpty(message = "Please enter email")
    @Email(message = "Email invalid")
    private String email;

    @NotEmpty(message = "Please enter password")
    @Length(min = 6, message = "Password must be longer than 6 characters")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}