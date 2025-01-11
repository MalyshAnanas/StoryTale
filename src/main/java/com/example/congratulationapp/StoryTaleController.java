package com.example.congratulationapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StoryTaleController implements Initializable { //implements Initializable - наследование интерфейса для инициализации
    //Random random = new Random();
    DBAdapter adapter = new DBAdapter(); //получаем объект класса DBAdapter
    @FXML
    private TextArea StoryTale;

    public void EndText(String Gender, String Name, String Species, String Genre) throws SQLException {
        String result = "";
        if(Genre.equals("Хоррор")){
            Horror w = new Horror(Gender, Name, Species, Genre);
            result=w.HorrorText();
        }
        if(Genre.equals("Фэнтези")){
            Fantasy w = new Fantasy(Gender, Name, Species, Genre);
            result=w.FantasyText();
        }
        StoryTale.setText(result);
        adapter.insert_data(Name, Gender, Species, Genre); //Записываем наши данные в БД
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adapter.create_or_connection();
    } //Подключаемся к БД во время создания окна
}
