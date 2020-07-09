import java.util.Scanner;

public class Main {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        System.out.println("Connecting to database...");
        System.out.println("Successfully connected to 13.57.13.193/bankdb!");
        System.out.println();
        System.out.println("Welcome to the customer database.");
        System.out.println("Please select the following options:");
        System.out.println("View database: (V)");
        System.out.println("Remove entry: (R)");
        System.out.println("Add entry: (A)");
        System.out.println("Update entry: (U)");
        System.out.println("Quit: (Q)");
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                String input = sc.next();
                if (input.equalsIgnoreCase("v")) {
                    ReadDatabase.printAll();
                    System.out.println();
                    System.out.println("Show menu: (S)");
                }
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Bye!");
                    System.exit(1);
                }
                if (input.equalsIgnoreCase("s")) {
                    System.out.println("View database: (V)");
                    System.out.println("Remove entry: (R)");
                    System.out.println("Add entry: (A)");
                    System.out.println("Update entry: (U)");
                    System.out.println("Quit: (Q)");
                }
                if (input.equalsIgnoreCase("r")) {
                    System.out.println("Please enter the ID: " );
                    int id = Integer.parseInt(sc.next());
                    ReadDatabase.remove(id);
                    System.out.println("Successfully removed entry with ID " + id);
                    System.out.println();
                    System.out.println("Show menu: (S)");
                }
                if (input.equalsIgnoreCase("a")) {
                    System.out.println("Please enter the first name: ");
                    String firstName = sc.next();
                    System.out.println("Please enter the last name: ");
                    String lastName = sc.next();
                    System.out.println("Please enter the phone number: ");
                    String phoneNumber = sc.next();
                    System.out.println("Please enter the email: ");
                    String email = sc.next();
                    ReadDatabase.add(firstName, lastName, phoneNumber, email);
                    System.out.println("Successfully added new entry!");
                    System.out.println();
                    System.out.println("Show menu: (S)");
                }
                if (input.equalsIgnoreCase("u")) {
                    System.out.println("Please enter the ID: ");
                    int id2 = Integer.parseInt(sc.nextLine());
                    System.out.println("Please enter the first name: ");
                    String firstName = sc.next();
                    System.out.println("Please enter the last name: ");
                    String lastName = sc.next();
                    System.out.println("Please enter the phone number: ");
                    String phoneNumber = sc.next();
                    System.out.println("Please enter the email: ");
                    String email = sc.next();
                    ReadDatabase.update(id2, firstName, lastName, phoneNumber, email);
                    System.out.println("Successfully added new entry!");
                    System.out.println();
                    System.out.println("Show menu: (S)");
                }
            }
        }
    }
}