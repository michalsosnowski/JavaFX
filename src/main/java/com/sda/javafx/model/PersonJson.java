package com.sda.javafx.model;

public class PersonJson {

    String name;
    String lastName;
    String street;
    String city;
    String postCode;
    String telephone;

    public PersonJson(){}

    public PersonJson(String name, String lastName, String street, String city, String postCode, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
