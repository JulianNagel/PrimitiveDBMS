import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        SQLGenerator sqlGenerator = new SQLGenerator();
        CreateTable createTable = new CreateTable();

        try {
            sqlGenerator.executeQuery(createTable.defineTableQuerry());
        } catch (SQLException sqlException) {
            System.err.println("ERROR MESSAGE: "+sqlException.getMessage());
        }
    }
}
