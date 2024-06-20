import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class CreateTable {
    String tableQuery;
    Scanner scanner = new Scanner(System.in);
    boolean hasPK = false;

    public String defineTableQuerry() {
        System.out.println("Enter name of the entity");
        String tableName = scanner.next();


        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (\n");


        while (true) {
            System.out.println("Add column?(y/n)");
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
        return tableQuery;
    }


    private @NotNull String defineColumn() {
        String input;
        StringBuilder collumnBuilder = new StringBuilder();


        System.out.println("Enter column name.");
        collumnBuilder.append(scanner.next());

        if (!hasPK) {
            System.out.println("add PK?(y/n)");
            if (scanner.next().equals("y")) {
                collumnBuilder.append(" INT UNSIGNED(11) AUTO_INCREMENT PRIMARY KEY");
                return collumnBuilder.toString();
            }
            hasPK = true;
        }

        System.out.println("Enter datatype.");
        collumnBuilder.append(" ").append(scanner.next());

        System.out.println("Enter Length.");
        collumnBuilder.append("(").append(scanner.nextInt()).append(")");

        while (true) {
            System.out.println("UN?(y/n)");
            input = scanner.next();
            if (input.equals("y")) {
                collumnBuilder.append(" UNIQUE");
                break;
            } else if (input.equals("n")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }

        while (true) {
            System.out.println("NN?(y/n)");
            input = scanner.next();
            if (input.equals("y")) {
                collumnBuilder.append(" NOT NULL");
                break;
            } else if (input.equals("n")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }

        collumnBuilder.append("\n");
        return collumnBuilder.toString();
    }
}
