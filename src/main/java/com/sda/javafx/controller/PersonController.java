package com.sda.javafx.controller;


import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PersonController {

    private Main main;

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
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldField, newFild)->showPersonDetails(newFild));
    }

    private void showPersonDetails(Person person) {
        nameLabel.setText(person.getName());
        lastNameLabel.setText(person.getLastName());
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(main.getPersonList());
    }



}
