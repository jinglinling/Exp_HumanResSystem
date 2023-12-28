package com.esms.entity;

//二级机构
public class SecondInsitution {
    private int secondInsitutionNum;
    private String secondInsitutionName;
    private int primaryInsitutionNum;

    public SecondInsitution(int secondInsitutionNum, String secondInsitutionName, int primaryInsitutionNum) {
        this.secondInsitutionNum = secondInsitutionNum;
        this.secondInsitutionName = secondInsitutionName;
        this.primaryInsitutionNum = primaryInsitutionNum;
    }

    public int getSecondInsitutionNum() {
        return secondInsitutionNum;
    }

    public void setSecondInsitutionNum(int secondInsitutionNum) {
        this.secondInsitutionNum = secondInsitutionNum;
    }

    public String getSecondInsitutionName() {
        return secondInsitutionName;
    }

    public void setSecondInsitutionName(String secondInsitutionName) {
        this.secondInsitutionName = secondInsitutionName;
    }

    public int getPrimaryInsitutionNum() {
        return primaryInsitutionNum;
    }

    public void setPrimaryInsitutionNum(int primaryInsitutionNum) {
        this.primaryInsitutionNum = primaryInsitutionNum;
    }

    @Override
    public String toString() {
        return "secondInsitution{" +
                "secondInsitutionNum=" + secondInsitutionNum +
                ", secondInsitutionName='" + secondInsitutionName + '\'' +
                ", primaryInsitutionNum=" + primaryInsitutionNum +
                '}';
    }
}
