package com.example.data.model;

public class Contact {
    private String name;
    private String phoneNumber;
    private int id;


    public Contact(){

    }

    public Contact(String name, String phoneNumber, int id){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;

    }
    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
