package com.sda.javafx.controller;

import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonDetails {
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

        //name.setText();
    }
    Stage stage;
    public void setStage(Stage stage){
        this.stage=stage;
    }

    public void setPerson(Person person){
        this.person=person;
        name.setText(person.getName());
        surname.setText(person.getLastName());
       /* street.setText(person.getStreet());
        city.setText(person.getCity());
        postcode.setText(person.getPostCode());
        phonenumber.setText(person.getTelephone());*/
    }

    public void handleOk() {
        person.setName(name.getText());
        person.setLastName(surname.getText());
        System.out.println("Zapisz");
        this.stage.close();

    }

    public void handleCancel() {
        this.stage.close();

    }
}
