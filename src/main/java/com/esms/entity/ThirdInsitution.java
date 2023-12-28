package com.esms.entity;

//三级机构
public class ThirdInsitution {
    private Integer thirdInsitutionNum;
    private String thirdInsitutionName;
    private int secondInsitutionNum;

    public ThirdInsitution(Integer thirdInsitutionNum, String thirdInsitutionName, int secondInsitutionNum) {
        this.thirdInsitutionNum = thirdInsitutionNum;
        this.thirdInsitutionName = thirdInsitutionName;
        this.secondInsitutionNum = secondInsitutionNum;
    }

    public Integer getThirdInsitutionNum() {
        return thirdInsitutionNum;
    }

    public void setThirdInsitutionNum(Integer thirdInsitutionNum) {
        this.thirdInsitutionNum = thirdInsitutionNum;
    }

    public String getThirdInsitutionName() {
        return thirdInsitutionName;
    }

    public void setThirdInsitutionName(String thirdInsitutionName) {
        this.thirdInsitutionName = thirdInsitutionName;
    }

    public int getSecondInsitutionNum() {
        return secondInsitutionNum;
    }

    public void setSecondInsitutionNum(int secondInsitutionNum) {
        this.secondInsitutionNum = secondInsitutionNum;
    }

    @Override
    public String toString() {
        return "thirdInsitution{" +
                "thirdInsitutionNum=" + thirdInsitutionNum +
                ", thirdInsitutionName='" + thirdInsitutionName + '\'' +
                ", secondInsitutionNum=" + secondInsitutionNum +
                '}';
    }
}
