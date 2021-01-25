package com.dov.myapplication;

import java.util.ArrayList;

public class User {
    private String login;
    private String email;


    public static ArrayList<User> users;

    public User(String login, String email){
        this.login = login;
        this.email = email;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static ArrayList<User> getUsers(){
        if (users == null){
            users = new ArrayList<>();
        }
        return users;
    }

}
