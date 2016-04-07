package com.sq.platform.txj.modules.indexModule.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/5 18:56
 */
public class Role implements Serializable{

    private static final long serialVersionUID = 823086511236257301L;

    private int id;

    private String name;

    private List<Permission> permissions;

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
