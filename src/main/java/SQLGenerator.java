import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class SQLGenerator {
    DBConnection dbConnection = new DBConnection();

    public void executeQuery(String query) throws SQLException {
        Connection connection = dbConnection.getconnection();
        Statement statement = connection.createStatement();
        statement.execute(query);
    }
}
