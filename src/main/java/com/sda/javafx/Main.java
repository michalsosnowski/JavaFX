package com.sda.javafx;

import com.sda.javafx.controller.PersonController;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private VBox layout;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main(){
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Kowalski"));
    }
    public ObservableList<Person> getPersonList(){
        return personList;
    }

    public static void main(String[] args) {
        launch();
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
    public void loadPersonEdit() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/PersonEdit.fxml"));
        VBox window = null;
        try {
            window = (VBox) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage editStage = new Stage();
        editStage.setTitle("Edytuj dane osoby");
        Scene scene = new Scene(window);
        editStage.setScene(scene);
        editStage.show();

    }
}
