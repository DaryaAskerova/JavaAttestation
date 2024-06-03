package Attestation;

import java.util.*;

public class PhoneBook {
    private static Map<String, Set<String>> phoneBook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            hr();
            System.out.println("Phone Book:\n");
            System.out.println("1. Review recordings");
            System.out.println("2. Add recording");
            System.out.println("3. Exit");
            System.out.print("\nSelect an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            clearConsole();

            switch (choice) {
                case 1:
                    displayItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("\nIncorrect choice! Try again.\n");
            }
        }
        System.out.println("\nThe application is completed.\n");
    }

    private static void displayItems() {
        if (phoneBook.isEmpty()) {
            System.out.println("\nThe phone book is empty.\n");
        } else {
            List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
            sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
            hr();
            System.out.println("Recordings in the phone book (sorted in descending order of the number of phones):\n");
            for (Map.Entry<String, Set<String>> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        waitEnter();
    }

    private static void addItem() {
        hr();
        System.out.print("Add recording\n\n");
        System.out.print("Enter a name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
        System.out.println("\nAn recorcing has been added " + name + ": " + phoneNumber);
        waitEnter();
    }

    private static void waitEnter() {
        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
        clearConsole();
    }
    private static void hr() {
        System.out.println("\n--------------------------------");
    }
    public static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}