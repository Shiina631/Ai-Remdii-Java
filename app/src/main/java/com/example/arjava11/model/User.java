package com.example.arjava11.model;

public class User {

    private int id,age;
    private String email,name,profileStatus;

    public User(int id,String email, String name,Integer age, String status)
    {
        this.id = id;
        this.email =email;
        this.name = name;
        this.age =age;
        this.profileStatus = status;

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getProfileStatus() {
        return profileStatus;
    }
}
