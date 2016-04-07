package com.sq.platform.txj.modules.indexModule.model;

import java.io.Serializable;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/5 18:51
 */
public class Permission implements Serializable{
    private static final long serialVersionUID = 7896679103633455883L;
    private int id;
    private String permissionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
