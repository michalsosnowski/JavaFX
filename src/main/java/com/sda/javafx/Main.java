package com.sda.javafx;

import com.sda.javafx.controller.NewPersonController;
import com.sda.javafx.controller.PersonController;
import com.sda.javafx.controller.PersonEditCOntroller;
import com.sda.javafx.model.Person;
import com.sda.javafx.model.PersonJson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private VBox layout;
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private List<PersonJson> personListJson = new ArrayList<>();

    public Main() {
        /*  personList.add(new Person("Maciej", "Kowalski"));*/
        /*  personList.add(new Person("Jan", "Nowak"));*/
        /*  personList.add(new Person("Marek", "Kowalski"));*/
        /*  personList.add(new Person("Maciej", "Nowak"));*/
        /*  personList.add(new Person("Marek", "Kowalski"));*/
        /*  personList.add(new Person("Jan", "Kowalski"));*/
        /*  personList.add(new Person("Zbigniew", "Kowalski"));*/
        /*  personList.add(new Person("Zbigniew", "Katulski"));*/
        /*  personList.add(new Person("Zbyszko", "Zbogdanca"));*/
        /*  personList.add(new Person("Emil", "Hauke"));*/
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));
        personListJson.add(new PersonJson("Jan", "Kowalski", "Katna","Inowroclaw", "88-110", "911"));


    }

    public static void main(String[] args)  {
        launch();
        }

    public Stage getStage() {
        return stage;
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Moja aplikacja w JavaFX");
        loadView();
    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/RootView.fxml"));
        try {
            layout = (VBox) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

        PersonController controller = loader.getController();
        controller.setMain(this);
    }

    public void loadPersonEdit(Person person) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/PersonEdit.fxml"));
        VBox window = null;
        try {
            window = (VBox) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PersonEditCOntroller personEditCOntroller = loader.getController();
        personEditCOntroller.setPerson(person);

        Stage editStage = new Stage();
        editStage.setTitle("Edytuj osobę");
        Scene scene = new Scene(window);
        editStage.setScene(scene);
        editStage.show();
        personEditCOntroller.setStage(editStage);

    }

    public void loadNewPerson() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/NewPerson.fxml"));
        VBox window = null;
        try {
            window = (VBox) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NewPersonController newPersonController = loader.getController();
        newPersonController.setMain(this);
        Stage editStage = new Stage();
        newPersonController.setStage(editStage);
        editStage.setTitle("Dodaj nową osobę");
        Scene scene = new Scene(window);
        editStage.setScene(scene);
        editStage.show();

    }


}

