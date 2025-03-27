import java.util.*;

public class NameManager {
    private static ArrayList<String> names = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Name");
            System.out.println("2. Remove Name");
            System.out.println("3. Search Name");
            System.out.println("4. Sort Names");
            System.out.println("5. Display Names");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            
            switch (choice) {
                case 1:
                    addName();
                    break;
                case 2:
                    removeName();
                    break;
                case 3:
                    searchName();
                    break;
                case 4:
                    sortNames();
                    break;
                case 5:
                    displayNames();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);
    }

    private static void addName() {
        System.out.print("Enter name to add: ");
        String name = scanner.nextLine();
        names.add(name);
        System.out.println("Name added successfully.");
    }

    private static void removeName() {
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        if (names.remove(name)) {
            System.out.println("Name removed successfully.");
        } else {
            System.out.println("Name not found.");
        }
    }

    private static void searchName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        if (names.contains(name)) {
            System.out.println("Name found in the list.");
        } else {
            System.out.println("Name not found.");
        }
    }

    private static void sortNames() {
        Collections.sort(names);
        System.out.println("Names sorted successfully.");
    }

    private static void displayNames() {
        if (names.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Names in the list:");
            for (String name : names) {
                System.out.println(name);
            }
        }
    }
}
