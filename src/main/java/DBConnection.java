import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DBConnection {
    public static void establishConnection() {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306";
        System.out.println("Enter your username.");
        String user = scanner.next();
        System.out.println();

        System.out.println("Enter the password.");
        System.out.println("If this User does not possess one, then enter 'NULL'.");
        String password = scanner.next();
        System.out.println();

        if(password.equals("NULL")){
            password = null;
        }


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("CONNECTION ESTABLISHED");
            System.out.println();
            listDatabases(connection);
        } catch (SQLException sqlException) {
            System.err.println("ERROR OCCURRED - ERROR MESSAGE: " + sqlException.getMessage() + "\nSQLSTATE: " + sqlException.getSQLState());
        }
    }
    private static void listDatabases(Connection connection) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getCatalogs();

            System.out.println("Databases:");
            while (resultSet.next()) {
                String dbName = resultSet.getString("TABLE_CAT");
                System.out.println(dbName);
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            System.err.println("ERROR OCCURRED - ERROR MESSAGE: " + sqlException.getMessage() + "\nSQLSTATE: " + sqlException.getSQLState());
        }
    }
    public static void main(String []args){
        establishConnection();
    }
}
