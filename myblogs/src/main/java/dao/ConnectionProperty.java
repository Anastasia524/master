package dao;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProperty {
	private String jdbcURL = "jdbc:postgresql://localhost:5433/authors";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "37852146";
    public ConnectionProperty() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}


