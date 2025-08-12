package org.leralix.tan.storage.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MySqlHandler extends DatabaseHandler {

    private final String host;
    private final int port;
    private final String databaseName;
    private final String user;
    private final String password;

    public MySqlHandler(String host, int port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.databaseName = database;
        this.user = username;
        this.password = password;
    }
    @Override
    public void connect() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + databaseName); // Address of your running MySQL database
        config.setUsername(user); // Username
        config.setPassword(this.password); // Password
        config.setMaximumPoolSize(10); // Pool size defaults to 10

        config.addDataSourceProperty("", ""); // MISC settings to add
        HikariDataSource dataSource = new HikariDataSource(config);

        try (Connection connection = dataSource.getConnection()) {
            // Use a try-with-resources here to autoclose the connection.
            PreparedStatement sql = connection.prepareStatement("SQL");
            // Execute statement
        } catch (Exception e) {
            // Handle any exceptions that arise from getting / handing the exception.
        }
    }

}
