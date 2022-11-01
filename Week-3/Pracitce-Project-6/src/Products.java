public class Products {
    private String name;
    private String description;
    private float price;
    private Dates manufacturingDate;
    private int productId;

    public Products(int productId ,String name, String description, float price, Dates manufacturingDate) {
        setProductId(productId);
        setName(name);
        setDescription(description);
        setPrice(price);
        setManufacturingDate(manufacturingDate);
        productId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Dates getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Dates manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
        
    }

    @Override
    public String toString() {
        return "Products [product Id: " + getProductId() + ", description=" + description + ", manufacturingDate=" + manufacturingDate + ", name=" + name
                + ", price=" + price + "]";
    }

}
