package ykvlv.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    private ConnectionManager() { }

    public static Connection open() throws SQLException {
        String url = PropertiesUtil.get(URL_KEY);
        String user = PropertiesUtil.get(USER_KEY);
        String password = PropertiesUtil.get(PASSWORD_KEY);
        if (url == null || user == null || password == null) {
            throw new RuntimeException("Необходимо указать параметры подключения к БД в application.properties");
        }
        return DriverManager.getConnection(
                PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
    }
}
