package com.aru.uzzal.uniassist;

public class userDetails {
    private String email;
    private String name;
    private String password;
    private String username;

    userDetails() {
    }

    public userDetails(String name2, String email2) {
        this.name = name2;
        this.email = email2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email2) {
        this.email = email2;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }
}
