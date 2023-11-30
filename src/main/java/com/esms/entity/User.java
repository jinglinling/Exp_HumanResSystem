package com.esms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int userID;
    private String userAccount;
    private String userName;
    private String userPassword;
    private int sex;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", sex=" + sex +
                '}';
    }
}
