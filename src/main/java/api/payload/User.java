package api.payload;

import io.qameta.allure.Step;

public class User {

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;

    public int getId() {
        return id;
    }

    @Step("User id is :")
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Step("Username is :")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    @Step("First name is :")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Step("Last name is :")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    @Step("Email is :")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Step("Password is :")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    @Step("Phone is :")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

}
