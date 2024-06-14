import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    String url;
    String user;
    String password;

    public void getGetconnectionRequirements(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public final Connection getconnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
