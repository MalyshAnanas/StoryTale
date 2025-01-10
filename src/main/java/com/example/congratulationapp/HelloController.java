package com.example.congratulationapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField Name;

    @FXML
    private ChoiceBox <String> Gender;

    @FXML
    private ChoiceBox <String> Species;

    @FXML
    private ChoiceBox <String> Genre;

    @FXML
    private void onHelloButtonClick() throws IOException, SQLException {
        String nameText = Name.getText();
        String getGender = Gender.getValue();
        String getSpecies = Species.getValue();
        String getGenre = Genre.getValue();
        if (!nameText.isEmpty()) { // Если ввели правильно
            // создаем новое окно
            Stage stage = (Stage) (welcomeText.getScene().getWindow());
            stage.hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StoryTale-view.fxml")); //загружает новое окно
            Scene scene = new Scene(loader.load(), 1000, 600);
            stage = new Stage();
            stage.setTitle("~~~История~~~");
            stage.setScene(scene);
            stage.setResizable(false); // запрет на изменение размера
            stage.show();

            StoryTaleController StoryTaleController = loader.getController(); //получаем объект класса StoryTaleController
            StoryTaleController.EndText(getGender, nameText, getSpecies, getGenre);
            //Вызываем метод
        }
        else {
            welcomeText.setText("Заполните все поля КОРРЕКТНО!!!");
        }
    }

}