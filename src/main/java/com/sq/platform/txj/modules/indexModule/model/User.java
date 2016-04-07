package com.sq.platform.txj.modules.indexModule.model;

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

    private int id;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
