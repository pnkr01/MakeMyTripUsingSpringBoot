package com.pawan.dreambuy.model.auth;

import jakarta.persistence.*;

@Entity
@Table(name = "userregistration")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_username")
    private String userName;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_status")
    private String userStatus;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_walletid")
    private int userWalletId;

    public UserRegistration(int userId, String userName, String name, String userEmail, int userAge, String userType, String userPhone, String userStatus, String userPassword, int userWalletId) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.userEmail = userEmail;
        this.userAge = userAge;
        this.userType = userType;
        this.userPhone = userPhone;
        this.userStatus = userStatus;
        this.userPassword = userPassword;
        this.userWalletId = userWalletId;
    }

    public UserRegistration() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserWalletId() {
        return userWalletId;
    }

    public void setUserWalletId(int userWalletId) {
        this.userWalletId = userWalletId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAge=" + userAge +
                ", userType='" + userType + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userWalletId=" + userWalletId +
                '}';
    }
}
