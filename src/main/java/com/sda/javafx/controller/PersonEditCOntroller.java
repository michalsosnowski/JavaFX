package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditCOntroller {
    private Main main;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private TextField postcode;
    @FXML
    private TextField phonenumber;

    private Person person;

    @FXML
    public void initialize(){

    }
    Stage stage;
    public void setStage(Stage stage){
        this.stage=stage;
    }

    public void setPerson(Person person){
        this.person=person;
        name.setText(person.getName());
        surname.setText(person.getLastName());
        street.setText(person.getStreet());
        city.setText(person.getCity());
        postcode.setText(person.getPostCode());
        phonenumber.setText(person.getTelephone());
    }

    public void handleOk() {
        person.setName(name.getText());
        person.setLastName(surname.getText());
        person.setStreet(street.getText());
        person.setCity(city.getText());
        person.setPostCode(postcode.getText());
        person.setTelephone(phonenumber.getText());
        System.out.println("Zapisz");
        //main.getStage().refresh();
        this.stage.close();

    }

    public void handleCancel() {
        this.stage.close();

    }

    public void PersonEditClose() {
        this.stage.close();

    }
}
