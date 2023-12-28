package com.esms.entity;

//一级机构
public class PrimaryInsitution {
    private int primaryInsitutionNum;
    private String primaryInsitutionName;

    public PrimaryInsitution(int primaryInsitutionNum, String primaryInsitutionName) {
        this.primaryInsitutionNum = primaryInsitutionNum;
        this.primaryInsitutionName = primaryInsitutionName;
    }

    public int getPrimaryInsitutionNum() {
        return primaryInsitutionNum;
    }

    public void setPrimaryInsitutionNum(int primaryInsitutionNum) {
        this.primaryInsitutionNum = primaryInsitutionNum;
    }

    public String getPrimaryInsitutionName() {
        return primaryInsitutionName;
    }

    public void setPrimaryInsitutionName(String primaryInsitutionName) {
        this.primaryInsitutionName = primaryInsitutionName;
    }

    @Override
    public String toString() {
        return "primaryInsitution{" +
                "primaryInsitutionNum=" + primaryInsitutionNum +
                ", primaryInsitutionName='" + primaryInsitutionName + '\'' +
                '}';
    }
}
