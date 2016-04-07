package com.sq.platform.txj.modules.vehicleModule.model;

import java.io.Serializable;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 14:14
 */
public class Vehicle implements Serializable {
    private static final long serialVersionUID = -2183054681770830346L;
    private String name;

    private String terminalId;

    private String owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
