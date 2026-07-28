import java.util.ArrayList;
import java.util.List;

/**
 * Generic Catalog class that can store and manage different types of library items.
 * T represents the type of items stored in the catalog.
 */
public class Catalog<T extends LibraryItem<?>> {
    
    // List to store library items
    private List<T> items;
    
    // Constructor
    public Catalog() {
        this.items = new ArrayList<>();
    }
    
    /**
     * Adds a new item to the catalog
     * @param item The item to add
     */
    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getTitle());
    }
    
    /**
     * Removes an item from the catalog by itemID
     * @param itemID The ID of the item to remove
     * @throws Exception if item is not found
     */
    public void removeItem(String itemID) throws Exception {
        boolean found = false;
        
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemID().equals(itemID)) {
                System.out.println("Removed: " + items.get(i).getTitle());
                items.remove(i);
                found = true;
                break;
            }
        }
        
        if (!found) {
            throw new Exception("Error: Item with ID '" + itemID + "' not found in catalog.");
        }
    }
    
    /**
     * Retrieves and displays details of a specific item
     * @param itemID The ID of the item to retrieve
     * @return The item if found, null otherwise
     */
    public T getItem(String itemID) {
        for (T item : items) {
            if (item.getItemID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Displays all items in the catalog
     */
    public void displayCatalog() {
        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }
        
        System.out.println("\n=== LIBRARY CATALOG ===");
        System.out.println("Total items: " + items.size());
        System.out.println("------------------------");
        
        for (T item : items) {
            System.out.println(item.toString());
        }
        System.out.println("========================\n");
    }
    
    /**
     * Returns the number of items in the catalog
     */
    public int getItemCount() {
        return items.size();
    }
}