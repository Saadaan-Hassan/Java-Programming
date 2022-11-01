public class StoreInventory {

    private int isbn;
    private String title;
    private Author author;
    private float price;
    private int quantity;

    public StoreInventory(int isbn, String title, Author author, float price, int quantity) {
        setisbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setQuantity(quantity);
    }

    //Setters
    public void setisbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Getters
    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
