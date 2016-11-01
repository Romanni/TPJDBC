package fr.univ_amu.iut.tpJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance;
    private static final String CONNECT_URL = "jdbc:mysql://mysql1.alwaysdata.com:3306/romain-colonna-distria_bd";
    private static final String LOGIN = "113436";
    private static final String PASSWORD = "752061322006";

    private ConnexionUnique() {
        try {
            connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnexionUnique getInstance() {
        if (instance == null)
            instance = new ConnexionUnique();
        return instance;
    }
}