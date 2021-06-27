package com.ishwar_arcore.explorebuddy.utils;

public class Traveller {

    private String userId;
    private String profilePic;
    private String userName;
    private String email;
    private String sex;
    private String age;
    private String addressone;
    private String addresstwo;
    private String city;
    private String state;
    private String pincode;
    private String mobile;

    public Traveller() {
    }

    public Traveller(String userId, String profilePic, String userName, String email, String sex, String age, String addressone, String addresstwo, String city, String state, String pincode, String mobile) {
        this.userId = userId;
        this.profilePic = profilePic;
        this.userName = userName;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.addressone = addressone;
        this.addresstwo = addresstwo;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddressone() {
        return addressone;
    }

    public void setAddressone(String addressone) {
        this.addressone = addressone;
    }

    public String getAddresstwo() {
        return addresstwo;
    }

    public void setAddresstwo(String addresstwo) {
        this.addresstwo = addresstwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
