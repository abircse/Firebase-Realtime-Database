package com.studioabir.firebasedatabase.firebasedatabase.model;

public class user {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public user(String id, String name, String email, String phone, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    ///------- FIREBASE DEMAND EMPTY CONSTRUCTOR SO CREATE IT PLZ----///
    public user() {
    }
}
