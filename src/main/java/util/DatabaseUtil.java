package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static constants.MysqlConstants.*;

public class DatabaseUtil {
    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
