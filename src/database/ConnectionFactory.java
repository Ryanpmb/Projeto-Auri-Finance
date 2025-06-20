package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/app_db";
    private static final String USER = "root";
    private static final String PASSWORD = "senha123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão com o banco: " + e.getMessage(), e);
        }
    }
}
