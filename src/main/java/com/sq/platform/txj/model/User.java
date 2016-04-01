package com.sq.platform.txj.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/3/30 15:46
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5796182386986927079L;
    @Pattern(regexp = "\\w{2,30}")
    private String name;

    @Pattern(regexp = "\\w{6,30}")
    private String password;

    @Min(value = 0)
    private int age;

    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
