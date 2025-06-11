package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class MysqlConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    Connection getConnection(){
        if(Objects.nonNull(connection)) return connection;

        try {
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
            return connection;

        } catch (SQLException e){
            throw new RuntimeException("Conexão falhou", e);
        }
    }
}
