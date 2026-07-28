/**
 * Generic LibraryItem class that can represent any type of library item.
 * T represents the type of item (Book, DVD, Magazine, etc.)
 */
class LibraryItem<T> {
    
    // Attributes
    private String title;
    private String author;
    private String itemID;
    private T itemType;  // Generic type for flexibility
    
    // Constructor
    public LibraryItem(String title, String author, String itemID, T itemType) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
        this.itemType = itemType;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getItemID() {
        return itemID;
    }
    
    public T getItemType() {
        return itemType;
    }
    
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setItemType(T itemType) {
        this.itemType = itemType;
    }
    
    /**
     * Returns a formatted string with item details
     */
    @Override
    public String toString() {
        return "Item ID: " + itemID + 
               " | Title: " + title + 
               " | Author: " + author + 
               " | Type: " + itemType.getClass().getSimpleName();
    }
}