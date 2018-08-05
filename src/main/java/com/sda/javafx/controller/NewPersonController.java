package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonController {
    Stage stage;
    Main main;
    private Person person;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField postcodeTextField;
    @FXML
    private TextField phonenumberTextField;
    @FXML
    public void initialize(){

    }

    public void handleCancel() {
        this.stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleAddNewPerson() {
        Person person = new Person();
       // main.loadPersonEdit(person);
        person.setName(nameTextField.getText());
        person.setLastName(surnameTextField.getText());
        person.setStreet(streetTextField.getText());
        person.setCity(cityTextField.getText());
        person.setPostCode(postcodeTextField.getText());
        person.setTelephone(phonenumberTextField.getText());
        main.getPersonList().add(person);
        this.stage.close();
    }


}
