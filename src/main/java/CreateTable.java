import java.util.Scanner;

public class CreateTable {
    String tableQuery;
    Scanner scanner = new Scanner(System.in);

    public void defineTableQuerry() {
        System.out.println("Enter name of the entity");
        String tableName = scanner.next();


        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (\n");


        while (true) {
            System.out.println("Add column? (y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                queryBuilder.append(defineColumn());
            } else if (input.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }

        queryBuilder.append(");");

        this.tableQuery = queryBuilder.toString();
    }

    public String defineColumn() {
        StringBuilder collumnBuilder = new StringBuilder();

        System.out.println("Enter column name.");
        collumnBuilder.append(scanner.next());

        System.out.println("Enter datatype.");
        collumnBuilder.append(" ").append(scanner.next());

        System.out.println("Enter Length.");
        collumnBuilder.append("(").append(scanner.nextInt()).append(")");

        System.out.println("Primary Key?(y/n)");
        if(scanner.next().equals("y")){
            collumnBuilder.append(" PRIMARY KEY AUTO_INCREMENT");
        }




        System.out.println();

        return collumnBuilder.toString();
    }
}
