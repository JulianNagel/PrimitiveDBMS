import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = null;

    public final Connection getconnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
