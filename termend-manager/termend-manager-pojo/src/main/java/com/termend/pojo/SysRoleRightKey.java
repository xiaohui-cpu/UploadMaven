package com.termend.pojo;

import java.io.Serializable;

public class SysRoleRightKey implements Serializable{
    private String rfRightCode;

    private Long rfRoleId;

    public String getRfRightCode() {
        return rfRightCode;
    }

    public void setRfRightCode(String rfRightCode) {
        this.rfRightCode = rfRightCode == null ? null : rfRightCode.trim();
    }

    public Long getRfRoleId() {
        return rfRoleId;
    }

    public void setRfRoleId(Long rfRoleId) {
        this.rfRoleId = rfRoleId;
    }
}