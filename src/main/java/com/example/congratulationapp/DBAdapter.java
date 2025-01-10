package com.example.congratulationapp;

import java.sql.*;

public class DBAdapter {
    Connection con;
//подключаем таблицу
    void create_or_connection() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:app.sqlite"); //пытаемся подключиться к БД app.sqlite

            Statement stmt = con.createStatement();
            //формируем sql запрос
            String sql = """
                    create table if not exists userData
                    (
                        id                  integer primary key autoincrement,
                        name                text    not null,
                        gender              text    not null,
                        species             text    not null,
                        genre               text    not null
                    );""";
            stmt.execute(sql);
            System.out.println("Tables created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//вставляем данные (сразу для двух таблиц)
    void insert_data(String name, String gender, String species, String genre) throws SQLException {
        String sql = "insert into userData(name, gender, species, genre)  VALUES('" + name + "', '" + gender + "', '" + species + "', '" + genre + "')";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        stmt.close();
        System.out.println("Inserted data");
    }


}
