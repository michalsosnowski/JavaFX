package com.sda.javafx.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import com.sda.javafx.model.PersonJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {

    private Main main;
     File file;

    @FXML
    private TableView<Person> personTable;
    @FXML
    private Label nameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postCodeLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private TableColumn<Person, String> firstNameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private Button newButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    @FXML
    public void handleNewPersonButton() {
        main.loadNewPerson();
    }

    @FXML
    public void handlePersonEdit() {

        Person selectPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectPerson != null) {
            /*System.out.println(selectPerson.getName());
            System.out.println(selectPerson.getLastName());*/
            main.loadPersonEdit(selectPerson);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Brak osoby");
            alert.setContentText("Nikt nie zostal wybrany");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeletePerson() {
        int index = personTable.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Czy usunąć " + personTable.getSelectionModel().getSelectedItem().getName() + " ?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Usuwanie");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {

                personTable.getItems().remove(index);
            }
        }
    }


    @FXML
    public void initialize() {
        firstNameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell -> cell.getValue().lastNameProperty());
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldField, newFild) -> showPersonDetails(newFild));
    }

    private void showPersonDetails(Person person) {
        if(person!=null){
        nameLabel.setText(person.getName());
        lastNameLabel.setText(person.getLastName());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postCodeLabel.setText(person.getPostCode());
        telephoneLabel.setText(person.getTelephone());}
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(main.getPersonList());
    }


    public void rootViewHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(main.getStage());
        alert.setHeaderText("Od tworcy");
        alert.setTitle("Wersja programu");
        alert.setContentText("Aktualnie posiadasz wersję 0.00.0.000.001");
        alert.showAndWait();
    }

    public void fileChooser() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        file = fileChooser.showOpenDialog(main.getStage());
        ObjectMapper mapper = new ObjectMapper();
        PersonJson[] readorders = mapper.readValue(file, PersonJson[].class);

        for (PersonJson p : readorders) {
            System.out.println(p.getName());
            main.getPersonList().add(new Person(p.getName(), p.getLastName(), p.getStreet(), p.getCity(), p.getPostCode(), p.getTelephone()));
        }

    }

    public void handleQuit() {
        main.getStage().close();

    }

    @FXML
    public void handleSaveFile() throws IOException {
        /*1dobrac sie do listy
         * 2nadpisac plik person.json*/

        ObjectMapper mapper = new ObjectMapper();
        List<PersonJson> personListJSON = new ArrayList<>();
        for (Person p : main.getPersonList()) {
            personListJSON.add(new PersonJson(p.getName(), p.getLastName(), p.getStreet(), p.getCity(), p.getPostCode(), p.getTelephone()));
        }
        mapper.writeValue(file, personListJSON);
    }

    public void handleSaveAsFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonJson> personListJSON = new ArrayList<>();
        for (Person p : main.getPersonList()) {
            personListJSON.add(new PersonJson(p.getName(), p.getLastName(), p.getStreet(), p.getCity(), p.getPostCode(), p.getTelephone()));
        }

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(main.getStage());
        mapper.writeValue(file, personListJSON);


    }
}

