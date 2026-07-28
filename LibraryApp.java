import java.util.Scanner;

/**
 * Main application class with command-line interface
 * for interacting with the library catalog.
 */
public class LibraryApp {
    
    // Create a catalog that can hold any type of LibraryItem
    private static Catalog<LibraryItem<?>> catalog = new Catalog<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("  WELCOME TO GENERIC LIBRARY CATALOG");
        System.out.println("=====================================\n");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addItem();
                    break;
                case "2":
                    removeItem();
                    break;
                case "3":
                    viewItem();
                    break;
                case "4":
                    catalog.displayCatalog();
                    break;
                case "5":
                    running = false;
                    System.out.println("Thank you for using Library Catalog. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Displays the main menu
     */
    private static void displayMenu() {
        System.out.println("\n----- MAIN MENU -----");
        System.out.println("1. Add a new library item");
        System.out.println("2. Remove an item");
        System.out.println("3. View item details");
        System.out.println("4. Display all items");
        System.out.println("5. Exit");
        System.out.println("---------------------");
    }
    
    /**
     * Handles adding a new item to the catalog
     */
    private static void addItem() {
        System.out.println("\n--- ADD NEW ITEM ---");
        
        System.out.print("Enter item type (Book/DVD/Magazine): ");
        String type = scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();
        
        // Create item based on type
        Object itemType;
        switch (type.toLowerCase()) {
            case "book":
                itemType = new Book();
                break;
            case "dvd":
                itemType = new DVD();
                break;
            case "magazine":
                itemType = new Magazine();
                break;
            default:
                itemType = new GenericItem();
        }
        
        LibraryItem<Object> newItem = new LibraryItem<>(title, author, itemID, itemType);
        catalog.addItem(newItem);
        System.out.println("Item added successfully!\n");
    }
    
    /**
     * Handles removing an item from the catalog
     */
    private static void removeItem() {
        System.out.println("\n--- REMOVE ITEM ---");
        System.out.print("Enter item ID to remove: ");
        String itemID = scanner.nextLine();
        
        try {
            catalog.removeItem(itemID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * Handles viewing a specific item's details
     */
    private static void viewItem() {
        System.out.println("\n--- VIEW ITEM ---");
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();
        
        LibraryItem<?> item = catalog.getItem(itemID);
        
        if (item != null) {
            System.out.println("Item found:");
            System.out.println(item.toString());
        } else {
            System.out.println("Item not found.");
        }
        System.out.println();
    }
}

// Helper classes to represent different item types
class Book {
    @Override
    public String toString() {
        return "Book";
    }
}

class DVD {
    @Override
    public String toString() {
        return "DVD";
    }
}

class Magazine {
    @Override
    public String toString() {
        return "Magazine";
    }
}

class GenericItem {
    @Override
    public String toString() {
        return "Generic Item";
    }
}