package ru.korus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class oracleConn {
    public Connection getConn(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            System.out.println("Не найден драйвер");
            e.printStackTrace();
            return null;
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin@172.17.230.107:1521:DEVSFERA","edi_gui_sbr_pub","edi_gui_sbr_pub");
        } catch (SQLException e) {
            System.out.println("Ошибка соединения с БД");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("Соединение установлено!");
            return connection;
        } else {
            System.out.println("Соединение не установлено!");
            return null;
        }

    }
}
