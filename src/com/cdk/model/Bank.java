package com.cdk.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.*;


@XmlRootElement(name = "myBranch")
public class Bank {

    int branchId;
    String branchName;
    String branchType;
    int branchStrength;
    int managerId;

    public Bank() {
    }

    public Bank(int branchId, String branchName, String branchType, int branchStrength, int managerId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchType = branchType;
        this.branchStrength = branchStrength;
        this.managerId = managerId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public int getBranchStrength() {
        return branchStrength;
    }

    public void setBranchStrength(int branchStrength) {
        this.branchStrength = branchStrength;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", branchType='" + branchType + '\'' +
                ", branchStrength=" + branchStrength +
                ", managerId=" + managerId +
                '}';
    }





}
